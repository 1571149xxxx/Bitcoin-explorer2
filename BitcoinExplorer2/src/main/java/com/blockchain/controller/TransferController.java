package com.blockchain.controller;

import com.alibaba.fastjson.JSONObject;
import com.blockchain.api.BitcoinApi;
import com.blockchain.api.BitcoinRpcClientJson;

import com.blockchain.service.TransferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;


@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired(required = false)
    private BitcoinApi bitcoinApi;
    @Autowired
    private BitcoinRpcClientJson bitcoinJsonRpcClient;
    @Autowired(required = false)
    private TransferService transferService;
    @GetMapping("/toBlock")
<<<<<<< HEAD
    public void getBlock(@RequestParam String blockHash,@RequestParam(defaultValue = "false",required = false)boolean isNull){
=======
    public void getBlock(@RequestParam String blockHash,@RequestParam(defaultValue = "false",required = false)boolean isNull) throws Throwable {
>>>>>>> static-blockExplorerHtml-blocktable

      transferService.setBlockByHash(blockHash,isNull);

    }
    @GetMapping("/toFromHeight")
    public void setFromHeight(@RequestParam Integer blockHeight, @RequestParam(required = false, defaultValue = "false") Boolean isNull){
        transferService.setFromHeight(blockHeight, isNull);
    }
<<<<<<< HEAD
    @GetMapping("/toTransfunction")
    public void setTransfunction(@RequestParam String txHash, @RequestParam String blockHash) throws Throwable {
        Date date = new Date(System.currentTimeMillis());
        transferService.setTx(txHash,blockHash,date);
    }
=======

>>>>>>> static-blockExplorerHtml-blocktable
    @GetMapping("/ttt")
    public JSONObject getChainInfo(){
        JSONObject chainInfo = bitcoinApi.getChainInfo();
        return  chainInfo;
    }
}
