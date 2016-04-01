package com.bjt.gpxparser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.InputStream;

/**
 * Created by Ben.Taylor on 01/04/2016.
 */
public class ActualnessTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ActualnessTest(String testName)
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ActualnessTest.class );
    }

    public void testSample1IsActual() throws Exception {
        final GeoFile sample1Tcx = getGeoFile("/Sample1.tcx");

        final StatusResult check = Actualness.check(sample1Tcx);
        assertTrue(check.isSuccess());
    }

    public void testSample1NoElevationsNotActual() throws Exception {
        final GeoFile sample1Tcx = getGeoFile("/Sample1_NoElevations.tcx");

        final StatusResult check = Actualness.check(sample1Tcx);
        assertFalse(check.isSuccess());
        System.out.println(check.getError());
    }

    public void testSample1NoTimesNotActual() throws Exception {
        final GeoFile sample1Tcx = getGeoFile("/Sample1_NoTimes.tcx");

        final StatusResult check = Actualness.check(sample1Tcx);
        assertFalse(check.isSuccess());
        System.out.println(check.getError());
    }

    public void testSample1ZeroElevationsIsActual() throws Exception {
        final GeoFile sample1Tcx = getGeoFile("/Sample1_AllElevationsZero.tcx");

        final StatusResult check = Actualness.check(sample1Tcx);
        assertTrue(check.isSuccess());
        System.out.println(check.getError());
    }

    public void testAcceptableIsActual() throws Exception {
        final GeoFile sample1Tcx = getGeoFile("/Acceptable.gpx");

        final StatusResult check = Actualness.check(sample1Tcx);
        assertTrue(check.isSuccess());
    }

    public void testAcceptableNoElevationsNotActual() throws Exception {
        final GeoFile sample1Tcx = getGeoFile("/Acceptable_NoElevations.gpx");

        final StatusResult check = Actualness.check(sample1Tcx);
        assertFalse(check.isSuccess());
        System.out.println(check.getError());
    }

    public void testAcceptableNoTimesNotActual() throws Exception {
        final GeoFile sample1Tcx = getGeoFile("/Acceptable_NoTimes.gpx");

        final StatusResult check = Actualness.check(sample1Tcx);
        assertFalse(check.isSuccess());
        System.out.println(check.getError());
    }

    public void testAcceptableZeroElevationsIsActual() throws Exception {
        final GeoFile sample1Tcx = getGeoFile("/Acceptable_AllElevationsZero.gpx");

        final StatusResult check = Actualness.check(sample1Tcx);
        assertTrue(check.isSuccess());
        System.out.println(check.getError());
    }

    public void testIntendedNotActual() throws Exception {
        final GeoFile sample1Tcx = getGeoFile("/Intended.gpx");

        final StatusResult check = Actualness.check(sample1Tcx);
        assertFalse(check.isSuccess());
        System.out.println(check.getError());
    }


    private GeoFile getGeoFile(String name) throws Exception {
        final InputStream inputStream = getClass().getResourceAsStream(name);
        final GeoFileParser gpxparser = new GeoFileParser();
        return gpxparser.parseGeoFile(inputStream, name);
    }
}
