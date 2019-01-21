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
public class Voltagedivider_main extends ActionBarActivity {


    private Toolbar toolbar;                              // Declaring the Toolbar Object


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voltagedivider_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.voltagebias_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem Item) {
        int id = Item.getItemId();

        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        ;
        if (id == R.id.voltageConfig) {
            detail();

        }
        ;

        return super.onOptionsItemSelected(Item);
    }

    public void VoltageBias(View v) {

        Double Icc, Rc2, Re2, Vcc2, Vbb2, Vbe, Beta2, Vth, Ib, Ic, Vce2, R1p, R2p;


        Button VD1;
        TextView icc, vcec, app, icc2, vcec2;

        EditText R1 = (EditText) findViewById(R.id.VDr1);
        EditText R2 = (EditText) findViewById(R.id.VDr2);
        EditText Rc = (EditText) findViewById(R.id.VDRc);
        EditText Re = (EditText) findViewById(R.id.VDRe);
        EditText Vcc = (EditText) findViewById(R.id.VDVcc);
        EditText Beta = (EditText) findViewById(R.id.VDbeta);
        VD1 = (Button) findViewById(R.id.VoltageCalc);
        TextView answer = (TextView) findViewById(R.id.vceVD);
        icc = (TextView) findViewById(R.id.collectorcurrentVD);
        icc2 = (TextView) findViewById(R.id.collectorcurrentVD2);
        vcec2 = (TextView) findViewById(R.id.vceVD2);
        app = (TextView) findViewById(R.id.app);

        if (v.getId() == R.id.VoltageCalc) {
            boolean isValidate = true;
            if (R1.getText().toString().length() <= 0) {
                R1.setError("Value Required");
                isValidate = false;
            }
            if (Rc.getText().toString().length() <= 0) {
                Rc.setError("Value Required");
                isValidate = false;
            }
            if (Re.getText().toString().length() <= 0) {
                Re.setError("Value Required");
                isValidate = false;
            }
            if (R2.getText().toString().length() <= 0) {
                R2.setError("Value Required");
                isValidate = false;
            }
            if (Vcc.getText().toString().length() <= 0) {
                Vcc.setError("Value Required");
                isValidate = false;
            }
            if (Beta.getText().toString().length() <= 0) {
                Beta.setError("Value Required");
                isValidate = false;
            }
            if (isValidate) {
                vcec = (TextView) findViewById(R.id.vceVD);
                R1p = Double.parseDouble(R1.getText().toString());
                R2p = Double.parseDouble(R2.getText().toString());
                Re2 = Double.parseDouble(Re.getText().toString());
                Rc2 = Double.parseDouble(Rc.getText().toString());
                Vcc2 = Double.parseDouble(Vcc.getText().toString());
                Beta2 = Double.parseDouble(Beta.getText().toString());
                Double Ve, Ie, Ic2, vceapp;

                double Rth = ((R1p * (R2p)) / ((R1p) + (R2p)));
                Vth = ((R2p * Vcc2) / (R1p + R2p));
                Vbe = 0.7;
                Ib = (Vth - Vbe) / ((Rth + (Beta2 + 1) * Re2) * 1000);
                Ic = Beta2 * Ib;
                Vce2 = Vcc2 - (Ic * (Rc2 + Re2) * 1000);
                Icc = Ic * 1000;
                Ve = Vth - Vbe;
                Ie = Ve / Re2;
                Ic2 = Ie;


                NumberFormat nf = NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);
                icc.setText("Collector Current is: " + nf.format(Icc) + "mA");
                vcec.setText("Collector Emitter Voltage is: " + nf.format(Vce2) + "V");

                if ((Beta2 * Re2 * 1000) >= (10 * R2p * 1000)) {

                    vceapp = Vcc2 - (Ic2 * (Rc2 + Re2));
                    app.setText("Approximate Solution: ");
                    icc2.setText("Collector Current is: " + nf.format(Ic2) + "mA");
                    vcec2.setText("Collector Emitter Voltage is: " + nf.format(vceapp) + "V");

                }




            }
        }


    }

    public void onButtonClick2(View v) {
        EditText R1 = (EditText) findViewById(R.id.VDr1);
        EditText R2 = (EditText) findViewById(R.id.VDr2);
        EditText Rc = (EditText) findViewById(R.id.VDRc);
        EditText Re = (EditText) findViewById(R.id.VDRe);
        EditText Vcc = (EditText) findViewById(R.id.VDVcc);
        EditText Beta2 = (EditText) findViewById(R.id.VDbeta);
        TextView answer = (TextView) findViewById(R.id.vceVD);
        TextView icc = (TextView) findViewById(R.id.collectorcurrentVD);
        R1.setText("");
        R2.setText("");
        Rc.setText("");
        Re.setText("");
        Vcc.setText("");
        Beta2.setText("");
        answer.setText("");
        icc.setText("");
    }

    public void detail() {
        Intent openFixedBias = new Intent("com.sunshine.adedoyindare.q_point.VDSPLASH");
        startActivity(openFixedBias);
    }
}
