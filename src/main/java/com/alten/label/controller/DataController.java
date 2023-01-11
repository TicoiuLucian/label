package com.alten.label.controller;


import com.alten.label.controller.model.Data;
import com.alten.label.controller.model.DataLocation;
import com.alten.label.controller.swagger.doc.DataDoc;
import com.alten.label.service.DataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PutMapping("/add-line")
    public ResponseEntity<Void> addLine(@RequestParam String dataName, @RequestParam String line) {
        try {
            datasetService.addLine(dataName, line);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(path = "/import-lines", method = RequestMethod.PUT, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> importLines(@RequestParam DataLocation dataLocation,
                                            @RequestParam String dataName,
                                            @RequestParam Boolean containsHeader,
                                            @RequestPart MultipartFile file) {
        try {
            datasetService.importLines(dataLocation, dataName, containsHeader, file);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}