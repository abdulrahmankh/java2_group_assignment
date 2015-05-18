package com.alkhatib.abdul.limkokwingreminder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;


public class MainActivity extends Activity {

    protected EditText username,password;
    protected Button login,signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize parse
        Parse.initialize(this, "FNvyhtc2DNz1IMxfJf8sQJntflAfPDqm6xGoh2lb", "fFNul649Iwp15gv7nZFHR2jyIbc8l3agTtH1c9KG");



        // reference
        username = (EditText)findViewById(R.id.usernameEditText);
        password = (EditText)findViewById(R.id.passwordEditText);

        login = (Button)findViewById(R.id.loginButton);
        signUp = (Button)findViewById(R.id.signButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check user

                // grab username and passwords
                String mUsername = username.getText().toString();
                String mPassword = password.getText().toString();

                if(mUsername.length() != 0 && mPassword.length() != 0){
                    // log the user in
                    ParseUser.logInInBackground(mUsername,mPassword,new LogInCallback() {
                        @Override
                        public void done(ParseUser parseUser, ParseException e) {
                            if(e == null){
                                // hooray the user is in
                                Intent homeIntent = new Intent(MainActivity.this,HomePage.class);
                                startActivity(homeIntent);
                                Toast.makeText(MainActivity.this,"Welcome",Toast.LENGTH_SHORT).show();

                            }else{
                                // something went wrong
                                Toast.makeText(MainActivity.this,"Sounds like you do not have an Account Please SignUp",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    });


                }else{
                    // spit out a toast
                    Toast.makeText(MainActivity.this,getResources().getString(R.string.pleaseLogIn),Toast.LENGTH_SHORT).show();
                }

            }
        });



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // take user to sign up page
                Intent signUpIntent = new Intent(MainActivity.this,SignUp.class);
                startActivity(signUpIntent);
            }
        });
    }






}
