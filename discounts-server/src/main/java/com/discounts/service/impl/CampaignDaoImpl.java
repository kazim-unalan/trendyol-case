package com.discounts.service.impl;

import com.discounts.model.Campaign;
import com.discounts.dao.CampaignDao;
import com.discounts.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
@Service
public class CampaignDaoImpl implements CampaignService {

    @Autowired
    private CampaignDao campaignDao;

    @Override
    public Optional<Campaign> getCampaign(String code) {
        return campaignDao.findCampaign(code);
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignDao.findAllCampaigns();
    }

}
