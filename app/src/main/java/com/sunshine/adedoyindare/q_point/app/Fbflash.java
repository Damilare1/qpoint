package com.sunshine.adedoyindare.q_point.app;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by ADEDOYIN DARE on 6/27/2015.
 */
public class Fbflash extends ActionBarActivity {
    private Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fbflash);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /**  Thread timer = new Thread() {
         public void run() {
         try { sleep(2000);
         } catch (InterruptedException e) {

         e.printStackTrace();
         } finally {
         Intent openFixedBias = new Intent("com.sunshine.adedoyindare.q_point.FIXEDBIAS");
         startActivity(openFixedBias);
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

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.emitterflash_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem Item) {
        int id = Item.getItemId();

        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        ;


        return super.onOptionsItemSelected(Item);
    }
}