package com.bagirapp.vivalamusica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.bagirapp.vivalamusica.MainActivity.composer;

public class ComposerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composer);

        ArrayList<Albums> albums = new ArrayList<>();
        ImageView composerImage = (ImageView) findViewById(R.id.composerPic);

        switch (composer) {
            case "Mozart":
                albums = getResource(R.array.Mozart, "Mozart");
                composerImage.setImageResource(R.drawable.mozart);
                composerImage.setContentDescription("Picture of Mozart");
                break;
            case "Beethoven":
                albums = getResource(R.array.Beethoven, "Beethoven");
                composerImage.setImageResource(R.drawable.beethoven);
                composerImage.setContentDescription("Picture of Beethoven");
                break;
            case "Bach":
                albums = getResource(R.array.Bach, "Bach");
                composerImage.setImageResource(R.drawable.bach);
                composerImage.setContentDescription("Picture of Bach");
                break;
            case "Chopin":
                albums = getResource(R.array.Chopin, "Chopin");
                composerImage.setImageResource(R.drawable.chopin);
                composerImage.setContentDescription("Picture of Chopin");
                break;
        }


        // get the ArrayList from string resource file

        final AlbumsAdapter adapter = new AlbumsAdapter(ComposerActivity.this, albums);

        ListView listView = (ListView) findViewById(R.id.albums);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ComposerActivity.this, PlayListActivity.class);
                intent.putExtra("composerName", composer);
                Albums clickedAlbum = (Albums) adapter.getItem(position);
                String albumtitle = clickedAlbum.getAlbumTitle();
                intent.putExtra("albumTitle", albumtitle);
                startActivity(intent);
            }
        });
    }

    // Create an ArrayList from a String resource
    public ArrayList<Albums> getResource(int resource, String composerName) {
        String[] albumsString = getResources().getStringArray(resource);
        ArrayList<Albums> mozartsAlbums = new ArrayList<>();

        for (int i = 0; i < albumsString.length; i++) {
            Albums mozart = new Albums(composerName, albumsString[i]);
            mozartsAlbums.add(mozart);
        }
        return mozartsAlbums;

    }
}
