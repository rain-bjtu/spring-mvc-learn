package com.rain.learn.sms.other;


import java.sql.Date;

import org.junit.Test;

import com.rain.learn.sms.basic.AbstractTest;

public class TimeTest extends AbstractTest {

    @Test
    public void testTimeValueOf() {
        Date d = Date.valueOf("2001-11-12");
        System.out.println(d);
    }
}
