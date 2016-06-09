package com.bjt.gpxparser;

import junit.framework.Assert;
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
public class ZipTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ZipTest(String testName)
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ZipTest.class );
    }

    public void testTwoGpxs() throws Exception {
        final GeoFile geoFile = getGeoFile("/TwoGpxTracks.zip");
        Assert.assertEquals(2, geoFile.getTracks().size());
    }

    public void testOneGpxOneTcx() throws Exception {
        final GeoFile geoFile = getGeoFile("/GpxTrackAndTcxTrack.zip");
        Assert.assertEquals(2, geoFile.getTracks().size());
    }

    public void testTwoTcxs() throws Exception {
        final GeoFile geoFile = getGeoFile("/TwoTcxTracks.zip");
        Assert.assertEquals(2, geoFile.getTracks().size());
    }

    public void testZipInAZip() throws Exception {
        final GeoFile geoFile = getGeoFile("/ZipInsideAnotherZip.zip");
        Assert.assertEquals(3, geoFile.getTracks().size());
    }


    private GeoFile getGeoFile(final String fileName) throws Exception {
        final InputStream inputStream = getClass().getResourceAsStream(fileName);
        final GeoFileParser gpxparser = new GeoFileParser();
        return gpxparser.parseGeoFile(inputStream, fileName);
    }

}
