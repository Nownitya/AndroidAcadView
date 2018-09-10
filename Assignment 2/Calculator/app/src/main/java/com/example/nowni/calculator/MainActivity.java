package com.example.nowni.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    String operand, a, b;
    Button add, sub, mul, div, equals;
    TextView display;
    Integer answer;
    Button reset, del;
    String str;


    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.txtView);

        equals= findViewById(R.id.btnEql);
        a="";
        b="";

        reset = findViewById(R.id.btnReset);

        del = findViewById(R.id.btnDel);

        del.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String str = display.getText().toString();
                if(str.length() >= 1)
                {
                    str = str.substring(0, str.length() -1);
                    display.setText(str);
                }
                else if (str.length() <=1 )
                {
                    display.setText("0");
                }

            }
        });

        equals.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.d("operand", operand);
                Log.d("operand", a+":"+b);


                switch (operand)
                {
                    case "+" : answer= Integer.parseInt(b)+ Integer.parseInt(a);
                    display.setText("+answer");
                    break;

                    case "-" : answer= Integer.parseInt(b)- Integer.parseInt(a);
                        display.setText("+answer");
                        break;

                    case "*" : answer= Integer.parseInt(b)* Integer.parseInt(a);
                        display.setText("+answer");
                        break;

                    case "/" : answer= Integer.parseInt(b)/ Integer.parseInt(a);
                        display.setText("+answer");
                        break;
                }
                a=""+answer;

            }
        });
    }

    void valueGetterOnClick(View v){

        str = display.getText().toString();

        if(v.getId()==R.id.btnOne){
            display.setText(str+"1");
            a = a + "1";
        }
        else if(v.getId()==R.id.btnTwo)
        {
            display.setText(str+"2");
            a = a + "2";
        }
        else if(v.getId()==R.id.btnThree){
            display.setText(str+"3");
            a = a + "3";
        }
        else if(v.getId()==R.id.btnFour){
            display.setText(str+"4");
            a = a + "4";
        }
        else if(v.getId()==R.id.btnFive){
            display.setText(str+"5");
            a = a + "5";
        }
        else if(v.getId()==R.id.btnSix){
            display.setText(str+"6");
            a = a + "6";
        }
        else if(v.getId()==R.id.btnSeven){
            display.setText(str+"7");
            a = a + "7";
        }
        else if(v.getId()==R.id.btnEight){
            display.setText(str+"8");
            a = a + "8";
        }
        else if(v.getId()==R.id.btnNine){
            display.setText(str+"9");
            a = a + "9";
        }
        else if(v.getId()==R.id.btnZero){
            display.setText(str+"0");
            a = a + "0";
        }
        else if(v.getId()==R.id.btnReset){
            display.setText("0");
            a = "";
            b = "";
        }



    }

    void operandGetterOnClick(View v){

        str=display.getText().toString();

        if(v.getId()==R.id.btnAdd){
            display.setText(str + "+" );
            operand="+";
        }
        else if(v.getId()==R.id.btnSub){
            display.setText(str + "-" );
            operand="-";
        }
        else if(v.getId()==R.id.btnMult){
            display.setText(str + "*" );
            operand="*";
        }
        else if(v.getId()==R.id.btnDiv){
            display.setText(str + "÷" );
            operand="/";
        }

        b=a;
        a="";

    }
}
