package com.example.nowni.registrationpagewithsharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    EditText name, email, phn, pass;
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);
        phn = findViewById(R.id.editPhn);
        pass = findViewById(R.id.editPass);
        reg = findViewById(R.id.btnReg);

        reg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SharedPreferences sharedPreferences;
                sharedPreferences = getSharedPreferences("login_data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor;
                editor = sharedPreferences.edit();
                editor.putString("user_name", name.getText().toString());
                editor.putString("phone_no.", phn.getText().toString());
                editor.putString("password", pass.getText().toString());
                editor.commit();

                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });


    }
}
