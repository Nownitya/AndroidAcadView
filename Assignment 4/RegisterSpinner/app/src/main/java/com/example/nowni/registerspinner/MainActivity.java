package com.example.nowni.registerspinner;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{
    EditText name,email,phone;
    Spinner country,state;
    Button reg;
    String rfName, rfEmail, rfphn, rfCountry , rfState;

    String[] countries = new String[]{"INDIA", "USA", "AUSTRALIA"};
    String[] INDIA = new String[]{"Andhra Pradesh", "Arunachal Pradesh", "Assam","Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir",
            "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim",
            "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal"};

    String[] USA = new String[]{"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida",
            "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine",
            "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
            "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
            "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
            "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};

    String[] Australia = new String[]{"MELBOURNE","VICTORIA","QUEENLAND"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);
        phone = findViewById(R.id.editPhone);
        country = findViewById(R.id.spinnerCountry);
        state = findViewById(R.id.spinnerState);
        reg = findViewById(R.id.btnReg);
        country = findViewById(R.id.spinnerCountry);
        state = findViewById(R.id.spinnerState);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, countries);
        country.setAdapter(adapter);


        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    setAdapter(INDIA);
                } else if (i == 1) {
                    setAdapter(USA);
                } else if (i == 2) {
                    setAdapter(Australia);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });

    }

    public void setAdapter(String[] states) {

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout. simple_list_item_1,states);
        state.setAdapter(arrayAdapter);






        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(name.getText().toString())) {
                    name.setError("Field is  empty");
                    return;
                }

                if (TextUtils.isEmpty(email.getText().toString())) {
                    email.setError("Field is empty");
                    return;
                }

                if (TextUtils.isEmpty(phone.getText().toString())) {
                    phone.setError("Field is empty");
                    return;
                }



                rfName = name.getText().toString();
                rfEmail = email.getText().toString();
                rfphn = phone.getText().toString();
                rfCountry = country.getSelectedItem().toString();
                rfState = state.getSelectedItem().toString();

                SharedPreferences sp = getSharedPreferences("detail", MODE_PRIVATE);


                SharedPreferences.Editor editor = sp.edit();

                editor.putString("Name", rfName);
                editor.putString("Email", rfEmail);
                editor.putString("Password", rfphn);
                editor.putString("Country",rfCountry);
                editor.putString("State",rfState);


                editor.commit();


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Submit Conformation");
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                builder.show();



            }


        });
    }
}