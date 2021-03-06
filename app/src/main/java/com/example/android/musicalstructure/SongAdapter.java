package com.example.android.musicalstructure;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Greta Grigutė on 2018-03-14.
 */

public class SongAdapter extends ArrayAdapter<Song> {
    private Context context;

    /**
     * Create a new {@link SongAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param objects is the list of {@link Song}s to be displayed.
     */
    public SongAdapter(@NonNull Context context, @NonNull List<Song> objects) {
        super(context, 0, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        // Check if the existing view is being reused, otherwise inflate the view
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the song_list_item.xml layout with the ID album_name
        final TextView albumName = listItemView.findViewById(R.id.album_name);
        // Get album name from the current Song object and
        // set this text on the song item album name TextView
        albumName.setText(currentSong.getAlbumName());

        // Find the TextView in the song_list_item.xml layout with the ID album_item_artist
        TextView albumArtist = listItemView.findViewById(R.id.artist_name);
        // Get album artist name from the current Cover object and
        // set this text on the album item artist TextView
        albumArtist.setText(currentSong.getArtistName());

        // Find the ImageView in the song_list_item.xml layout with the ID album_image
        ImageView image = listItemView.findViewById(R.id.album_image);
        // Get the image resource ID from the current Song object and set the image to album_image
        image.setImageResource(currentSong.getImageResourceId());

        // Find the TextView in the song_list_item.xml layout with the ID album_item_artist
        TextView song = listItemView.findViewById(R.id.song_name);
        // Get album artist name from the current Cover object and
        // set this text on the album item artist TextView
        song.setText(currentSong.getSongName());

        final String album = currentSong.getAlbumName();
        final int albumImage = currentSong.getImageResourceId();
        final int albumColor = currentSong.getAlbumColorResourceId();
        final String artist = currentSong.getArtistName();
        final String playingSong = currentSong.getSongName();
        final int songFile = currentSong.getSongResourceId();

        song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, PlayerActivity.class);

                i.putExtra("album", album);
                i.putExtra("album_image", albumImage);
                i.putExtra("album_color", albumColor);
                i.putExtra("artist", artist);
                i.putExtra("song", playingSong);
                i.putExtra("song_file", songFile);

                context.startActivity(i);
            }
        });
        // Find the ImageButton in the song_list_item.xml layout with the ID play_button
        ImageButton playMusic = listItemView.findViewById(R.id.play_button);
        // Get the song resource ID from the current Song object and set the butto to play that song
        int songMusic = currentSong.getSongResourceId();
        final MediaPlayer playSong = MediaPlayer.create(getContext(), songMusic);
        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong.start();
            }
        });

        // Return the whole list item layout (containing 3 TextViews, an ImageView and music file)
        // so that it can be shown in the GridView
        return listItemView;
    }
}
