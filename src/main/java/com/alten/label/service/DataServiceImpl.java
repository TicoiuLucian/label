package com.alten.label.service;

import com.alten.label.controller.model.Data;
import com.alten.label.controller.model.DataLocation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

@Service
public class DataServiceImpl implements DataService {

    @Override
    public void createData(Data data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("Provisionning\\Data\\" + data.getDataName() + ".json"), data);
        } catch (Exception e) {
            throw new IOException("Cannot create json file");
        }
    }

    @Override
    public void addLine(String dataName, String line) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("Provisionning\\Data\\" + dataName + ".json");
            Data data = mapper.readValue(file, Data.class);
            String pathToCsv = data.getPathToDatasetCSV();
            writeToCsv(pathToCsv, line);
        } catch (Exception e) {
            throw new IOException("Cannot create json file");
        }
    }

    @Override
    public void importLines(DataLocation dataLocation, String dataName, Boolean containsHeader, MultipartFile attachedFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("Provisionning\\Data\\" + dataName + ".json");
            Data data = mapper.readValue(file, Data.class);
            String pathToCsv = data.getPathToDatasetCSV();
            importToCsv(pathToCsv, dataLocation, containsHeader, attachedFile);
        } catch (Exception e) {
            throw new IOException("Cannot read json file");
        }
    }

    private void importToCsv(String pathToCsv, DataLocation dataLocation, Boolean containsHeader, MultipartFile attachedFile) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(attachedFile.getInputStream()));

        if (reader.ready() && containsHeader) {
            reader.readLine(); //skip first line
        }
        try (OutputStream os = Files.newOutputStream(Path.of(pathToCsv), CREATE, APPEND)) {
            while (reader.ready()) {
                String line = reader.readLine();
                os.write(line.getBytes());
            }
        }
    }

    private void writeToCsv(String pathToCsv, String line) throws IOException {
        try (var writer = new BufferedWriter(new FileWriter(pathToCsv));) {
            writer.write(line);
        } catch (Exception e) {
            throw new IOException("Cannot write in csv file");
        }
    }
}
