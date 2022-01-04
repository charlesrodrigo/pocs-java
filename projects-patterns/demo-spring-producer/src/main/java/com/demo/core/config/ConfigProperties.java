package com.demo.core.config;

import com.demo.core.domain.Product;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@ConstructorBinding
@ConfigurationProperties("item")
public record ConfigProperties(List<Product> products) {

}
