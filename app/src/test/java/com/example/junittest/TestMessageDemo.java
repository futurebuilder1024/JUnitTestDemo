package com.example.junittest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 创建对应的 测试类
 */
public class TestMessageDemo {
    private String message = "java";
    private MessageDemo messageDemo = new MessageDemo(this.message);

    @Test
    public void testPrint() {
        assertEquals(message, messageDemo.print());
    }

}
