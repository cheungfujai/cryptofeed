package com.myproject.cryptoapi.lunarcrushapi.infrastructure.connector.lunarcrush;

import com.myproject.cryptoapi.lunarcrushapi.domain.asset.Asset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class LunarcrushService {

    public Asset getAsset(String data, String apiKey, String symbol){
        URI targetUrl = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.lunarcrush.com")
                .path("v2")
                .queryParam("data", data)
                .queryParam("key", apiKey)
                .queryParam("symbol", symbol)
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        try{
            Asset asset =  restTemplate.getForObject(targetUrl, Asset.class);
            System.out.println(restTemplate.getForEntity(targetUrl,String.class));
            return asset;
        } catch (Exception e){
            throw e;
        }
    }
}
