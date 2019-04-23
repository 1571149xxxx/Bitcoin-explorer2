package com.blockchain.service;

import com.alibaba.fastjson.JSONObject;

import java.sql.Date;

public interface TransferService {

    void setBlockByHash(String blockHash, boolean isNull);


    void setFromHeight(Integer blockHeight, Boolean isNull);

    void setVinDetail(JSONObject vin, String txidOrigin) throws Throwable;

    void setTx(String txHash, String blockhash, Date time) throws Throwable;
}
