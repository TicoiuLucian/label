package com.alten.label.controller;


import com.alten.label.controller.model.Data;
import com.alten.label.controller.swagger.doc.DataDoc;
import com.alten.label.service.DataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/data")
public class DataController implements DataDoc {

    @Autowired
    private DataService datasetService;

    @PostMapping("/create")
    public ResponseEntity<Void> createData(@RequestBody @Valid Data data) {
        try {
            datasetService.createData(data);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //todo add endpoint to add line
}