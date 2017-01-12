package com.rain.learn.sms.other;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.junit.runners.MethodSorters;

@ActiveProfiles("unittest")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassTest {
    @SuppressWarnings("unused")
    private String filed;

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    @Test
    public void testClassName() {
        System.out.println(getClass().getName());
    }

    @Test
    public void testFiledName() {
        System.out.println(getClass().getDeclaredFields()[0].getName());
    }

    @Test
    public void testAssignableFrom() {
        System.out.println(String.class.isAssignableFrom(Object.class));
        System.out.println(Object.class.isAssignableFrom(String.class));
    }
}
