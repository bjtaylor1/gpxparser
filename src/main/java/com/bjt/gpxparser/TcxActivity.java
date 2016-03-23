package com.bjt.gpxparser;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben.Taylor on 23/03/2016.
 */
@Root(strict = false)
public class TcxActivity {
    public List<TcxLap> getLaps() {
        return laps;
    }

    @ElementList(name = "Lap", required = false, inline = true, type = TcxLap.class)
    private List<TcxLap> laps = new ArrayList<>();
}
