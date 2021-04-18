package com.myproject.cryptoapi.lunarcrushapi.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.cryptoapi.lunarcrushapi.domain.asset.Asset;
import com.myproject.cryptoapi.lunarcrushapi.domain.asset.AssetItem;
import com.myproject.cryptoapi.lunarcrushapi.domain.asset.AssetItemTimeSeries;
import com.myproject.cryptoapi.lunarcrushapi.domain.product.Product;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class serializationTest {
    @Test
    public void assetAssetSerialization() throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/Asset.json");
        Object obj  = jsonParser.parse(reader);
        JSONObject arr = (JSONObject) obj;
        Asset asset = mapper.readValue(arr.toString(), Asset.class);

        assert asset.getData() != null;
        assert asset.getData().size() == 1;
    }

    @Test
    public void assetAssetItemSerialization() throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/Asset.json");
        Object obj  = jsonParser.parse(reader);
        JSONObject arr = (JSONObject) obj;
        JSONArray data = (JSONArray) arr.get("data");

        AssetItem asset = mapper.readValue(data.get(0).toString(), AssetItem.class);

        /**
         *       "symbol": "LTC",
         *       "name": "Litecoin",
         */
        assert asset.getSymbol().equals("LTC");
        assert asset.getName().equals("Litecoin");
    }

    @Test
    public void assetAssetItemTimeSeriesSerialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File("src/test/AssetItemTimeSeries.json");
        AssetItemTimeSeries asset = mapper.readValue(file, AssetItemTimeSeries.class);
        /**
         * "open": 279.606439,
         * "close": 277.652853,
         */
        assert asset.getOpenPrice() == 279.606439;
        assert asset.getClosePrice() == 277.652853;
    }

    @Test
    public void productSeriesSerialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        byte[] bytes = Files.readAllBytes(Paths.get("src", "test", "product.json"));
        String s = new String(bytes, Charset.defaultCharset());
        Product products = mapper.readValue(s, Product.class);
        System.out.println(products);
    }
}
