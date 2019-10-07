package com.front.configuration;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kazim Unalan
 */
@Configuration
@EnableFeignClients({"com.front.client.cart", "com.front.client.category", "com.front.client.product"})
public class ClientConfiguration {
}
