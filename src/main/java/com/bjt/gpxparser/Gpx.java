package com.bjt.gpxparser;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Ben.Taylor on 16/04/2015.
 */
@Root(name = "gpx", strict = false)
public class Gpx {

    @ElementList(entry = "trk", type = Track.class, inline = true)
    private List<Track> tracks;



    public List<Track> getTracks() {
        return tracks;
    }
}

