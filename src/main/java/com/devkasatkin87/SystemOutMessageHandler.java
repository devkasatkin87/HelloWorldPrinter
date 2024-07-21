package com.devkasatkin87;

public class SystemOutMessageHandler implements MessageHandler{
    private MessageProvider messageProvider;

    public SystemOutMessageHandler() {
        System.out.println("Initialize SystemOutMessageHandler class");
    }

    @Override
    public void handling() {
        if (messageProvider == null) throw new RuntimeException("Set MessageProvider");
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
