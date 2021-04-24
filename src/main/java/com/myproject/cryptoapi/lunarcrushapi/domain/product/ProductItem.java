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
public class ProductItem {
    enum TradingStatus {
        TRADING,
        BREAK
    }
    private String symbol;
    private TradingStatus status;

    private String baseAsset;
    private int baseAssetPrecision;
    private int baseCommissionPrecision;

    private String quoteAsset;
    private int quotePrecision;
    private int quoteAssetPrecision;

    private int quoteCommissionPrecision;

    private boolean icebergAllowed;
    private boolean ocoAllowed;
    private boolean quoteOrderQtyMarketAllowed;
    private boolean isSpotTradingAllowed;
    private boolean isMarginTradingAllowed;

    private List<String> orderTypes;

    @JsonProperty("filters")
    @Embedded
    private List<ProductFilter> productFilters;

}
