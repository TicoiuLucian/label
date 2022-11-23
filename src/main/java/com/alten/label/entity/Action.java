package com.alten.label.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actId;

    private String actionContent;

    private String actionDescription;

    private String typeOfAction;

    private String labelList;

    private Boolean noAction;

    private Boolean oneAction;

    private Boolean multipleActions;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "step_id")
    private Step step;
}
