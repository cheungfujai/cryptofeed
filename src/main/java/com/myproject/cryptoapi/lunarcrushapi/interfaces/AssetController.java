package com.myproject.cryptoapi.lunarcrushapi.interfaces;

import com.myproject.cryptoapi.lunarcrushapi.domain.asset.Asset;
import com.myproject.cryptoapi.lunarcrushapi.domain.asset.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssetController {
    private static final String URL = "/api/v1/";
    private AssetService assetService;
    @Autowired
    public AssetController(AssetService assetService){
        this.assetService = assetService;
    }

    @GetMapping(value = URL + "/crypto/data")
    public Asset getTodayCryptoData(String symbol){
        return assetService.getTodayAsset(symbol);
    }
}
