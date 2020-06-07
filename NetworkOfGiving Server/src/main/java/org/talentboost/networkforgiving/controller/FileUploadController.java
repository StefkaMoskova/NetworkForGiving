package org.talentboost.networkforgiving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.talentboost.networkforgiving.service.FileUploadService;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "fileUpload")
public class FileUploadController {


    @Autowired
    FileUploadService fileUploadService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        fileUploadService.uploadFile(file);
    }
}