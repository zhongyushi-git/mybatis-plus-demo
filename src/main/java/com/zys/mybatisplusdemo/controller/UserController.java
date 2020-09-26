package com.zys.mybatisplusdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zys.mybatisplusdemo.entity.User;
import com.zys.mybatisplusdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public JSONObject userList() {
        List<User> users = userService.selectList();
        JSONObject json = new JSONObject();
        json.put("data", users);
        return json;
    }

    @PostMapping("/")
    public String save(User user) {
        int count = userService.insert(user);
        if (count != 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        int count = userService.deleteById(id);
        if (count != 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @PutMapping("/")
    public String update(User user) {
        int count = userService.updateById(user);
        if (count != 0) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @GetMapping("/list2")
    public Map<String, Object> userList2() {
        return userService.userList();
    }

    @GetMapping("/list3")
    public JSONObject userList3(Integer curr, Integer limit) {
        return userService.userListByPage(curr, limit);
    }

}
