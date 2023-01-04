package com.alten.label.service;

import com.alten.label.controller.model.Dataset;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface DatasetService {

    void createDataset(Dataset dataset, MultipartFile file) throws IOException;

    Dataset getDatasetByName(String name) throws IOException;
}
