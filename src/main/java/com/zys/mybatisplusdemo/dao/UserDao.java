package com.zys.mybatisplusdemo.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.zys.mybatisplusdemo.config.MybatisPlusCache;
import com.zys.mybatisplusdemo.entity.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;


@CacheNamespace(implementation= MybatisPlusCache.class,eviction=MybatisPlusCache.class)
public interface UserDao extends BaseMapper<User> {

    IPage<User> selectPageList(IPage<User> page, @Param(Constants.WRAPPER) QueryWrapper<User> queryWrapper);
}
