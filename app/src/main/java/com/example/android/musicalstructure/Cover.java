package com.example.android.musicalstructure;


/**
 * Created by Greta Grigutė on 2018-03-13.
 */

public class Cover {
    //String value Cover name (for moods/genres, artist name, album name)
    private String mCoverName;

    //String value Artist name (for additional info about album)
    private String mArtistName;

    //Integer value for resource id of image corresponding the cover (moods/genres, artist, album)
    private int mImageResourceId;

    /**
     * Constructs a new Cover object with initial values for cover name, additional info and image resource.
     *
     * @param coverName is album name.
     * @param artistName is the additional info about the artist.
     * @param imageResourceId is the resource id of the image corresponding album.
     */
    public Cover(String coverName, String artistName, int imageResourceId) {
      mCoverName = coverName;
       mArtistName = artistName;
       mImageResourceId = imageResourceId;
    }

    /**
     * Constructs a new Cover object with initial values for cover name and image resource.
     *
     * @param coverName       is mood/genre, artist name.
     * @param imageResourceId is the resource id of the image corresponding mood/genre, artist.
     */
    public Cover(String coverName, int imageResourceId) {
        mCoverName = coverName;
        mImageResourceId = imageResourceId;
    }

    /**
     * Gets the cover name string value in the Cover.
     *
     * @return current cover name in the Cover.
     */
    public String getCoverName() {
        return mCoverName;
    }

    /**
     * Gets the artist name string value in the Cover.
     *
     * @return current artist name in the Cover.
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Gets the image resource id in the Cover.
     *
     * @return current image resource id in the Cover.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
}
