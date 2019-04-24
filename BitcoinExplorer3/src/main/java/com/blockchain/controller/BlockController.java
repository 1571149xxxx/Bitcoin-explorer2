package com.blockchain.controller;

import com.blockchain.api.BitcoinApi;
import com.blockchain.api.BitcoinRpcClientJson;
import com.blockchain.dao.blockMapper;
import com.blockchain.dao.transactionMapper;
import com.blockchain.dto.BlockDTO;
import com.blockchain.dto.BlockListDTO;
import com.blockchain.po.block;
import com.blockchain.po.transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
    @Autowired(required = false)
    private transactionMapper transactionmapper;
    @GetMapping("/getRecentBlocksByHeight")
    public block getRecentBlocksById(@RequestParam Integer blockHeight){
        block b = blockmapper.selectRecentBlocksByBlockHeight(blockHeight);
        return b;
    }
    @GetMapping("/getTxbyHeight")
    public List<transaction> getTxByHeight(@RequestParam Integer blockHeight){
        block b = blockmapper.selectRecentBlocksByBlockHeight(blockHeight);
        String blockHash = b.getBlockHash();
        List<transaction> transactions = transactionmapper.selectTxByBlockHash(blockHash);
        return transactions;
    }
    @GetMapping("/blockViewMore")
    public List<BlockDTO> getblockViewMore(){
        List<BlockDTO> blockDTOS = blockmapper.getblockViewMore();
        return blockDTOS;
    }
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



}
