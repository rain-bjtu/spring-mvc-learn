package com.rain.learn.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rain.learn.sms.dao.GroupDao;
import com.rain.learn.sms.ebo.GroupEbo;
import com.rain.learn.sms.service.GroupService;

@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public void save(GroupEbo group) {
        groupDao.save(group);
    }

    @Override
    public void delete(GroupEbo group) {
        groupDao.delete(group);
    }

    @Override
    public void delete(int id) {
        groupDao.deleteByKey(id);
    }

    @Override
    public GroupEbo get(int id) {
        return groupDao.getByKey(id);
    }

    @Override
    public GroupEbo get(String name) {
        return groupDao.queryByName(name);
    }

}
