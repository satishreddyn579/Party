package com.example.satti.party;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class Login extends AppCompatActivity {

    //protected EditText mUsername;
   // protected EditText mEmail;
    protected EditText mUsername;
    protected EditText mPassword;
    protected Button mLogin;
    protected Button mSigin;
    protected ProgressDialog pdia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = (EditText)findViewById(R.id.nameid);

        mPassword = (EditText)findViewById(R.id.passwordid);
        mLogin =(Button)findViewById(R.id.loginid1);
        mSigin =(Button)findViewById(R.id.signinid);

        //Login activity
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //input from the user
                String user = mUsername.getText().toString();
                String password = mPassword.getText().toString();
                Login.this.pdia = ProgressDialog.show(Login.this,null,"Logging in..... ",true);
               //showdialog();

                ParseUser.logInInBackground(user, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        ////doubt 1
                        if (e == null) {
                            Toast.makeText(Login.this, "sucess", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Login.this, MainActivity.class));
                            finish();
                        } else {
                            Toast.makeText(Login.this, "Error", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


        //Sigin activity
        mSigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Signin.class));
            }
        });
    }
    /*void showdialog()
    {   //this.pdia.setMessage("Loading.....");
        if(!this.pdia.isShowing()){
            this.pdia.show();
        }
    }
    void hidedialog(){
        if(this.pdia.isShowing()){
            this.pdia.dismiss();
        }
    }*/

}
