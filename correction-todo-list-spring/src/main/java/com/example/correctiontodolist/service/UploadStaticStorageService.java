package com.example.correctiontodolist.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class UploadStaticStorageService implements UploadService {

    private String location = "images";
    @Override
    public String store(MultipartFile file) throws IOException {
        Path destinationFile = Paths.get("src","main","resources","static",location).resolve(Paths.get(file.getOriginalFilename())).toAbsolutePath();
        InputStream stream = file.getInputStream();
        Files.copy(stream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        return "images/"+file.getOriginalFilename();
    }
}
