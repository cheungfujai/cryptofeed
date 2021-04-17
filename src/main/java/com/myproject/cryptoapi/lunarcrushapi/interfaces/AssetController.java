package com.myproject.cryptoapi.lunarcrushapi.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.cryptoapi.lunarcrushapi.domain.asset.Asset;
import com.myproject.cryptoapi.lunarcrushapi.domain.asset.AssetService;
import com.myproject.cryptoapi.lunarcrushapi.infrastructure.connector.lunarcrush.LunarcrushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class AssetController {
    private static final String URL = "/api/v1";
    private AssetService assetService;
    private LunarcrushService lunarcrushService;
    @Autowired
    public AssetController(AssetService assetService, LunarcrushService lunarcrushService){
        this.assetService = assetService;
        this.lunarcrushService = lunarcrushService;
    }

    @GetMapping(value = URL + "/asset/data")
    public Asset getTodayCryptoData() throws URISyntaxException {
        URI uri = new URI("https://api.lunarcrush.com/v2?data=assets&key=arayehysw9a0g01t1pj9dkd&symbol=LTC");
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(uri,Asset.class);
    }

    @GetMapping(value = URL + "/test")
    public String getTodayData(){
        return "hi";
    }
}
