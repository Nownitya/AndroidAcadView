package com.example.nowni.registrationpageautofill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayPage extends AppCompatActivity
{
    TextView name, email, phn, state, city;
    Button submitReturn;
    Integer stringPosition;

//    btnSubmit

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_page);

        name = findViewById(R.id.txtName);
        email = findViewById(R.id.txtEmail);
        phn = findViewById(R.id.txtPhn);
        state = findViewById(R.id.txtState);
        city = findViewById(R.id.txtCity);
        submitReturn = findViewById(R.id.btnSubmit);
        stringPosition = Integer.parseInt(getIntent().getStringExtra("statePosition"));
        Log.d("Test",stringPosition+"");
        name.setText(getIntent().getStringExtra("name"));
        email.setText(getIntent().getStringExtra("email"));
        phn.setText(getIntent().getStringExtra("phn"));
        state.setText(getIntent().getStringExtra("state"));
        city.setText(getIntent().getStringExtra("city"));

        submitReturn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(DisplayPage.this,MainActivity.class);
                intent.putExtra("name2",name.getText().toString());
                intent.putExtra("mail2",email.getText().toString());
                intent.putExtra("phn2",phn.getText().toString());
                intent.putExtra("city2",city.getText().toString());
                intent.putExtra("string_position",stringPosition);
                startActivity(intent);

            }
        });


    }
}
