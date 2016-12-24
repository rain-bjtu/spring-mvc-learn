package com.rain.learn.sms.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rain.learn.sms.basic.AbstractTest;
import com.rain.learn.sms.ebo.AuthorityEbo;
import com.rain.learn.sms.ebo.GroupEbo;
import com.rain.learn.sms.ebo.UserEbo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class GroupDaoTest extends AbstractTest {

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthorityDao authorityDao;

    @Ignore
    @Test
    // @Commit
    public void testPrintGroup() {
        GroupEbo group = groupDao.getByKey(1);
        System.out.println(group);

        for (UserEbo user : group.getUsers()) {
            System.out.println(user);
        }
        for (AuthorityEbo authority : group.getAuthorities()) {
            System.out.println(authority);
        }
        groupDao.delete(group);
    }

    @Ignore
    @Test
    @Commit
    public void testSaveUser() {
        GroupEbo group = groupDao.queryByName("Users");
        System.out.println(group);

        UserEbo user = userDao.queryByName("12");
        System.out.println(user);
        System.out.println(group.getUsers());
        group.getUsers().add(user);
        // groupDao.save(group);
    }

    @Ignore
    @Test
    @Commit
    public void testSaveAuthority() {
        GroupEbo group = groupDao.queryByName("Users");
        System.out.println(group);

        AuthorityEbo auth = authorityDao.queryByName("ROLE_USER");
        System.out.println(auth);
        System.out.println(group.getAuthorities());
        group.getAuthorities().add(auth);
        auth.getGroups().add(group);
        // groupDao.save(group);
    }
}
