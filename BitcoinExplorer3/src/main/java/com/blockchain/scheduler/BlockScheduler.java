package com.blockchain.scheduler;

import com.blockchain.controller.BlockController;
import com.blockchain.dto.BlockListDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlockScheduler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BlockController blockController;
    @Scheduled(fixedRate = 3000)
    public List<BlockListDTO> getRecentBlocksList() throws Throwable {
        logger.info("start import block transactions");
        List<BlockListDTO> recentBlocks = blockController.getRecentBlocks();
        return recentBlocks;
    }
    
}
