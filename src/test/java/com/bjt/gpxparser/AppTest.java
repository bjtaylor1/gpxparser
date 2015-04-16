package com.bjt.gpxparser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
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
        assertTrue(true);
    }

    public void testSimple() throws Exception {
        final InputStream inputStream = getClass().getResourceAsStream("/simple.gpx.xml");

        final GpxParser gpxparser = new GpxParser();
        final Gpx simpleGpx = gpxparser.parseGpx(inputStream);

        assertEquals(2, simpleGpx.getTracks().size());
    }
}
