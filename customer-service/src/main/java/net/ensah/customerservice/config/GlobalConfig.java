package net.ensah.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.params")
public record GlobalConfig(int x,int y) {
}
