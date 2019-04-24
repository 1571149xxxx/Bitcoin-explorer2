package com.blockchain.controller;

import com.blockchain.dto.BlockListDTO;
import com.blockchain.scheduler.BlockScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;

@RestController
@RequestMapping("/webSocket")
public class webSocketController extends TextWebSocketHandler {
    @Autowired
    private BlockScheduler blockScheduler;
    @GetMapping("/getRecentBlocks")
    public void getRecentBlocks(WebSocketSession session ) throws Throwable {

        List<BlockListDTO> recentBlocksList = blockScheduler.getRecentBlocksList();
        session.sendMessage(new TextMessage(recentBlocksList.toString()));
    }
}
