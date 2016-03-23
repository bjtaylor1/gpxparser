package com.bjt.gpxparser;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben.Taylor on 23/03/2016.
 */
@Root(strict = false)
public class TcxLap {
    public List<TcxTrack> getTracks() {
        return tracks;
    }

    @ElementList(name = "Track", required = false, inline = true, type = TcxTrack.class)
    private List<TcxTrack> tracks = new ArrayList<>();
}
