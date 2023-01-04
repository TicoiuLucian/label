package com.alten.label.service;

import com.alten.label.controller.model.Dataset;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DatasetServiceImpl implements DatasetService {
    @Override
    public void createDataset(Dataset dataset, MultipartFile file) throws IOException {
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        Path filepath = Paths.get("Provisionning\\Data\\", file.getOriginalFilename() + "-" + System.currentTimeMillis() + fileExtension);

        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        }
        dataset.setFilePath(filepath.toString());

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("Provisionning\\Dataset\\Dataset-" + System.currentTimeMillis() + ".json"), dataset);
        } catch (Exception e) {
            throw new IOException("Cannot create json file");
        }

    }

    @Override
    public Dataset getDatasetByName(String datasetName) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("Provisionning\\Dataset\\" + datasetName);
        Dataset dataset = objectMapper.readValue(file, Dataset.class);
        return null;
    }

}
