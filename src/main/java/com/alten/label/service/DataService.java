package com.alten.label.service;

import com.alten.label.controller.model.Data;
import com.alten.label.controller.model.ImportLinesRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DataService {
    void createData(Data data) throws IOException;

    void addLine(String dataName, String line) throws IOException;

    void importLine(ImportLinesRequest request, MultipartFile file) throws IOException;
}
