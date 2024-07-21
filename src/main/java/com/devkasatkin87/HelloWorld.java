package com.devkasatkin87;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
    public static void main(String[] args) {
//        defaultHelloWorldPrinter();
//        modularHelloWorldPrinter();
//        factoryHelloWorld();
//        xmlBeanConfigHelloWorldPrinter();
        annotationBeanHelloWorldPrinter();
    }

    private static void annotationBeanHelloWorldPrinter() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProjConfig.class);
        MessageHandler messageHandler = applicationContext.getBean("messageHandler", MessageHandler.class);
        messageHandler.handling();

    }

    private static void xmlBeanConfigHelloWorldPrinter() {
        ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("bean.xml");

        MessageHandler messageHandler = applicationContext.getBean("handler", MessageHandler.class);
        messageHandler.handling();
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
