package com.delivery.service;

import com.delivery.model.DeliveryCostCalculator;


/**
 * @author Kazim Unalan
 */
public interface DeliveryCostCalculatorService {

    public Double calculateFor(DeliveryCostCalculator deliveryCostCalculator, Double numberOfDeliveries, Double numberOfProducts);

}
