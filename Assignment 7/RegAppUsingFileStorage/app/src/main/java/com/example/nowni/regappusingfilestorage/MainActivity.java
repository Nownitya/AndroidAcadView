package com.example.nowni.regappusingfilestorage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity
{
    EditText name, email, phn, pass;
    Button reg;

    String fileText;

    String FILE_NAME="regdata.txt";

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

                confirmAlert();

            }
        });

    }

    private void confirmAlert()
    {
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);

        alertdialog.setTitle("Alert");
        alertdialog.setMessage("Do you realy wants to save your data?");
        alertdialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                try
                {
                    FileOutputStream fileOutputStream = openFileOutput(FILE_NAME,MODE_PRIVATE);

                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

                    Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                    startActivity(intent);

                    outputStreamWriter.write(fileText);
                    Toast.makeText(getApplicationContext(),"All details are stored in File ", Toast.LENGTH_SHORT).show();
                    outputStreamWriter.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        alertdialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                finish();

            }
        });

        AlertDialog alertDialogBox = alertdialog.create();
        alertDialogBox.show();

    }


}
