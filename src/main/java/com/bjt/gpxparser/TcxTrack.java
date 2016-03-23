package com.bjt.gpxparser;

/**
 * Created by Ben.Taylor on 06/03/2016.
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ben.Taylor on 16/04/2015.
 */
@Root(strict = false)
public class TcxTrack implements Track {
    @Element(required = false)
    private String name;

    @ElementList(entry = "Trackpoint", type = TcxTrackPoint.class, inline = true)
    private List<TrackPoint> trackPoints = new ArrayList<>();

    @Override
    public List<TrackSegment> getTrackSegments() {
        final TcxTrackSegment tcxTrackSegment = new TcxTrackSegment(trackPoints);
        final List<TrackSegment> trackSegments = Arrays.asList(tcxTrackSegment);
        return trackSegments;
    }

    @Override
    public String getName() {
        return name;
    }
}
