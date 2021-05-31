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
}