package com.myproject.cryptoapi.lunarcrushapi.domain.asset;

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
public class AssetItem {
    private String symbol;              // A comma-separted list of symbols to get data for
    private String name;                // The full name of the asset

    @JsonProperty("price")
    private double priceCurrent;        // Current price in USD

    @JsonProperty("price_btc")
    private double priceBtcCurrent;     // Current price in BTC

    @JsonProperty("percent_change_24h")
    private double percentChangeHours;  // Percent change in price since 24 hours ago

    @JsonProperty("percent_change_7d")
    private double percentChangeWeek;   // Percent change in price since 7 days ago

    @JsonProperty("percent_change_30d")
    private double percentChangeMonth;  // Percent change in price since 30 days ago

    @JsonProperty("volume_24h")
    private double volumeHours;         // Volume in USD for 24 hours up to this data point


    @JsonProperty("max_supply")
    private String max_supply;

    @Embedded
    private List<AssetItemTimeSeries>timeSeries;
}
