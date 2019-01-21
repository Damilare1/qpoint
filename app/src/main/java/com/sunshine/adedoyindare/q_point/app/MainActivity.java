package com.sunshine.adedoyindare.q_point.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    Button EB, FB, VD, CF;
    TextView display;

    private Toolbar toolbar;                              // Declaring the Toolbar Object


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        EB = (Button) findViewById(R.id.EmitterBiasButton);
        FB = (Button) findViewById(R.id.FIXEDBIASBUTTON);
        VD = (Button) findViewById(R.id.VOLTAGEDIVIDERBIAS);
        CF = (Button) findViewById(R.id.COLLECTORFEEDBACK);

        CF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent openCollectorFlash = new Intent("com.sunshine.adedoyindare.q_point.COLLECTORFEEDBACK");
                startActivity(openCollectorFlash);
            }
        });
        FB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent openFIXEDBIASFLASH = new Intent("com.sunshine.adedoyindare.q_point.FIXEDBIAS");
                startActivity(openFIXEDBIASFLASH);
            }
        });
        VD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent openVOLTAGEFLASH = new Intent("com.sunshine.adedoyindare.q_point.VOLTAGEDIVIDER");
                startActivity(openVOLTAGEFLASH);
            }
        });
        EB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent openEMITTERBIASFLASH = new Intent("com.sunshine.adedoyindare.q_point.EMITTERBIAS");
                startActivity(openEMITTERBIASFLASH);
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            detail();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.

    /**
     * int id = item.getItemId();
     * if (id == R.id.action_settings) {
     * detail();
     * <p/>
     * return true;
     * }
     */

    public void detail() {
        Intent openFixedBias = new Intent("com.sunshine.adedoyindare.q_point.Detail");
        startActivity(openFixedBias);
    }
}










