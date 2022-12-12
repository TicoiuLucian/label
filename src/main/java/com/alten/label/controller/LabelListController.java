package com.alten.label.controller;

import com.alten.label.controller.model.LabelList;
import com.alten.label.controller.model.ListElement;
import com.alten.label.controller.model.Metadata;
import com.alten.label.service.LabelListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/label")
public class LabelListController {

    @Autowired
    LabelListService labelListService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createLabelList(@RequestBody LabelList labelList) {
        try {
            labelListService.createLabelListJsonFile(labelList);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/list-element", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addListElementsToLabelList(@RequestBody List<ListElement> listElements,
                                                           @RequestParam(name = "label-list-name") String labelListName) {
        try {
            labelListService.addListElementsToLabelList(listElements, labelListName);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public List<LabelList> getAllLabelLists() {
        return labelListService.getLabelLists();
    }

    @GetMapping(value = "/label-list-files")
    public List<String> getAllLabelListsFileName() {
        return labelListService.getAllLabelListsFileName();
    }

    @PostMapping(value = "/metadata", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addMetadataToLabelList(@RequestBody Metadata metadata,
                                                       @RequestParam(name = "label-list-name") String labelListName) {
        try {
            labelListService.addMetadataToLabelList(metadata, labelListName);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/import", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> upload(@RequestBody String labelListName) throws Exception {
        return labelListService.sendLabelListJsonToLabelServer(labelListName);
    }
//
//    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> getList(@RequestParam(required = false) String path) {
//        return labelListService.getLabelList(path);
//    }
//
//    @GetMapping(value = "/file-content", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> getFileContent(@RequestParam(name = "file_to_read") String fileToRead) {
//        return labelListService.getFileContent(fileToRead);
//    }
//
//    @DeleteMapping(value = "/delete")
//    public ResponseEntity<Void> delete(@RequestParam(name = "file_to_delete") String fileToDelete) {
//        try {
//            labelListService.deleteFile(fileToDelete);
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
}


