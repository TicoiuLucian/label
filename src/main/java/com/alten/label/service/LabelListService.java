package com.alten.label.service;


import com.alten.label.controller.model.LabelList;
import com.alten.label.controller.model.ListElement;
import com.alten.label.controller.model.Metadata;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface LabelListService {

    ResponseEntity<String> sendLabelListJsonToLabelServer(String labelListName) throws Exception;

    ResponseEntity<String> getLabelList(String path);

    ResponseEntity<String> getFileContent(String fileToRead);

    void deleteFile(String fileToDelete);

    void createLabelListJsonFile(LabelList labelList) throws Exception;

    void addListElementsToLabelList(List<ListElement> listElements, String labelListName) throws Exception;

    List<LabelList> getLabelLists() throws RuntimeException;

    List<String> getAllLabelListsFileName() throws RuntimeException;

    void addMetadataToLabelList(Metadata metadata, String labelListName) throws Exception;

    void deleteLabelList(String labelListName) throws IOException;

    void deleteLabelFromLabelList(String labelListName, long labelId) throws IOException;

    void updateLabelElementParents(String labelListName, Long labelId, List<ListElement> listElement) throws IOException;

    void updateLabelElement(String labelListName, Long labelId, ListElement listElement) throws IOException;

}
