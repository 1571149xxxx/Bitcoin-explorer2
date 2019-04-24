package com.blockchain.dao;

import com.blockchain.dto.TransactionListDTO;
import com.blockchain.po.transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface transactionMapper {
    int deleteByPrimaryKey(String txId);

    int insert(transaction record);

    int insertSelective(transaction record);

    transaction selectByPrimaryKey(String txId);

    int updateByPrimaryKeySelective(transaction record);

    int updateByPrimaryKey(transaction record);

    List<TransactionListDTO> selectRecentTx();

    List<transaction> selectTxByBlockHash(@Param("blockHash") String blockHash);
}