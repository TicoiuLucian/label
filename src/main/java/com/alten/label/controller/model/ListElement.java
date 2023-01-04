package com.alten.label.controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ListElement {
    @JsonProperty("label_id")
    private String labelId;

    @JsonProperty("label_content")
    private String labelContent;

    @JsonProperty("label_desc")
    private String labelDescription;

    @JsonProperty("label_parents")
    private List<ListElement> labelParents = new ArrayList<>();
}
