package com.nicodangelo.pantrie;

import android.app.DialogFragment;
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

import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class NewLogInDialog extends DialogFragment implements View.OnClickListener
{
    public View view;

    private static EditText usernameText;
    private static EditText passwordText;
    private static EditText passwordCheckText;
    private static Button logInButton;

    private static String username;
    private static String password;
    private static String passwordCheck;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //cant just grab the objects from the XML, need to create a view to point to were the XML is.
        view = inflater.inflate(R.layout.activity_new_log_in_dialog, null);
        logInButton = (Button) view.findViewById(R.id.createUser);
        //set the attributes to the Dialog
        logInButton.setOnClickListener(this);
        setCancelable(false);
        //need to return the view!
        return view;
    }

    //because you cannot get the action directly from the XML you have to do it smartly, implement the onClickListener and use its method..
    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.createUser)
        {
            signUp(view);
        }
    }

    public void signUp(View view)
    {
        usernameText = (EditText) view.findViewById(R.id.usernameText);
        passwordText = (EditText) view.findViewById(R.id.passwordText);
        passwordCheckText = (EditText) view.findViewById(R.id.passwordCheckText);
        logInButton = (Button) view.findViewById(R.id.createUser);

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

    }
}
