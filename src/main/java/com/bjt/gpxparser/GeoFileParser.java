package com.bjt.gpxparser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.simpleframework.xml.core.Persister;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class GeoFileParser {
    private final Persister persister;
    private final Gson gson;

    public GeoFileParser() {
        persister = new Persister();
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    public GeoFile parseGeoFile(final InputStream inputStream, String fileName) throws Exception {
        GeoFile returnValue;
        if(fileName.toLowerCase().endsWith("tcx")) {
            returnValue = readTcx(inputStream);
        } else {
            returnValue = persister.read(Gpx.class, inputStream);
        }
        return returnValue;
    }

    private GeoFile readTcx(final InputStream inputStream) throws JAXBException {
        final JAXBContext jaxbContext = JAXBContext.newInstance(TrainingCenterDatabaseT.class);
        final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        final JAXBElement<TrainingCenterDatabaseT> unmarshal = (JAXBElement<TrainingCenterDatabaseT>) jaxbUnmarshaller.unmarshal(inputStream);
        final TrainingCenterDatabaseT value = unmarshal.getValue();

        return value;

    }

    public GpxTrackPoint[] parseTrackpointsFromJson(InputStream inputStream) throws IOException {
        final String jsonString = IOUtils.toString(inputStream);
        return gson.fromJson(jsonString, GpxTrackPoint[].class);
    }

    public void toJson(List<GpxTrackPoint> trackPoints, Appendable writer) {
        gson.toJson(trackPoints.toArray(new GpxTrackPoint[] {}), writer);
    }
}
