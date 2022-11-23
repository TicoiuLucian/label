package com.alten.label.service;

import com.alten.label.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
