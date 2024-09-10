package com.leusonguenha.link_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "tb_link")
public class LinkModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String title;
    private String description;

    @Column(unique = true)
    private String url;
}
