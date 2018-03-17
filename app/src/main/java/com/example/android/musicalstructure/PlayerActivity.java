package com.example.android.musicalstructure;

import android.content.res.Resources;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Greta Grigutė on 2018-03-15.
 */

public class PlayerActivity extends AppCompatActivity {

    String artist;
    String album;
    int albumImage;
    String song;
    int songFile;
    int albumColor;
    ImageView playMusic;
    boolean volumeOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        album = extras.getString("album");
        albumImage = extras.getInt("album_image");
        albumColor = extras.getInt("album_color");
        artist = extras.getString("artist");
        song = extras.getString("song");
        songFile = extras.getInt("song_file");


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView title = findViewById(R.id.custom_title);
        title.setText(R.string.player);

        ImageView image = findViewById(R.id.album_image);
        image.setImageResource(albumImage);

        TextView albumName = findViewById(R.id.album_name);
        albumName.setText(album);

        TextView artistName = findViewById(R.id.artist_name);
        artistName.setText(artist);

        RelativeLayout playerLayout = findViewById(R.id.player);
        playerLayout.setBackgroundResource(albumColor);


        playMusic = findViewById(R.id.play);
        // Get the song resource ID from the current Song object and set the button to play that song

        final MediaPlayer playSong = MediaPlayer.create(this, songFile);
        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playSong.isPlaying()) {
                    playSong.pause();
                } else playSong.start();
            }
        });

        if (playSong.isPlaying()) {
            playMusic.setImageResource(R.drawable.ic_pause_white_36dp);
        }
        else playMusic.setImageResource(R.drawable.ic_play_arrow_white_36dp);

        final ImageView volume = findViewById(R.id.volume);
        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (volumeOn){
                playSong.setVolume(0,0);
                volume.setImageResource(R.drawable.ic_volume_off_white_24dp);
               volumeOn = false;}
                else {
                   playSong.setVolume(1,1);
                   volume.setImageResource(R.drawable.ic_volume_up_white_24dp);
                   volumeOn = true;
               }
            }
        });
    }
    @Override
    //Solution from https://stackoverflow.com/questions/15686555/display-back-button-on-action-bar
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
