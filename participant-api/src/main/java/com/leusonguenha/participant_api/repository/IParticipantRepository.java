package com.leusonguenha.participant_api.repository;

import com.leusonguenha.participant_api.model.ParticipantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IParticipantRepository extends JpaRepository<ParticipantModel, UUID> {
    ParticipantModel findByEmail(String email);
}
