package com.alkhatib.abdul.limkokwingreminder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class HomePage extends Activity {


    protected int notifyID = 33;

    Adapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_layout);



        ad = new Adapter(this);
        ad.loadObjects();

    }

    @Override
    protected void onResume() {
        super.onResume();

        ad.loadObjects();
    }

    public void addModuleMethod(View view){
        Intent addModuleIntent = new Intent(HomePage.this,AddModule.class);
        startActivity(addModuleIntent);

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
        if (id == R.id.action_about) {
            Intent aboutIntent = new Intent(HomePage.this,About.class);
            startActivity(aboutIntent);
            return true;
        }

        if (id == R.id.action_ourteam) {
            Intent ourteamIntent = new Intent(HomePage.this,OurTeam.class);
            startActivity(ourteamIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
