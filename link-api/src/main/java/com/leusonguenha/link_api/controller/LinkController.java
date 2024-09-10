package com.leusonguenha.link_api.controller;

import com.leusonguenha.link_api.model.LinkModel;
import com.leusonguenha.link_api.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkRepository linkRepository;

    @PostMapping
    public ResponseEntity<LinkModel> createLink(@RequestBody LinkModel linkModel) {

        var link = linkRepository.findByTitle(linkModel.getTitle());

        if (link != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(link);
        }

        var linkCreated = linkRepository.save(linkModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(linkCreated);
    }

    @GetMapping
    public ResponseEntity<List<LinkModel>> getAllLinks() {
        List<LinkModel> links = linkRepository.findAll();
        return ResponseEntity.ok(links);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LinkModel> deleteLink(@PathVariable UUID id) {
        linkRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
