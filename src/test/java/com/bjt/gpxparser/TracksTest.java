package com.bjt.gpxparser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class TracksTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TracksTest(String testName)
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TracksTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testPlains() throws Exception {
        final InputStream inputStream = getClass().getResourceAsStream("/300plains-trax.gpx.xml");
        final GpxParser gpxparser = new GpxParser();
        final Gpx plainsGpx = gpxparser.parseGpx(inputStream);
        assertEquals(7, plainsGpx.getTracks().size());

        for(final Track track : plainsGpx.getTracks()) {

            assertFalse(track.getName() == null || track.getName().isEmpty());
            System.out.println(track.getName());
            assertTrue(track.getTrackSegments().size() > 0);

            for(final TrackSegment trackSegment : track.getTrackSegments()) {

                assertTrue(trackSegment.getTrackPoints().size() > 0);
                for (final TrackPoint trackPoint : trackSegment.getTrackPoints()) {
                    assertTrue(trackPoint.getLat() > 49);
                    assertTrue(trackPoint.getLat() < 55);
                    assertTrue(trackPoint.getLon() < -1);
                    assertTrue(trackPoint.getLon() > -4);
                }
            }
        }
    }

    public void testSimple() throws Exception {
        final InputStream inputStream = getClass().getResourceAsStream("/simple.gpx.xml");

        final GpxParser gpxparser = new GpxParser();
        final Gpx simpleGpx = gpxparser.parseGpx(inputStream);

        assertEquals(2, simpleGpx.getTracks().size());
    }

    public void testParseTrackFromJson() throws IOException {
        final InputStream jsonStream = getClass().getResourceAsStream("/trackpoints.json");
        final GpxParser gpxParser = new GpxParser();
        final TrackPoint[] trackPoints = gpxParser.parseTrackpointsFromJson(jsonStream);

        assertEquals(3, trackPoints.length);

        assertEquals(53.1, trackPoints[0].getLat());
        assertEquals(-0.2, trackPoints[0].getLon());

        assertEquals(53.2, trackPoints[1].getLat());
        assertEquals(-0.3, trackPoints[1].getLon());

        assertEquals(53.3, trackPoints[2].getLat());
        assertEquals(-0.4, trackPoints[2].getLon());

    }
}