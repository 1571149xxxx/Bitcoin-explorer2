package com.blockchain.dto;

import java.sql.Date;

public class BlockDTO {
    private Integer blockHeight;
    private Date blockTime;
    private String blockHash;
    private Long sizeOnDisk;

    public Integer getBlockHeight() {
        return blockHeight;
    }

    public void setblockHeight(Integer height) {
        this.blockHeight = height;
    }

    public Date getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(Date time) {
        this.blockTime = time;
    }


    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public Long getSizeOnDisk() {
        return sizeOnDisk;
    }

    public void setSizeOnDisk(Long sizeOnDisk) {
        this.sizeOnDisk = sizeOnDisk;
    }
}
