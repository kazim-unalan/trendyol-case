package com.front.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Kazim Unalan
 */
@Component
@ConfigurationProperties("val")
public class FrontEndProperties {

    private BigDecimal val;

    public BigDecimal getVal() {
        return val;
    }

    public void setVal(BigDecimal val) {
        this.val = val;
    }
}
