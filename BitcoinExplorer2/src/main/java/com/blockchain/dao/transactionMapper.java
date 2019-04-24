package com.blockchain.dao;

import com.blockchain.po.transaction;

public interface transactionMapper {
    int deleteByPrimaryKey(String txId);

    int insert(transaction record);

    int insertSelective(transaction record);

    transaction selectByPrimaryKey(String txId);

    int updateByPrimaryKeySelective(transaction record);

    int updateByPrimaryKey(transaction record);
}