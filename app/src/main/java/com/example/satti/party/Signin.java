package com.example.satti.party;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Signin extends AppCompatActivity {

    //initialize;
    protected EditText mUsername;
    protected EditText mEmail;
    protected EditText mPassword;
    protected EditText mPhone;
    protected Button mButton;
    protected ProgressDialog pdia;




    @Override
    public View findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_signin);
        mUsername = (EditText)findViewById(R.id.nameid);
        mEmail =(EditText)findViewById(R.id.mailid);
        mPassword = (EditText)findViewById(R.id.passwordid);
        mPhone =(EditText)findViewById(R.id.phoneid);
        mButton =(Button)findViewById(R.id.signupid);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //toast

                Signin.this.pdia = ProgressDialog.show(Signin.this, null, "Signing in.... ");
                String username = mUsername.getText().toString().trim();
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                String phone = mPhone.getText().toString();

                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                user.put("phone", phone);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            //sucess

                            Toast.makeText(Signin.this, "sucess", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Signin.this,MainActivity.class));
                            finish();
                        } else {
                            //error
                            Toast.makeText(Signin.this,"Error",Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }
        });



    }


}
