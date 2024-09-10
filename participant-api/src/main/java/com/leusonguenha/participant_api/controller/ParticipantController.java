package com.leusonguenha.participant_api.controller;

import com.leusonguenha.participant_api.model.ParticipantModel;
import com.leusonguenha.participant_api.repository.IParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private IParticipantRepository participantRepository;

    @PostMapping("/invite")
    public ResponseEntity<ParticipantModel> createParticipant(@RequestBody ParticipantModel participantModel){

        var invite = participantRepository.findByEmail(participantModel.getEmail());
        if(invite != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(invite);
        }

        var invitationSent = participantRepository.save(participantModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(invitationSent);
    }

    @GetMapping
    public ResponseEntity<List<ParticipantModel>> findAll() {
        participantRepository.findAll();
        return ResponseEntity.ok().build();
    }

}
