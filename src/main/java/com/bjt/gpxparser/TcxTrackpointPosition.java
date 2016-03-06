package com.bjt.gpxparser;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Ben.Taylor on 06/03/2016.
 */
@Root(strict = false)
public class TcxTrackpointPosition {
    public TcxTrackpointPosition(double latitudeDegrees, double longitudeDegrees) {
        this.latitudeDegrees = latitudeDegrees;
        this.longitudeDegrees = longitudeDegrees;
    }

    public TcxTrackpointPosition() {
    }

    @Element(name = "LatitudeDegrees")
    private double latitudeDegrees;
    @Element(name = "LongitudeDegrees")
    private double longitudeDegrees;

    public double getLatitudeDegrees() {
        return latitudeDegrees;
    }

    public double getLongitudeDegrees() {
        return longitudeDegrees;
    }
}
