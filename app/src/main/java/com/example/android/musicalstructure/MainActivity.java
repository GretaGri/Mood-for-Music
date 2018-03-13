package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Underline TextView Moods to show chosen category in navigation.
        //Source: https://stackoverflow.com/questions/2394935/can-i-underline-text-in-an-android-layout
        TextView moodsNavigation = findViewById(R.id.moods);
        SpannableString content = new SpannableString(getString(R.string.moods));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        moodsNavigation.setText(content);

        //Set onclick to artists text view to go to Artists activity when clicked
        TextView artistsNavigation = findViewById(R.id.artists);
        artistsNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ArtistActivity.class);
                startActivity(i);
            }
        });

        //Set onclick to albums text view to go to Albums activity when clicked
        TextView albumsNavigation = findViewById(R.id.albums);
        albumsNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AlbumsActivity.class);
                startActivity(i);
            }
        });


      // Set grid view when swiped left to go to Artists activity
        GridView moodsGrid = findViewById(R.id.moods_grid);
        moodsGrid.setOnTouchListener(new OnSwipeTouchListener() {
            @Override
            public boolean onSwipeLeft() {
                Intent i = new Intent(MainActivity.this, ArtistActivity.class);
                startActivity(i);
                return true;
             }
        });
    }
}
