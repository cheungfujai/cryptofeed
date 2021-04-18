package com.myproject.cryptoapi.lunarcrushapi.domain.product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public Product getTodayProducts(){
        return new Product();
    }
}
