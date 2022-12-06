package com.alten.label.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Campaign {
    private Long id;

    private String name;

    private String dataset;

    private String scenario;

    private Metadata metadata;

    @JsonProperty("data_list")
    private List<CampaignData> dataList = new ArrayList<>();

}
