package com.leusonguenha.trip_api.repository;

import com.leusonguenha.trip_api.model.TripModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITripRepository extends JpaRepository<TripModel, UUID> {
    TripModel findByLocationName(String locationName);
}
