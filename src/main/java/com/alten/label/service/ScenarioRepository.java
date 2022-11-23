package com.alten.label.service;

import com.alten.label.entity.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScenarioRepository extends JpaRepository<Scenario, UUID> {
}
