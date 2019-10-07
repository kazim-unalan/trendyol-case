package com.discounts.controller;

import com.discounts.model.Campaign;
import com.discounts.service.CampaignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
@Controller
@RestController
@RequestMapping(value = "campaign")
public class CampaignController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignController.class);

    @Autowired
    private CampaignService campaignService;

    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            value = "/code"
    )
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Campaign> getCampaign(@RequestParam(value = "code") String code, HttpServletRequest request, HttpServletRequest response) {
        LOGGER.info("getCampaign");
        return campaignService.getCampaign(code);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            value = "/campaigns"
    )
    @ResponseBody
    public List<Campaign> getAllCampaigns(HttpServletRequest request, HttpServletRequest response) {
        LOGGER.info("getAllCampaigns");
        return campaignService.getAllCampaigns();
    }


}
