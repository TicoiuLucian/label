package com.alten.label.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LabelList {
    private Long id;

    private String name;

    @JsonProperty("list_structure")
    private ListStructure listStructure;

    private Metadata metadata;

    @JsonProperty("list_elements")
    private List<ListElement> listElements = new ArrayList<>();

}
