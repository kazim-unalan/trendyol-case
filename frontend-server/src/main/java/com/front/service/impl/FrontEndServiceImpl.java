package com.front.service.impl;

import com.front.properties.FrontEndProperties;
import com.front.service.FrontEndService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kazim Unalan
 */
@Service
public class FrontEndServiceImpl implements FrontEndService {

    private static final Logger LOG = LoggerFactory.getLogger(FrontEndServiceImpl.class);

    @Autowired
    private FrontEndProperties frontEndProperties;


}
