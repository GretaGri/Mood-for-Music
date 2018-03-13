package com.example.android.musicalstructure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Greta Grigutė on 2018-03-13.
 */

public class MoodAdapter extends ArrayAdapter<Cover> {

    /**Create a new {@link MoodAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param objects is the list of {@link Cover}s to be displayed.
     */
    public MoodAdapter(@NonNull Context context, @NonNull List<Cover> objects) {
        super(context, 0, objects);
    }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            // Check if the existing view is being reused, otherwise inflate the view
            View gridItemView = convertView;
            if(gridItemView == null) {
                gridItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.mood_item, parent, false);
            }
// Get the {@link Cover} object located at this position in the list
            Cover currentCover = getItem(position);

            // Find the TextView in the mood_item.xml layout with the ID mood_item_text
            TextView moodName = gridItemView.findViewById(R.id.mood_item_text);
            // Get the miwok translation from the current Word object and
            // set this text on the name TextView
            moodName.setText(currentCover.getCoverName());

            // Find the ImageView in the mood_item.xml layout with the ID mood_item_image
            ImageView image = gridItemView.findViewById(R.id.mood_item_image);
            // Get the image resource ID from the current Cover object and set the image to mood_item_image
            image.setImageResource(currentCover.getImageResourceId());

            // Return the whole list item layout (containing 1 TextView and an ImageView)
            // so that it can be shown in the GridView
            return gridItemView;
        }
}