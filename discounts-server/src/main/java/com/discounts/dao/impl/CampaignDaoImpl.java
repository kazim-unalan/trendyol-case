package com.discounts.dao.impl;

import com.discounts.model.Campaign;
import com.discounts.model.DiscountType;
import com.discounts.dao.CampaignDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
@Repository
public class CampaignDaoImpl implements CampaignDao {

    private static List<Campaign> CAMPAINGS = null;

    @PostConstruct
    public void init() {
        CAMPAINGS = Arrays.asList(new Campaign("campaign1", "Campaign1", "food", "fruit", 20.0d, 3, DiscountType.RATE),
                new Campaign("campaign2", "Campaign2", "food", "fruit", 50.0d, 5, DiscountType.RATE),
                new Campaign("campaign3", "Campaign3", "food", "vegetables", 5.0d, 5, DiscountType.AMOUNT));
    }

    @Override
    public Optional<Campaign> findCampaign(String code) {
        return CAMPAINGS.stream().filter(campaign -> campaign.getCode().equals(code)).findFirst();
    }

    @Override
    public List<Campaign> findAllCampaigns() {
        return CAMPAINGS;
    }

}
