package com.alten.label.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String dataset;

    private String scenario;

    @OneToOne(cascade = CascadeType.ALL)
    private Metadata metadata;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<CampaignData> dataList = new ArrayList<>();
}
