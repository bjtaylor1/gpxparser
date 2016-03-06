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

    @Element(name = "Courses")
    private TcxCourses courses;

    @Override
    public List<Track> getTracks() {
        final List<Track> tracks = new ArrayList<>();
        for(final TcxCourse course : courses.getCourses()) {
            tracks.addAll(course.getTracks());
        }
        return tracks;
    }

}

