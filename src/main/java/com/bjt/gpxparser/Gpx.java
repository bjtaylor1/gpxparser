package com.bjt.gpxparser;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Ben.Taylor on 16/04/2015.
 */
@Root(name = "gpx", strict = false)
public class Gpx implements GeoFile {

    @ElementList(entry = "trk", type = GpxTrack.class, inline = true)
    private List<Track> tracks;

    @XmlTransient
    private List<Track> originalTracks;

    @Override
    public List<Track> getTracks() {
        return tracks;
    }

    @Override
    public void pruneTracks(final Collection<String> trackNamesToKeep) {
        if(originalTracks == null) {
            originalTracks = new ArrayList<>(tracks);
        } else {
            tracks = new ArrayList<>(originalTracks);
        }
        tracks.removeIf(track -> !trackNamesToKeep.contains(track.getName()));
    }
}
