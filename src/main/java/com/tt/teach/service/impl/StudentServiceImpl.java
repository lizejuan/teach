package com.tt.teach.service.impl;

import com.tt.teach.dao.StudentDao;
import com.tt.teach.pojo.Student;
import com.tt.teach.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *@作者:lizejuan
 *@时间:2018/12/19 11:45
 *@描述:学生的业务逻辑层的实现类
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Resource
    private StudentDao studentDao;

    //登录的方法
    public Student doLogin(Student student) {
        return studentDao.doLogin(student);
    }

    //获取所有学生信息的方法
    public List<Student> findStuAll() {
        return studentDao.findStuAll();
    }

    //修改学生信息的方法
    @Transactional
    public int updateStu(Student student) {
        return studentDao.updateStu(student);
    }

    //删除学生信息的方法
    @Transactional
    public int deleteStu(Integer stuNo) {
        return studentDao.deleteStu(stuNo);
    }

    //获取所有学生学号的方法
    public Student getStudentByNo(Integer studentNo) {
        return studentDao.getStudentByNo(studentNo);
    }
}
