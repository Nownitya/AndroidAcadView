package com.example.nowni.instagramclone;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    EditText userid, pass;
    Button btnlogin , login_button;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);


        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null)
        {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        userid = (EditText) findViewById(R.id.editUser);
        pass = (EditText) findViewById(R.id.editPass);
        btnlogin = findViewById(R.id.btnLogin);

        auth = FirebaseAuth.getInstance();


        btnlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String editUser = userid.getText().toString();
                final String editPass = pass.getText().toString();

                if (TextUtils.isEmpty(editUser))
                {
                    Toast.makeText(getApplicationContext(),"Enter user id", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(editPass))
                {
                    Toast.makeText(getApplicationContext(),"Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.signInWithEmailAndPassword(editUser,editPass)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {

                                if (!task.isSuccessful())
                                {
                                    if (editPass.length()<6)
                                    {
                                        pass.setError(getString(R.string.minimum_password));
                                    }
                                    else
                                    {
                                        Toast.makeText(LoginActivity.this, MaiActivity.class);

                                    }
                                }
                            }
                        });


            }
        });


        EditText userid, pass;
        Button btnlogin ;
        private FirebaseAuth auth;


        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);


            auth = FirebaseAuth.getInstance();

            if (auth.getCurrentUser() != null)
            {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }

            userid = (EditText) findViewById(R.id.editUser);
            pass = (EditText) findViewById(R.id.editPass);
            btnlogin = findViewById(R.id.btnLogin);

            auth = FirebaseAuth.getInstance();


            btnlogin.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    String editUser = userid.getText().toString();
                    final String editPass = pass.getText().toString();

                    if (TextUtils.isEmpty(editUser))
                    {
                        Toast.makeText(getApplicationContext(),"Enter user id", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (TextUtils.isEmpty(editPass))
                    {
                        Toast.makeText(getApplicationContext(),"Enter Password", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    auth.signInWithEmailAndPassword(editUser,editPass)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task)
                                {

                                    if (!task.isSuccessful())
                                    {
                                        if (editPass.length()<6)
                                        {
                                            pass.setError(getString(R.string.minimum_password));
                                        }
                                        else
                                        {
                                            Toast.makeText(LoginActivity.this, MaiActivity.class);

                                        }
                                    }
                                }
                            });


                }
            });

        //facebook






            private static final String EMAIL = "email";

            loginButton = (LoginButton) findViewById(R.id.login_button);
            loginButton.setReadPermissions(Arrays.asList(EMAIL));
            // If you are using in a fragment, call loginButton.setFragment(this);

            // Callback registration
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    // App code
                }

                @Override
                public void onCancel() {
                    // App code
                }

                @Override
                public void onError(FacebookException exception) {
                    // App code
                }
            });




            callbackManager = CallbackManager.Factory.create();

            LoginManager.getInstance().registerCallback(callbackManager,
                    new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            // App code
                        }

                        @Override
                        public void onCancel() {
                            // App code
                        }

                        @Override
                        public void onError(FacebookException exception) {
                            // App code
                        }
                    });


            @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            callbackManager.onActivityResult(requestCode, resultCode, data);
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
