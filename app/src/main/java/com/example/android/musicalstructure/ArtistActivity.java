package com.example.android.musicalstructure;

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

public class ArtistActivity extends AppCompatActivity {

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
        TextView artistsNavigation = findViewById(R.id.artists);
        SpannableString content = new SpannableString(getString(R.string.artists));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        artistsNavigation.setText(content);

        //Set onclick to moods text view to go to Main activity (moods page) when clicked
        TextView moodsNavigation = findViewById(R.id.moods);
        moodsNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ArtistActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //Set onclick to albums text view to go to Albums activity when clicked
        TextView albumsNavigation = findViewById(R.id.albums);
        albumsNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ArtistActivity.this, AlbumsActivity.class);
                startActivity(i);
            }
        });

        // Set grid view when swiped left to go to Albums activity, right - to Main activity (moods page).
        GridView artistGrid = findViewById(R.id.moods_grid);
        artistGrid.setOnTouchListener(new OnSwipeTouchListener() {
            @Override
            public boolean onSwipeRight() {
                Intent i = new Intent(ArtistActivity.this, MainActivity.class);
                startActivity(i);
                return true;
            }
            @Override
            public boolean onSwipeLeft() {
                Intent i = new Intent(ArtistActivity.this, AlbumsActivity.class);
                startActivity(i);
                return true;
            }
        });
        //Create a ArrayList with artists and corresponding image (dummy names and images).
        ArrayList<Cover> covers = new ArrayList<>();
        covers.add(new Cover("Ricky Bob",R.drawable.artist_man2_s));
        covers.add(new Cover("Alice",R.drawable.album_chlidren_s));
        covers.add(new Cover("Disco man",R.drawable.artist_man_s));
        covers.add(new Cover("Silent Jim",R.drawable.artist_man3_s));
        covers.add(new Cover("Mona Lisa",R.drawable.artist_girl_s));
        covers.add(new Cover("Pretty",R.drawable.artist_girl4_s));
        covers.add(new Cover("Lora",R.drawable.artist_girls3_s));
        covers.add(new Cover("Mini-me",R.drawable.artist_indie_s));
        covers.add(new Cover("Flower",R.drawable.artist_flower_s));
        covers.add(new Cover("Country boy",R.drawable.artist_with_guitar_s));
        covers.add(new Cover("Big G",R.drawable.artist_hiphop_s));

        //Create a ArtistAdapter adapter.
        ArtistAdapter adapter = new ArtistAdapter(this, covers);

        //Set adapter to GridView.
        artistGrid.setAdapter(adapter);

        artistGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ArtistActivity.this,SongListActivity.class);
                startActivity(i);
            }
        });
    }
}
