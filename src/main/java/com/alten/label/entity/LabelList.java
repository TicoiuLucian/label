package com.alten.label.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class LabelList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Metadata metadata;

    @OneToMany(mappedBy = "labelList", cascade = CascadeType.ALL)
    private List<ListElement> listElements = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;
}
