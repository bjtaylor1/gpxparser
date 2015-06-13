package com.bjt.gpxparser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class GpxParser {
    private final Persister persister;
    private final Gson gson;

    public GpxParser() {
        persister = new Persister();
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

    }
    public Gpx parseGpx(final InputStream inputStream) throws Exception {
        return persister.read(Gpx.class, inputStream);
    }

    public TrackPoint[] parseTrackpointsFromJson(InputStream inputStream) throws IOException {
        final String jsonString = IOUtils.toString(inputStream);
        return gson.fromJson(jsonString, TrackPoint[].class);
    }

    public void toJson(List<TrackPoint> trackPoints, Appendable writer) {
        gson.toJson(trackPoints.toArray(new TrackPoint[] {}), writer);
    }
}
