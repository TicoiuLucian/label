package com.alten.label.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class CampaignData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long dataId;

    private String lots;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

}
