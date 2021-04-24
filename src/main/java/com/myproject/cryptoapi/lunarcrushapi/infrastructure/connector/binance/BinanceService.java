package com.myproject.cryptoapi.lunarcrushapi.infrastructure.connector.binance;

import com.myproject.cryptoapi.lunarcrushapi.domain.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class BinanceService {
    @Value("${binance.endpoint}")
    private static String binanceURL;

    public Product getProduct(){
        URI targetUrl = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.binance.com")
                .path("api/v3/exchangeInfo")
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        try{
            Product products =  restTemplate.getForObject(targetUrl, Product.class);
            return products;
        } catch (Exception e){
            throw e;
        }
    }

}
