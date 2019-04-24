package com.blockchain.controller;

import com.blockchain.dao.transactionMapper;
import com.blockchain.dto.TransactionListDTO;
import com.blockchain.po.transaction;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getTransactionByTxhash")
    public transaction getTransactionInfoByTxhash(@RequestParam String txHash){
        transaction t = transactionmapper.selectBytxHash(txHash);
        return t;
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
   @GetMapping("/viewMoreTransactions")
   public List<transaction> getviewMoreTransactions(){
        return null;
   }
}
