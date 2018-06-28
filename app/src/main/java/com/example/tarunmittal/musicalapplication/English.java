package com.example.tarunmittal.musicalapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.ArrayList;
public class English extends AppCompatActivity {
    @BindView(R.id.playBar)
    LinearLayout playBar;
    @BindView(R.id.playBarImage)
    ImageView playBarImage;
    @BindView(R.id.playBarText)
    TextView playBarText;
    @BindView(R.id.playBarButton)
    Button playBarButton;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.backButton) {
            Intent back = new Intent(English.this, Playlist.class);
            startActivity(back);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater getMenu = getMenuInflater();
        getMenu.inflate(R.menu.homemenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        ButterKnife.bind(this);
        final ArrayList<Album> albums = new ArrayList<Album>();
        Album albumName = new Album(R.drawable.avatar2, getString(R.string.avatar2), getString(R.string.song3));
        albums.add(albumName);
        Album albumName1 = new Album(R.drawable.beirut, getString(R.string.beirut), getString(R.string.song8));
        albums.add(albumName1);
        Album albumName2 = new Album(R.drawable.betatest, getString(R.string.betatest), getString(R.string.song3));
        albums.add(albumName2);
        Album albumName3 = new Album(R.drawable.commando, getString(R.string.commando), getString(R.string.song5));
        albums.add(albumName3);
        Album albumName4 = new Album(R.drawable.gonegirl, getString(R.string.gonegirl), getString(R.string.song6));
        albums.add(albumName4);
        Album albumName5 = new Album(R.drawable.hisss, getString(R.string.hisss), getString(R.string.song8));
        albums.add(albumName5);
        Album albumName6 = new Album(R.drawable.iboy, getString(R.string.iboy), getString(R.string.song4));
        albums.add(albumName6);
        Album albumName7 = new Album(R.drawable.popeye, getString(R.string.popeye), getString(R.string.song8));
        albums.add(albumName7);
        Album albumName8 = new Album(R.drawable.rampage, getString(R.string.rampage), getString(R.string.song6));
        albums.add(albumName8);
        Album albumName9 = new Album(R.drawable.skyscraper, getString(R.string.skyscraper), getString(R.string.song6));
        albums.add(albumName9);
        Album albumName10 = new Album(R.drawable.snomannen, getString(R.string.snomannen), getString(R.string.song8));
        albums.add(albumName10);
        Album albumName11 = new Album(R.drawable.thor, getString(R.string.thor), getString(R.string.song11));
        albums.add(albumName11);
        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums);
        GridView albumGrid = (GridView) findViewById(R.id.grid_album);
        albumGrid.setAdapter(albumAdapter);
        albumGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                playBar.setVisibility(View.VISIBLE);
                playBarButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(English.this, "Song is playing", Toast.LENGTH_SHORT).show();
                    }
                });
                Album getSong = albums.get(position);
                playBarImage.setImageResource(getSong.getAlbumImage());
                playBarText.setText(getSong.getAlbumName());
            }
        });
    }
}
