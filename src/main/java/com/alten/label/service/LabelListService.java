package com.alten.label.service;


import com.alten.label.controller.model.LabelList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LabelListService {

    ResponseEntity<String> convertRequestBodyToJsonFile(LabelList labelList) throws Exception;

    ResponseEntity<String> getLabelList(String path);

    ResponseEntity<String> getFileContent(String fileToRead);

    void deleteFile(String fileToDelete);
}
