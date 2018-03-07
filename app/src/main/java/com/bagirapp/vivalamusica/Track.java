package com.bagirapp.vivalamusica;

import java.util.Random;

/**
 * Created by User on 2018.03.03..
 */

public class Track {
    protected String composerName;
    protected String albumTitle;
    private String trackNr;
    private String timeDuration;


    public Track(String composerName, String albumTitle, String trackNr) {
        this.composerName = composerName;
        this.albumTitle = albumTitle;
        this.trackNr = trackNr;
        int timeDurationSec = new Random().nextInt(600);
        String trackDuration = timeDurationSec / 60 + ":";
        if (timeDurationSec % 60 < 10) {
            trackDuration += "0" + timeDurationSec % 60;
        } else {
            trackDuration += timeDurationSec % 60;
        }
        this.timeDuration = trackDuration;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getTrackNr() {
        return trackNr;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

}
