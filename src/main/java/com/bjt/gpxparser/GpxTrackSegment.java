package com.bjt.gpxparser;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Ben.Taylor on 16/04/2015.
 */
@Root(strict = false)
public class GpxTrackSegment implements TrackSegment {
    @ElementList(entry = "trkpt", type = GpxTrackPoint.class, inline = true)
    private List<? extends TrackPoint> trackPoints;

    public GpxTrackSegment() {
    }

    public GpxTrackSegment(final List<? extends TrackPoint> trackPoints) {
        this.trackPoints = trackPoints;
    }

    @Override
    public List<? extends TrackPoint> getTrackPoints() {
        return trackPoints;
    }
}
