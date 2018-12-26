package com.tt.teach.service.impl;

import com.tt.teach.dao.ResultDao;
import com.tt.teach.pojo.Result;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.ResultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *@作者:lizejuan
 *@时间:2018/12/20 16:42
 *@描述:这是成绩的业务逻辑层的实现类
 */
@Service
public class ResultServiceImpl implements ResultService{
    @Resource
    private ResultDao resultDao;

    //获取所有成绩信息的接口
    public List<Result> findResAll() {
        return resultDao.findResAll();
    }

    //删除成绩信息的方法
    @Transactional
    public int deleteResult(Integer resultNo) {
        return resultDao.deleteResult(resultNo);
    }
    //修改成绩信息的方法
    @Transactional
    public int updateResult(Result result1) {
        return resultDao.updateResult(result1);
    }

    //添加学生成绩信息的方法
    @Transactional
    public int addResult(Result result1) {
        return resultDao.addResult(result1);
    }

    //获取所有科目信息的方法
    public List<Subject> getSubject() {
        return resultDao.getSubject();
    }
}
