package com.blockchain.service;

import com.alibaba.fastjson.JSONObject;

import java.sql.Date;

public interface TransferService {

<<<<<<< HEAD
    void setBlockByHash(String blockHash, boolean isNull);
=======
    void setBlockByHash(String blockHash, boolean isNull) throws Throwable;
>>>>>>> static-blockExplorerHtml-blocktable


    void setFromHeight(Integer blockHeight, Boolean isNull);

    void setVinDetail(JSONObject vin, String txidOrigin) throws Throwable;

<<<<<<< HEAD
    void setTx(String txHash, String blockhash, Date time) throws Throwable;
=======

>>>>>>> static-blockExplorerHtml-blocktable
}
