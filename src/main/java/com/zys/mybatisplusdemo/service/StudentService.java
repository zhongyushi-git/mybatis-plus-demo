package com.zys.mybatisplusdemo.service;

import com.alibaba.fastjson.JSONObject;

public interface StudentService {
    JSONObject selectPage(Integer curr, Integer limit);

    JSONObject selectPage2(Integer curr, Integer limit);
}
