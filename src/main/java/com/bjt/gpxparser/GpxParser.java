package com.bjt.gpxparser;

import org.simpleframework.xml.core.Persister;

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
    public Gpx parseGpx(InputStream inputStream) throws Exception {
        return persister.read(Gpx.class, inputStream);
    }
}
