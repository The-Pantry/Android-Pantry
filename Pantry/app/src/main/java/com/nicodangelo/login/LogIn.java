/*
@Author Jake Cox
This is the first class called when a user starts the Pantrie app, It is the logIn and also the first Item To connect To parse.com
 */

package com.nicodangelo.login;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nicodangelo.pantry.R;
import com.parse.Parse.*;
import com.parse.Parse;
import com.parse.ParseObject;


public class LogIn extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        ///////////////////////////////////////////////////////////////////////////////////////////
        // Enable Local Datastore, and make a Test Parse Object!
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "pBnaKMYAdbbfRhdvcKQEWFLiKtmsXXzOZXAAGoLh", "tJpug7m4dtF6FhpaMoM9PWAxlTRAbSoAKLcdWx5J");

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
        ///////////////////////////////////////////////////////////////////////////////////////////

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }
}
