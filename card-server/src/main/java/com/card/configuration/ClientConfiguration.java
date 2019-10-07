package com.card.configuration;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kazim Unalan
 */
@Configuration
@EnableFeignClients({"com.cart.client.product", "com.cart.client.delivery", "com.cart.client.discount"})
public class ClientConfiguration {
}
