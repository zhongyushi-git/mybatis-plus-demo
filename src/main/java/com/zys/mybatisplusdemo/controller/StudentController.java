package com.zys.mybatisplusdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.zys.mybatisplusdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/list")
    public JSONObject getList(Integer curr, Integer limit) {
        return studentService.selectPage(curr, limit);
    }
}
