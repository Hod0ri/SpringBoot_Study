package com.hod0ri.textsocket.network;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Slf4j
@Component
@ServerEndpoint(value = "/socket") // Binding Address
public class Socket {
    private Session session;
    public static Set<Socket> listeners = new CopyOnWriteArraySet<>();
    private static int OnlineCount = 0;

    @OnOpen
    public void onOpen(Session session) {
        OnlineCount++;
        this.session = session;
        listeners.add(this);

        log.info("onOpen Called :: " + OnlineCount);
    }

    @OnClose
    public void onClose(Session session) {
        OnlineCount--;
        listeners.remove(this);
        log.info("onClose Called :: " + OnlineCount);
    }

    @OnMessage
    public void onMessage(String payload) {
        log.info("onMessage Called :: " + payload);
        broadcast(payload);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.warn("onClose Called Abused :: " + throwable.getMessage());
        listeners.remove(this);
        OnlineCount--;
    }

    private static void broadcast(String message) {
        for (Socket listner : listeners)
            listner.sendMessage(message);
    }

    private void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.warn("IOException!!!");
        }
    }
}
