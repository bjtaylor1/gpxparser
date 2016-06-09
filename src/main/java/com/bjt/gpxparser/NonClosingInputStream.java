package com.bjt.gpxparser;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ben.Taylor on 09/06/2016.
 */
public class NonClosingInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    public NonClosingInputStream(InputStream in) {
        super(in);
    }

    @Override
    public void close() throws IOException {
        //do nothing
    }
}
