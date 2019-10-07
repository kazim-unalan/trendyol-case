package com.delivery.model;


/**
 * @author Kazim Unalan
 */
public class DeliveryCostCalculator {

    private Double costPerDelivery;

    private Double costPerProduct;

    private Double fixedCost;

    public DeliveryCostCalculator() {
    }

    public DeliveryCostCalculator(Double costPerDelivery, Double costPerProduct, Double fixedCost) {
        this.costPerDelivery = costPerDelivery;
        this.costPerProduct = costPerProduct;
        this.fixedCost = fixedCost;
    }

    public Double getCostPerDelivery() {
        return costPerDelivery;
    }

    public void setCostPerDelivery(Double costPerDelivery) {
        this.costPerDelivery = costPerDelivery;
    }

    public Double getCostPerProduct() {
        return costPerProduct;
    }

    public void setCostPerProduct(Double costPerProduct) {
        this.costPerProduct = costPerProduct;
    }

    public Double getFixedCost() {
        return fixedCost;
    }

    public void setFixedCost(Double fixedCost) {
        this.fixedCost = fixedCost;
    }

}
