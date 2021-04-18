package com.myproject.cryptoapi.lunarcrushapi.interfaces;

import com.myproject.cryptoapi.lunarcrushapi.domain.product.Product;
import com.myproject.cryptoapi.lunarcrushapi.domain.product.ProductService;
import com.myproject.cryptoapi.lunarcrushapi.infrastructure.connector.binance.BinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
public class ProductController {
    private static final String URL = "/api/v1/product";
    private ProductService productService;
    private BinanceService binanceService;
    @Autowired
    public ProductController(ProductService productService, BinanceService binanceService){
        this.productService = productService;
        this.binanceService = binanceService;
    }

    @GetMapping(value = URL + "/exchangeInfo")
    public Product getExchangeData() throws URISyntaxException {
        return binanceService.getProduct();
    }

    @GetMapping(value = URL + "/test")
    public String getTodayData(){
        return "hi";
    }
}
