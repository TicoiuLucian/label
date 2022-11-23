package com.alten.label.service;

import com.alten.label.entity.CampaignData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CampaignDataRepository extends JpaRepository<CampaignData, Long> {
}
