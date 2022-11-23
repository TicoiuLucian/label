package com.alten.label.controller.model;

import com.alten.label.entity.CampaignData;
import com.alten.label.entity.Metadata;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CampaignModel {

    private String name;

    private String dataset;

    private String scenario;

    private MetadataModel metadata;

    @JsonProperty("data_list")
    private List<CampaignDataModel> dataList = new ArrayList<>();
}
