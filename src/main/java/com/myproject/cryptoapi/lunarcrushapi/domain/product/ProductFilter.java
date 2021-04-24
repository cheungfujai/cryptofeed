package com.myproject.cryptoapi.lunarcrushapi.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductFilter {
    private String filterType;
    private String minPrice;
    private String maxPrice;
    private String tickSize;
}
