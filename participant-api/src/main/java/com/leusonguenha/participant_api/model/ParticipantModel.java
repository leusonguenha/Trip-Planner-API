package com.leusonguenha.participant_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_participant")
public class ParticipantModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
    private String email;
}
