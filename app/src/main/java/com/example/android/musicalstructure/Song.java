package com.example.android.musicalstructure;

/**
 * Created by Greta Grigutė on 2018-03-14.
 */

public class Song {
    //String value Album name
    private String mAlbumName;

    //String value Artist name
    private String mArtistName;

    //Integer value for resource id of image corresponding the album
    private int mImageResourceId;

    //String value Song name
    private String mSongName;

    //Integer value for resource id of the song file.
    private int mSongResourceId;

    /**
     * Constructs a new Song object with initial values for album name, artist name, song name, song file and image resource.
     *
     * @param albumName is album name.
     * @param artistName is the additional info about the artist.
     * @param imageResourceId is the resource id of the image corresponding album.
     * @param songName is the song name.
     * @param songResourceId is the resource id of the song file.
     */
    public Song(String albumName, String artistName, int imageResourceId, String songName, int songResourceId) {
        mAlbumName = albumName;
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
        mSongName = songName;
        mSongResourceId = songResourceId;
    }


    /**
     * Gets the album name string value in the Song.
     *
     * @return current album name in the Song.
     */
    public String getAlbumName() {
        return mAlbumName;
    }

    /**
     * Gets the artist name string value in the Song.
     *
     * @return current artist name in the Song.
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Gets the image resource id in the Song.
     *
     * @return current image resource id in the Song.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
    /**
     * Gets the song name string value in the Song.
     *
     * @return current artist name in the Song.
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Gets the song resource id in the Song.
     *
     * @return current song resource id in the Song.
     */
    public int getSongResourceId() {
        return mSongResourceId;
    }
}
