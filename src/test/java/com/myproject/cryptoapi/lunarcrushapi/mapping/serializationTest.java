package com.myproject.cryptoapi.lunarcrushapi.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.cryptoapi.lunarcrushapi.domain.asset.Asset;
import com.myproject.cryptoapi.lunarcrushapi.domain.asset.AssetItem;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class serializationTest {
    @Test
    public void assetSerialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/Asset.json"));
        String s = new String(bytes, Charset.defaultCharset());
        AssetItem asset = mapper.readValue(s, AssetItem.class);
        System.out.println(asset);
    }
}
