package com.zys.mybatisplusdemo.service;

import com.alibaba.fastjson.JSONObject;
import com.zys.mybatisplusdemo.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {
    List<User> selectList();

    int insert(User user);

    int deleteById(long id);

    int updateById(User user);

    Map<String, Object> userList();

    JSONObject userListByPage(Integer curr, Integer limit);
}
