package com.myproject.cryptoapi.lunarcrushapi.domain.asset;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Embedded;
import java.util.List;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Asset {

    @Embedded
    private List<Asset> data;
}
