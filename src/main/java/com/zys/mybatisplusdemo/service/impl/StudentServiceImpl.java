package com.zys.mybatisplusdemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zys.mybatisplusdemo.dao.StudentDao;
import com.zys.mybatisplusdemo.entity.Student;
import com.zys.mybatisplusdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;


    @Override
    public JSONObject selectPage(Integer curr, Integer limit) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("t1.name", "张");
        IPage<Student> page = new Page<>(curr, limit);
        IPage<Student> stu = studentDao.selectPageList(page, queryWrapper);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", stu.getRecords());
        jsonObject.put("total", stu.getTotal());
        return jsonObject;
    }

    @Override
    public JSONObject selectPage2(Integer curr, Integer limit) {
        IPage<Student> page = new Page<>(curr, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张");
        IPage<Student> stu = studentDao.selectPageList2(page, map);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", stu.getRecords());
        jsonObject.put("total", stu.getTotal());
        return jsonObject;
    }
}
