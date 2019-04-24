package com.blockchain.po;

import java.sql.Date;

public class transaction {
    private String txId;

    private String txHash;

    private String blockHash;

    private Long size;

    private Integer weight;

    private Date time;

    private Double totalInput;

    private Double totalOutput;

    private Double fees;

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId == null ? null : txId.trim();
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash == null ? null : txHash.trim();
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash == null ? null : blockHash.trim();
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getTotalInput() {
        return totalInput;
    }

    public void setTotalInput(Double totalInput) {
        this.totalInput = totalInput;
    }

    public Double getTotalOutput() {
        return totalOutput;
    }

    public void setTotalOutput(Double totalOutput) {
        this.totalOutput = totalOutput;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "transaction{" +
                "txId='" + txId + '\'' +
                ", txHash='" + txHash + '\'' +
                ", blockHash='" + blockHash + '\'' +
                ", size=" + size +
                ", weight=" + weight +
                ", time=" + time +
                ", totalInput=" + totalInput +
                ", totalOutput=" + totalOutput +
                ", fees=" + fees +
                '}';
    }
}