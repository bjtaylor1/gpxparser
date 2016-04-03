package com.bjt.gpxparser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class PrunerTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PrunerTest(String testName)
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PrunerTest.class );
    }


    public void testPrune() throws Exception {
        final GeoFile geoFile = getGeoFile("/Acceptable_MultipleTracks.gpx");
        assertEquals("Acceptable1,Acceptable2,Acceptable3", (String)geoFile.getTracks().stream().map(o -> o.getName()).sorted().collect(Collectors.joining(",")));
        geoFile.pruneTracks(Arrays.asList("Acceptable1", "Acceptable3"));
        assertEquals("Acceptable1,Acceptable3", (String) geoFile.getTracks().stream().map(o -> o.getName()).sorted().collect(Collectors.joining(",")));
    }

    public void testPruneDifferentOrder() throws Exception {
        final GeoFile geoFile = getGeoFile("/Acceptable_MultipleTracks.gpx");
        assertEquals("Acceptable1,Acceptable2,Acceptable3", (String)geoFile.getTracks().stream().map(o -> o.getName()).sorted().collect(Collectors.joining(",")));
        geoFile.pruneTracks(Arrays.asList("Acceptable3", "Acceptable2"));
        assertEquals("Acceptable2,Acceptable3", (String) geoFile.getTracks().stream().map(o -> o.getName()).sorted().collect(Collectors.joining(",")));
    }

    private GeoFile getGeoFile(String name) throws Exception {
        final InputStream inputStream = getClass().getResourceAsStream(name);
        final GeoFileParser gpxparser = new GeoFileParser();
        return gpxparser.parseGeoFile(inputStream, name);
    }

}
