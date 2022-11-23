package com.alten.label.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Scenario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "scenario", cascade = CascadeType.ALL)
    private List<LabelList> labelLists = new ArrayList<>();

    @OneToMany(mappedBy = "scenario", cascade = CascadeType.ALL)
    private List<Step> steps = new ArrayList<>();

    public void addLabelToScenario(LabelList labelList) {
        labelLists.add(labelList);
        labelList.setScenario(this);
    }

    public void addStepsToScenario(Step step) {
        steps.add(step);
        step.setScenario(this);
    }


}
