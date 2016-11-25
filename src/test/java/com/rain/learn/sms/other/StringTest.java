package com.rain.learn.sms.other;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("unittest")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringTest {

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    @Test
    public void testSubStringIndex() {
        System.out.println("abc".substring(0, 0));
    }

}
