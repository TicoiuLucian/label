package com.alten.label.controller;

import com.alten.label.controller.model.LabelList;
import com.alten.label.controller.model.ListElement;
import com.alten.label.controller.model.Metadata;
import com.alten.label.controller.swagger.doc.LabelListDoc;
import com.alten.label.service.LabelListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class LabelListController implements LabelListDoc {

    @Autowired
    LabelListService labelListService;


    public ResponseEntity<Void> createLabelList(@RequestBody LabelList labelList) {
        try {
            labelListService.createLabelListJsonFile(labelList);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    public ResponseEntity<Void> addListElementsToLabelList(@RequestBody List<ListElement> listElements,
                                                           @RequestParam(name = "label-list-name") String labelListName) {
        try {
            labelListService.addListElementsToLabelList(listElements, labelListName);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    public List<LabelList> getAllLabelLists() {
        return labelListService.getLabelLists();
    }

    public List<String> getAllLabelListsFileName() {
        return labelListService.getAllLabelListsFileName();
    }

    public ResponseEntity<Void> addMetadataToLabelList(@RequestBody Metadata metadata,
                                                       @RequestParam(name = "label-list-name") String labelListName) {
        try {
            labelListService.addMetadataToLabelList(metadata, labelListName);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<String> upload(@RequestBody String labelListName) throws Exception {
        return labelListService.sendLabelListJsonToLabelServer(labelListName);
    }

    public ResponseEntity<Void> deleteLabelList(String labelListName) {
        try {
            labelListService.deleteLabelList(labelListName);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    public ResponseEntity<Void> deleteLabelFromLabelList(@RequestParam String labelListName, @RequestParam Long labelId) {
        try {
            labelListService.deleteLabelFromLabelList(labelListName, labelId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    public ResponseEntity<Void> updateLabelElementParents(@RequestParam(name = "label-list-name") String labelListName, @RequestParam(name = "label-id") Long labelId, @RequestBody List<ListElement> listElement) {
        try {
            labelListService.updateLabelElementParents(labelListName, labelId, listElement);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    public ResponseEntity<Void> updateLabelElement(@RequestParam(name = "label-list-name") String labelListName, @RequestParam(name = "label-id") Long labelId, @RequestBody ListElement listElement) {
        try {
            labelListService.updateLabelElement(labelListName, labelId, listElement);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
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


