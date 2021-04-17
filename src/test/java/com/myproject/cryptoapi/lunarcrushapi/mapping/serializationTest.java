package com.myproject.cryptoapi.lunarcrushapi.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.cryptoapi.lunarcrushapi.domain.asset.AssetItem;
import com.myproject.cryptoapi.lunarcrushapi.domain.asset.AssetItemTImeSeries;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class serializationTest {
    @Test
    public void assetAssetItemSerialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JSONParser jsonParser = new JSONParser();
        try{
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
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void assetAssetItemTimeSeriesSerialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File("src/test/AssetItemTimeSeries.json");
        AssetItemTImeSeries asset = mapper.readValue(file, AssetItemTImeSeries.class);
        /**
         * "open": 279.606439,
         * "close": 277.652853,
         */
        assert asset.getOpenPrice() == 279.606439;
        assert asset.getClosePrice() == 277.652853;
    }

}
