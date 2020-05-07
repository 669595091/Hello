package com.hjcrm.system.controller;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Subject;
import com.hjcrm.system.service.InterSubjectService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    private InterSubjectService subjectService;

    /**
     * 跳转主页面
     */
    @RequestMapping(value="/system/subjectMang.do",method=RequestMethod.GET)
    public String subjectMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return JumpView.SYSTEM_SUBJECT;
        }
        return JumpView.LOGIN_VIEW;
    }
    //分页查询显示科目信息
    @RequestMapping(value="/subject/querySubject.do")
    public @ResponseBody
    String querySubject(Integer pageSize,Integer currentPage){
        System.out.println("pagesizeSubject:"+pageSize);
        if(pageSize!=null && currentPage!=null){
            //封装分页查询实体类
            PageBean pageBean=new PageBean();
            pageBean.setPageSize(pageSize);//设置每页记录条数
            pageBean.setCurrentPage( (currentPage-1)*pageSize );//设置当前页
            //分页查询角色信息数据
            List<Subject> list = subjectService.querySubject(pageBean);
            for (Subject s:list
                 ) {
                System.out.println("subjectList: "+s);
            }
            //设置返回分页数据的json字符串(pageBean的三个key：countResult,total,rows);
            int count = subjectService.querySubjectCount();
            String subjectJson = PageBean.jsonUserInfoToPage(list,count,currentPage);
            System.out.println("subjectJson:"+subjectJson);
            return subjectJson;
        }
        return ReturnConstants.PARAM_NULL;
    }

    //添加课程
    @RequestMapping(value="/subject/addOrUpdateSubject.do")
    public @ResponseBody
    String addOrUpdateSubject(Subject subject){
        if(subject!=null){
            if(subject.getSubjectid()!=0){
                int i = subjectService.updateSubject(subject);
                System.out.println("修改课程："+i);
                return ReturnConstants.SUCCESS;
            }else{
                int i = subjectService.addSubject(subject);
                System.out.println("添加课程："+i);
                return ReturnConstants.SUCCESS;
            }

        }
        return ReturnConstants.PARAM_NULL;
    }

    //删除课程
    @RequestMapping(value = "/subject/deleteSubject.do")
    public @ResponseBody String deleteSubject(String subjectids) {
        System.out.println("删除科目ids： "+subjectids);
        if(StringUtils.isNotBlank(subjectids)){
            List<String> list = new ArrayList<>();
            for ( String id:subjectids.split(",")
                    ) {
                list.add(id);
            }
            int i = subjectService.deleteSubject(list);
            System.out.println("删除结果： "+i);
            return ReturnConstants.SUCCESS;
        }

        return ReturnConstants.PARAM_NULL;
    }


}
