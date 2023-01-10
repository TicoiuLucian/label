package com.alten.label.service;

import com.alten.label.controller.model.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    private void writeToCsv(String pathToCsv, String line) throws IOException {
        try (var writer = new BufferedWriter(new FileWriter(pathToCsv));) {
            writer.write(line);
        } catch (Exception e) {
            throw new IOException("Cannot write in csv file");
        }
    }
}
