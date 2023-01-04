package com.alten.label.controller.model;

import lombok.Data;

@Data
public class Dataset {

    private String datasetName;

    //TODO enum
    private String mimeType;

    private Metadata metadata;

    private boolean containsHeader;

    //content
    private String filePath;
}


/*
-RestController primeste date + fisier csv
datele + adresa fisierului csv vor fi salvate intr-un json file
 */