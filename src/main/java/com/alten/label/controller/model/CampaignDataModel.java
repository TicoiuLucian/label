package com.alten.label.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CampaignDataModel {
    
    @JsonProperty("data_id")
    private Long dataId;

    private List<Long> lots;

}
