package com.bagirapp.vivalamusica;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 2018.03.06..
 */

public class TrackAdapter extends ArrayAdapter {

    public TrackAdapter(Context context, ArrayList<Track> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_tracks, parent, false);
        }

        Track currentTrack = (Track) getItem(position);

        TextView composer = (TextView) listItemView.findViewById(R.id.composerName);
        composer.setText(currentTrack.composerName + "  - ");

        TextView album = (TextView) listItemView.findViewById(R.id.albumTitle);
        album.setText(currentTrack.getAlbumTitle());

        TextView track = (TextView) listItemView.findViewById(R.id.track);
        track.setText(currentTrack.getTrackNr());

        TextView duration = (TextView) listItemView.findViewById(R.id.trackDuration);

        duration.setText(currentTrack.getTimeDuration());

        return listItemView;
    }
}