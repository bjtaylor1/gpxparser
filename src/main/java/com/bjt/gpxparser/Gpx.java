package com.bjt.gpxparser;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Ben.Taylor on 16/04/2015.
 */
@Root(name = "gpx", strict = false)
public class Gpx implements GeoFile {

    @ElementList(entry = "trk", type = GpxTrack.class, inline = true)
    private List<Track> tracks;



    @Override
    public List<Track> getTracks() {
        return tracks;
    }
}

