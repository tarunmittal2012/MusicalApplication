package com.example.tarunmittal.musicalapplication;
public class Album {
    private int albumImage;
    private String albumName;
    private String noOfSongs;

    public Album(int albumImage, String albumName, String songs) {
        this.albumImage = albumImage;
        this.albumName = albumName;
        this.noOfSongs = songs;
    }

    public String getSongs() {
        return noOfSongs;
    }

    public void setSongs(String songs) {
        this.noOfSongs = songs;
    }

    public int getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(int albumImage) {
        this.albumImage = albumImage;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
