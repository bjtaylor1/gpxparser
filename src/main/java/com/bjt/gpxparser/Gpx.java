package com.bjt.gpxparser;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ben.Taylor on 16/04/2015.
 */
@Root(name = "gpx", strict = false)
public class Gpx implements GeoFile {


    @Override
    public String getCreator() {
        return creator;
    }

    public void setCreator(final String creator) {
        this.creator = creator;
    }

    @Attribute(name = "creator", required = false)
    private String creator;

    @ElementList(entry = "trk", type = GpxTrack.class, inline = true)
    private List<? extends Track> tracks;

    @XmlTransient
    private List<Track> originalTracks;

    @Override
    public List<? extends Track> getTracks() {
        return tracks;
    }

    public Gpx() {
    }

    public Gpx(List<? extends Track> tracks) {
        this.tracks = tracks;
    }

    public static Gpx fromTrackpoints(final List<TrackPoint> trackPoints) {
        return new Gpx(Arrays.asList(GpxTrack.fromTrackpoints(trackPoints)));
    }

    public static GeoFile combineTracks(final GeoFile... sourceGpxs) {
        final List<Track> allTracks = new ArrayList<>();
        String creator = null;
        for(final GeoFile gpx : sourceGpxs) {
            allTracks.addAll(gpx.getTracks());
            if(creator == null) creator = gpx.getCreator();
        }
        final Gpx gpx = new Gpx(allTracks);
        gpx.setCreator(creator);
        return gpx;
    }

    @Override
    public void pruneTracks(final Collection<String> trackNamesToKeep) {
        if(originalTracks == null) {
            originalTracks = new ArrayList<>(tracks);
        } else {
            tracks = new ArrayList<>(originalTracks);
        }
        for(int i = tracks.size() - 1; i >= 0; i--) {
            if(!trackNamesToKeep.contains(tracks.get(i).getName())) {
                tracks.remove(i);
            }
        }

    }
}
