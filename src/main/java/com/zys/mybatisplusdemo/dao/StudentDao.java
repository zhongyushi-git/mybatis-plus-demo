package com.zys.mybatisplusdemo.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zys.mybatisplusdemo.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface StudentDao extends BaseMapper<Student> {
    IPage<Student> selectPageList(IPage<Student> page, @Param(Constants.WRAPPER) QueryWrapper<Student> queryWrapper);

    IPage<Student> selectPageList2(IPage<Student> page, @Param(Constants.WRAPPER)Map<String, Object> map);
}
