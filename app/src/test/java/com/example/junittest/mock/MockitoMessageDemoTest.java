package com.example.junittest.mock;

import com.example.junittest.MessageDemo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


/**
 * Mockito 生成的测试类
 */
public class MockitoMessageDemoTest {
//    @Mock
    MessageDemo mock;

    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
        MessageDemo demo = new MessageDemo("param");
        mock = Mockito.mock(MessageDemo.class);
    }
    @Test
    public void print() {
        //mock 打桩，就是不管真实的方法如何执行，我们可以自行假设该方法执行的结果
        //后续的测试都是基于打桩结果来走
//        Mockito.when(mock.printMessage("mock")).thenReturn("go");
//        Assert.assertEquals("mock",mock.printMessage("mock"));
        //当测试方法出现异常，测试方法  如果有try{}catch{} 则可以测试异常是否正常
        Mockito.when(mock.printMessage("mock")).thenThrow(new RuntimeException());
        Mockito.when(mock.printMessage("mock")).thenCallRealMethod();
        Assert.assertEquals("mock",mock.printMessage("mock"));

        /*验证 Verify
        前面提到的 when(……).thenReturn(……) 属于状态测试，某些时候，测试不关心返回结果，
        而是侧重方法有否被正确的参数调用过，这时候就应该使用 验证方法了。
        从概念上讲，就是和状态测试所不同的“行为测试”了。
        */
        // 测试是否打印了参数  mock
        Mockito.verify(mock).printMessage("mock");
        // 测试是否打印了参数  go
        Mockito.verify(mock).printMessage("go");

    }

    @After
    public void after() {
        System.out.println("测试结束");
    }
}