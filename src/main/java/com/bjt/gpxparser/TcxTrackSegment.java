package com.bjt.gpxparser;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Ben.Taylor on 06/03/2016.
 */
public class TcxTrackSegment implements TrackSegment {
    public TcxTrackSegment(final List<TrackPoint> trackPoints) {
        this.trackPoints = trackPoints;
    }

    private final List<TrackPoint> trackPoints;

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }
}
