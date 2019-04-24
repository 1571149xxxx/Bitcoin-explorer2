package com.blockchain.controller;

<<<<<<< HEAD
import com.blockchain.dto.BlockDetailDTO;
import com.blockchain.dto.BlockListDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {
=======
import com.alibaba.fastjson.JSONObject;
import com.blockchain.api.BitcoinApi;
import com.blockchain.api.BitcoinRpcClientJson;
import com.blockchain.dao.blockMapper;
import com.blockchain.dto.BlockDetailDTO;
import com.blockchain.dto.BlockListDTO;
import com.blockchain.po.block;
import com.blockchain.scheduler.BlockScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/block")
@CrossOrigin
public class BlockController {
    @Autowired(required = false)
    private BitcoinApi bitcoinApi;
    @Autowired
    private BitcoinRpcClientJson bitcoinJsonRpcClient;
    @Autowired(required = false)
    private blockMapper blockmapper;

>>>>>>> static-blockExplorerHtml-blocktable
    @GetMapping("/getRecentBlocksById")
    public List<BlockListDTO> getRecentBlocksById(@RequestParam Integer blockchainId){
        return null;
    }
<<<<<<< HEAD

=======
    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks() throws Throwable {
//        String bestBlockhash = bitcoinJsonRpcClient.getBestBlockhash();
//        String tempBlockhash = bestBlockhash;
//        List<BlockListDTO> blockList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            JSONObject block = bitcoinApi.getNoTxBlock(tempBlockhash);
//            BlockListDTO blockListDTO = new BlockListDTO();
//            blockListDTO.setHeight(block.getInteger("height"));
//            Long time = block.getLong("time");
//            blockListDTO.setTime(time);
//            new Date
//            blockListDTO.setTxSize(block.getJSONArray("tx").size());
//            blockListDTO.setSizeOnDisk(block.getLong("size"));
//            blockListDTO.setMiner("x-x-x");
//            blockList.add(blockListDTO);
//            tempBlockhash = block.getString("previousblockhash");
//        }
        List<block> blocks = blockmapper.selectRecent();
        List<BlockListDTO> blockListDTOS = blocks.stream().map(block -> {
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setHeight(block.getBlockHeight());
            blockListDTO.setTime(block.getBlockTime().getTime());
            blockListDTO.setTxSize(block.getTxSize());
            blockListDTO.setSizeOnDisk(block.getSizeOnDisk());
            blockListDTO.setMiner("x-x-x");
            return blockListDTO;
        }).collect(Collectors.toList());
        return blockListDTOS;
    }
>>>>>>> static-blockExplorerHtml-blocktable


    @GetMapping("/getBlockDetailByHash")
    public BlockDetailDTO getBlockDetailByHash(@RequestParam String blockhash){
        return null;
    }

    @GetMapping("/getBlockDetailByHeight")
    public BlockDetailDTO getBlockDetailByHeight(@RequestParam Integer blockheight){
        return null;
    }
}
