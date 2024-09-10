package com.leusonguenha.activity_api.repository;

import com.leusonguenha.activity_api.model.ActivityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivityRepository extends JpaRepository<ActivityModel, UUID> {
    ActivityModel findByTitle(String title);
}
