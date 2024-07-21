package com.devkasatkin87;

import java.util.Optional;
import java.util.Properties;

public class MessageFactory {
    private static final MessageFactory instance;
    private MessageProvider messageProvider;
    private MessageHandler messageHandler;
    private Properties props;

    static {
        instance = new MessageFactory();
    }

    private MessageFactory() {
        props = new Properties();
        try {
            props.load(this.getClass().getResourceAsStream("/application.properties"));
            String handlerClass = props.getProperty("handler.class");
            String providerClass = props.getProperty("provider.class");

            messageHandler = (MessageHandler) Class.forName(handlerClass).getDeclaredConstructor().newInstance();
            messageProvider = (MessageProvider) Class.forName(providerClass).getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static MessageFactory getInstance() {
        return instance;
    }

    public Optional<MessageHandler> getMessageHandler() {
        return messageHandler == null ? Optional.empty() : Optional.of(messageHandler);
    }

    public Optional<MessageProvider> getMessageProvider() {
        return messageProvider == null ? Optional.empty() : Optional.of(messageProvider);
    }
}
