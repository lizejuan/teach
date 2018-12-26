package com.tt.teach.dao;

import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@作者:lizejuan
 *@时间:2018/12/21 20:01
 *@描述:这是科目类的数据访问层
 */
@Mapper
@Repository
public interface SubjectDao {
    //获取所有科目信息的方法
    @Select("select subject.*,grade.gradeName as gradeName from subject,grade where grade.gradeID = subject.gradeID")
    List<Subject> getSubAll();
    //删除科目信息的方法
    @Delete("delete from subject where subjectNo = #{subjectNo}")
    int deleteSubject(Integer subjectNo);
    //修改科目信息的方法
    @Update("update subject set subjectName =#{subjectName},classHour = #{classHour} where subjectNo = #{subjectNo}")
    int updateSubject(Subject subject);
    //添加科目信息的方法
    @Insert("insert into subject(subjectName,classHour,gradeID) values(#{subjectName},#{classHour},#{gradeID})")
    int addSubject(Subject subject);
    //获取所有年级信息
    @Select("select * from grade")
    List<Grade> getGrade();
}
