package com.example.junittest.mock;

import com.example.junittest.MockDemo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class MockDemoTest {
    @Mock
    MockDemo demo;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void add() {

        //mock 打桩，就是不管真实的方法如何执行，我们可以自行假设该方法执行的结果
        //后续的测试都是基于打桩结果来走
//         Mockito.when(demo.add(1,2)).thenReturn(5);
//         Assert.assertEquals(3,demo.add(1,2));
//         //当测试方法出现异常，测试方法  如果有try{}catch{} 则可以测试异常是否正常
        Mockito.when(demo.add(1,1)).thenThrow(new RuntimeException());

        //调用真实的方法
        Mockito.when(demo.add(1,1)).thenCallRealMethod();
        Assert.assertEquals(2,demo.add(1,1));
        // 验证 add 方法身份调用了
        MockDemo mockDemo = Mockito.mock(MockDemo.class);
        mockDemo.add(1, 1);
        Mockito.verify(mockDemo,Mockito.times(1)).add(Mockito.anyInt(), Mockito.anyInt());// 没有调用
//        Mockito.verify(mockDemo,Mockito.times(2)).add(1,1);


    }

    @Test
    public void testMock() {
        List mock = Mockito.mock( List.class );
        Mockito.when( mock.get(0) ).thenReturn( 1 );
        Assert.assertEquals( "预期返回1", 1, mock.get( 0 ) );// mock.get(0) 返回 1
    }
    // 有参数的静态方法
    @Test
    public void staticMethodParam() {
//        MockedStatic<StaticUtils> mockStatic = Mockito.mockStatic(StaticUtils.class);
//        mockStatic.when(() -> StaticUtils.setParam(ArgumentMatchers.anyString())).thenReturn("static");
//        Assert.assertEquals("StaticUtils",StaticUtils.setParam("StaticUtils"));

//        mockStatic.when(()->StaticUtils.setName("StaticUtils")).notify();
//        Assert.assertEquals("StaticUtils","StaticUtils");
    }

    // 无参静态方法构建
    @Test
    public void staticMethod() {
//        MockedStatic<StaticUtils> mockStatic = Mockito.mockStatic(StaticUtils.class);
//        mockStatic.when(StaticUtils::getClassName).thenReturn("StaticUtils");
//        Assert.assertEquals("StaticUtils",StaticUtils.getClassName());
//        mockStatic.close();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束");
    }

}