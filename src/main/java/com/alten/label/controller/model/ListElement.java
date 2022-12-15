package com.alten.label.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ListElement {
    @JsonProperty("label_id")
    private Long labelId;

    @JsonProperty("label_content")
    private String labelContent;

    @JsonProperty("label_desc")
    private String labelDescription;
}
