package com.example.android.musicalstructure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Greta Grigutė on 2018-03-14.
 */

public class AlbumAdapter extends ArrayAdapter<Cover> {

    /**Create a new {@link AlbumAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param objects is the list of {@link Cover}s to be displayed.
     */
    public AlbumAdapter(@NonNull Context context, @NonNull List<Cover> objects) {
        super(context, 0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View gridItemView = convertView;
        if(gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_item, parent, false);
        }
        // Get the {@link Cover} object located at this position in the list
        Cover currentCover = getItem(position);

        // Find the TextView in the album_item.xml layout with the ID album_item_name
        TextView albumName = gridItemView.findViewById(R.id.album_item_name);
        // Get album name from the current Cover object and
        // set this text on the album item name TextView
        albumName.setText(currentCover.getCoverName());

        // Find the TextView in the album_item.xml layout with the ID album_item_artist
        TextView albumArtist = gridItemView.findViewById(R.id.album_item_artist);
        // Get album artist name from the current Cover object and
        // set this text on the album item artist TextView
        albumArtist.setText(currentCover.getArtistName());

        // Find the ImageView in the album_item.xml layout with the ID album_item_image
        ImageView image = gridItemView.findViewById(R.id.album_item_image);
        // Get the image resource ID from the current Cover object and set the image to album_item_image
        image.setImageResource(currentCover.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the GridView
        return gridItemView;
    }
}
