package com.bjt.gpxparser;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Ben.Taylor on 16/04/2015.
 */
@Root(strict = false)
public class TrackSegment {
    @ElementList(entry = "trkpt", type = TrackPoint.class, inline = true)
    private List<TrackPoint> trackPoints;

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }
}
