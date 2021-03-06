package com.bjt.gpxparser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

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

    public void testCreator() throws Exception {
        final String name = "/300plains-trax.gpx";
        final GeoFile plainsGpx = getGeoFile(name);
        assertEquals("MapSource 6.13.7", plainsGpx.getCreator());
    }

    public void testPlainsGpx() throws Exception {
        final String name = "/300plains-trax.gpx";
        final GeoFile plainsGpx = getGeoFile(name);
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

    public void testPlainsTcx() throws Exception {
        final String name = "/300plains-trax.tcx";
        final GeoFile plainsGpx = getGeoFile(name);
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
    }

    public void testSample1Tcx() throws Exception {
        final String name = "/Sample1.tcx";
        final GeoFile plainsGpx = getGeoFile(name);
        assertEquals(1, plainsGpx.getTracks().size());

        for(final Track track : plainsGpx.getTracks()) {

            assertTrue(track.getTrackSegments().size() > 0);

            for(final TrackSegment trackSegment : track.getTrackSegments()) {

                assertTrue(trackSegment.getTrackPoints().size() > 0);
                for (final TrackPoint trackPoint : trackSegment.getTrackPoints()) {
                    assertTrue(trackPoint.getLat() > 49);
                    assertTrue(trackPoint.getLat() < 59);
                    assertTrue(trackPoint.getLon() < -1);
                    assertTrue(trackPoint.getLon() > -4);
                }
            }
        }
    }

    public void testSample2Tcx() throws Exception {
        final String name = "/Sample2.tcx";
        final GeoFile plainsGpx = getGeoFile(name);
        assertEquals(1, plainsGpx.getTracks().size());
        assertEquals("TRACK1", plainsGpx.getTracks().get(0).getName());
        for(final Track track : plainsGpx.getTracks()) {

            assertTrue(track.getTrackSegments().size() > 0);

            for(final TrackSegment trackSegment : track.getTrackSegments()) {

                assertTrue(trackSegment.getTrackPoints().size() > 0);
                for (final TrackPoint trackPoint : trackSegment.getTrackPoints()) {
                    assertTrue(trackPoint.getLat() > 49);
                    assertTrue(trackPoint.getLat() < 59);
                    assertTrue(trackPoint.getLon() < -1);
                    assertTrue(trackPoint.getLon() > -4);
                }
            }
        }
    }

    public void testSimple() throws Exception {
        String fileName = "/simple.gpx";
        final GeoFile simpleGpx = getGeoFile(fileName);

        assertEquals(2, simpleGpx.getTracks().size());
    }

    public void testFiles() throws Exception {
        getGeoFile("/Acceptable.gpx");
        getGeoFile("/Intended.gpx");
    }

    private GeoFile getGeoFile(String fileName) throws Exception {
        final InputStream inputStream = getClass().getResourceAsStream(fileName);
        final GeoFileParser gpxparser = new GeoFileParser();
        return gpxparser.parseGeoFile(inputStream, fileName);
    }

    public void testIntended() throws Exception {
        final GeoFile simpleGpx = getGeoFile("/simple.gpx.xml");

        assertEquals(2, simpleGpx.getTracks().size());
    }

    public void testParseTrackFromJson() throws IOException {
        final InputStream jsonStream = getClass().getResourceAsStream("/trackpoints.json");
        final GeoFileParser geoFileParser = new GeoFileParser();
        final GpxTrackPoint[] trackPoints = geoFileParser.parseTrackpointsFromJson(jsonStream);

        assertEquals(3, trackPoints.length);

        assertEquals(53.1, trackPoints[0].getLat());
        assertEquals(-0.2, trackPoints[0].getLon());

        assertEquals(53.2, trackPoints[1].getLat());
        assertEquals(-0.3, trackPoints[1].getLon());

        assertEquals(53.3, trackPoints[2].getLat());
        assertEquals(-0.4, trackPoints[2].getLon());

    }

    public void testParseTrackToJson() {
        final List<GpxTrackPoint> trackPoints = new ArrayList<GpxTrackPoint>();
        trackPoints.add(new GpxTrackPoint(53.1, -2.1));
        trackPoints.add(new GpxTrackPoint(53.2, -2.2));
        final GeoFileParser geoFileParser = new GeoFileParser();
        final StringWriter stringWriter = new StringWriter();
        geoFileParser.toJson(trackPoints, stringWriter);
        final String jsonString = stringWriter.toString();
        assertEquals("[{\"lat\":53.1,\"lon\":-2.1},{\"lat\":53.2,\"lon\":-2.2}]", jsonString);
    }
}
