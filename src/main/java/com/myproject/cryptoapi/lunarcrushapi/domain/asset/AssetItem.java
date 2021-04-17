package com.myproject.cryptoapi.lunarcrushapi.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Getter
@Builder
@Slf4j
@AllArgsConstructor
public class AssetItem {
    @JsonProperty("price")
    private double priceCurrent;        // Current price in USD

    @JsonProperty("price_btc")
    private double priceBtcCurrent;     // Current price in BTC

    @JsonProperty("open")
    private double openPrice;           // Open price for the time period

    @JsonProperty("close")
    private double closePrice;          // Close price for the time period

    private double high;                // Highest price for the time period
    private double low;                 // Close price for the time period

    @JsonProperty("percent_change_24h")
    private double percentChangeHours;  // Percent change in price since 24 hours ago

    @JsonProperty("percent_change_7d")
    private double percentChangeWeek;   // Percent change in price since 7 days ago

    @JsonProperty("percent_change_30d")
    private double percentChangeMonth;  // Percent change in price since 30 days ago

    @JsonProperty("volume_24h")
    private double volumeHours;         // Volume in USD for 24 hours up to this data point

    @JsonProperty("volume")
    private int volumeCurrent;          // Volume for the time period in USD
    private double volatility;          // degree of variation of a trading price series over time as measured by the standard deviation of logarithmic returns

    @JsonProperty("market_cap")
    private int marketCapacity;         // Total available supply multiplied by the current price in USD

    @JsonProperty("market_dominance")
    private double marketDominance;

    @JsonProperty("max_supply")
    private long max_supply;
}
