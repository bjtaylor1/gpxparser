package com.bjt.gpxparser;

        import org.simpleframework.xml.Element;
        import org.simpleframework.xml.ElementList;
        import org.simpleframework.xml.Root;

        import java.util.List;

/**
 * Created by Ben.Taylor on 16/04/2015.
 */
@Root(strict = false)
public class GpxTrack implements Track {
    @ElementList(entry = "trkseg", type = GpxTrackSegment.class, inline = true, required = false)
    private List<TrackSegment> trackSegments;

    @Element(required = false)
    private String name;

    @Override
    public List<TrackSegment> getTrackSegments() {
        return trackSegments;
    }

    @Override
    public String getName() {
        return name;
    }
}
