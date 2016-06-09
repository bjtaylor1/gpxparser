package com.bjt.gpxparser;

import java.util.List;

/**
 * Created by Ben.Taylor on 04/03/2016.
 */
public interface Track {
    List<? extends TrackSegment> getTrackSegments();

    String getName();
}
