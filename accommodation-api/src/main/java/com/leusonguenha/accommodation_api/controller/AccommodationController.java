package com.leusonguenha.accommodation_api.controller;

import com.leusonguenha.accommodation_api.model.AccommodationModel;
import com.leusonguenha.accommodation_api.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/accommodation")
public class AccommodationController {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @PostMapping
    public ResponseEntity<AccommodationModel> create(@RequestBody AccommodationModel accommodationModel) {

        var accommodation = accommodationRepository.findByHotelName(accommodationModel.getHotelName());
        if (accommodation != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(accommodation);
        }

        var accommodationCreated = accommodationRepository.save(accommodationModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(accommodationCreated);
    }

    @GetMapping
    public ResponseEntity<List<AccommodationModel>> getAll() {
       var allAccommodation = accommodationRepository.findAll();
        return ResponseEntity.ok(allAccommodation);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AccommodationModel> delete(@PathVariable UUID id) {
        accommodationRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
