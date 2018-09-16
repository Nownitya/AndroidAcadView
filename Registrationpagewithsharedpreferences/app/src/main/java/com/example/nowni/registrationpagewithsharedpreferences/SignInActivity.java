package com.example.nowni.registrationpagewithsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity
{
    TextView email, phn, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = findViewById(R.id.txtDEmail);
        phn = findViewById(R.id.txtDphn);
        pass = findViewById(R.id.txtDPass);

        SharedPreferences settings = getSharedPreferences("login_data", Context.MODE_PRIVATE);
        String email_id = settings.getString("user_name", "");
        String phn_no = settings.getString("phone_no.", "null");
        String pass_w = settings.getString("password", "null");

        email.setText(email_id);
        phn.setText(phn_no);
        pass.setText(pass_w);
    }
}
