package com.alten.label.controller.model;

import com.alten.label.entity.Campaign;
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
    private Long id;

    private String name;

    private String dataset;

    private String scenario;

    private MetadataModel metadata;

    @JsonProperty("data_list")
    private List<CampaignDataModel> dataList = new ArrayList<>();

    public Campaign toEntity() {
        Campaign campaign = new Campaign();
        campaign.setId(this.id);
        campaign.setName(this.name);
        campaign.setScenario(this.scenario);
        campaign.setDataset(this.dataset);
        campaign.setMetadata(this.metadata.toEntity());
        this.dataList.stream()
                .map(CampaignDataModel::toEntity)
                .forEach(campaign::addCampaignDataToCampaign);

        return campaign;
    }
}
