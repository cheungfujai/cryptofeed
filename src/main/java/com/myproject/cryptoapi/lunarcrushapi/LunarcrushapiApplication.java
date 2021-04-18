package com.myproject.cryptoapi.lunarcrushapi;

import com.myproject.cryptoapi.lunarcrushapi.infrastructure.ws.WebSocketClientEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class LunarcrushapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LunarcrushapiApplication.class, args);


    }

}
