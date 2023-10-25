package com.example.junittest;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class CountUnit {

    @Ignore
    @Test
    public void testAdd() {
        CountTest countTest = new CountTest();
        int result = countTest.add(2, 2);
        assertEquals(result, 2 + 2);

    }

    @Test(expected=ArithmeticException.class)
    public void division() {
        CountTest countTest = new CountTest();
        int division = countTest.division(1, 2);
        assertEquals(division,1/2);
    }

}

class CountTest {
    public int add(int x, int y) {
        return x + y;
    }

    public int division(int a, int b) {
        return a / b;
    }
}
