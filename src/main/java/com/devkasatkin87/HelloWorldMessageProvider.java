package com.devkasatkin87;

public class HelloWorldMessageProvider implements MessageProvider{
    public HelloWorldMessageProvider() {
        System.out.println("Initialize HelloWorldMessageProvider class");
    }

    @Override
    public String getMessage() {
        return "Hello World from HelloWorldMessageProvider.getMessage()";
    }
}
