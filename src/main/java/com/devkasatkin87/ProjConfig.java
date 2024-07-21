package com.devkasatkin87;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjConfig {

    @Bean
    public MessageProvider messageProvider() {
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageHandler messageHandler(MessageProvider messageProvider) {
        MessageHandler handler = new SystemOutMessageHandler();
        handler.setMessageProvider(messageProvider);
        return handler;
    }
}
