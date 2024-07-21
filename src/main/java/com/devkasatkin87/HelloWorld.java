package com.devkasatkin87;

public class HelloWorld {
    public static void main(String[] args) {
//        defaultHelloWorldPrinter();
//        modularHelloWorldPrinter();
        factoryHelloWorld();
    }

    private static void defaultHelloWorldPrinter() {
        System.out.println("Hello world from defaultHelloWorldPrinter");
    }

    private static void modularHelloWorldPrinter() {
        MessageProvider messageProvider = new HelloWorldMessageProvider();
        MessageHandler messageHandler = new SystemOutMessageHandler();

        messageHandler.setMessageProvider(messageProvider);
        messageHandler.handling();
    }

    private static void factoryHelloWorld() {
        var handler = MessageFactory.getInstance().getMessageHandler()
                .orElseThrow(() -> new IllegalArgumentException("Handler is null"));
        var provider = MessageFactory.getInstance().getMessageProvider().orElseThrow(() -> new IllegalArgumentException("Provider is null"));

        handler.setMessageProvider(provider);
        handler.handling();
    }
}
