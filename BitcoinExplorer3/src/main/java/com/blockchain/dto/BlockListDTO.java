package com.blockchain.dto;

    import java.sql.Date;

public class BlockListDTO {
    private Integer height;
    private Long time;
    private Integer txSize;
    private Long sizeOnDisk;
    private String miner;

    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getTxSize() {
        return txSize;
    }

    public void setTxSize(Integer txSize) {
        this.txSize = txSize;
    }

    public Long getSizeOnDisk() {
        return sizeOnDisk;
    }

    public void setSizeOnDisk(Long sizeOnDisk) {
        this.sizeOnDisk = sizeOnDisk;
    }
}
