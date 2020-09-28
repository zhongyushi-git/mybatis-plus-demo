package com.zys.mybatisplusdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zys.mybatisplusdemo.config.MybatisPlusCache;
import com.zys.mybatisplusdemo.entity.User;
import org.apache.ibatis.annotations.CacheNamespace;


@CacheNamespace(implementation= MybatisPlusCache.class,eviction=MybatisPlusCache.class)
public interface UserDao extends BaseMapper<User> {

}
