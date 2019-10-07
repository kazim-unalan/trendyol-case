package com.delivery.service.impl;

import com.delivery.model.DeliveryCostCalculator;
import com.delivery.service.DeliveryCostCalculatorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @author Kazim Unalan
 */
@Service
public class DeliveryCostCalculatorServiceImpl implements DeliveryCostCalculatorService {

    @Value("${fixed-cost}")
    private String fixedCost;

    @Override
    public Double calculateFor(DeliveryCostCalculator deliveryCostCalculator, Double numberOfDeliveries, Double numberOfProducts) {
        return Double.valueOf(deliveryCostCalculator.getCostPerDelivery() * numberOfDeliveries + deliveryCostCalculator.getCostPerProduct() * numberOfProducts + fixedCost);
    }
}
