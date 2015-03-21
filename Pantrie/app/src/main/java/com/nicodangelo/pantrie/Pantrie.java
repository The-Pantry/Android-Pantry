package com.nicodangelo.pantrie;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Pantrie extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        onCreateLogInDialog();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantrie);
    }

    public void onCreateLogInDialog()
    {
        FragmentManager manager = getFragmentManager();
        LogInDialog logInDialog = new LogInDialog();
        logInDialog.show(manager,"logInDialog");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pantrie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
