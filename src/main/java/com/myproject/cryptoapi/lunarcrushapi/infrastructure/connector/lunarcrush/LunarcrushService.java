package com.myproject.cryptoapi.lunarcrushapi.infrastructure.connector.lunarcrush;

import com.myproject.cryptoapi.lunarcrushapi.domain.asset.Asset;
import com.myproject.cryptoapi.lunarcrushapi.domain.asset.AssetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class LunarcrushService {
    private final AssetService assetService;

    @Autowired
    public LunarcrushService(AssetService assetService){
        this.assetService = assetService;
    }

    public Asset getAsset(String data, String apiKey, String symbol){
        URI targetUrl = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("api.lunarcrush.com")
                .path("v2")
                .queryParam("data", data)
                .queryParam("key", apiKey)
                .queryParam("symbol", symbol)
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        try{
            // not yet done
            ResponseEntity<Asset> responseEntity = restTemplate.getForEntity(targetUrl, Asset.class);
            Asset ttt = (Asset) responseEntity.getBody();
            return new Asset();
        } catch (Exception e){
            throw e;
        }
    }
}
