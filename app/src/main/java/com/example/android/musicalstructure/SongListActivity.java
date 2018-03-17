package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {

    String mood;
    String album;
    String artist;
    String song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView title = findViewById(R.id.custom_title);
        title.setText(R.string.songs);

        //Get extras from previous activities

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        mood = extras.getString("mood");
        artist = extras.getString("artist");
        album = extras.getString("album");

        ListView songList = findViewById(R.id.song_list);
        //Create a ArrayList with albums and corresponding image (dummy names and images).
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Balloons", "Ricky Bob", R.drawable.album_balloons_s, "Balloons one", R.raw.empty, "Pop", "Party", R.color.album_balloons_color));
        songs.add(new Song("Balloons", "Ricky Bob", R.drawable.album_balloons_s, "Balloons two", R.raw.empty, "Pop", "Party", R.color.album_balloons_color));
        songs.add(new Song("Balloons", "Ricky Bob", R.drawable.album_balloons_s, "Balloons three", R.raw.empty, "Pop", "Party", R.color.album_balloons_color));
        songs.add(new Song("Balloons", "Ricky Bob", R.drawable.album_balloons_s, "Balloons four", R.raw.empty, "Pop", "Party", R.color.album_balloons_color));
        songs.add(new Song("Balloons", "Ricky Bob", R.drawable.album_balloons_s, "Balloons five", R.raw.empty, "Pop", "Party", R.color.album_balloons_color));
        songs.add(new Song("Balloons", "Ricky Bob", R.drawable.album_balloons_s, "Balloons six", R.raw.empty, "Pop", "Party", R.color.album_balloons_color));
        songs.add(new Song("Balloons", "Ricky Bob", R.drawable.album_balloons_s, "Balloons seven", R.raw.empty, "Pop", "Party", R.color.album_balloons_color));
        songs.add(new Song("Balloons", "Ricky Bob", R.drawable.album_balloons_s, "Balloons eight", R.raw.empty, "Pop", "Party", R.color.album_balloons_color));
        songs.add(new Song("Balloons", "Ricky Bob", R.drawable.album_balloons_s, "Balloons nine", R.raw.empty, "Pop", "Party", R.color.album_balloons_color));
        songs.add(new Song("Balloons", "Ricky Bob", R.drawable.album_balloons_s, "Balloons ten", R.raw.empty, "Pop", "Party", R.color.album_balloons_color));
        songs.add(new Song("Balloons", "Ricky Bob", R.drawable.album_balloons_s, "Balloons eleven", R.raw.empty, "Pop", "Party", R.color.album_balloons_color));
        songs.add(new Song("Children songs", "Alice", R.drawable.album_chlidren_s, "Children one", R.raw.empty, "Pop", "Kids", R.color.album_children_color));
        songs.add(new Song("Children songs", "Alice", R.drawable.album_chlidren_s, "Children two", R.raw.empty, "Pop", "Kids", R.color.album_children_color));
        songs.add(new Song("Children songs", "Alice", R.drawable.album_chlidren_s, "Children three", R.raw.empty, "Pop", "Kids", R.color.album_children_color));
        songs.add(new Song("Children songs", "Alice", R.drawable.album_chlidren_s, "Children four", R.raw.empty, "Pop", "Kids", R.color.album_children_color));
        songs.add(new Song("Children songs", "Alice", R.drawable.album_chlidren_s, "Children five", R.raw.empty, "Pop", "Kids", R.color.album_children_color));
        songs.add(new Song("Children songs", "Alice", R.drawable.album_chlidren_s, "Children six", R.raw.empty, "Pop", "Kids", R.color.album_children_color));
        songs.add(new Song("Children songs", "Alice", R.drawable.album_chlidren_s, "Children seven", R.raw.empty, "Pop", "Kids", R.color.album_children_color));
        songs.add(new Song("Children songs", "Alice", R.drawable.album_chlidren_s, "Children eight", R.raw.empty, "Pop", "Kids", R.color.album_children_color));
        songs.add(new Song("Children songs", "Alice", R.drawable.album_chlidren_s, "Children nine", R.raw.empty, "Pop", "Kids", R.color.album_children_color));
        songs.add(new Song("Children songs", "Alice", R.drawable.album_chlidren_s, "Children ten", R.raw.empty, "Pop", "Kids", R.color.album_children_color));
        songs.add(new Song("Disco", "Disco man", R.drawable.album_disco_s, "Disco one", R.raw.empty, "Pop", "Dance", R.color.album_disco_color));
        songs.add(new Song("Disco", "Disco man", R.drawable.album_disco_s, "Disco two", R.raw.empty, "Pop", "Dance", R.color.album_disco_color));
        songs.add(new Song("Disco", "Disco man", R.drawable.album_disco_s, "Disco three", R.raw.empty, "Pop", "Dance", R.color.album_disco_color));
        songs.add(new Song("Disco", "Disco man", R.drawable.album_disco_s, "Disco four", R.raw.empty, "Pop", "Dance", R.color.album_disco_color));
        songs.add(new Song("Disco", "Disco man", R.drawable.album_disco_s, "Disco five", R.raw.empty, "Pop", "Dance", R.color.album_disco_color));
        songs.add(new Song("Disco", "Disco man", R.drawable.album_disco_s, "Disco six", R.raw.empty, "Pop", "Dance", R.color.album_disco_color));
        songs.add(new Song("Disco", "Disco man", R.drawable.album_disco_s, "Disco seven", R.raw.empty, "Pop", "Dance", R.color.album_disco_color));
        songs.add(new Song("Disco", "Disco man", R.drawable.album_disco_s, "Disco eight", R.raw.empty, "Pop", "Dance", R.color.album_disco_color));
        songs.add(new Song("Lake", "Silent Jim", R.drawable.album_lake_s, "Lake one", R.raw.empty, "Rock", "Party", R.color.album_lake_color));
        songs.add(new Song("Lake", "Silent Jim", R.drawable.album_lake_s, "Lake two", R.raw.empty, "Rock", "Party", R.color.album_lake_color));
        songs.add(new Song("Lake", "Silent Jim", R.drawable.album_lake_s, "Lake three", R.raw.empty, "Rock", "Party", R.color.album_lake_color));
        songs.add(new Song("Lake", "Silent Jim", R.drawable.album_lake_s, "Lake four", R.raw.empty, "Rock", "Party", R.color.album_lake_color));
        songs.add(new Song("Lake", "Silent Jim", R.drawable.album_lake_s, "Lake five", R.raw.empty, "Rock", "Party", R.color.album_lake_color));
        songs.add(new Song("Lake", "Silent Jim", R.drawable.album_lake_s, "Lake six", R.raw.empty, "Rock", "Party", R.color.album_lake_color));
        songs.add(new Song("Lake", "Silent Jim", R.drawable.album_lake_s, "Lake seven", R.raw.empty, "Rock", "Party", R.color.album_lake_color));
        songs.add(new Song("Lake", "Silent Jim", R.drawable.album_lake_s, "Lake eight", R.raw.empty, "Rock", "Party", R.color.album_lake_color));
        songs.add(new Song("Lake", "Silent Jim", R.drawable.album_lake_s, "Lake nine", R.raw.empty, "Rock", "Party", R.color.album_lake_color));
        songs.add(new Song("Smile", "Mona Lisa", R.drawable.album_lights_s, "Smile one", R.raw.empty, "Jazz", "Sunny", R.color.album_smile_color));
        songs.add(new Song("Smile", "Mona Lisa", R.drawable.album_lights_s, "Smile two", R.raw.empty, "Jazz", "Sunny", R.color.album_smile_color));
        songs.add(new Song("Smile", "Mona Lisa", R.drawable.album_lights_s, "Smile three", R.raw.empty, "Jazz", "Sunny", R.color.album_smile_color));
        songs.add(new Song("Smile", "Mona Lisa", R.drawable.album_lights_s, "Smile four", R.raw.empty, "Jazz", "Sunny", R.color.album_smile_color));
        songs.add(new Song("Smile", "Mona Lisa", R.drawable.album_lights_s, "Smile five", R.raw.empty, "Jazz", "Sunny", R.color.album_smile_color));
        songs.add(new Song("Love", "Pretty", R.drawable.album_love_s, "Love one", R.raw.empty, "Classic", "Love", R.color.album_love_color));
        songs.add(new Song("Love", "Pretty", R.drawable.album_love_s, "Love two", R.raw.empty, "Classic", "Love", R.color.album_love_color));
        songs.add(new Song("Love", "Pretty", R.drawable.album_love_s, "Love three", R.raw.empty, "Classic", "Love", R.color.album_love_color));
        songs.add(new Song("Love", "Pretty", R.drawable.album_love_s, "Love four", R.raw.empty, "Classic", "Love", R.color.album_love_color));
        songs.add(new Song("Love", "Pretty", R.drawable.album_love_s, "Love five", R.raw.empty, "Classic", "Love", R.color.album_love_color));
        songs.add(new Song("Love", "Pretty", R.drawable.album_love_s, "Love six", R.raw.empty, "Classic", "Love", R.color.album_love_color));
        songs.add(new Song("Love", "Pretty", R.drawable.album_love_s, "Love seven", R.raw.empty, "Classic", "Love", R.color.album_love_color));
        songs.add(new Song("Love", "Pretty", R.drawable.album_love_s, "Love eight", R.raw.empty, "Classic", "Love", R.color.album_love_color));
        songs.add(new Song("Love", "Pretty", R.drawable.album_love_s, "Love nine", R.raw.empty, "Classic", "Love", R.color.album_love_color));
        songs.add(new Song("Mountains", "Lora", R.drawable.album_mountains_s, "Mountains one", R.raw.empty, "Jazz", "Movie", R.color.album_mountains_color));
        songs.add(new Song("Mountains", "Lora", R.drawable.album_mountains_s, "Mountains one", R.raw.empty, "Jazz", "Movie", R.color.album_mountains_color));
        songs.add(new Song("Mountains", "Lora", R.drawable.album_mountains_s, "Mountains one", R.raw.empty, "Jazz", "Movie", R.color.album_mountains_color));
        songs.add(new Song("Mountains", "Lora", R.drawable.album_mountains_s, "Mountains one", R.raw.empty, "Jazz", "Movie", R.color.album_mountains_color));
        songs.add(new Song("Mountains", "Lora", R.drawable.album_mountains_s, "Mountains one", R.raw.empty, "Jazz", "Movie", R.color.album_mountains_color));
        songs.add(new Song("Mountains", "Lora", R.drawable.album_mountains_s, "Mountains one", R.raw.empty, "Jazz", "Movie", R.color.album_mountains_color));
        songs.add(new Song("Mountains", "Lora", R.drawable.album_mountains_s, "Mountains one", R.raw.empty, "Jazz", "Movie", R.color.album_mountains_color));
        songs.add(new Song("Mountains", "Lora", R.drawable.album_mountains_s, "Mountains one", R.raw.empty, "Jazz", "Movie", R.color.album_mountains_color));
        songs.add(new Song("Mountains", "Lora", R.drawable.album_mountains_s, "Mountains one", R.raw.empty, "Jazz", "Movie", R.color.album_mountains_color));
        songs.add(new Song("Sky", "Mini-me", R.drawable.album_sky_s, "Sky one", R.raw.empty, "Indie", "Coding", R.color.album_sky_color));
        songs.add(new Song("Sky", "Mini-me", R.drawable.album_sky_s, "Sky two", R.raw.empty, "Indie", "Coding", R.color.album_sky_color));
        songs.add(new Song("Sky", "Mini-me", R.drawable.album_sky_s, "Sky three", R.raw.empty, "Indie", "Coding", R.color.album_sky_color));
        songs.add(new Song("Sky", "Mini-me", R.drawable.album_sky_s, "Sky four", R.raw.empty, "Indie", "Coding", R.color.album_sky_color));
        songs.add(new Song("Sky", "Mini-me", R.drawable.album_sky_s, "Sky five", R.raw.empty, "Indie", "Coding", R.color.album_sky_color));
        songs.add(new Song("Sky", "Mini-me", R.drawable.album_sky_s, "Sky six", R.raw.empty, "Indie", "Coding", R.color.album_sky_color));
        songs.add(new Song("Sky", "Mini-me", R.drawable.album_sky_s, "Sky seven", R.raw.empty, "Indie", "Coding", R.color.album_sky_color));
        songs.add(new Song("Sky", "Mini-me", R.drawable.album_sky_s, "Sky eight", R.raw.empty, "Indie", "Coding", R.color.album_sky_color));
        songs.add(new Song("Sky", "Mini-me", R.drawable.album_sky_s, "Sky nine", R.raw.empty, "Indie", "Coding", R.color.album_sky_color));
        songs.add(new Song("Miss you", "Flower", R.drawable.artist_flower_s, "Miss you one", R.raw.empty, "Pop", "Raining", R.color.album_missyou_color));
        songs.add(new Song("Miss you", "Flower", R.drawable.artist_flower_s, "Miss you two", R.raw.empty, "Pop", "Raining", R.color.album_missyou_color));
        songs.add(new Song("Miss you", "Flower", R.drawable.artist_flower_s, "Miss you three", R.raw.empty, "Pop", "Raining", R.color.album_missyou_color));
        songs.add(new Song("Miss you", "Flower", R.drawable.artist_flower_s, "Miss you four", R.raw.empty, "Pop", "Raining", R.color.album_missyou_color));
        songs.add(new Song("Miss you", "Flower", R.drawable.artist_flower_s, "Miss you five", R.raw.empty, "Pop", "Raining", R.color.album_missyou_color));
        songs.add(new Song("Miss you", "Flower", R.drawable.artist_flower_s, "Miss you six", R.raw.empty, "Pop", "Raining", R.color.album_missyou_color));
        songs.add(new Song("Miss you", "Flower", R.drawable.artist_flower_s, "Miss you seven", R.raw.empty, "Pop", "Raining", R.color.album_missyou_color));
        songs.add(new Song("Miss you", "Flower", R.drawable.artist_flower_s, "Miss you eight", R.raw.empty, "Pop", "Raining", R.color.album_missyou_color));
        songs.add(new Song("Miss you", "Flower", R.drawable.artist_flower_s, "Miss you nine", R.raw.empty, "Pop", "Raining", R.color.album_missyou_color));
        songs.add(new Song("Miss you", "Flower", R.drawable.artist_flower_s, "Miss you ten", R.raw.empty, "Pop", "Raining", R.color.album_missyou_color));
        songs.add(new Song("Home", "Country boy", R.drawable.artist_with_guitar_s, "Home one", R.raw.empty, "Country", "Love", R.color.album_home_color));
        songs.add(new Song("Home", "Country boy", R.drawable.artist_with_guitar_s, "Home two", R.raw.empty, "Country", "Love", R.color.album_home_color));
        songs.add(new Song("Home", "Country boy", R.drawable.artist_with_guitar_s, "Home three", R.raw.empty, "Country", "Love", R.color.album_home_color));
        songs.add(new Song("Home", "Country boy", R.drawable.artist_with_guitar_s, "Home four", R.raw.empty, "Country", "Love", R.color.album_home_color));
        songs.add(new Song("Home", "Country boy", R.drawable.artist_with_guitar_s, "Home five", R.raw.empty, "Country", "Love", R.color.album_home_color));
        songs.add(new Song("Home", "Country boy", R.drawable.artist_with_guitar_s, "Home six", R.raw.empty, "Country", "Love", R.color.album_home_color));
        songs.add(new Song("Home", "Country boy", R.drawable.artist_with_guitar_s, "Home seven", R.raw.empty, "Country", "Love", R.color.album_home_color));
        songs.add(new Song("Pressure", "Big G", R.drawable.artist_hiphop_s, "Pressure one", R.raw.empty, "Hip-Hop", "Workout", R.color.album_pressure_color));
        songs.add(new Song("Pressure", "Big G", R.drawable.artist_hiphop_s, "Pressure two", R.raw.empty, "Hip-Hop", "Workout", R.color.album_pressure_color));
        songs.add(new Song("Pressure", "Big G", R.drawable.artist_hiphop_s, "Pressure three", R.raw.empty, "Hip-Hop", "Workout", R.color.album_pressure_color));
        songs.add(new Song("Pressure", "Big G", R.drawable.artist_hiphop_s, "Pressure four", R.raw.empty, "Hip-Hop", "Workout", R.color.album_pressure_color));
        songs.add(new Song("Pressure", "Big G", R.drawable.artist_hiphop_s, "Pressure five", R.raw.empty, "Hip-Hop", "Workout", R.color.album_pressure_color));
        songs.add(new Song("Pressure", "Big G", R.drawable.artist_hiphop_s, "Pressure six", R.raw.empty, "Hip-Hop", "Workout", R.color.album_pressure_color));
        songs.add(new Song("Pressure", "Big G", R.drawable.artist_hiphop_s, "Pressure seven", R.raw.empty, "Hip-Hop", "Workout", R.color.album_pressure_color));
        songs.add(new Song("Pressure", "Big G", R.drawable.artist_hiphop_s, "Pressure eight", R.raw.empty, "Hip-Hop", "Workout", R.color.album_pressure_color));
        songs.add(new Song("Pressure", "Big G", R.drawable.artist_hiphop_s, "Pressure nine", R.raw.empty, "Hip-Hop", "Workout", R.color.album_pressure_color));
        songs.add(new Song("Pressure", "Big G", R.drawable.artist_hiphop_s, "Pressure ten", R.raw.empty, "Hip-Hop", "Workout", R.color.album_pressure_color));
        songs.add(new Song("Rock star", "Billie Jean", R.drawable.rockstar_s, "Rock star one", R.raw.empty, "Rock", "Movie", R.color.album_rockstar_color));
        songs.add(new Song("Rock star", "Billie Jean", R.drawable.rockstar_s, "Rock star two", R.raw.empty, "Rock", "Movie", R.color.album_rockstar_color));
        songs.add(new Song("Rock star", "Billie Jean", R.drawable.rockstar_s, "Rock star three", R.raw.empty, "Rock", "Movie", R.color.album_rockstar_color));
        songs.add(new Song("Rock star", "Billie Jean", R.drawable.rockstar_s, "Rock star four", R.raw.empty, "Rock", "Movie", R.color.album_rockstar_color));
        songs.add(new Song("Rock star", "Billie Jean", R.drawable.rockstar_s, "Rock star five", R.raw.empty, "Rock", "Movie", R.color.album_rockstar_color));
        songs.add(new Song("Rock star", "Billie Jean", R.drawable.rockstar_s, "Rock star six", R.raw.empty, "Rock", "Movie", R.color.album_rockstar_color));

        int size = songs.size();//Song array list size
        ArrayList<Integer> positionsToRemove = new ArrayList<>();

        //Loop for checking what songs from list to remove.
        for (int i = 0; i < size; i++) {
            if (!songs.get(i).getMood().equals(mood) && !songs.get(i).getGenre().equals(mood) && !songs.get(i).getAlbumName().equals(album) && !songs.get(i).getArtistName().equals(artist)) {
                positionsToRemove.add(i);
            }
        }

        int removeSize = positionsToRemove.size();

        for (int i = 0; i < removeSize; i++) {
            int removeThisPosition = positionsToRemove.get(i);
            songs.remove(removeThisPosition - i);
        }

        //Create a MoodAdapter adapter.
        final SongAdapter adapter = new SongAdapter(this, songs);

        //Set adapter to GridView.
        songList.setAdapter(adapter);

    }
    @Override
    //Solution from https://stackoverflow.com/questions/15686555/display-back-button-on-action-bar
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
