package com.blockchain.po;

public class transaction_detail extends transaction_detailKey {
    private Byte type;

    private Double amount;

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}