package com.example.correctiontodolist.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {
    String store(MultipartFile file) throws IOException;
}
