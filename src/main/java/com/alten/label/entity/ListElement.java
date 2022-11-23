package com.alten.label.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ListElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labelId;

    private String labelContent;

    private String labelDescription;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "label_list_id")
    private LabelList labelList;
}
