package com.bjt.gpxparser;

import java.util.List;

/**
 * Created by Ben.Taylor on 04/03/2016.
 */
public interface Track {
    List<TrackSegment> getTrackSegments();

    String getName();
}
