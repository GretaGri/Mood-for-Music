package com.example.android.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

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
        final GridView moodsGrid = findViewById(R.id.moods_grid);
        moodsGrid.setOnTouchListener(new OnSwipeTouchListener() {
            @Override
            public boolean onSwipeLeft() {
                Intent i = new Intent(MainActivity.this, ArtistActivity.class);
                startActivity(i);
                return true;
            }
        });

        //Create a ArrayList with moods/genres and corresponding image.
        ArrayList<Cover> covers = new ArrayList<>();
        covers.add(new Cover("Pop", R.drawable.pop_s));
        covers.add(new Cover("Party", R.drawable.party_s));
        covers.add(new Cover("Dance", R.drawable.dance_s));
        covers.add(new Cover("Hip-Hop", R.drawable.hip_hop_s));
        covers.add(new Cover("Workout", R.drawable.workout_s));
        covers.add(new Cover("Movie", R.drawable.girl_s));
        covers.add(new Cover("Jazz", R.drawable.jazz_s));
        covers.add(new Cover("Sunny", R.drawable.summer_s));
        covers.add(new Cover("Love", R.drawable.love_s));
        covers.add(new Cover("Indie", R.drawable.indie_s));
        covers.add(new Cover("Coding", R.drawable.code_s));
        covers.add(new Cover("Raining", R.drawable.rain_s));
        covers.add(new Cover("Country", R.drawable.country_s));
        covers.add(new Cover("Classic", R.drawable.classic_s));
        covers.add(new Cover("Rock", R.drawable.rock_s));
        covers.add(new Cover("Kids", R.drawable.kids_s));


        //Create a MoodAdapter adapter.
        final MoodAdapter adapter = new MoodAdapter(this, covers);

        //Set adapter to GridView.
        moodsGrid.setAdapter(adapter);

        moodsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mood = adapter.getItem(position).getCoverName();
                Intent i = new Intent(MainActivity.this, SongListActivity.class);
                i.putExtra("mood", mood);
                startActivity(i);
            }
        });
    }
}


