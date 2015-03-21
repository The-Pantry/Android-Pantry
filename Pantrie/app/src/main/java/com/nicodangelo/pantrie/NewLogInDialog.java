package com.nicodangelo.pantrie;

import android.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class NewLogInDialog extends DialogFragment implements View.OnClickListener
{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //cant just grab the objects from the XML, need to create a view to point to were the XML is.
        View view = inflater.inflate(R.layout.activity_new_log_in_dialog, null);

        //set the attributes to the Dialog
        setCancelable(false);
        //need to return the view!
        return view;
    }

    //because you cannot get the action directly from the XML you have to do it smartly, implement the onClickListener and use its method..
    @Override
    public void onClick(View v)
    {

    }
}
