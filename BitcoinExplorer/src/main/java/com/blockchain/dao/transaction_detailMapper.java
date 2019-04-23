package com.blockchain.dao;

import com.blockchain.po.transaction_detail;
import com.blockchain.po.transaction_detailKey;

public interface transaction_detailMapper {
    int deleteByPrimaryKey(transaction_detailKey key);

    int insert(transaction_detail record);

    int insertSelective(transaction_detail record);

    transaction_detail selectByPrimaryKey(transaction_detailKey key);

    int updateByPrimaryKeySelective(transaction_detail record);

    int updateByPrimaryKey(transaction_detail record);
}