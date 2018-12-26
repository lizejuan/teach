package com.tt.teach.dao;

import com.tt.teach.pojo.Result;
import com.tt.teach.pojo.Subject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@作者:lizejuan
 *@时间:2018/12/20 16:41
 *@描述:成绩的数据访问层
 */
@Mapper
@Repository
public interface ResultDao {
    //获取所有成绩信息的接口
    @Select("SELECT result.*,student.studentName AS studentName,subject.subjectName AS subjectName FROM result,student,SUBJECT  WHERE result.studentNo=student.studentNo AND result.subjectNo=subject.subjectNo ORDER BY examDate DESC\n")
    List<Result> findResAll();
    //删除成绩信息的方法
    @Delete("delete from result where resultNo=#{resultNo}")
    int deleteResult(Integer resultNo);
    //修改成绩信息的方法
    @Update("update result set studentResult =#{studentResult} where resultNo=#{resultNo}")
    int updateResult(Result result1);
    //添加学生成绩信息的方法
    @Insert("INSERT INTO result (subjectNo,studentNo,examDate,studentResult) VALUES(#{subjectNo},#{studentNo},#{examDate},#{studentResult})")
    int addResult(Result result1);
    //获取所有科目信息的方法
    @Select("select * from subject")
    List<Subject> getSubject();
}
