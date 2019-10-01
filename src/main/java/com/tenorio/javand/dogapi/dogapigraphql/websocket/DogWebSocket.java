package com.tenorio.javand.dogapi.dogapigraphql.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@ServerEndpoint("/dogws")
public class DogWebSocket {

    private static final Logger logger = Logger.getLogger("DogWebSocket");
    static Queue<Session> queue = new ConcurrentLinkedQueue<>();

    public static void send(String msg) {
        try {
            for (Session session: queue) {
                session.getBasicRemote().sendText(msg);
            }
            logger.log(Level.INFO, "Sent: {0}", msg);
        } catch (IOException e) {
            logger.log(Level.INFO, e.toString());
        }
    }

    @OnOpen
    public void openConnection(Session session/*, @PathParam("username") String username*/) {
        queue.add(session);
        logger.log(Level.INFO, "Connection opened.");
    }

    @OnMessage
    public void onMessage(Session session, String jsonStr) {
        logger.log(Level.INFO, "onMessage:"+jsonStr);
        send(jsonStr);
    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session) {
        logger.log(Level.INFO, "onClose.");
    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.log(Level.WARNING, "onError.");
        error.printStackTrace();
    }
}
