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
public class GeoFileParser {
    private final Persister persister;
    private final Gson gson;

    public GeoFileParser() {
        persister = new Persister();
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    public GeoFile parseGpx(final InputStream inputStream, String fileType) throws Exception {
        GeoFile returnValue;
        if("tcx".equalsIgnoreCase(fileType)) {
            returnValue = persister.read(Tcx.class, inputStream);
        } else {
            returnValue = persister.read(Gpx.class, inputStream);
        }
        return returnValue;
    }

    public GpxTrackPoint[] parseTrackpointsFromJson(InputStream inputStream) throws IOException {
        final String jsonString = IOUtils.toString(inputStream);
        return gson.fromJson(jsonString, GpxTrackPoint[].class);
    }

    public void toJson(List<GpxTrackPoint> trackPoints, Appendable writer) {
        gson.toJson(trackPoints.toArray(new GpxTrackPoint[] {}), writer);
    }
}
