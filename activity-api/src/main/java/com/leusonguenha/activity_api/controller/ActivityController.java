package com.leusonguenha.activity_api.controller;

import com.leusonguenha.activity_api.model.ActivityModel;
import com.leusonguenha.activity_api.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("activities")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @PostMapping
    public ResponseEntity<ActivityModel> create(@RequestBody ActivityModel activityModel) {

        var activity = this.activityRepository.findByTitle(activityModel.getTitle());

        if (activity != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(activity);
        }

        var activityCreated = this.activityRepository.save(activityModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(activityCreated);
    }

    @GetMapping
    public ResponseEntity<List<ActivityModel>> getAll() {
        return ResponseEntity.ok(activityRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ActivityModel> delete(@PathVariable UUID id) {
        activityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
