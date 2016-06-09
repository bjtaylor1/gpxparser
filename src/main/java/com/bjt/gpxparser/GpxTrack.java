package com.bjt.gpxparser;

        import org.simpleframework.xml.Element;
        import org.simpleframework.xml.ElementList;
        import org.simpleframework.xml.Root;

        import java.util.Arrays;
        import java.util.List;

/**
 * Created by Ben.Taylor on 16/04/2015.
 */
@Root(strict = false)
public class GpxTrack implements Track {
    @ElementList(entry = "trkseg", type = GpxTrackSegment.class, inline = true, required = false)
    private List<? extends TrackSegment> trackSegments;

    @Element(required = false)
    private String name;

    public GpxTrack() {
    }

    public GpxTrack(final List<? extends TrackSegment> trackSegments) {
        this.trackSegments = trackSegments;
    }

    public static GpxTrack fromTrackpoints(final List<? extends TrackPoint> trackPoints){
        return new GpxTrack(Arrays.asList(new GpxTrackSegment(trackPoints)));
    }

    @Override
    public List<? extends TrackSegment> getTrackSegments() {
        return trackSegments;
    }

    @Override
    public String getName() {
        return name;
    }
}
