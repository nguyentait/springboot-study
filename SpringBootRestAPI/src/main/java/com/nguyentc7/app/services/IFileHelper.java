package com.nguyentc7.app.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface IFileHelper {
    public boolean uploadSingleFile(File uploadDir, MultipartFile multipartFile);
    public ResponseEntity<?> download( File file);
}
