package com.blockchain.po;

public class blockchain {
    private Integer blockchainId;

    private String blockchainName;

    private String blockchainType;

    private String shortname;

    public Integer getBlockchainId() {
        return blockchainId;
    }

    public void setBlockchainId(Integer blockchainId) {
        this.blockchainId = blockchainId;
    }

    public String getBlockchainName() {
        return blockchainName;
    }

    public void setBlockchainName(String blockchainName) {
        this.blockchainName = blockchainName == null ? null : blockchainName.trim();
    }

    public String getBlockchainType() {
        return blockchainType;
    }

    public void setBlockchainType(String blockchainType) {
        this.blockchainType = blockchainType == null ? null : blockchainType.trim();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }
}