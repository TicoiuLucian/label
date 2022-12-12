package com.alten.label.service;

import com.alten.label.controller.model.LabelList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class LabelListServiceImpl implements LabelListService {

    public ResponseEntity<String> convertRequestBodyToJsonFile(LabelList labelList) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("labelList.json"), labelList);
        } catch (Exception e) {
            throw new IOException("Cannot create json file");
        }
        File file = new File("labelList.json");

        try {
            //send json to client
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String, Object> body
                    = new LinkedMultiValueMap<>();
            body.add("file", new FileSystemResource(file));


            HttpEntity<MultiValueMap<String, Object>> requestEntity
                    = new HttpEntity<>(body, headers);

            String serverUrl = "http://52.157.194.63:18080/labels/import";

            RestTemplate restTemplate = new RestTemplate();
            return restTemplate
                    .postForEntity(serverUrl, requestEntity, String.class);
        } catch (RestClientException e) {
            throw new RestClientException("LabelList POST failed");
        } finally {
            Files.deleteIfExists(file.toPath());
        }
    }

    @Override
    public ResponseEntity<String> getLabelList(String path) {
        RestTemplate restTemplate = new RestTemplate();
        String serverUrl;
        serverUrl = path == null ? "http://52.157.194.63:18080/labels/list" : "http://52.157.194.63:18080/labels/list?path=" + path;

        return restTemplate.getForEntity(serverUrl, String.class);
    }

    @Override
    public ResponseEntity<String> getFileContent(String fileToRead) {
        RestTemplate restTemplate = new RestTemplate();
        String serverUrl = "http://52.157.194.63:18080/labels/fileContent?file_to_read=" + fileToRead;
        return restTemplate.getForEntity(serverUrl, String.class);
    }

    @Override
    public void deleteFile(String fileToDelete) {
        RestTemplate restTemplate = new RestTemplate();
        String serverUrl = "http://52.157.194.63:18080/labels/delete?file_to_delete=" + fileToDelete;

        try {
            restTemplate.delete(serverUrl);
        } catch (RestClientException e) {
            throw new RestClientException("LabelList DELETE failed");
        }
    }

    public void createLabelList(LabelList labelList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("labelList.json"), labelList);
        } catch (Exception e) {
            throw new IOException("Cannot create json file");
        }
    }
}
