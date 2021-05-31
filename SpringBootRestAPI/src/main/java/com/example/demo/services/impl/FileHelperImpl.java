package com.example.demo.services.impl;

import com.example.demo.exception.item.NotFoundException;
import com.example.demo.exception.item.UploadFileErrorException;
import com.example.demo.services.IFileHelper;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;

@Service
public class FileHelperImpl implements IFileHelper {
    /**
     * Upload file
     * @param uploadDir
     * @param multipartFile
     * @return
     */
    @Override
    public boolean uploadSingleFile(File uploadDir, MultipartFile multipartFile) {
        if(!uploadDir.exists()){
            uploadDir.mkdir();
        }
        String name = multipartFile.getOriginalFilename();
        if(name != null && name.length()> 0){
            try{
                // Create file
                File serverFile = new File(uploadDir.getPath()+"\\"+ name);
                BufferedOutputStream stream =
                        new BufferedOutputStream(
                                new FileOutputStream(serverFile)
                        );
                stream.write(multipartFile.getBytes());
                stream.close();
                return true;
            }catch (Exception e){
                throw new UploadFileErrorException("Can not upload file");
            }
        }
        throw new UploadFileErrorException("File not valid");
    }

    /**
     * Download file
     * @param file
     * @return
     */
    public ResponseEntity<?> download(File file){
        if (!file.exists()) {
            throw new NotFoundException("File not found");
        }

        UrlResource resource;
        try {
            resource = new UrlResource(file.toURI());
        } catch (MalformedURLException e) {
            throw new NotFoundException("File not found");
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(resource);
    }
}
