package com.blockchain.controller;

import com.blockchain.dto.TransactionInfoDTO;
import com.blockchain.dto.TransactionListDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class TransController {
    @GetMapping("/getRecentTransactionsById")
    public List<TransactionListDTO> getRecentTransactionsById(@RequestParam Integer blockchainId){
        return null;
    }

    @GetMapping("/getRecentTransactionsByNameType")
    public List<TransactionListDTO> getRecentTransactionsByNameType(@RequestParam String name,
                                                                    @RequestParam String type){
        return null;
    }

    @GetMapping("/getTransactionInfoByTxid")
    public TransactionInfoDTO getTransactionInfoByTxid(@RequestParam String txid){
        return null;
    }

    @GetMapping("/getTransactionInfoByTxhash")
    public TransactionInfoDTO getTransactionInfoByTxhash(@RequestParam String txhash){
        return null;
    }
}
