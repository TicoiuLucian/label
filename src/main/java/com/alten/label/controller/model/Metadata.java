package com.alten.label.controller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Metadata {

    private String owner;

    private Confidentiality confidentiality;

    private String date;

    private String language;

}
