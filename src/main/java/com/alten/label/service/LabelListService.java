package com.alten.label.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LabelListService {

    <T> void convertRequestBodyToJsonFile(T labelList);

    ResponseEntity<String> getLabelList(String path);

    ResponseEntity<String> getFileContent(String fileToRead);

    void deleteFile(String fileToDelete);
}
