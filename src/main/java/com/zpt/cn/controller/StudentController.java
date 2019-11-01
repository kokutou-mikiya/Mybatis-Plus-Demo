package com.zpt.cn.controller;

import com.zpt.cn.entity.Student;
import com.zpt.cn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: ZPT
 * @Description:
 * @Date: 2019-10-31 11:56
 **/
@RestController
@CrossOrigin
//@RequestMapping("/student")
public class StudentController {

    @Autowired  //注入service
    private StudentService studentService;

    @GetMapping("AllStudent")     //查询所有
    public List<Student> selectAllStudent(){
        List<Student> students = studentService.selectAllStudent();
        return students;
    }

    @GetMapping("OneStudent")     //查询一个
    public Student selectOneStudent(){
        Student student = studentService.selectOneStudent();
        return student;
    }

    @GetMapping("SelectStudent")    //条件查询
    public List<Student> selectStudent(){
        List<Student> students = studentService.selectStudent();
        return students;
    }

    @GetMapping("SelectPage")   //分页查询
    public List<Student> selectPage(){
        //pagehelper
//        String s = studentService.selectPage();
//        return s;
        //mybatis-plus

        return studentService.mybatisPage();
    }

    @PutMapping("UpdataStudent")    //修改
    public String updataStudent(){
        studentService.updataStudent();
        return "updata success";
    }

    @PostMapping("InsertStudent")   //添加
    public String insertStudent(){
        studentService.insertStudent();
        return "insert success";
    }

    @PostMapping("Insert")   //添加
    public String insert(){
        studentService.insert();
        return "insert success";
    }

    @DeleteMapping("DeleteStudent") //删除
    public String deleteStudent(){
        studentService.deleteStudent();
        return "delete success";
    }
}
