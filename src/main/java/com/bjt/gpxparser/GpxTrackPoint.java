package com.bjt.gpxparser;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Ben.Taylor on 16/04/2015.
 */
@Root(strict = false)
public class GpxTrackPoint implements TrackPoint {
    public GpxTrackPoint(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
    public GpxTrackPoint() {

    }

    @Attribute
    private double  lat;

    @Attribute
    private double lon;

    @Element(name = "time", required = false)
    private String time;

    @Element(name = "ele", required = false)
    private Double elevation;

    @Override
    public double getLat() {
        return lat;
    }

    @Override
    public double getLon() {
        return lon;
    }

    @Override
    public String getTime() {
        return time;
    }

    private String name;
    private String cmt;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCmt() {
        return cmt;
    }

    @Override
    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public Double getElevation() {
        return elevation;
    }
}
