package com.organisation.organisation.utils;

import org.springframework.stereotype.Service;


public class utils {
    public static String getExtensionFromContentType(String contentType) {
        switch (contentType) {
            case "image/jpeg": return ".jpg";
            case "image/png": return ".png";
            case "image/gif": return ".gif";
            case "image/bmp": return ".bmp";
            case "image/webp": return ".webp";
            case "image/tiff": return ".tiff";
            case "image/x-icon": return ".ico";

            case "application/pdf": return ".pdf";
            case "application/msword": return ".doc";
            case "application/vnd.openxmlformats-officedocument.wordprocessingml.document": return ".docx";
            case "application/vnd.ms-excel": return ".xls";
            case "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet": return ".xlsx";
            case "application/vnd.ms-powerpoint": return ".ppt";
            case "application/vnd.openxmlformats-officedocument.presentationml.presentation": return ".pptx";

            case "application/zip": return ".zip";
            case "application/x-rar-compressed": return ".rar";
            case "application/x-7z-compressed": return ".7z";
            case "application/gzip": return ".gz";

            case "application/json": return ".json";
            case "application/xml": return ".xml";
            case "application/javascript": return ".js";

            case "text/plain": return ".txt";
            case "text/csv": return ".csv";
            case "text/html": return ".html";
            case "text/css": return ".css";

            case "audio/mpeg": return ".mp3";
            case "audio/ogg": return ".ogg";
            case "audio/wav": return ".wav";
            case "audio/x-aac": return ".aac";
            case "audio/webm": return ".weba";

            case "video/mp4": return ".mp4";
            case "video/webm": return ".webm";
            case "video/ogg": return ".ogv";
            case "video/x-msvideo": return ".avi";
            case "video/mpeg": return ".mpeg";

            case "application/octet-stream": return ".bin"; // Generic binary file
            case "application/x-shockwave-flash": return ".swf";
            case "application/vnd.android.package-archive": return ".apk";
            case "application/x-msdownload": return ".exe";

            default: return ""; // Default to no extension for unknown types
        }
    }
}
