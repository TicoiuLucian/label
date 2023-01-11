package com.alten.label.controller.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {

    @NotEmpty
    private String dataName; // file name

    @NotNull
    private DataType dataType;

//    private Metadata metadata;

    @NotNull
    private DataLocation dataLocation;

    @NotEmpty
    private String pathToDatasetCSV; //link to dataset
}
