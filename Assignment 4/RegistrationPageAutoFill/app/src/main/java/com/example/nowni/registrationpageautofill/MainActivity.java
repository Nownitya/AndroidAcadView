package com.example.nowni.registrationpageautofill;

import android.content.Intent;
import android.os.Bundle;
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
    EditText name, email, phn, city;
    Button register;
    Spinner state;
    String stateList;
    Integer state_position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);
        phn = findViewById(R.id.editPhn);
        city = findViewById(R.id.editCity);
        state = findViewById(R.id.spinnerState);

        register = findViewById(R.id.btnRegister);

        final String states[] = {"Andhra Pradesh", "Arunachal Pradesh", "Assam","Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir",
                "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim",
                "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, states);
        state.setAdapter(arrayAdapter);

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                stateList = states[i];
                state_position = i;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                Toast.makeText(MainActivity.this,"You did't select any state", Toast.LENGTH_SHORT).show();

            }
        });


        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, DisplayPage.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("email",email.getText().toString());
                intent.putExtra("phn",phn.getText().toString());
                intent.putExtra("state",stateList);
                intent.putExtra("stat_Position",(state_position).toString());
                intent.putExtra("city",city.getText().toString());
                startActivity(intent);

            }
        });

        name.setText(getIntent().getStringExtra("name2"));
        email.setText(getIntent().getStringExtra("email2"));
        phn.setText(getIntent().getStringExtra("phn2"));
        city.setText(getIntent().getStringExtra("city2"));
        state_position = getIntent().getIntExtra("string_position",0);
        state.setSelection(state_position);

    }
}
