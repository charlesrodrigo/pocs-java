package com.demo.common.config;

import com.demo.common.domain.entity.Product;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@ConstructorBinding
@ConfigurationProperties("item")
public record ConfigProperties(List<Product> products) {

}
