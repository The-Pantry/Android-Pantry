/*
@Author Jake Cox
This is the first class called when a user starts the Pantrie app, It is the logIn and also the first Item To connect To parse.com
 */

package com.nicodangelo.login;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nicodangelo.pantry.Pantrie;
import com.nicodangelo.pantry.R;
import com.parse.LogInCallback;
import com.parse.Parse.*;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;


public class LogIn extends ActionBarActivity
{
    private static String username;
    private static String password;
    //private static String email;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        ///////////////////////////////////////////////////////////////////////////////////////////
        // Enable Local Datastore, and make a Test Parse Object!
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "pBnaKMYAdbbfRhdvcKQEWFLiKtmsXXzOZXAAGoLh", "tJpug7m4dtF6FhpaMoM9PWAxlTRAbSoAKLcdWx5J");
        ///////////////////////////////////////////////////////////////////////////////////////////

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void signIn(View view)
    {
        EditText usernameText = (EditText) findViewById(R.id.logInUsernameText);
        EditText passwordText = (EditText) findViewById(R.id.logInPasswordText);

        username = usernameText.getText().toString();
        password = passwordText.getText().toString();

        ParseUser.logInInBackground(username, password, new LogInCallback()
        {
            public void done(ParseUser user, com.parse.ParseException e)
            {
                if (user != null) {
                    // Hooray! The user is logged in.
                    loadPantrie();
                } else {
                    // Signup failed. Look at the ParseException to see what happened.
                }
            }
        });




    }

    public void loadPantrie()
    {
        Intent i = new Intent(this,Pantrie.class);
        startActivity(i);
    }

    public void createNewUser(View view)
    {
        Intent i = new Intent(this,NewLogIn.class);
        startActivity(i);
    }
}
