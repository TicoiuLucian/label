package com.alten.label.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class LabelListServiceImpl implements LabelListService {

    public <T> void convertRequestBodyToJsonFile(T labelList) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            // Writing to a file
            // log file content + file name
            mapper.writeValue(new File("labelList.json"), labelList);


            //send json to client
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);


            File file = new File("labelList.json");
            MultiValueMap<String, Object> body
                    = new LinkedMultiValueMap<>();
            body.add("file", new FileSystemResource(file));


            HttpEntity<MultiValueMap<String, Object>> requestEntity
                    = new HttpEntity<>(body, headers);

            String serverUrl = "http://52.157.194.63:18080/labels/import";

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate
                    .postForEntity(serverUrl, requestEntity, String.class);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());

            //delete file
            Files.deleteIfExists(file.toPath()); //surround it in try catch block

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResponseEntity<String> getLabelList(String path) {
        RestTemplate restTemplate = new RestTemplate();
        String serverUrl;
        serverUrl = path == null ? "http://52.157.194.63:18080/labels/list" : "http://52.157.194.63:18080/labels/list?path=" + path;

        ResponseEntity<String> response
                = restTemplate.getForEntity(serverUrl, String.class);
        return response;
    }

    @Override
    public ResponseEntity<String> getFileContent(String fileToRead) {
        RestTemplate restTemplate = new RestTemplate();
        String serverUrl = "http://52.157.194.63:18080/labels/fileContent?file_to_read=" + fileToRead;

        ResponseEntity<String> response
                = restTemplate.getForEntity(serverUrl, String.class);
        return response;
    }

    @Override
    public void deleteFile(String fileToDelete) {
        RestTemplate restTemplate = new RestTemplate();
        String serverUrl = "http://52.157.194.63:18080/labels/delete?file_to_delete=" + fileToDelete;

        restTemplate.delete(serverUrl);
    }
}
