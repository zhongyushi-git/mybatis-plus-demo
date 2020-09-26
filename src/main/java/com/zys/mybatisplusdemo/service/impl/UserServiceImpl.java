package com.zys.mybatisplusdemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zys.mybatisplusdemo.dao.UserDao;
import com.zys.mybatisplusdemo.entity.User;
import com.zys.mybatisplusdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectList() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 24);
        return userDao.selectList(queryWrapper);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int deleteById(long id) {
        return userDao.deleteById(id);
    }

    @Override
    public int updateById(User user) {
        return userDao.updateById(user);
    }

    @Override
    public Map<String, Object> userList() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("t_name", "o");
        List<User> users = userDao.selectList(queryWrapper);
        Integer integer = userDao.selectCount(queryWrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("data", users);
        map.put("total", integer);
        return map;
    }

    @Override
    public JSONObject userListByPage(Integer curr, Integer limit) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //设置分页，默认值是1,10
        IPage<User> page = new Page<>(curr, limit);
        IPage<User> user = userDao.selectPage(page, queryWrapper);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", user.getRecords());
        jsonObject.put("total", user.getTotal());
        return jsonObject;
    }


}
