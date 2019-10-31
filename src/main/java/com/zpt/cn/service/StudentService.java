package com.zpt.cn.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpt.cn.mapper.StudentMapper;
import com.zpt.cn.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: ZPT
 * @Description: 逻辑层
 * @Date: 2019-10-31 12:19
 **/
@Service
public class StudentService {

    //注入 mapper层
    @Autowired
    private StudentMapper studentMapper;

    public String addStudent(){
        for (int i = 0; i < 50; i++) {
            studentMapper.insert(
                Student.builder().name("马云+i").sex("男").age(10+i).birthday(new Date()).build()
            );
        }
        return "OK";
    }

    //查询所有
    public List<Student> selectAllStudent(){
        return (List<Student>) studentMapper.selectList(null);
    }
    //查询一个
    public Student selectOneStudent(){
        return  studentMapper.selectById(2);
    }
    //条件查询
    public List<Student> selectStudent(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("name","马云20"); //条件：name=马云20的数据
        List<Student> students = studentMapper.selectList(queryWrapper);
        return students;
    }
    //根据id修改
    public void updataStudent(){
        Student student = Student.builder().age(11).id(2).build();
        studentMapper.updateById(student);
    }
    //添加
    public void insertStudent(){
        for (int i = 0; i < 50; i++) {
            Student student = Student.builder().id(3+i).name("马云"+(3+i)).sex("男").age(12+i).birthday(new Date()).build();
            studentMapper.insert(student);
        }
    }
    //添加
    public void insert(){
        Student student = Student.builder().name("马云100").sex("男").age(12).birthday(new Date()).build();
        studentMapper.insert(student);
    }
    
    //删除
    public void deleteStudent(){
        studentMapper.deleteById(5);
    }


    //分页-----pageHelper
    public String selectPage(){
        //从第0条开始，查5条
        PageHelper.startPage(0,5);

        PageInfo<Student> info = new PageInfo(studentMapper.selectList(null));
        int pageNum = info.getPageNum();
        int pageSize = info.getPageSize();
        long total = info.getTotal();
        return "pageNum:"+pageNum+"pageSize:"+pageSize+"pageTotal:"+total;
    }


    /*
        mybatis-plus自带的分页
        第一步：在springboot主配置类中添加组件
        第二步：实现IPage的Page方法
     */
    public List<Student> mybatisPage(){
        IPage page = new Page(0,5);
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age");    //按年龄降序
        List<Student> students = studentMapper.selectList(queryWrapper);
        return students;
//        IPage pageInfo = studentMapper.selectPage(page,queryWrapper);
//        long total = pageInfo.getTotal();
//        long size = pageInfo.getSize();
//        long current = pageInfo.getCurrent();
//        return "total:"+total+"size:"+size+"current:"+current;
    }

}
