package com.alten.label.controller.swagger.doc;

import com.alten.label.controller.model.Dataset;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface DatasetDoc {

    @PostMapping("/upload")
    public ResponseEntity<Void> createDataset(@RequestBody Dataset dataset, @RequestParam("file") MultipartFile file);
}
