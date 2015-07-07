package com.example.sean.betrayalprototype;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Type;

public class CharacterSheet extends Activity {

    int NUM_VALUES = 8;

    int speed_position;
    int might_position;
    int sanity_position;
    int know_position;

    TextView[] speedValues = new TextView[NUM_VALUES];
    TextView[] mightValues = new TextView[NUM_VALUES];
    TextView[] sanityValues = new TextView[NUM_VALUES];
    TextView[] knowValues = new TextView[NUM_VALUES];

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("save_speed", speed_position);
        outState.putInt("save_might", might_position);
        outState.putInt("save_sanity", sanity_position);
        outState.putInt("save_know", know_position);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        speed_position = savedInstanceState.getInt("save_speed");
        might_position = savedInstanceState.getInt("save_might");
        sanity_position = savedInstanceState.getInt("save_sanity");
        know_position = savedInstanceState.getInt("save_know");

        resetTextDecoration();

        decorateStatText(speedValues[speed_position], 1);
        decorateStatText(mightValues[might_position], 2);
        decorateStatText(sanityValues[sanity_position], 3);
        decorateStatText(knowValues[know_position], 4);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_sheet);

        // Intent to get character selection from activity_main
        Intent intentFromMain = getIntent();

        // Init arrays to hold stat TextViews
        initValueContainers();

        int characterID = intentFromMain.getIntExtra(MainActivity.EXTRA_ID, 1);

        characterSelect(characterID);
    }

    public void resetTextDecoration() {
        int i;
        for (i = 0; i < NUM_VALUES; ++i) {
            speedValues[i].setTextColor(getResources().getColor(R.color.WHITE));
            mightValues[i].setTextColor(getResources().getColor(R.color.WHITE));
            sanityValues[i].setTextColor(getResources().getColor(R.color.WHITE));
            knowValues[i].setTextColor(getResources().getColor(R.color.WHITE));
        }
    }

    public void openMainActivity(View view) {
        Intent openMainActivityIntent = new Intent(this, MainActivity.class);

        startActivity(openMainActivityIntent);

        finish();
    }

    public void initValueContainers() {

        LinearLayout speed_layout = (LinearLayout) findViewById(R.id.speed_values_layout);
        LinearLayout might_layout = (LinearLayout) findViewById(R.id.might_values_layout);
        LinearLayout sanity_layout = (LinearLayout) findViewById(R.id.sanity_values_layout);
        LinearLayout know_layout = (LinearLayout) findViewById(R.id.know_values_layout);

        int i;
        for (i = 0; i < NUM_VALUES; ++i) {

            speedValues[i] = (TextView) speed_layout.getChildAt(i);
            mightValues[i] = (TextView) might_layout.getChildAt(i);
            sanityValues[i] = (TextView) sanity_layout.getChildAt(i);
            knowValues[i] = (TextView) know_layout.getChildAt(i);
        }
    }

    public void characterSelect(int characterID) {
        switch (characterID) {
            case 1:
                setZostra();
                break;
            case 2:
                setVivian();
                break;
            case 3:
                setPeter();
                break;
            case 4:
                setBrandon();
                break;
            case 5:
                setFlash();
                break;
            case 6:
                setOx();
                break;
            case 7:
                setHeather();
                break;
            case 8:
                setJenny();
                break;
            case 9:
                setMissy();
                break;
            case 10:
                setZoe();
                break;
            case 11:
                setRhinehardt();
                break;
            case 12:
                setLongfellow();
                break;
            default:
                setZostra();
                break;
        }

    }

    // TODO: test decorator for subject TextView
    public void decorateStatText(TextView changeText, int statType) {

        switch (statType) {
            case 1: // Speed
                changeText.setTextColor(getResources().getColor(R.color.ARROW_GREEN));
                break;
            case 2: // Might
                changeText.setTextColor(getResources().getColor(R.color.ARROW_ORANGE));
                break;
            case 3: // Sanity
                changeText.setTextColor(getResources().getColor(R.color.ARROW_BLUE));
                break;
            case 4: // Knowledge
                changeText.setTextColor(getResources().getColor(R.color.ARROW_YELLOW));
                break;
        }

        changeText.setTypeface(null, Typeface.BOLD);

    }

    public void setZostra() {
        ImageView zostraPortrait = (ImageView) findViewById(R.id.character_portrait_imageView);
        zostraPortrait.setImageResource(R.drawable.zostra);

        String[] speed = {"2","3","3","5","5","6","6","7"};
        String[] might = {"2","3","3","4","5","5","5","6"};
        String[] sanity = {"4","4","4","5","6","7","8","8"};
        String[] know = {"1","3","4","4","4","5","6","6"};

        int i;
        for (i = 0; i < NUM_VALUES; ++i) {

            speedValues[i].setText(speed[i]);
            mightValues[i].setText(might[i]);
            sanityValues[i].setText(sanity[i]);
            knowValues[i].setText(know[i]);
        }

        // Starting stat values
        speed_position = 2;
        decorateStatText(speedValues[speed_position], 1);

        might_position = 3;
        decorateStatText(mightValues[might_position], 2);

        sanity_position = 2;
        decorateStatText(sanityValues[sanity_position], 3);

        know_position = 3;
        decorateStatText(knowValues[know_position], 4);

        // Set birthday

        TextView zostraBirthday = (TextView) findViewById(R.id.birthday_textView);
        zostraBirthday.setText("December 10th");

        // Set hobbies

        TextView zostraHobbies = (TextView) findViewById(R.id.hobbies_textView);
        zostraHobbies.setText("Astrology, Cooking, Baseball");

        // Set name

        TextView zostraName = (TextView) findViewById(R.id.character_name_textView);
        zostraName.setText("Madame Zostra");

    }

    public void setVivian() {
        ImageView vivianPortrait = (ImageView) findViewById(R.id.character_portrait_imageView);
        vivianPortrait.setImageResource(R.drawable.vivian);

        String[] speed = {"3","4","4","4","4","6","7","8"};
        String[] might = {"2","2","2","4","4","5","6","6"};
        String[] sanity = {"4","4","4","5","6","7","8","8"};
        String[] know = {"4","5","5","5","5","6","6","7"};

        int i;
        for (i = 0; i < NUM_VALUES; ++i) {

            speedValues[i].setText(speed[i]);
            mightValues[i].setText(might[i]);
            sanityValues[i].setText(sanity[i]);
            knowValues[i].setText(know[i]);
        }

        // Starting stat values
        speed_position = 3;
        decorateStatText(speedValues[speed_position], 1);

        might_position = 2;
        decorateStatText(mightValues[might_position], 2);

        sanity_position = 2;
        decorateStatText(sanityValues[sanity_position], 3);

        know_position = 3;
        decorateStatText(knowValues[know_position], 4);

        // Set birthday

        TextView vivianBirthday = (TextView) findViewById(R.id.birthday_textView);
        vivianBirthday.setText("January 11th");

        // Set hobbies

        TextView vivianHobbies = (TextView) findViewById(R.id.hobbies_textView);
        vivianHobbies.setText("Old Movies, Horses");

        // Set name

        TextView vivianName = (TextView) findViewById(R.id.character_name_textView);
        vivianName.setText("Vivian Lopez");

    }

    public void setPeter() {
        ImageView peterPortrait = (ImageView) findViewById(R.id.character_portrait_imageView);
        peterPortrait.setImageResource(R.drawable.peter);

        String[] speed = {"3","3","3","4","6","6","7","7"};
        String[] might = {"2","3","3","4","5","5","6","8"};
        String[] sanity = {"3","4","4","4","5","6","6","7"};
        String[] know = {"3","4","4","5","6","7","7","8"};

        int i;
        for (i = 0; i < NUM_VALUES; ++i) {

            speedValues[i].setText(speed[i]);
            mightValues[i].setText(might[i]);
            sanityValues[i].setText(sanity[i]);
            knowValues[i].setText(know[i]);
        }

        // Starting stat values
        speed_position = 3;
        decorateStatText(speedValues[speed_position], 1);

        might_position = 2;
        decorateStatText(mightValues[might_position], 2);

        sanity_position = 3;
        decorateStatText(sanityValues[sanity_position], 3);

        know_position = 2;
        decorateStatText(knowValues[know_position], 4);

        // Set birthday

        TextView peterBirthday = (TextView) findViewById(R.id.birthday_textView);
        peterBirthday.setText("September 3rd");

        // Set hobbies

        TextView peterHobbies = (TextView) findViewById(R.id.hobbies_textView);
        peterHobbies.setText("Bugs, Basketball");

        // Set name

        TextView peterName = (TextView) findViewById(R.id.character_name_textView);
        peterName.setText("Peter Akimoto");

    }

    public void setBrandon() {
        ImageView brandonPortrait = (ImageView) findViewById(R.id.character_portrait_imageView);
        brandonPortrait.setImageResource(R.drawable.brandon);

        String[] speed = {"3","4","4","4","5","6","7","8"};
        String[] might = {"2","3","3","4","5","6","6","7"};
        String[] sanity = {"3","3","3","4","5","6","7","8"};
        String[] know = {"1","3","3","5","5","6","6","7"};

        int i;
        for (i = 0; i < NUM_VALUES; ++i) {

            speedValues[i].setText(speed[i]);
            mightValues[i].setText(might[i]);
            sanityValues[i].setText(sanity[i]);
            knowValues[i].setText(know[i]);
        }

        // Starting stat values
        speed_position = 2;
        decorateStatText(speedValues[speed_position], 1);

        might_position = 3;
        decorateStatText(mightValues[might_position], 2);

        sanity_position = 3;
        decorateStatText(sanityValues[sanity_position], 3);

        know_position = 2;
        decorateStatText(knowValues[know_position], 4);

        // Set birthday

        TextView brandonBirthday = (TextView) findViewById(R.id.birthday_textView);
        brandonBirthday.setText("May 21st");

        // Set hobbies

        TextView brandonHobbies = (TextView) findViewById(R.id.hobbies_textView);
        brandonHobbies.setText("Computers, Camping, Hockey");

        // Set name

        TextView brandonName = (TextView) findViewById(R.id.character_name_textView);
        brandonName.setText("Brandon Jaspers");


    }

    public void setFlash() {
        ImageView flashPortrait = (ImageView) findViewById(R.id.character_portrait_imageView);
        flashPortrait.setImageResource(R.drawable.flash);

        String[] speed = {"4","4","4","5","6","7","7","8"};
        String[] might = {"2","3","3","4","5","6","6","7"};
        String[] sanity = {"1","2","3","4","5","5","5","7"};
        String[] know = {"2","3","3","4","5","5","5","7"};

        int i;
        for (i = 0; i < NUM_VALUES; ++i) {

            speedValues[i].setText(speed[i]);
            mightValues[i].setText(might[i]);
            sanityValues[i].setText(sanity[i]);
            knowValues[i].setText(know[i]);
        }

        // Starting stat values
        speed_position = 4;
        decorateStatText(speedValues[speed_position], 1);

        might_position = 2;
        decorateStatText(mightValues[might_position], 2);

        sanity_position = 2;
        decorateStatText(sanityValues[sanity_position], 3);

        know_position = 2;
        decorateStatText(knowValues[know_position], 4);

        // Set birthday

        TextView flashBirthday = (TextView) findViewById(R.id.birthday_textView);
        flashBirthday.setText("June 6th");

        // Set hobbies

        TextView flashHobbies = (TextView) findViewById(R.id.hobbies_textView);
        flashHobbies.setText("Track, Music, Shakespearean Literature");

        // Set name

        TextView flashName = (TextView) findViewById(R.id.character_name_textView);
        flashName.setText("Darrin 'Flash' Williams");

    }

    public void setOx() {
        ImageView oxPortrait = (ImageView) findViewById(R.id.character_portrait_imageView);
        oxPortrait.setImageResource(R.drawable.ox);

        String[] speed = {"2","2","2","3","4","5","5","6"};
        String[] might = {"4","5","5","6","6","7","8","8"};
        String[] sanity = {"2","2","3","4","5","5","6","7"};
        String[] know = {"2","2","3","3","5","5","6","6"};

        int i;
        for (i = 0; i < NUM_VALUES; ++i) {

            speedValues[i].setText(speed[i]);
            mightValues[i].setText(might[i]);
            sanityValues[i].setText(sanity[i]);
            knowValues[i].setText(know[i]);
        }

        // Starting stat values
        speed_position = 4;
        decorateStatText(speedValues[speed_position], 1);

        might_position = 2;
        decorateStatText(mightValues[might_position], 2);

        sanity_position = 2;
        decorateStatText(sanityValues[sanity_position], 3);

        know_position = 2;
        decorateStatText(knowValues[know_position], 4);

        // Set birthday

        TextView oxBirthday = (TextView) findViewById(R.id.birthday_textView);
        oxBirthday.setText("October 18th");

        // Set hobbies

        TextView oxHobbies = (TextView) findViewById(R.id.hobbies_textView);
        oxHobbies.setText("Football, Shiny Objects");

        // Set name

        TextView oxName = (TextView) findViewById(R.id.character_name_textView);
        oxName.setText("Ox Bellows");

    }

    public void setHeather() {
        ImageView heatherPortrait = (ImageView) findViewById(R.id.character_portrait_imageView);
        heatherPortrait.setImageResource(R.drawable.heather);

        String[] speed = {"3","3","4","5","6","6","7","8"};
        String[] might = {"3","3","3","4","5","6","7","8"};
        String[] sanity = {"3","3","3","4","5","6","6","6"};
        String[] know = {"2","3","3","4","5","6","7","8"};

        int i;
        for (i = 0; i < NUM_VALUES; ++i) {

            speedValues[i].setText(speed[i]);
            mightValues[i].setText(might[i]);
            sanityValues[i].setText(sanity[i]);
            knowValues[i].setText(know[i]);
        }

        // Starting stat values
        speed_position = 2;
        decorateStatText(speedValues[speed_position], 1);

        might_position = 2;
        decorateStatText(mightValues[might_position], 2);

        sanity_position = 2;
        decorateStatText(sanityValues[sanity_position], 3);

        know_position = 4;
        decorateStatText(knowValues[know_position], 4);

        // Set birthday

        TextView heatherBirthday = (TextView) findViewById(R.id.birthday_textView);
        heatherBirthday.setText("August 2nd");

        // Set hobbies

        TextView heatherHobbies = (TextView) findViewById(R.id.hobbies_textView);
        heatherHobbies.setText("Television, Shopping");

        // Set name

        TextView heatherName = (TextView) findViewById(R.id.character_name_textView);
        heatherName.setText("Heather Granville");

    }

    public void setJenny() {
        ImageView jennyPortrait = (ImageView) findViewById(R.id.character_portrait_imageView);
        jennyPortrait.setImageResource(R.drawable.jenny);

        String[] speed = {"2","3","4","4","4","5","6","8"};
        String[] might = {"3","4","4","4","4","5","6","8"};
        String[] sanity = {"1","1","2","4","4","4","5","6"};
        String[] know = {"2","3","3","4","4","5","6","8"};

        int i;
        for (i = 0; i < NUM_VALUES; ++i) {

            speedValues[i].setText(speed[i]);
            mightValues[i].setText(might[i]);
            sanityValues[i].setText(sanity[i]);
            knowValues[i].setText(know[i]);
        }

        // Starting stat values
        speed_position = 3;
        decorateStatText(speedValues[speed_position], 1);

        might_position = 2;
        decorateStatText(mightValues[might_position], 2);

        sanity_position = 4;
        decorateStatText(sanityValues[sanity_position], 3);

        know_position = 2;
        decorateStatText(knowValues[know_position], 4);

        // Set birthday

        TextView jennyBirthday = (TextView) findViewById(R.id.birthday_textView);
        jennyBirthday.setText("March 4th");

        // Set hobbies

        TextView jennyHobbies = (TextView) findViewById(R.id.hobbies_textView);
        jennyHobbies.setText("Reading, Soccer");

        // Set name

        TextView jennyName = (TextView) findViewById(R.id.character_name_textView);
        jennyName.setText("Jenny LeClerc");

    }

    public void setZoe() {
        ImageView zoePortrait = (ImageView) findViewById(R.id.character_portrait_imageView);
        zoePortrait.setImageResource(R.drawable.zoe);

        String[] speed = {"4","4","4","4","5","6","8","8"};
        String[] might = {"2","2","3","3","4","4","6","7"};
        String[] sanity = {"3","4","5","5","6","6","7","8"};
        String[] know = {"1","2","3","4","4","5","5","5"};

        int i;
        for (i = 0; i < NUM_VALUES; ++i) {

            speedValues[i].setText(speed[i]);
            mightValues[i].setText(might[i]);
            sanityValues[i].setText(sanity[i]);
            knowValues[i].setText(know[i]);
        }

        // Starting stat values
        speed_position = 3;
        decorateStatText(speedValues[speed_position], 1);

        might_position = 3;
        decorateStatText(mightValues[might_position], 2);

        sanity_position = 2;
        decorateStatText(sanityValues[sanity_position], 3);

        know_position = 2;
        decorateStatText(knowValues[know_position], 4);

        // Set birthday

        TextView zoeBirthday = (TextView) findViewById(R.id.birthday_textView);
        zoeBirthday.setText("November 5th");

        // Set hobbies

        TextView zoeHobbies = (TextView) findViewById(R.id.hobbies_textView);
        zoeHobbies.setText("Dolls, Music");

        // Set name

        TextView zoeName = (TextView) findViewById(R.id.character_name_textView);
        zoeName.setText("Zoe Ingstrom");

    }

    public void setMissy() {
        ImageView missyPortrait = (ImageView) findViewById(R.id.character_portrait_imageView);
        missyPortrait.setImageResource(R.drawable.missy);

        String[] speed = {"3","4","5","6","6","6","7","7"};
        String[] might = {"2","3","3","3","4","5","6","7"};
        String[] sanity = {"1","2","3","4","5","5","6","7"};
        String[] know = {"2","3","4","4","5","6","6","6"};

        int i;
        for (i = 0; i < NUM_VALUES; ++i) {

            speedValues[i].setText(speed[i]);
            mightValues[i].setText(might[i]);
            sanityValues[i].setText(sanity[i]);
            knowValues[i].setText(know[i]);
        }

        // Starting stat values
        speed_position = 2;
        decorateStatText(speedValues[speed_position], 1);

        might_position = 3;
        decorateStatText(mightValues[might_position], 2);

        sanity_position = 2;
        decorateStatText(sanityValues[sanity_position], 3);

        know_position = 3;
        decorateStatText(knowValues[know_position], 4);

        // Set birthday

        TextView missyBirthday = (TextView) findViewById(R.id.birthday_textView);
        missyBirthday.setText("February 14th");

        // Set hobbies

        TextView missyHobbies = (TextView) findViewById(R.id.hobbies_textView);
        missyHobbies.setText("Swimming, Medicine");

        // Set name

        TextView missyName = (TextView) findViewById(R.id.character_name_textView);
        missyName.setText("Missy Dubourde");

    }

    public void setRhinehardt() {
        ImageView rhinehardtPortrait = (ImageView) findViewById(R.id.character_portrait_imageView);
        rhinehardtPortrait.setImageResource(R.drawable.rhinehardt);

        String[] speed = {"2","3","3","4","5","6","7","7"};
        String[] might = {"1","2","2","4","4","5","5","7"};
        String[] sanity = {"3","4","5","5","6","7","7","8"};
        String[] know = {"1","3","3","4","5","6","6","8"};

        int i;
        for (i = 0; i < NUM_VALUES; ++i) {

            speedValues[i].setText(speed[i]);
            mightValues[i].setText(might[i]);
            sanityValues[i].setText(sanity[i]);
            knowValues[i].setText(know[i]);
        }

        // Starting stat values
        speed_position = 2;
        decorateStatText(speedValues[speed_position], 1);

        might_position = 2;
        decorateStatText(mightValues[might_position], 2);

        sanity_position = 4;
        decorateStatText(sanityValues[sanity_position], 3);

        know_position = 3;
        decorateStatText(knowValues[know_position], 4);

        // Set birthday

        TextView rhinehardtBirthday = (TextView) findViewById(R.id.birthday_textView);
        rhinehardtBirthday.setText("April 29th");

        // Set hobbies

        TextView rhinehardtHobbies = (TextView) findViewById(R.id.hobbies_textView);
        rhinehardtHobbies.setText("Fencing, Gardening");

        // Set name

        TextView rhinehardtName = (TextView) findViewById(R.id.character_name_textView);
        rhinehardtName.setText("Father Rhinehardt");

    }

    public void setLongfellow() {
        ImageView longfellowPortrait = (ImageView) findViewById(R.id.character_portrait_imageView);
        longfellowPortrait.setImageResource(R.drawable.longfellow);

        String[] speed = {"2","2","4","4","5","5","6","6"};
        String[] might = {"1","2","3","4","5","5","6","6"};
        String[] sanity = {"1","3","3","4","5","5","6","7"};
        String[] know = {"4","5","5","5","5","6","7","8"};

        int i;
        for (i = 0; i < NUM_VALUES; ++i) {

            speedValues[i].setText(speed[i]);
            mightValues[i].setText(might[i]);
            sanityValues[i].setText(sanity[i]);
            knowValues[i].setText(know[i]);
        }

        // Starting stat values
        speed_position = 3;
        decorateStatText(speedValues[speed_position], 1);

        might_position = 2;
        decorateStatText(mightValues[might_position], 2);

        sanity_position = 2;
        decorateStatText(sanityValues[sanity_position], 3);

        know_position = 4;
        decorateStatText(knowValues[know_position], 4);

        // Set birthday

        TextView longfellowBirthday = (TextView) findViewById(R.id.birthday_textView);
        longfellowBirthday.setText("July 27th");

        // Set hobbies

        TextView longfellowHobbies = (TextView) findViewById(R.id.hobbies_textView);
        longfellowHobbies.setText("Gaelic Music, Drama, Fine Wines");

        // Set name

        TextView longfellowName = (TextView) findViewById(R.id.character_name_textView);
        longfellowName.setText("Professor Longfellow");

    }

    public void speedDec(View view) {

        if (speed_position > 0) {

            speedValues[speed_position].setTextColor(Color.WHITE);
            speedValues[speed_position].setTypeface(null, Typeface.NORMAL);
            --speed_position;
            decorateStatText(speedValues[speed_position], 1);
        }
        else {

            Toast.makeText(this, "Speed at minimum value", Toast.LENGTH_SHORT).show();
        }
    }

    public void speedInc(View view) {

        if (speed_position < 7) {

            speedValues[speed_position].setTextColor(Color.WHITE);
            speedValues[speed_position].setTypeface(null, Typeface.NORMAL);
            ++speed_position;
            decorateStatText(speedValues[speed_position], 1);
        }
        else {

            Toast.makeText(this, "Speed at maximum value", Toast.LENGTH_SHORT).show();
        }
    }

    public void mightDec(View view) {

        if (might_position > 0) {

            mightValues[might_position].setTextColor(Color.WHITE);
            mightValues[might_position].setTypeface(null, Typeface.NORMAL);
            --might_position;
            decorateStatText(mightValues[might_position], 2);
        }
        else {

            Toast.makeText(this, "Might at minimum value", Toast.LENGTH_SHORT).show();
        }
    }

    public void mightInc(View view) {

        if (might_position < 7) {

            mightValues[might_position].setTextColor(Color.WHITE);
            mightValues[might_position].setTypeface(null, Typeface.NORMAL);
            ++might_position;
            decorateStatText(mightValues[might_position], 2);
        }
        else {

            Toast.makeText(this, "Might at maximum value", Toast.LENGTH_SHORT).show();
        }
    }

    public void sanityDec(View view) {

        if (sanity_position > 0) {

            sanityValues[sanity_position].setTextColor(Color.WHITE);
            sanityValues[sanity_position].setTypeface(null, Typeface.NORMAL);
            --sanity_position;
            decorateStatText(sanityValues[sanity_position], 3);
        }
        else {

            Toast.makeText(this, "Sanity at minimum value", Toast.LENGTH_SHORT).show();
        }
    }

    public void sanityInc(View view) {

        if (sanity_position < 7) {

            sanityValues[sanity_position].setTextColor(Color.WHITE);
            sanityValues[sanity_position].setTypeface(null, Typeface.NORMAL);
            ++sanity_position;
            decorateStatText(sanityValues[sanity_position], 3);
        }
        else {

            Toast.makeText(this, "Sanity at maximum value", Toast.LENGTH_SHORT).show();
        }
    }

    public void knowDec(View view) {

        if (know_position > 0) {

            knowValues[know_position].setTextColor(Color.WHITE);
            knowValues[know_position].setTypeface(null, Typeface.NORMAL);
            --know_position;
            decorateStatText(knowValues[know_position], 4);
        }
        else {

            Toast.makeText(this, "Knowledge at minimum value", Toast.LENGTH_SHORT).show();
        }
    }

    public void knowInc(View view) {

        if (know_position < 7) {

            knowValues[know_position].setTextColor(Color.WHITE);
            knowValues[know_position].setTypeface(null, Typeface.NORMAL);
            ++know_position;
            decorateStatText(knowValues[know_position], 4);
        }
        else {

            Toast.makeText(this, "Knowledge at maximum value", Toast.LENGTH_SHORT).show();
        }
    }
}
