package com.tenorio.javand.dogapi.dogapigraphql.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.util.logging.Level;
import java.util.logging.Logger;

@EnableScheduling
@Configuration
public class DogWebSocketScheduler {
    Logger logger = Logger.getLogger("DogWebSocketConfig");

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Scheduled(fixedDelay = 5000)
    public void sendDogInfoMessage() {
        String msg = "{\"username\":\"\",\"msg\":\"sdf\"}";
        DogWebSocket.send(msg);
        logger.log(Level.INFO, "sentDogInfo: {0}", msg);
    }
}
