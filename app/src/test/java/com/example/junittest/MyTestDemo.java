package com.example.junittest;

import java.lang.reflect.Method;
public class MyTestDemo {
    public static void main(String[] args) {

        Class<TestJunit> junitClass = TestJunit.class;
        Method[] methods = junitClass.getMethods();
        for (Method method :
                methods) {
            boolean present = method.isAnnotationPresent(MyTest.class);
            if (present) {
                try {
                    method.invoke(junitClass.newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {

            }
        }
    }
}
