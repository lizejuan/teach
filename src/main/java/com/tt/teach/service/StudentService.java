package com.tt.teach.service;

import com.tt.teach.pojo.Student;

import java.util.List;

/**
 *@作者:lizejuan
 *@时间:2018/12/19 11:46
 *@描述:学生的业务逻辑层的接口
 */
public interface StudentService {
    //登录的方法
    Student doLogin(Student student);
    //获取所有学生信息的方法
    List<Student> findStuAll();
    //修改学生信息的方法
    int updateStu(Student student);
    //删除学生信息的方法
    int deleteStu(Integer stuNo);
    //获取所有学生学号的方法
    Student getStudentByNo(Integer studentNo);
}
