package com.blockchain.controller;

import com.blockchain.dao.transactionMapper;
import com.blockchain.dto.TransactionInfoDTO;
import com.blockchain.dto.TransactionListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransController {
    @Autowired(required = false)
    private transactionMapper transactionmapper;
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
   @GetMapping("/getRecentTransactions")
    public List<TransactionListDTO> getRecentTransactions(){
       List<TransactionListDTO> transactionListDTOS = transactionmapper.selectRecentTx();
       for (TransactionListDTO t:transactionListDTOS
            ) {
           t.setFees(0.005);
       }
       return transactionListDTOS;
   }
}
