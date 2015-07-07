package com.example.sean.betrayalprototype;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    public static final String EXTRA_ID = "com.example.sean.betrayalprototype";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //Below: openCharacterSheetIntent.putExtra(EXTRA_ID, intValue)
    //where intValue is the ID of the character to be loaded
    public void zostraSelect(View view) {
        Intent openCharacterSheetIntent = new Intent(this, CharacterSheet.class);

        final int result = 1;

        openCharacterSheetIntent.putExtra(EXTRA_ID,1);

        //opens character_sheet activity
        startActivity(openCharacterSheetIntent);
    }

    public void vivianSelect(View view) {
        Intent openCharacterSheetIntent = new Intent(this, CharacterSheet.class);

        final int result = 1;

        openCharacterSheetIntent.putExtra(EXTRA_ID,2);

        //opens character_sheet activity
        startActivity(openCharacterSheetIntent);
    }

    public void peterSelect(View view) {
        Intent openCharacterSheetIntent = new Intent(this, CharacterSheet.class);

        final int result = 1;

        openCharacterSheetIntent.putExtra(EXTRA_ID,3);

        //opens character_sheet activity
        startActivity(openCharacterSheetIntent);
    }

    public void brandonSelect(View view) {
        Intent openCharacterSheetIntent = new Intent(this, CharacterSheet.class);

        final int result = 1;

        openCharacterSheetIntent.putExtra(EXTRA_ID,4);

        //opens character_sheet activity
        startActivity(openCharacterSheetIntent);
    }

    public void flashSelect(View view) {
        Intent openCharacterSheetIntent = new Intent(this, CharacterSheet.class);

        final int result = 1;

        openCharacterSheetIntent.putExtra(EXTRA_ID,5);

        //opens character_sheet activity
        startActivity(openCharacterSheetIntent);
    }

    public void oxSelect(View view) {
        Intent openCharacterSheetIntent = new Intent(this, CharacterSheet.class);

        final int result = 1;

        openCharacterSheetIntent.putExtra(EXTRA_ID,6);

        //opens character_sheet activity
        startActivity(openCharacterSheetIntent);
    }

    public void heatherSelect(View view) {
        Intent openCharacterSheetIntent = new Intent(this, CharacterSheet.class);

        final int result = 1;

        openCharacterSheetIntent.putExtra(EXTRA_ID,7);

        //opens character_sheet activity
        startActivity(openCharacterSheetIntent);
    }

    public void jennySelect(View view) {
        Intent openCharacterSheetIntent = new Intent(this, CharacterSheet.class);

        final int result = 1;

        openCharacterSheetIntent.putExtra(EXTRA_ID,8);

        //opens character_sheet activity
        startActivity(openCharacterSheetIntent);
    }

    public void missySelect(View view) {
        Intent openCharacterSheetIntent = new Intent(this, CharacterSheet.class);

        final int result = 1;

        openCharacterSheetIntent.putExtra(EXTRA_ID,9);


        //opens character_sheet activity
        startActivity(openCharacterSheetIntent);
    }

    public void zoeSelect(View view) {
        Intent openCharacterSheetIntent = new Intent(this, CharacterSheet.class);

        final int result = 1;

        openCharacterSheetIntent.putExtra(EXTRA_ID,10);


        //opens character_sheet activity
        startActivity(openCharacterSheetIntent);
    }

    public void rhinehardtSelect(View view) {
        Intent openCharacterSheetIntent = new Intent(this, CharacterSheet.class);

        final int result = 1;

        openCharacterSheetIntent.putExtra(EXTRA_ID,11);


        //opens character_sheet activity
        startActivity(openCharacterSheetIntent);
    }

    public void longfellowSelect(View view) {
        Intent openCharacterSheetIntent = new Intent(this, CharacterSheet.class);

        final int result = 1;

        openCharacterSheetIntent.putExtra(EXTRA_ID,12);


        //opens character_sheet activity
        startActivity(openCharacterSheetIntent);
    }


}