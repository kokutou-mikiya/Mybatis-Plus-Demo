package com.zpt.cn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: ZPT
 * @Description: Student实体类
 * @Date: 2019-10-31 11:54
 **/
@Data
@AllArgsConstructor //有参构造
@NoArgsConstructor  //无参构造
@Builder
@TableName(value = "student")   //mybatis-plus表名注解
public class Student {

    @TableId(type = IdType.AUTO)    //mybatis-plus主键自增注解
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Date birthday;
}
