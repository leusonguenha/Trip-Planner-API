package com.leusonguenha.link_api.repository;

import com.leusonguenha.link_api.model.LinkModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LinkRepository extends JpaRepository<LinkModel, UUID> {

    LinkModel findByTitle(String title);
}
