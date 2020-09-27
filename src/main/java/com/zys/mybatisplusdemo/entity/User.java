package com.zys.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "t_user")
public class User implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "t_name")
    private String name;

    @TableField(value = "age")
    private Integer age;

    @TableField(value = "email")
    private String email;

    @TableField(exist = false)
    private String aaa;

}
