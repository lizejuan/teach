package com.tt.teach.pojo;

import java.io.Serializable;
/**
 *@作者:lizejuan
 *@时间:2018/12/19 10:26
 *@描述:实体类Grade表---对应数据库的grade
 */
public class Grade implements Serializable{
    private Integer gradeID;
    private String gradeName;

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Grade() {
    }

    public Grade(Integer gradeID, String gradeName) {
        this.gradeID = gradeID;
        this.gradeName = gradeName;
    }
}
