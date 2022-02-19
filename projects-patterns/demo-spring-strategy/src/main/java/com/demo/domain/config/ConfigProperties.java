package com.demo.domain.config;

import com.demo.domain.model.Product;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@ConstructorBinding
@ConfigurationProperties("item")
public record ConfigProperties(List<Product> products) {

}
