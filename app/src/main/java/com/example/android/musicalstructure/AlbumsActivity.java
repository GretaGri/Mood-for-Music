package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        //Underline TextView Moods to show chosen category in navigation.
        //Source: https://stackoverflow.com/questions/2394935/can-i-underline-text-in-an-android-layout
        TextView textView = findViewById(R.id.albums);
        SpannableString content = new SpannableString(getString(R.string.albums));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);

        //Set onclick to moods text view to go to Main activity (moods page) when clicked
        TextView moodsNavigation = findViewById(R.id.moods);
        moodsNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AlbumsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //Set onclick to artists text view to go to Artists activity when clicked
        TextView artistsNavigation = findViewById(R.id.artists);
        artistsNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AlbumsActivity.this, ArtistActivity.class);
                startActivity(i);
            }
        });

        GridView moodsGrid = findViewById(R.id.moods_grid);
        moodsGrid.setOnTouchListener(new OnSwipeTouchListener() {
            @Override
            public boolean onSwipeRight() {
                Intent i = new Intent(AlbumsActivity.this, ArtistActivity.class);
                startActivity(i);
                return true;
            }
        });
    }
}
