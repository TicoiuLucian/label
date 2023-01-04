package com.alten.label.controller.model;

public enum Confidentiality {
    C0("Public"),
    C1("Internal"),
    C2("Restricted"),
    C3("Confidential");

    public final String label;

    private Confidentiality(String label) {
        this.label = label;
    }
}
