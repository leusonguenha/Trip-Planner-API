package com.leusonguenha.trip_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_trip")
public class TripModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String locationName;
    private LocalDateTime date;

    private String description;
}
