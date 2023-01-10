package com.alten.label.controller.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImportLinesRequest {

    @NotEmpty
    private String dataName;

    @NotNull
    private DataLocation dataLocation;

    @NotEmpty
    private String path;

    @NotEmpty
    private String separator;

    @NotEmpty
    private String containsHeader;

    @NotEmpty
    private Integer columnNumber;

}
