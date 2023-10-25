package com.example.junittest;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRunSequence {
    @Test
    public void TestCase1() {
        assertEquals(2+2,4);
    }
    @Test
    public void TestCase2() {
        assertEquals(2+2,4);
    }
    @Test
    public void TestCaeAa() {
        assertEquals("Java","js");
    }

}
