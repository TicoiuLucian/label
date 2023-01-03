package com.alten.label.service;

import com.alten.label.controller.model.LabelList;
import com.alten.label.controller.model.ListElement;
import com.alten.label.controller.model.Metadata;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class LabelListServiceImpl implements LabelListService {


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

    @Override
    public void createLabelListJsonFile(LabelList labelList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("Provisionning\\Labels\\LabelList-" + System.currentTimeMillis() + ".json"), labelList);
        } catch (Exception e) {
            throw new IOException("Cannot create json file");
        }
    }

    @Override
    public void addListElementsToLabelList(List<ListElement> listElements, String labelListName) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("Provisionning\\Labels\\" + labelListName);
        LabelList labelList = objectMapper.readValue(file, LabelList.class);
        labelList.getListElements().addAll(listElements);
        objectMapper.writeValue(file, labelList);
    }

    @Override
    public List<LabelList> getLabelLists() throws RuntimeException {
        ObjectMapper objectMapper = new ObjectMapper();
        return Stream.of(Objects.requireNonNull(new File("Provisionning\\Labels").listFiles()))
                .filter(file -> !file.isDirectory())
                .map(file -> {
                    try {
                        return objectMapper.readValue(file, LabelList.class);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }

    @Override
    public List<String> getAllLabelListsFileName() throws RuntimeException {
        return Stream.of(Objects.requireNonNull(new File("Provisionning\\Labels").listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .toList();
    }

    @Override
    public void addMetadataToLabelList(Metadata metadata, String labelListName) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("Provisionning\\Labels\\" + labelListName);
        LabelList labelList = objectMapper.readValue(file, LabelList.class);
        labelList.setMetadata(metadata);
        objectMapper.writeValue(file, labelList);
    }

    @Override
    public void deleteLabelList(String labelListName) throws IOException {
        Path path
                = Paths.get("Provisionning\\Labels\\" + labelListName);
        Files.deleteIfExists(path);
    }

    @Override
    public void deleteLabelFromLabelList(String labelListName, long labelId) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("Provisionning\\Labels\\" + labelListName);
        LabelList labelList = objectMapper.readValue(file, LabelList.class);
        labelList.getListElements().removeIf(elem -> elem.getLabelId().equals(labelId));
        objectMapper.writeValue(file, labelList);
    }

    public ResponseEntity<String> sendLabelListJsonToLabelServer(String labelListName) {

        File file = new File("Provisionning\\Labels\\" + labelListName);

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
        }
    }

    public void updateLabelElementParents(String labelListName, Long labelId, List<ListElement> listElements) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("Provisionning\\Labels\\" + labelListName);
        LabelList labelList = objectMapper.readValue(file, LabelList.class);
        labelList.getListElements().stream()
                .filter(elem -> Objects.equals(elem.getLabelId(), labelId))
                .forEach(elem -> elem.setLabelParents(listElements));
        objectMapper.writeValue(file, labelList);
    }

    public void updateLabelElement(String labelListName, Long labelId, ListElement listElement) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("Provisionning\\Labels\\" + labelListName);
        LabelList labelList = objectMapper.readValue(file, LabelList.class);
        labelList.getListElements().stream()
                .filter(elem -> Objects.equals(elem.getLabelId(), labelId))
                .forEach(elem -> {
                    elem.setLabelContent(listElement.getLabelContent());
                    elem.setLabelDescription(listElement.getLabelDescription());
                });
        objectMapper.writeValue(file, labelList);
    }
}
