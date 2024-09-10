package com.leusonguenha.trip_api.controller;

import com.leusonguenha.trip_api.model.TripModel;
import com.leusonguenha.trip_api.repository.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private ITripRepository tripRepository;

    @PostMapping
    public ResponseEntity<TripModel> createTrip(@RequestBody TripModel tripModel) {
        var trip = tripRepository.findByLocationName(tripModel.getLocationName());
        if (trip != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(trip);
        }

        var tripCreated = tripRepository.save(tripModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(tripCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TripModel> deleteTrip(@PathVariable UUID id) {
        tripRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripModel> updateTrip(@PathVariable UUID id, @RequestBody TripModel tripModel) {
        tripModel.setId(id);
        tripRepository.save(tripModel);
        return ResponseEntity.ok().build();
    }
}
