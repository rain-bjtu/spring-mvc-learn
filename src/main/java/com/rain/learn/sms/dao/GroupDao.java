package com.rain.learn.sms.dao;

import java.util.List;

import com.rain.learn.sms.ebo.GroupEbo;

public interface GroupDao {

    void save(GroupEbo group);

    void delete(GroupEbo group);

    void deleteByKey(Integer id);

    GroupEbo loadByKey(Integer id);

    GroupEbo getByKey(Integer id);

    GroupEbo queryByName(String name);

    List<GroupEbo> queryAll();
}
