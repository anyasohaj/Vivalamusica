package com.bagirapp.vivalamusica;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 2018.03.05..
 */

public class AlbumsAdapter extends ArrayAdapter {

    public AlbumsAdapter(Activity context, ArrayList albums){
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_albums, parent, false);
        }

        Albums currentAlbum = (Albums) getItem(position);

        ImageView dvd = (ImageView) listItemView.findViewById(R.id.albumImage);
        dvd.setImageResource(R.drawable.clef);

        TextView composer = (TextView) listItemView.findViewById(R.id.composerName);
        composer.setText(currentAlbum.getComposerName());

        TextView title = (TextView) listItemView.findViewById(R.id.albumTitle);
        title.setText(currentAlbum.getAlbumTitle());

        return listItemView;
    }
}
