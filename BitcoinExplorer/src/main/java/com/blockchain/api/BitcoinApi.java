package com.blockchain.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "bitcoin", url = "http://localhost:18332")
public interface BitcoinApi {

   @GetMapping("/rest/tx/{txHash}.json")
    JSONObject getTransaction(@PathVariable("txHash") String  txHash);
   @GetMapping("/rest/block/{blockHash}.json")
    JSONObject getBlock(@PathVariable("blockHash") String blockHash);
   @GetMapping("/rest/headers/{count}/{blockHash}.json")
    JSONObject getBlockheaders(@PathVariable("count") Integer count, @PathVariable("blockHash") String blockHash);
   @GetMapping("/rest/chaininfo.json")
    JSONObject getChainInfo();
    @GetMapping("/rest/mempool/info.json")
    JSONObject getMempoolInfo();
    @GetMapping("/rest/mempool/contents.json")
    JSONObject getMempoolContents();
    @GetMapping("/rest/block/notxdetails/{blockHash}.json")
    JSONObject getNoTxBlock(@PathVariable("blockHash") String blockHash);

}
