package com.myproject.cryptoapi.lunarcrushapi.infrastructure.connector.bitfinex;

import com.myproject.cryptoapi.lunarcrushapi.domain.asset.Asset;
import com.myproject.cryptoapi.lunarcrushapi.infrastructure.ws.WebSocketClientEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class BitfinexService {
    final static CountDownLatch messageLatch = new CountDownLatch(1);

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

    public void initWebSocketTicket(){

        try{
            URI uri = new URI("wss://api-pub.bitfinex.com/ws/2");
            WebSocketClientEndpoint clientEndpoint = new WebSocketClientEndpoint(uri);

            clientEndpoint.addMessageHandler(new WebSocketClientEndpoint.MessageHandler() {
                @Override
                public void handleMessage(String message) {
                    System.out.println(message);
                }
            });

            // send message subscription
            clientEndpoint.sendMessage("{ \"event\": \"subscribe\", \"channel\": \"ticker\", \"symbol\": \"tBTCUSD\"}");

            // keep fetch data from socket endpoint until timeout
            messageLatch.await(10, TimeUnit.SECONDS);

            // end program
        } catch (URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}