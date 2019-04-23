package com.blockchain.dao;

import com.blockchain.po.block;

public interface blockMapper {
    int deleteByPrimaryKey(String blockHash);

    int insert(block record);

    int insertSelective(block record);

    block selectByPrimaryKey(String blockHash);

    int updateByPrimaryKeySelective(block record);

    int updateByPrimaryKey(block record);

    int truncate();
}