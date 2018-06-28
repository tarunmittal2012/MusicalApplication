package com.example.tarunmittal.musicalapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
public class Playlist extends AppCompatActivity {
    @BindView(R.id.playlist)
    ListView playList;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.backButton) {
            Intent back = new Intent(Playlist.this, MainActivity.class);
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
        setContentView(R.layout.activity_playlist);
        ButterKnife.bind(this);
        String[] playlistItem = {
                getString(R.string.punjabi),
                getString(R.string.english),
                getString(R.string.bollywood),
                getString(R.string.artist)
        };
        ArrayAdapter<String> playlistAdapter = new ArrayAdapter<String>(this, R.layout.customplaylist, playlistItem);
        playList.setAdapter(playlistAdapter);
        playList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent moveToPunjabi = new Intent(Playlist.this, Punjabi.class);
                    startActivityForResult(moveToPunjabi, 0);
                } else if (position == 1) {
                    Intent moveToEnglish = new Intent(Playlist.this, English.class);
                    startActivityForResult(moveToEnglish, 0);
                } else if (position == 2) {
                    Intent moveToBollywood = new Intent(Playlist.this, Bollywood.class);
                    startActivityForResult(moveToBollywood, 0);
                } else if (position == 3) {
                    Intent moveToArtist = new Intent(Playlist.this, Artist.class);
                    startActivityForResult(moveToArtist, 0);
                }
            }
        });
    }
}
