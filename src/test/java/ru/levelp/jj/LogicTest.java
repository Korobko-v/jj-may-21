package ru.levelp.jj;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class LogicTest {

    @Test
    public void testMeTest() {
        int result = new Logic().testMe();
        assertEquals(777, result);
    }

    @Test
    public void testMeTest2() {
        int result = new Logic().testMe();
    }

    @Test
    public void testSum() {
        assertEquals(3, new Logic().sum(1,2));
        assertEquals(3, new Logic().sum(2,1));
        assertEquals(0, new Logic().sum(0,0));
    }

    @Test
    public  void testMul() {
        assertEquals(6, new Logic().multiply(3,2));
        assertEquals(12, new Logic().multiply(3,4));
        assertEquals(100, new Logic().multiply(20,5));
        assertEquals(25, new Logic().multiply(5, 5));
        assertEquals(-25, new Logic().multiply(-5, 5));
        assertEquals(-35, new Logic().multiply(-5, 7));
    }
}