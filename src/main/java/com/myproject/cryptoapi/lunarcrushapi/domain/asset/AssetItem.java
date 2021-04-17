package com.myproject.cryptoapi.lunarcrushapi.domain.asset;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Embedded
    private List<AssetItemTImeSeries>timeSeries;
}
