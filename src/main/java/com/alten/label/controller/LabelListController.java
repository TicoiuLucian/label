package com.alten.label.controller;

import com.alten.label.controller.model.LabelList;
import com.alten.label.controller.model.ListElement;
import com.alten.label.controller.model.Metadata;
import com.alten.label.controller.swagger.doc.LabelListDoc;
import com.alten.label.service.LabelListService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "/labels")
public class LabelListController implements LabelListDoc {

    @Autowired
    LabelListService labelListService;


    @Override
    public ResponseEntity<Void> createLabelList(@RequestBody LabelList labelList) throws IOException {


    }

    @Override
    public ResponseEntity<Void> addListElementsToLabelList(List<ListElement> listElements) throws FileNotFoundException {
        //cauti fisierul in sistem
        try (FileReader reader = new FileReader("labelList.json"))
        {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
     //   } catch (ParseException e) {
            e.printStackTrace();
        }

        //mapezi fisierul pe obiect (LabelList)
        ObjectMapper mapper = new ObjectMapper();


        //adaugi listElements la LabelList
        //salvezi noul fisier
        return null;
    }

    @Override
    public ResponseEntity<Void> addMetadataToLabelList(Metadata metadata) {
        //cauti fisierul in sistem
        //mapezi fisierul pe obiect (LabelList)
        //adaugi metadata la LabelList
        //salvezi noul fisier
        return null;
    }

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


