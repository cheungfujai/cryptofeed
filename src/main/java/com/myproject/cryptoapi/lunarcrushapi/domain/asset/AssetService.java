package com.myproject.cryptoapi.lunarcrushapi.domain.asset;

import org.springframework.stereotype.Service;

@Service
public class AssetService {
    public Asset getTodayAsset(String symbol){
        return new Asset();
    }
}
