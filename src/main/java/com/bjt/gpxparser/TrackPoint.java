package com.bjt.gpxparser;

/**
 * Created by Ben.Taylor on 04/03/2016.
 */
public interface TrackPoint {
    double getLat();

    double getLon();

    String getTime();

    String getName();

    void setName(String name);

    String getCmt();

    void setCmt(String cmt);

    Double getElevation();
}
