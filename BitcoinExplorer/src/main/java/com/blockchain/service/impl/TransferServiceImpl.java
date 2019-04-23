package com.blockchain.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.blockchain.api.BitcoinApi;
import com.blockchain.api.BitcoinRpcClientJson;
import com.blockchain.dao.blockMapper;
import com.blockchain.dao.transactionMapper;
import com.blockchain.dao.transaction_detailMapper;
import com.blockchain.enumeration.TransactionDetailType;
import com.blockchain.po.block;
import com.blockchain.po.transaction;
import com.blockchain.po.transaction_detail;
import com.blockchain.service.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import java.sql.Date;

@Service
public class TransferServiceImpl implements TransferService {
    private Logger logger = LoggerFactory.getLogger((this.getClass()));
    @Autowired(required = false)
    private blockMapper blockmapper;
    @Autowired(required = false)
    private transaction_detailMapper transactionDetailMapper;
    @Autowired(required = false)
    private BitcoinApi bitcoinApi;
    @Autowired(required = false)
    private transactionMapper transactionmapper;
    @Autowired(required = false)
    private BitcoinRpcClientJson bitcoinRpcClientJson;

    @Async
    @Override
    //通过Hash导入块
    public void setBlockByHash(String blockHash, boolean isNull) {
        if(isNull==true){
       blockmapper.truncate();
   }
         String whileHash = blockHash;
        while (whileHash != null && !"".equals(whileHash + "")) {
            block block = new block();
            JSONObject findBlock = bitcoinApi.getBlock(whileHash);
            block.setBlockchainId(2);
            Integer height = findBlock.getInteger("height");
            block.setBlockHeight(height);
            String hash = findBlock.getString("hash");
            block.setBlockHash(hash);
            Long time = findBlock.getLong("time");
            Date date = new Date(time * 1000);
            block.setBlockTime(date);
            JSONArray tx = findBlock.getJSONArray("tx");
            block.setTxSize(tx.size());
            Long size = findBlock.getLong("size");
            block.setSizeOnDisk(size);
            String previousblockhash = findBlock.getString("previousblockhash");
            block.setPrevblockhash(previousblockhash);
            String nextblockhash = findBlock.getString("nextblockhash");
            block.setNextblockhash(nextblockhash);
            block.setMerkleRoot(findBlock.getString("merkleroot"));
            block.setDifficulty(findBlock.getDouble("difficulty"));
            blockmapper.insert(block);
            whileHash = findBlock.getString("nextblockhash");
            boolean n = whileHash != null && !"".equals(whileHash + "");
        }
    }
    @Override
    public void setFromHeight(Integer blockHeight, Boolean isNull) {

    }

    public void setTx(String txHash, String blockhash, Date time) throws Throwable {

        if (txHash != null && !"".equals(txHash + "")) {

            transaction transaction = new transaction();
            JSONObject tx = bitcoinApi.getTransaction(txHash);
            String txid = tx.getString("txid");
            transaction.setTxId(txid);
            transaction.setTxHash(tx.getString("hash"));
            transaction.setBlockHash(blockhash);
            transaction.setSize(tx.getLong("size"));
            transaction.setWeight(tx.getInteger("weight"));
            transaction.setTime(time);
            int insert = transactionmapper.insert(transaction);

            JSONArray vouts = tx.getJSONArray("vout");
            for (int i = 0; i < vouts.size(); i++) {
               setVoutDetail(vouts.getJSONObject(i),txid);
            }

            JSONArray vins = tx.getJSONArray("vin");
            for (int i = 1; i < vins.size(); i++) {
                setVinDetail(vins.getJSONObject(i),txid);
           }
        }
    }
   // 交易细节的中的输出
    public void setVoutDetail(JSONObject vout, String txid){
        transaction_detail transactionDetail = new transaction_detail();
        transactionDetail.setTxid(txid);
        JSONObject scriptPubKey = vout.getJSONObject("scriptPubKey");
        JSONArray addresses = scriptPubKey.getJSONArray("addresses");
        //检查地址是否为异步数据
        if (addresses != null && !addresses.isEmpty()){
            String address = addresses.getString(0);
            transactionDetail.setAddress(address);
        }
        Double amount = vout.getDouble("value");
        transactionDetail.setAmount(amount);
        transactionDetail.setType((byte) TransactionDetailType.Receive.ordinal());
        transactionDetailMapper.insert(transactionDetail);
    }
    // 交易细节的中的输入
    public void setVinDetail(JSONObject vin, String txidOrigin) throws Throwable {
            transaction_detail transactionDetail = new transaction_detail();
            String txid = vin.getString("txid");
            Integer vout = vin.getInteger("vout");

            JSONObject rawTransaxtion = bitcoinRpcClientJson.getRawTransaxtion(txid);
            JSONArray vouts = rawTransaxtion.getJSONArray("vout");
            JSONObject jsonObject = vouts.getJSONObject(vout);

            transactionDetail.setTxid(txidOrigin);
            transactionDetail.setType((byte) TransactionDetailType.Send.ordinal());
            Double amount = jsonObject.getDouble("value");
            transactionDetail.setAmount(amount);
            JSONObject scriptPubKey = jsonObject.getJSONObject("scriptPubKey");
            JSONArray addresses = scriptPubKey.getJSONArray("addresses");
            if (addresses != null){
                String address = addresses.getString(0);
                transactionDetail.setAddress(address);
            }
        transactionDetailMapper.insert(transactionDetail);
    }






}
