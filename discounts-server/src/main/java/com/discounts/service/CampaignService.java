package com.discounts.service;

import com.discounts.model.Campaign;

import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
public interface CampaignService {

    Optional<Campaign> getCampaign(String code);

    List<Campaign> getAllCampaigns();

}
