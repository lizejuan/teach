package com.tt.teach.service;

import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;

import java.util.List;

/**
 *@作者:lizejuan
 *@时间:2018/12/21 20:01
 *@描述:这是科目类的业务逻辑层的接口
 */
public interface SubjectService {
    //获取所有科目信息的方法
    List<Subject> getSubAll();
    //删除科目信息的方法
    int deleteSubject(Integer subjectNo);
    //修改科目信息的方法
    int updateSubject(Subject subject);
    //添加科目信息的方法
    int addSubject(Subject subject);
    //获取所有年级信息
    List<Grade> getGrade();
}
