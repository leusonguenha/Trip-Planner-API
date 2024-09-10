package com.leusonguenha.accommodation_api.repository;

import com.leusonguenha.accommodation_api.model.AccommodationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccommodationRepository extends JpaRepository<AccommodationModel, UUID> {
    AccommodationModel findByHotelName(String hotelName);
}
