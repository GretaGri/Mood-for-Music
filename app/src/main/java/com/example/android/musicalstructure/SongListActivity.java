package com.example.android.musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        ListView songList = findViewById(R.id.song_list);
        //Create a ArrayList with albums and corresponding image (dummy names and images).
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Balloons","Ricky Bob",R.drawable.album_baloons_s,"Balloons one",R.raw.empty));
        songs.add(new Song("Children songs","Alice",R.drawable.album_chlidren_s,"Children one",R.raw.empty));
        songs.add(new Song("Disco","Disco man",R.drawable.album_disco_s,"Disco one",R.raw.empty));
        songs.add(new Song("Lake","Silent Jim",R.drawable.album_lake_s,"Lake one",R.raw.empty));
        songs.add(new Song("Smile","Mona Lisa",R.drawable.album_lights_s,"Smile one",R.raw.empty));
        songs.add(new Song("Love","Pretty",R.drawable.album_love_s,"Love one",R.raw.empty));
        songs.add(new Song("Mountains","Lora",R.drawable.album_mountains_s,"Mountains one",R.raw.empty));
        songs.add(new Song("Sky","Mini-me",R.drawable.album_sky_s,"Sky one",R.raw.empty));
        songs.add(new Song("Miss you","Flower",R.drawable.artist_flower_s, "Miss you one",R.raw.empty));
        songs.add(new Song("Home","Country boy",R.drawable.artist_with_guitar_s, "Home one",R.raw.empty));
        songs.add(new Song("Pressure","Big G",R.drawable.artist_hiphop_s, "Pressure one",R.raw.empty));


        //Create a MoodAdapter adapter.
        SongAdapter adapter = new SongAdapter(this, songs);

        //Set adapter to GridView.
        songList.setAdapter(adapter);
    }
}
