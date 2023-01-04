package com.alten.label.controller;


import com.alten.label.controller.model.Dataset;
import com.alten.label.controller.swagger.doc.DatasetDoc;
import com.alten.label.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/dataset")
public class DatasetController implements DatasetDoc {

    @Autowired
    private DatasetService datasetService;

    public ResponseEntity<Void> createDataset(@RequestBody Dataset dataset, @RequestParam("file") MultipartFile file) {
        try {
            datasetService.createDataset(dataset, file);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
