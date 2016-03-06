package com.bjt.gpxparser;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Ben.Taylor on 06/03/2016.
 */
@Root(strict = false)
public class TcxTrackPoint implements TrackPoint {
    public TcxTrackPoint(double lat, double lon) {
        position = new TcxTrackpointPosition(lat, lon);
    }
    public TcxTrackPoint() {

    }

    @Element(name = "Position")
    private TcxTrackpointPosition position;

    @Element(name = "Time", required = false)
    private String time;

    @Override
    public double getLat() {
        return position.getLatitudeDegrees();
    }

    @Override
    public double getLon() {
        return position.getLongitudeDegrees();
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
}
