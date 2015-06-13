package com.bjt.gpxparser;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Ben.Taylor on 16/04/2015.
 */
@Root(strict = false)
public class TrackPoint {
    public TrackPoint(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
    public TrackPoint() {

    }

    @Attribute
    private double  lat;

    @Attribute
    private double lon;

    @Element(name = "time", required = false)
    private String time;

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getTime() {
        return time;
    }

    private String name;
    private String cmt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }
}
