package com.bjt.gpxparser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class GpxParser {
    private final Persister persister;

    public GpxParser() {
        persister = new Persister();
    }
    public Gpx parseGpx(final InputStream inputStream) throws Exception {
        return persister.read(Gpx.class, inputStream);
    }

    public TrackPoint[] parseTrackpointsFromJson(InputStream inputStream) throws IOException {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        final String jsonString = IOUtils.toString(inputStream);
        return gson.fromJson(jsonString, TrackPoint[].class);
    }
}
