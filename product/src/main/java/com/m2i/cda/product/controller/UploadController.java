package com.m2i.cda.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("upload")
public class UploadController {


    private String location = "upload-dir";

    @GetMapping("form")
    public ModelAndView form(){
        ModelAndView vm = new ModelAndView("form-upload");
        return vm;
    }


    @GetMapping("files")
    @ResponseBody
    public List<String> getFiles() throws IOException {
        List<String> liste = new ArrayList<>();
        Files.walk(Paths.get(this.location)).forEach(path -> {
            liste.add(path.getFileName().toString());
        });
        return liste;
    }




    @PostMapping("submitForm")
    @ResponseBody
    public void submitForm(@RequestParam("image")MultipartFile image) throws IOException {
        Path destinationFile = Paths.get(location).resolve(Paths.get(image.getOriginalFilename())).toAbsolutePath();
        InputStream stream = image.getInputStream();
        Files.copy(stream, destinationFile, StandardCopyOption.REPLACE_EXISTING);

    }








}
