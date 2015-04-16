package com.bjt.gpxparser;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Ben.Taylor on 16/04/2015.
 */
@Root(strict = false)
public class Track {
    @ElementList(entry = "trkseg", type = TrackSegment.class, inline = true, required = false)
    private List<TrackSegment> trackSegments;

    public List<TrackSegment> getTrackSegments() {
        return trackSegments;
    }
}
