package com.bjt.gpxparser;

public class StatusResult {
    public StatusResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }

    boolean success;
    String error;
}
