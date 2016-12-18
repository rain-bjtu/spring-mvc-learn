package com.rain.learn.sms.other;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rain.learn.sms.dao.UserDao;
import com.rain.learn.sms.ebo.UserEbo;

public class GroupAddUserTest {

    public static void main(String[] args) {
        System.out.println("------------------------");
//        addUser();
        addUserByDao();

        System.out.println("========================");
    }

    public static void addUser() {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "file:src/main/webapp/WEB-INF/spring/root-context.xml")) {
            SessionFactory sf = (SessionFactory) context.getBean(SessionFactory.class);
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            UserEbo user = new UserEbo();
            user.setName("12");
            user.setPassword("12");
            session.save(user);
            tx.commit();
            session.close();
        }
    }
    
    public static void addUserByDao() {
        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "file:src/main/webapp/WEB-INF/spring/root-context.xml")) {
            UserDao userDao = context.getBean(UserDao.class);
            UserEbo user = new UserEbo();
            user.setName("123");
            user.setPassword("123");
            userDao.save(user);
        }
    }
}
