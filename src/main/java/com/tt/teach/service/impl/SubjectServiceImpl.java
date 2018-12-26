package com.tt.teach.service.impl;

import com.tt.teach.dao.SubjectDao;
import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.SubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *@作者:lizejuan
 *@时间:2018/12/21 20:02
 *@描述:这是业务逻辑层的实现类
 */
@Service
public class SubjectServiceImpl implements SubjectService{
    @Resource
    private SubjectDao subjectDao;

    //获取所有科目信息的方法
    public List<Subject> getSubAll() {
        return subjectDao.getSubAll();
    }

    //删除科目信息的方法
    public int deleteSubject(Integer subjectNo) {
        return subjectDao.deleteSubject(subjectNo);
    }

    //修改科目信息的方法
    public int updateSubject(Subject subject) {
        return subjectDao.updateSubject(subject);
    }

    //添加科目信息的方法
    public int addSubject(Subject subject) {
        return subjectDao.addSubject(subject);
    }

    //获取所有年级信息
    public List<Grade> getGrade() {
        return subjectDao.getGrade();
    }
}
