package com.alten.label.controller.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DataType {

    TEXT_PLAIN("text/plain"),
    TEXT_HTML("text/html"),
    IMAGE_JPEG("image/jpeg"),
    IMAGE_PNG("image/png");

    @Getter
    private final String value;
}
