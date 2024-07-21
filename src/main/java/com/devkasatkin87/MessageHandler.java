package com.devkasatkin87;

public interface MessageHandler {
    void handling();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
