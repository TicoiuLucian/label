package com.alten.label.controller.model;

import com.alten.label.entity.Metadata;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MetadataModel {
    private Long id;

    private String owner;

    private String confidenciality;

    private String date;

    public Metadata toEntity() {
        Metadata metadata = new Metadata();
        metadata.setConfidenciality(this.confidenciality);
        metadata.setDate(this.date);
        metadata.setOwner(this.owner);
        return metadata;
    }
}
