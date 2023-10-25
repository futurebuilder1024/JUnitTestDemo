package com.example.junittest;

import org.junit.Test;

public class TestJunit {
    @Test
    public void test1() {
        System.out.println("test1 = " + this);
    }
    @MyTest
    public void test2() {
        System.out.println("test2 = " + this);
    }
    @MyTest
    public void test3() {
        System.out.println("test3 = " + this);
    }

    public void test4() {
        System.out.println("test4 = " + this);
    }


}
