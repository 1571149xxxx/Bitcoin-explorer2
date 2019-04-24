package com.blockchain.dao;

import com.blockchain.dto.BlockDTO;
import com.blockchain.dto.BlockListDTO;
import com.blockchain.po.block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface blockMapper {
    int deleteByPrimaryKey(String blockHash);

    int insert(block record);

    int insertSelective(block record);

    block selectByPrimaryKey(String blockHash);

    int updateByPrimaryKeySelective(block record);

    int updateByPrimaryKey(block record);

    int truncate();

    List<block> selectRecent();

    block selectRecentBlocksByBlockHeight(@Param("blockHeight") Integer blockHeight);

    List<BlockDTO> getblockViewMore();
}