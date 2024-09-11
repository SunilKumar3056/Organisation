package com.organisation.organisation.models;

public class FileResponse {
    private final byte[] fileData;
    private final String contentType;

    public FileResponse(byte[] fileData, String contentType) {
        this.fileData = fileData;
        this.contentType = contentType;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public String getContentType() {
        return contentType;
    }
}