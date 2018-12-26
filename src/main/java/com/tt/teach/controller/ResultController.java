package com.tt.teach.controller;

import com.tt.teach.pojo.Result;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.ResultService;
import com.tt.teach.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *@作者:lizejuan
 *@时间:2018/12/20 16:39
 *@描述:成绩类的控制器
 */
@Controller
@RequestMapping("/res")
public class ResultController {
    @Resource
    private ResultService resultService;

    //获取所有学生成绩的页面请求
    //http://localhost:8080/res/result
    @RequestMapping(value = "/result",method = RequestMethod.GET)
    public String result(Model model) {
        List<Subject> list = resultService.getSubject();
        model.addAttribute("subjectList",list);
        return "/result/result";
    }
    //获取所有成绩信息的接口
    //http://localhost:8080/res/findResAll
    @RequestMapping(value = "/findResAll",method = RequestMethod.GET)
    @ResponseBody
    public Object findResAll() {
        List<Result> list = resultService.findResAll();
        return list;
    }
    //删除成绩信息的方法
    //http://localhost:8080/res/deleteResult
    @RequestMapping(value = "/deleteResult/{resultNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteResult(@PathVariable Integer resultNo) {
        int result = resultService.deleteResult(resultNo);
        if (result>0){
            return JsonResult.ok("删除成功！",result);
        }
        return JsonResult.no("删除失败！",result);
    }

    //修改成绩信息的方法
    //http://localhost:8080/res/updateResult
    @RequestMapping(value = "/updateResult",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateResult(@RequestParam Integer resultNo,@RequestParam Integer studentResult) {
        Result result1 = new Result();
        result1.setResultNo(resultNo);
        result1.setStudentResult(studentResult);
        int result = resultService.updateResult(result1);
        if (result>0){
            return JsonResult.ok("修改成功",result);
        }
        return JsonResult.no("修改失败！",result);
    }
    //添加学生成绩信息的方法
    //http://localhost:8080/res/addResult
    @RequestMapping(value = "/addResult",method = RequestMethod.PUT)
    @ResponseBody
    public Object addResult(@RequestParam Integer subjectNo,@RequestParam Integer studentResult,@RequestParam String examDate,@RequestParam Integer studentNo) throws ParseException {
        Result result1 = new Result();
        result1.setSubjectNo(subjectNo);
        result1.setStudentResult(studentResult);
        result1.setStudentNo(studentNo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        result1.setExamDate(simpleDateFormat.parse(examDate));
        int result = resultService.addResult(result1);
        if (result>0){
            return JsonResult.ok("添加成功",result);
        }
        return JsonResult.no("添加失败！",result);
    }

}
