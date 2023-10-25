package com.example.junittest;

public class MessageDemo {
    private String message;

    private MessageDemo() {
    }

    public MessageDemo(String message) {
        this.message = message;
    }

    public String print() {
        System.out.println("message = " + message);
        return message;
    }
    public String printMessage(String message) {
        System.out.println("message = " + message);
        return message;
    }
}
