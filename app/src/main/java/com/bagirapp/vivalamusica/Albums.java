package com.bagirapp.vivalamusica;

/**
 * Created by User on 2018.03.05..
 */

public class Albums {
    protected String composerName;
    protected String albumTitle;

    public Albums(String composerName, String albumTitle) {
        this.composerName = composerName;
        this.albumTitle = albumTitle;
    }

    public String getComposerName() {
        return composerName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }
}
