package com.alten.label.controller;

import com.alten.label.entity.LabelList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/labels")
public class LabelListController {

    @PostMapping(value = "/import", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void upload(@RequestBody LabelList labelList) {
    }

    @GetMapping(value = "/import", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LabelList> getList(@RequestParam String path) {
        return null;
    }

    @GetMapping(value = "/file-content", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LabelList> getFileContent(@RequestParam String fileToRead) {
        return null;
    }

    @DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestParam String fileToDelete) {

    }
}

