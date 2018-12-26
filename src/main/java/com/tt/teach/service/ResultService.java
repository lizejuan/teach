package com.tt.teach.service;

import com.tt.teach.pojo.Result;
import com.tt.teach.pojo.Subject;

import java.util.List;

public interface ResultService {
    //获取所有成绩信息的接口
    List<Result> findResAll();
    //删除成绩信息的方法
    int deleteResult(Integer resultNo);
    //修改成绩信息的方法
    int updateResult(Result result1);
    //添加学生成绩信息的方法
    int addResult(Result result1);
    //获取所有科目信息的方法
    List<Subject> getSubject();
}
