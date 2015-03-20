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
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class NewLogIn extends ActionBarActivity
{
    private static String username;
    private static String password;
    private static String passwordCheck;

    private static EditText usernameText;
    private static EditText passwordText;
    private static EditText passwordCheckText;
    private static Button logInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //get all the objects from the view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_log_in);
    }

    public void signUp(View view)
    {
        usernameText = (EditText) findViewById(R.id.usernameText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        passwordCheckText = (EditText) findViewById(R.id.passwordCheckText);
        logInButton = (Button) findViewById(R.id.logInButton);

        username = usernameText.getText().toString();
        password = passwordText.getText().toString();
        passwordCheck = passwordCheckText.getText().toString();

        if(password.equalsIgnoreCase(passwordCheck))
        {
            ParseUser user = new ParseUser();
            if(!username.isEmpty())
            {
                user.setUsername(username);
                user.setPassword(password);
            }

            // other fields can be set just like with ParseObject

            user.signUpInBackground(new SignUpCallback()
            {
                @Override
                public void done(com.parse.ParseException e)
                {
                    if (e == null)
                    {
                        // Hooray! Let them use the app now.
                        loadPantrie();

                    } else
                    {
                        // Sign up didn't succeed. Look at the ParseException
                        System.out.println("the sign in failed!!");
                        // to figure out what went wrong
                    }
                }
            });
        }
        else
        {
            System.out.println("password don't match");
        }
    }

    public void loadPantrie()
    {
        Intent i = new Intent(this,Pantrie.class);
        startActivity(i);
    }
}
