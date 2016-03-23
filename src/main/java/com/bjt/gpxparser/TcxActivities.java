package com.bjt.gpxparser;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben.Taylor on 23/03/2016.
 */
@Root(strict = false)
public class TcxActivities {

    @ElementList(entry = "Activity", required = false, type = TcxActivity.class, inline = true)
    private List<TcxActivity> activities = new ArrayList<>();

    public List<TcxActivity> getActivities() {
        return activities;
    }
}
