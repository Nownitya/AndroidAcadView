package com.example.nowni.regappusingfilestorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SignInActivity extends AppCompatActivity
{
    TextView detail;

    String fileText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        detail = findViewById(R.id.txtDEmail);

        try {
            String FILE_NAME="regdata.txt";
            FileInputStream fileInputStream = openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            int CharCount;
            char [] inputText = new char[200];
            fileText="";

            while((CharCount=inputStreamReader.read(inputText))>0){
                fileText=fileText+String.copyValueOf(inputText,0,CharCount);
            }
            inputStreamReader.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        detail.setText(""+fileText);

    }
}
