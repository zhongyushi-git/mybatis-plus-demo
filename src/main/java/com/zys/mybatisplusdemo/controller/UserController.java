package com.zys.mybatisplusdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.zys.mybatisplusdemo.entity.User;
import com.zys.mybatisplusdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有的数据
     * @return
     */
    @GetMapping("/list")
    public JSONObject userList() {
        List<User> users = userService.selectList();
        JSONObject json = new JSONObject();
        json.put("data", users);
        return json;
    }

    /**
     * 添加数据
     * @param user
     * @return
     */
    @PostMapping("/")
    public String save(User user) {
        int count = userService.insert(user);
        if (count != 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        int count = userService.deleteById(id);
        if (count != 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    /**
     * 修改数据
     * @param user
     * @return
     */
    @PutMapping("/")
    public String update(User user) {
        int count = userService.updateById(user);
        if (count != 0) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    /**
     * 模糊查询
     * @return
     */
    @GetMapping("/list2")
    public Map<String, Object> userList2() {
        return userService.userList();
    }

    /**
     * 单表分页查询
     * @param curr
     * @param limit
     * @return
     */
    @GetMapping("/list3")
    public JSONObject userList3(Integer curr, Integer limit) {
        return userService.userListByPage(curr, limit);
    }

    /**
     * 单自定义表分页查询
     * @param curr
     * @param limit
     * @return
     */
    @GetMapping("/list4")
    public JSONObject userList4(Integer curr, Integer limit) {
        return userService.userListByPage2(curr, limit);
    }

}
