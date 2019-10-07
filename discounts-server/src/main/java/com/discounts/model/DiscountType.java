package com.discounts.model;

/**
 * @author Kazim Unalan
 */
public enum DiscountType {

    RATE("rate"),
    AMOUNT("amount"),
    UNKNOWN("");

    private String url;

    DiscountType(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }

}
