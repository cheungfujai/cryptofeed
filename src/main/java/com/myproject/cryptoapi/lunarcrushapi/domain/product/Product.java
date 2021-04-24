package com.myproject.cryptoapi.lunarcrushapi.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Embedded;
import java.util.List;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    @JsonProperty("symbols")
    @Embedded
    private List<ProductItem> productList;
}
