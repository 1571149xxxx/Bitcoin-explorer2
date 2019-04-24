package com.blockchain.dto;

import java.sql.Date;

public class TransactionListDTO {

    private String txHash;

    private Date time;

    private Double fees;

    public String getTxhash() {
        return txHash;
    }

    public void setTxhash(String txhash) {
        this.txHash = txhash;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }
}
