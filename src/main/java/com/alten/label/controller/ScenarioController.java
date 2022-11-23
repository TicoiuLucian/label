package com.alten.label.controller;

import com.alten.label.controller.model.CampaignModel;
import com.alten.label.entity.Campaign;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class ScenarioController {


    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public void upload(@RequestPart("file") @Valid @NotNull @NotBlank MultipartFile multipartFile) {

        try {
            final String fileLocation = saveMultipartToDisk(multipartFile);
//            Path file = ResourceUtils.getFile(fileLocation).toPath();
            CampaignModel response = objectMapper.readValue(new File(fileLocation), CampaignModel.class);
            System.out.println(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private String saveMultipartToDisk(MultipartFile multipartFile) throws Exception {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
        String fileName = date + multipartFile.getOriginalFilename();
        String fileLocation = new File("src\\main\\resources\\static\\uploads").getAbsolutePath() + "\\" + fileName;
        FileOutputStream output = new FileOutputStream(fileLocation);
        output.write(multipartFile.getBytes());
        output.close();
        return fileLocation;
    }
}
