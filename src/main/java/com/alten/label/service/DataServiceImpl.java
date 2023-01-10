package com.alten.label.service;

import com.alten.label.controller.model.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
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
}
