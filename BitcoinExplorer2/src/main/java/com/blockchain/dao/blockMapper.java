package com.blockchain.dao;

<<<<<<< HEAD
import com.blockchain.po.block;

=======
import com.blockchain.dto.BlockListDTO;
import com.blockchain.po.block;

import java.util.List;

>>>>>>> static-blockExplorerHtml-blocktable
public interface blockMapper {
    int deleteByPrimaryKey(String blockHash);

    int insert(block record);

    int insertSelective(block record);

    block selectByPrimaryKey(String blockHash);

    int updateByPrimaryKeySelective(block record);

    int updateByPrimaryKey(block record);

    int truncate();
<<<<<<< HEAD
=======

    List<block> selectRecent();
>>>>>>> static-blockExplorerHtml-blocktable
}