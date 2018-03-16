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

public class AlbumsActivity extends AppCompatActivity {

    String album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);
        TextView title = findViewById(R.id.custom_title);
        title.setText(R.string.albums);

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

        GridView albumGrid = findViewById(R.id.moods_grid);
        albumGrid.setOnTouchListener(new OnSwipeTouchListener() {
            @Override
            public boolean onSwipeRight() {
                Intent i = new Intent(AlbumsActivity.this, ArtistActivity.class);
                startActivity(i);
                return true;
            }
        });

        //Create a ArrayList with albums and corresponding image (dummy names and images).
        ArrayList<Cover> covers = new ArrayList<>();
        covers.add(new Cover("Balloons", "Ricky Bob", R.drawable.album_balloons_s));
        covers.add(new Cover("Children songs", "Alice", R.drawable.album_chlidren_s));
        covers.add(new Cover("Disco", "Disco man", R.drawable.album_disco_s));
        covers.add(new Cover("Lake", "Silent Jim", R.drawable.album_lake_s));
        covers.add(new Cover("Smile", "Mona Lisa", R.drawable.album_lights_s));
        covers.add(new Cover("Love", "Pretty", R.drawable.album_love_s));
        covers.add(new Cover("Mountains", "Lora", R.drawable.album_mountains_s));
        covers.add(new Cover("Sky", "Mini-me", R.drawable.album_sky_s));
        covers.add(new Cover("Miss you", "Flower", R.drawable.artist_flower_s));
        covers.add(new Cover("Home", "Country boy", R.drawable.artist_with_guitar_s));
        covers.add(new Cover("Pressure", "Big G", R.drawable.artist_hiphop_s));


        //Create a MoodAdapter adapter.
        final AlbumAdapter adapter = new AlbumAdapter(this, covers);

        //Set adapter to GridView.
        albumGrid.setAdapter(adapter);

        albumGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                album = adapter.getItem(position).getCoverName();
                Intent i = new Intent(AlbumsActivity.this, SongListActivity.class);
                i.putExtra("album", album);
                startActivity(i);
            }
        });
    }
}
