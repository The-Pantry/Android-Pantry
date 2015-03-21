package com.nicodangelo.pantrie;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseUser;


public class LogInDialog extends DialogFragment implements View.OnClickListener
{
    public  static View view;
    private static EditText usernameText;
    private static EditText passwordText;
    private static Button newLogInButton;
    private static Button logInButton;

    private static String username;
    private static String password;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //cant just grab the objects from the XML, need to create a view to point to were the XML is.
        view = inflater.inflate(R.layout.activity_log_in_dialog, null);
        //instantiate the objects with the created View.
        usernameText = (EditText) view.findViewById(R.id.usernameText);
        passwordText = (EditText) view.findViewById(R.id.passwordText);
        newLogInButton = (Button) view.findViewById(R.id.newLogInButton);
        logInButton = (Button) view.findViewById(R.id.logInButton);
        //set the attributes to the Dialog
        newLogInButton.setOnClickListener(this);
        logInButton.setOnClickListener(this);
        setCancelable(false);
        //need to return the view!
        return view;
    }

    //because you cannot get the action directly from the XML you have to do it smartly, implement the onClickListener and use its method..
    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.newLogInButton)
        {
            dismiss();
            FragmentManager manager = getFragmentManager();
            NewLogInDialog newLogInDialog = new NewLogInDialog();
            newLogInDialog.show(manager,"newLogInDialog");
        }

        if(view.getId() == R.id.logInButton)
        {
            System.out.println("LOG IN WAS PUSHED!!!!!!!!!");
            SignIn();
        }
    }

    public void SignIn()
    {
        usernameText = (EditText) view.findViewById(R.id.usernameText);
        passwordText = (EditText) view.findViewById(R.id.passwordText);

        username = usernameText.getText().toString();
        password = passwordText.getText().toString();

        ParseUser.logInInBackground(username, password, new LogInCallback()
        {
            public void done(ParseUser user, com.parse.ParseException e)
            {
                if (user != null)
                {
                    // Hooray! The user is logged in.
                    loadPantrie();
                } else
                {
                    // Signup failed. Look at the ParseException to see what happened.
                    System.out.println("SignIn Failed!");
                }
            }
        });
    }

    public void loadPantrie()
    {
        System.out.println("User should have logged in and everything should be working!!");
    }


}
