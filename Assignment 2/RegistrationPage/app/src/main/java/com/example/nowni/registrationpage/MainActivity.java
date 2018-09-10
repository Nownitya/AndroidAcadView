package com.example.nowni.registrationpage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText name, email, phn, city, password;
    Button register;
    Spinner state;
    String stateList;
    Integer statePosition;

    SharedPreferences sharedPreferences;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editName);
        email =findViewById(R.id.editEmail);
        phn = findViewById(R.id.editPhone);
        city = findViewById(R.id.editCity);
        state = findViewById(R.id.spinnerState);
        password = findViewById(R.id.editPass);
        register = findViewById(R.id.btnReg);


        sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_APPEND);

        final String states[]  = {"Andhra Pradesh", "Arunachal Pradesh", "Assam","Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir",
                "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim",
                "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item, states);

        state.setAdapter(arrayAdapter);

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                stateList = states[i];
                statePosition = i;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                Toast.makeText(MainActivity.this, "You did't selected any STATE", Toast.LENGTH_SHORT).show();

            }
        });


        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                confirmAlertBox();

            }
        });


    }

    private void confirmAlertBox()
    {
        AlertDialog.Builder alertBox = new AlertDialog.Builder(MainActivity.this);

        alertBox.setTitle("Confirm Alert");

        alertBox.setMessage("Are you want to save data and Proceed?");

        alertBox.setPositiveButton("YES", new DialogInterface.OnClickListener()
        {
            @SuppressLint("ApplySharedPref")
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name", name.getText().toString());
                editor.putString("Email", email.getText().toString());
                editor.putString("Phone No.", phn.getText().toString());
                editor.putString("Password", password.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(),"Registered Succesfully", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        alertBox.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {

                finish();

            }
        });
        AlertDialog alertDialogBox= alertBox.create();
        alertDialogBox.show();
    }
}
