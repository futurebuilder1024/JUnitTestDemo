package com.example.junittest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMessageDemo2 {

    private String message = "php";
    private MessageDemo messageDemo = new MessageDemo(this.message);

    @Test
    public void testPrint() {
        message = "go";
        assertEquals(message, messageDemo.print());
    }
}
