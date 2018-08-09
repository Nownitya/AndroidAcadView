package com.example.nowni.lifecyclemethod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Activity Created", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(MainActivity.this, "Activity Started", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(MainActivity.this, "Activity Resumed", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(MainActivity.this, "Activity Paused", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(MainActivity.this, "Activity Stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "Activity Destroyed", Toast.LENGTH_SHORT).show();
    }


}
