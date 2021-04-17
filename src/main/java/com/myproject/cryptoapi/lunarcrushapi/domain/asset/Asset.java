package com.myproject.cryptoapi.lunarcrushapi.domain.asset;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    private String symbol;              // A comma-separted list of symbols to get data for
    private String name;                // The full name of the asset
    private List<AssetDuration> assetDataInPeriod;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public class AssetDuration{
        private LocalDate date;
        private List<AssetItem> assetDataInDay;
    }
}
