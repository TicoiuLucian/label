package com.alten.label.controller.model;

import com.alten.label.entity.CampaignData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class CampaignDataModel {

    private Long id;
    @JsonProperty("data_id")
    private Long dataId;

    private List<Long> lots;

//    @JsonIgnore
//    private CampaignModel campaignModel;

    public CampaignData toEntity() {
        CampaignData campaignData = new CampaignData();
        campaignData.setId(this.id);
        campaignData.setDataId(this.dataId);
        campaignData.setLots(this.lots.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",", "{", "}")));
//        campaignData.setCampaign(this.campaignModel.toEntity());

        return campaignData;
    }

}
