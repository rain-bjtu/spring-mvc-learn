package com.rain.learn.sms.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rain.learn.sms.basic.AbstractTest;
import com.rain.learn.sms.ebo.UserEbo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class UserDaoTest extends AbstractTest {

    @Autowired
    private UserDao userDao;

    @Ignore
    @Test
    public void testDeleteUser() {
        printExistUsers();

        // System.out.println(userDao.delete(3));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(userDao.queryByName("guest"));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        printExistUsers();
    }

    private void printExistUsers() {
        List<UserEbo> list = userDao.queryAll();
        for (UserEbo user : list) {
            System.out.println(user);
        }
    }

    @Ignore
    @Test
    public void testDeleteUserByEntity() {
        // List<UserEbo> users = userDao.queryAll();
        // System.out.println(users.size());
        // UserEbo user = new UserEbo();
        // user.setId(9);
        // user.setName("1");
        // user.setPassword("1");
        // userDao.save(user);
        userDao.deleteByKey(9);
        // System.out.println(users.size());
    }

    @Test
    @Ignore
    public void testPrintGroupFromUser() {
        UserEbo user = userDao.getByKey(1);
        System.out.println(user);
        System.out.println(user.getGroup());
    }

    /**
     * throw javax.persistence.NoResultException
     */
    @Test
    @Ignore
    public void testNoExistUser() {
        UserEbo user = userDao.queryByName("abcd");
        System.out.println(user);
    }
}