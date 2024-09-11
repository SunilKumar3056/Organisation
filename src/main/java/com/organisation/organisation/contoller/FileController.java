package com.organisation.organisation.contoller;

import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSDownloadOptions;
import com.organisation.organisation.models.FileResponse;
import com.organisation.organisation.service.impl.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

import static com.organisation.organisation.utils.utils.getExtensionFromContentType;

@RestController
public class FileController {
    @Autowired
    private FileStorage fileStorageService;

    // Upload a file
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String fileId = fileStorageService.storeFile(file);
        return ResponseEntity.ok("File uploaded with ID: " + fileId);
    }

    // Download a file
    @GetMapping("/download/{fileId}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileId) throws IOException {
        FileResponse fileResponse = fileStorageService.getFile(fileId);
        HttpHeaders headers = new HttpHeaders();
        String contentType = fileResponse.getContentType();
        String fileExtension = getExtensionFromContentType(contentType);

        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileId + fileExtension);
        headers.add(HttpHeaders.CONTENT_TYPE, fileResponse.getContentType());


        return new ResponseEntity<>(fileResponse.getFileData(), headers, HttpStatus.OK);
    }

}


