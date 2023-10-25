package com.example.junittest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
//        Result result = JUnitCore.runClasses(TestMessageDemo.class);
        Result result = JUnitCore.runClasses(TestSuite.class);
        for (Failure failure :
                result.getFailures()) {
            System.out.println("failure = " + failure);

        }
        System.out.println("测试结果 ：result.wasSuccessful() = " + result.wasSuccessful());
    }
}
