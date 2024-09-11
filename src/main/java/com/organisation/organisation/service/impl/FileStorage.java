package com.organisation.organisation.service.impl;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.organisation.organisation.models.FileResponse;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FileStorage {
    @Autowired
    private GridFSBucket gridFSBucket;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    // Store file in MongoDB
    public String storeFile(MultipartFile file) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(file.getBytes());

        // Get content type
        String contentType = file.getContentType();

        // Define upload options with content type metadata
        GridFSUploadOptions options = new GridFSUploadOptions()
                .metadata(new org.bson.Document("contentType", contentType));

        // Upload file to GridFS
        String fileId = gridFSBucket.uploadFromStream(file.getOriginalFilename(), inputStream, options).toString();

        return fileId;
    }

    // Retrieve file from MongoDB
    public FileResponse getFile(String fileId) throws IOException {
        ObjectId objectId;
        try {
            objectId = new ObjectId(fileId);
        } catch (IllegalArgumentException e) {
            throw new IOException("Invalid file ID format", e);
        }

        GridFSFile gridFSFile = gridFSBucket.find(new Document("_id",objectId)).first();

        if (gridFSFile == null) {
            throw new IOException("File not found");
        }

        // Retrieve the content type from metadata
        assert gridFSFile.getMetadata() != null;
        String contentType = gridFSFile.getMetadata().getString("contentType");

        GridFSDownloadStream downloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int data;
        while ((data = downloadStream.read()) != -1) {
            outputStream.write(data);
        }
        downloadStream.close();

        return new FileResponse(outputStream.toByteArray(), contentType);
    }
}
