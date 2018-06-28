package com.example.tarunmittal.musicalapplication;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class AlbumAdapter extends ArrayAdapter<Album> {
    public AlbumAdapter(Context context, ArrayList<Album> albumArrayListayList) {
        super(context, 0, albumArrayListayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        Album word = getItem(position);
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.custom_grid, parent, false);
        }
        TextView albumName = listView.findViewById(R.id.albumName);
        ImageView albumImage = listView.findViewById(R.id.imageAlbum);
        TextView songNumber = listView.findViewById(R.id.songNumber);
        albumName.setText(word.getAlbumName());
        albumImage.setImageResource(word.getAlbumImage());
        songNumber.setText(word.getSongs());
        return listView;
    }
}
