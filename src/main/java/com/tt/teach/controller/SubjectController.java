package com.tt.teach.controller;

import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.SubjectService;
import com.tt.teach.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *@作者:lizejuan
 *@时间:2018/12/21 20:00
 *@描述:这是科目类的控制器
 */
@Controller
@RequestMapping("/sub")
public class SubjectController {
    @Resource
    private SubjectService subjectService;
    //获取科目信息的页面
    @RequestMapping("/subject")
    public String subject(Model model) {
        List<Grade> list = subjectService.getGrade();
        model.addAttribute("gradeList",list);
        return "/subject/subject";

    }
    //获取所有科目信息的方法
    @RequestMapping("/getSubAll")
    @ResponseBody
    public Object getSubAll() {
        List<Subject> list = subjectService.getSubAll();
        return list;
    }
    //删除科目信息的方法
    @RequestMapping(value = "/deleteSubject/{subjectNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteSubject(@PathVariable Integer subjectNo) {
        int result = subjectService.deleteSubject(subjectNo);
        if (result>0){
            return JsonResult.ok("删除成功！",result);
        }
        return JsonResult.ok("删除失败！",result);
    }

    //修改科目信息的方法
    @RequestMapping(value = "/updateSubject",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateSubject(@RequestParam Integer subjectNo,@RequestParam String subjectName,@RequestParam Integer classHour) {
        Subject subject = new Subject();
        subject.setClassHour(classHour);
        subject.setSubjectNo(subjectNo);
        subject.setSubjectName(subjectName);
        int result = subjectService.updateSubject(subject);
        if (result>0){
            return JsonResult.ok("修改成功！",result);
        }
        return JsonResult.ok("修改失败！",result);
    }
    //添加科目信息的方法
    @RequestMapping(value = "/addSubject",method = RequestMethod.PUT)
    @ResponseBody
    public Object addSubject(@RequestParam Integer gradeID,@RequestParam String subjectName,@RequestParam Integer classHour) {
        Subject subject = new Subject();
        subject.setClassHour(classHour);
        subject.setGradeID(gradeID);
        subject.setSubjectName(subjectName);
        int result = subjectService.addSubject(subject);
        if (result>0){
            return JsonResult.ok("添加成功！",result);
        }
        return JsonResult.ok("添加失败！",result);
    }
}
