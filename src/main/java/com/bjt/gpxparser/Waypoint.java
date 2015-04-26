package com.bjt.gpxparser;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Ben.Taylor on 16/04/2015.
 */
@Root(strict = false)
public class Waypoint {
    @Attribute
    private double lat;

    @Attribute
    private double lon;

    @Element(required = false)
    private String name;

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getName() {
        return name;
    }
}
