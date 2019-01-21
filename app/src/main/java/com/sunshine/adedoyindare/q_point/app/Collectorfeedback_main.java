package com.sunshine.adedoyindare.q_point.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by ADEDOYIN DARE on 6/27/2015.
 */
public class Collectorfeedback_main extends ActionBarActivity {


    private Toolbar toolbar;                              // Declaring the Toolbar Object


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collectorfeedback_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.collector_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem Item) {
        int id = Item.getItemId();

        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        ;

        if (id == R.id.collectorConfig) {
            detail();

        }
        ;

        return super.onOptionsItemSelected(Item);
    }


    public void CollectorBias(View v) {
        Double Rb2, Rc2, Re2, Vcc2, Vbe, Beta, Ib, Ic, Icc, Vce;

        EditText Rb = (EditText) findViewById(R.id.CFRb);
        EditText Rc = (EditText) findViewById(R.id.CFRc);
        EditText Re = (EditText) findViewById(R.id.CFRe);
        EditText Vcc = (EditText) findViewById(R.id.CFVcc);
        EditText Beta2 = (EditText) findViewById(R.id.CFbeta);

        Button CF1 = (Button) findViewById(R.id.CollectorCalc);
        TextView icc = (TextView) findViewById(R.id.collectorcurrentCF);
        TextView vcec = (TextView) findViewById(R.id.vcecf);

        if (v.getId() == R.id.CollectorCalc) {
            boolean isValidate = true;

            if (Rc.getText().toString().length() <= 0) {
                Rc.setError("Value Required");
                isValidate = false;
            }
            if (Re.getText().toString().length() <= 0) {
                Re.setError("Value Required");
                isValidate = false;
            }

            if (Vcc.getText().toString().length() <= 0) {
                Vcc.setError("Value Required");
                isValidate = false;
            }
            if (Beta2.getText().toString().length() <= 0) {
                Beta2.setError("Value Required");
                isValidate = false;
            }
            if (isValidate) {
                Rb2 = Double.parseDouble(Rb.getText().toString());
                Rc2 = Double.parseDouble(Rc.getText().toString());
                Re2 = Double.parseDouble(Re.getText().toString());
                Vcc2 = Double.parseDouble(Vcc.getText().toString());
                Beta = Double.parseDouble(Beta2.getText().toString());

                Vbe = 0.7;
                Ib = (Vcc2 - Vbe) / ((Rb2 + Beta * (Rc2 + Re2)) * 1000);
                Ic = Beta * Ib;
                Vce = Vcc2 - (Ic) * (((Rc2) + (Re2)) * 1000);
                Icc = Ic * 1000;
                NumberFormat nf = NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);
                icc.setText("Collector Current is: " + nf.format(Icc) + "mA");
                vcec.setText("Collector Emitter Voltage is: " + nf.format(Vce) + "V");
            }

        }

    }

    public void onButtonClick2(View v) {
        EditText Rb = (EditText) findViewById(R.id.CFRb);
        EditText Rc = (EditText) findViewById(R.id.CFRc);
        EditText Re = (EditText) findViewById(R.id.CFRe);
        EditText Vcc = (EditText) findViewById(R.id.CFVcc);
        EditText Beta2 = (EditText) findViewById(R.id.CFbeta);
        TextView icc = (TextView) findViewById(R.id.collectorcurrentCF);
        TextView vcec = (TextView) findViewById(R.id.vcecf);
        Rb.setText("");
        Rc.setText("");
        Re.setText("");
        Vcc.setText("");
        Beta2.setText("");
        vcec.setText("");
        icc.setText("");
    }

    public void detail() {
        Intent openFixedBias = new Intent("com.sunshine.adedoyindare.q_point.CFFLASH");
        startActivity(openFixedBias);
    }
}

