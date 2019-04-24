package com.blockchain.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.blockchain.api.BitcoinApi;
import com.blockchain.api.BitcoinRpcClientJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tt")
public class TempController {

    @Autowired(required = false)
    private BitcoinApi bitcoinApi;
    @Autowired
    private BitcoinRpcClientJson bitcoinJsonRpcClient;

    @GetMapping("/ttt")
    public JSONObject test(){
        JSONObject chainInfo = bitcoinApi.getChainInfo();
        Object blocks = chainInfo.get("blocks");

        return  chainInfo;
    }
    @GetMapping("/test")
    public  void test2() throws Throwable {
      // String txHash = "b66688284c0d0e8f09db922924e536606bb23ab8190d4aa103ba7a026c36492e";
      // JSONObject transaction = bitcoinApi.getTransaction(txHash);
       String blockHash = "000000000000004b1aecd12119a19e38efdce8c385f89a5d3a7698427108a2ee";
      JSONObject block = bitcoinApi.getBlock(blockHash);
    //  JSONObject noTxBlock = bitcoinApi.getNoTxBlock(blockHash);
   //  String blockHash2 = "00000000000000a727d074e9d1cc0a225540eb40693d6aa15d702b0bd96d378b";
   //    JSONObject blockHeaders = bitcoinApi.getBlockheaders(10,blockHash2);
   //    JSONObject mempoolInfo = bitcoinApi.getMempoolInfo();
   //    JSONObject mempoolContents = bitcoinApi.getMempoolContents();
    //    String blockHashByHeight = bitcoinJsonRpcClient.getBlockHashByHeight(1489445);
    }
}
