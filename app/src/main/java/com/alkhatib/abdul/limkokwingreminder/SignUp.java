package com.alkhatib.abdul.limkokwingreminder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignUp extends Activity {

    protected EditText user,email,pass,confirmPass;

    protected Button submit;

    protected ParseUser parseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        // reference
        user = (EditText)findViewById(R.id.UserEditText);
        email = (EditText)findViewById(R.id.emailEditText);
        pass = (EditText)findViewById(R.id.passwordSignUp);
        confirmPass = (EditText)findViewById(R.id.confirmPassword);

        submit = (Button)findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sign up the user

                // do some checkings
                String mUser = user.getText().toString().trim();
                String mEmail = email.getText().toString();
                String mPass = pass.getText().toString();
                String mConfirmPass = confirmPass.getText().toString();

                // make sure everything is filled in
                if(mUser.length() == 0 || mEmail.length() == 0 || mPass.length() == 0 || mConfirmPass.length() == 0){
                    // spit out a toast and return
                    Toast.makeText(SignUp.this,"Please make sure you have filled in all the fields",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(mPass.equals(mConfirmPass)){
                    // everything is good

                    parseUser = new ParseUser();

                    parseUser.setUsername(mUser);
                    parseUser.setPassword(mPass);
                    parseUser.setEmail(mEmail);

                    // sign him up
                    parseUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e == null){
                                // hooray the user is signed up take him to Home
                                // take him to HomePage
                                Intent intent = new Intent(SignUp.this,HomePage.class);
                                startActivity(intent);


                            }else{
                                Toast.makeText(SignUp.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }else{
                    // toast and return
                    Toast.makeText(SignUp.this,"Your passwords do not match",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }
}
