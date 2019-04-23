package com.blockchain.api;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@Service
public class BitcoinRpcClientJson {

    private JsonRpcHttpClient jsonRpcHttpClient;

    public BitcoinRpcClientJson() throws MalformedURLException {
        HashMap<String, String> headers = new HashMap<>();
        String authStrOrig = String.format("%s:%s","lxq","123456");
        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
        String authStrResult = String.format("Basic %s",authStr);
        headers.put("Authorization",authStrResult);
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL("http://localhost:18332"),headers);
    }

    public String getBlockHashByHeight(Integer blockHeight) throws Throwable {
        String blockHash = jsonRpcHttpClient.invoke("getblockHash", new Integer[]{blockHeight}, String.class);
        return blockHash;
    }
    public Double getBalance(String address) throws Throwable {
        JSONArray balances = jsonRpcHttpClient.invoke("listunspent", new Object[]{6, 9999999, new String[]{address}}, JSONArray.class);
        JSONObject balance = balances.getJSONObject(0);
        Double amount = balance.getDouble("amount");
        return amount;
    }

    public JSONObject getRawTransaxtion(String txid) throws Throwable {
        JSONObject rawTransaction = jsonRpcHttpClient.invoke("getrawtransaction", new Object[]{txid, true}, JSONObject.class);
        return rawTransaction;
    }
    public String getBestBlockhash() throws Throwable {
        String bestblockhash = jsonRpcHttpClient.invoke("getbestblockhash", new Object[]{}, String.class);
        return bestblockhash;
    }
}
