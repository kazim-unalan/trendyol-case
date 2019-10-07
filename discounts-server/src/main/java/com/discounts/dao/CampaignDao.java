package com.discounts.dao;

import com.discounts.model.Campaign;

import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
public interface CampaignDao {

    Optional<Campaign> findCampaign(String code);

    List<Campaign> findAllCampaigns();

}
