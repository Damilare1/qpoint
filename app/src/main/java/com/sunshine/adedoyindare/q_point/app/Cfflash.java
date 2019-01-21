package com.sunshine.adedoyindare.q_point.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by ADEDOYIN DARE on 6/27/2015.
 */
public class Cfflash extends ActionBarActivity {
    private Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cfflash);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /**Thread timer = new Thread() {
         public void run() {
         try { sleep(2000);
         } catch (InterruptedException e) {

         e.printStackTrace();
         } finally {
         Intent openCollectorFeedback = new Intent("com.sunshine.adedoyindare.q_point.COLLECTORFEEDBACK");
         startActivity(openCollectorFeedback);
         }
         }
         };
         timer.start();
         }

         protected void onPause() {
         super.onPause();
         finish();
         }*/
    }
}