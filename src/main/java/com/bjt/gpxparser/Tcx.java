package com.bjt.gpxparser;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben.Taylor on 06/03/2016.
 */

@Root(name = "TrainingCentreDatabase", strict = false)
public class Tcx implements GeoFile {

    @Element(name = "Courses", required = false)
    private TcxCourses courses = new TcxCourses();

    @Element(name = "Activities", required = false)
    private TcxActivities activities = new TcxActivities();

    @Override
    public List<Track> getTracks() {
        final List<Track> tracks = new ArrayList<>();
        for (final TcxCourse course : courses.getCourses()) {
            tracks.addAll(course.getTracks());
        }
        for(final TcxActivity activity : activities.getActivities()) {
            for(final TcxLap lap : activity.getLaps()) {
                tracks.addAll(lap.getTracks());
            }
        }
        return tracks;
    }

}

