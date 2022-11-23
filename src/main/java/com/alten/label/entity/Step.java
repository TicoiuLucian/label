package com.alten.label.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stepId;

    private String stepName;

    private String stepDesc;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;

    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL)
    List<Action> actions = new ArrayList<>();

    public void addActionsToStep(Action action) {
        actions.add(action);
        action.setStep(this);
    }

}
