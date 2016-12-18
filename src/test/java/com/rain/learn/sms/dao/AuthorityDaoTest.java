package com.rain.learn.sms.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rain.learn.sms.basic.AbstractTest;
import com.rain.learn.sms.ebo.AuthorityEbo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class AuthorityDaoTest extends AbstractTest {

    @Autowired
    private AuthorityDao authorityDao;

    @Test
    public void testPrintAuthority() {
        AuthorityEbo authority = authorityDao.getByKey(1);
        System.out.println(authority);
    }
}
