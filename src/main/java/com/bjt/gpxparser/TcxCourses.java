package com.bjt.gpxparser;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben.Taylor on 06/03/2016.
 */
@Root(strict = false)
public class TcxCourses {
    @ElementList(entry = "Course", type = TcxCourse.class, inline = true)
    private List<TcxCourse> courses = new ArrayList<>();

    public List<TcxCourse> getCourses() {
        return courses;
    }
}
