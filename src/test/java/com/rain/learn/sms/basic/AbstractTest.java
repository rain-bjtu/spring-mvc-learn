package com.rain.learn.sms.basic;

import org.junit.After;
import org.junit.Before;

public class AbstractTest {

    @Before
    public void begin() {
        System.out.println("------------------------------------------------");
    }

    @After
    public void end() {
        System.out.println("================================================");
    }
}
