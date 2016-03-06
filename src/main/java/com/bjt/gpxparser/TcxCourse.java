package com.bjt.gpxparser;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Ben.Taylor on 06/03/2016.
 */
@Root(strict = false)
public class TcxCourse {
    @ElementList(entry = "Track", type = TcxTrack.class, inline = true)
    private List<Track> tracks;

    @Element(name = "Name")
    private String name;

    public List<Track> getTracks() {
        return tracks;
    }

    public String getName() {
        return name;
    }

}
