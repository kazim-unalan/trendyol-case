package com.category.configuration;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kazim Unalan
 */
@Configuration
@EnableFeignClients({"com.category.client.product"})
public class ClientConfiguration {
}
