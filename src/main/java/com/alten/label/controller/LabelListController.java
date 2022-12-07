package com.alten.label.controller;

import com.alten.label.controller.model.LabelList;
import com.alten.label.service.LabelListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/labels")
public class LabelListController {

    @Autowired
    LabelListService labelListService;

    @PostMapping(value = "/import", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> upload(@RequestBody LabelList labelList) throws Exception {
        return labelListService.convertRequestBodyToJsonFile(labelList);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getList(@RequestParam(required = false) String path) {
        return labelListService.getLabelList(path);
    }

    @GetMapping(value = "/file-content", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getFileContent(@RequestParam(name = "file_to_read") String fileToRead) {
        return labelListService.getFileContent(fileToRead);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Void> delete(@RequestParam(name = "file_to_delete") String fileToDelete) {
        try {
            labelListService.deleteFile(fileToDelete);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

