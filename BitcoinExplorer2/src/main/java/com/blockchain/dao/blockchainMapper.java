package com.blockchain.dao;

import com.blockchain.po.blockchain;

public interface blockchainMapper {
    int deleteByPrimaryKey(Integer blockchainId);

    int insert(blockchain record);

    int insertSelective(blockchain record);

    blockchain selectByPrimaryKey(Integer blockchainId);

    int updateByPrimaryKeySelective(blockchain record);

    int updateByPrimaryKey(blockchain record);
}