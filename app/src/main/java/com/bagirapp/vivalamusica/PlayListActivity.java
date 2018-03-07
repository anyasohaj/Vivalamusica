package com.bagirapp.vivalamusica;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.bagirapp.vivalamusica.MainActivity.composer;

public class PlayListActivity extends AppCompatActivity {
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);


        // Create the screen
        //Get datas from the previous screen
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String albumTitle = "";

        if (bundle != null) {
            albumTitle = bundle.getString("albumTitle");
        }

        //Create adapter, attach listview
        ListView listView = (ListView) findViewById(R.id.tracksList);
        final ArrayList<Track> tracks = getResource(R.array.tracks, composer, albumTitle);

        final TrackAdapter adapter = new TrackAdapter(PlayListActivity.this, tracks);

        listView.setAdapter(adapter);

        // Set listView to clickable
        final TextView currentTrack = (TextView) findViewById(R.id.actualTrack);
        final TextView currentTime = (TextView) findViewById(R.id.timer);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Track currentObject = (Track) adapter.getItem(position);
                currentTrack.setText(currentObject.getTrackNr());
                currentTime.setText(currentObject.getTimeDuration());
                currentPosition = position;
            }
        });

        //for  play button's working
        final ImageView playPause = (ImageView) findViewById(R.id.play_pause);
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable = playPause.getDrawable();
                if (drawable.getConstantState().equals(getResources().getDrawable(R.drawable.ic_action_playback_play).getConstantState())) {
                    playPause.setImageResource(R.drawable.ic_action_playback_pause);
                    playPause.setContentDescription(getResources().getString(R.string.pause));
                } else {
                    playPause.setImageResource(R.drawable.ic_action_playback_play);
                    playPause.setContentDescription(getResources().getString(R.string.play));
                }
            }
        });

        //Set Previous  button to work
        final ImageView previous = (ImageView) findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPosition--;
                if (currentPosition >= 0) {
                    Track currentObject = (Track) adapter.getItem(currentPosition);
                    currentTrack.setText(currentObject.getTrackNr());
                    currentTime.setText(currentObject.getTimeDuration());
                }
            }
        });

        // Set NEXT button to work
        ImageView next = (ImageView) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPosition++;
                if (currentPosition < tracks.size()) {
                    Track currentObject = (Track) adapter.getItem(currentPosition);
                    currentTrack.setText(currentObject.getTrackNr());
                    currentTime.setText(currentObject.getTimeDuration());
                }
            }
        });

    }

    //gettint resources from string-array into ArrayList<T>
    public ArrayList<Track> getResource(int resource, String composerName, String albumTitle) {
        String[] tracksString = getResources().getStringArray(resource);
        ArrayList<Track> tracks = new ArrayList<>();

        for (int i = 0; i < tracksString.length; i++) {
            Track track = new Track(composerName, albumTitle, tracksString[i]);
            tracks.add(track);

        }
        return tracks;
    }
}