package com.rain.learn.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.rain.learn.sms.dao.GroupDao;
import com.rain.learn.sms.ebo.GroupEbo;

@Repository("groupDao")
public class GroupDaoImpl extends AbstractDao<Integer, GroupEbo> implements GroupDao {

    @Override
    public GroupEbo queryByName(String name) {
        return queryByName(name, GroupEbo.NAME_PATH);
    }

}
