package com.bjt.gpxparser;

import java.io.InputStream;

/**
 * Created by Ben.Taylor on 01/04/2016.
 */
public class Actualness {
    public static StatusResult check(final GeoFile geoFile) {
        for (final Track track:        geoFile.getTracks()){
            for(final TrackSegment trackSeg : track.getTrackSegments()) {
                for(final TrackPoint  trackPoint : trackSeg.getTrackPoints()) {
                    if(trackPoint.getElevation() == null) {
                        return new StatusResult(false, "At least one trackpoint has no elevation information.");
                    }
                    if(trackPoint.getTime() == null || trackPoint.getTime().isEmpty()) {
                        return new StatusResult(false, "At least one trackpoint has no time information.");
                    }
                }
            }

        }
        return new StatusResult(true, "");
    }
}

