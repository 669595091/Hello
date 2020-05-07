package com.hjcrm.system.controller.sales;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Dealrecord;
import com.hjcrm.system.entity.Resource;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.service.InterResourceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SaleResourceController {
    @Autowired
    private InterResourceService resourceService;


    /**
     * 跳转主页面
     */
    @RequestMapping(value="/sales/resourcesMang.do",method=RequestMethod.GET)
    public String resourcesMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return JumpView.SALES_RESOURCE;
        }

        return JumpView.LOGIN_VIEW;
    }
    /**
     * 跳转主页面
     */
    @RequestMapping(value="/sales/resourcesTelMang.do",method=RequestMethod.GET)
    public String resourcesTelMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return JumpView.SALES_SALESTELAMOUNT;
        }

        return JumpView.LOGIN_VIEW;
    }
    //销售资源管理查询
    @RequestMapping("/sales/queryResource.do")
    public @ResponseBody
    String querySalesResource(int userid, int deptid, int roleid, Integer currentPage, Integer pageSize){
        Map<String,Integer> map=new HashMap<>();
        map.put("belongId",userid);
        map.put("deptid",deptid);
        map.put("currentPage",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Resource> list=resourceService.querySalesResource(map);
        if(list.size()>0){
            PageBean pageBean=new PageBean();
            pageBean.setCurrentPage(currentPage);
            pageBean.setPageSize(resourceService.queryResourceCount());
            return PageBean.jsonToPage(list,pageBean);
        }
        return ReturnConstants.PARAM_NULL;

    }
    //资源管理详情
    @RequestMapping("/resource/details.do")
    public String details(int resourceId, Model model){
        if(UserSessionContext.getLoginUser()!=null){
            List<Resource> resource = resourceService.queryDetailsResource(resourceId);
            if(resource!=null){
                model.addAttribute("record",resourceService.selectVisitrecord());
                model.addAttribute("resource",resource);
                return JumpView.SALES_DATAILS;
            }
        }
        return ReturnConstants.PARAM_NULL;
    }

    //添加资源成交信息
    @RequestMapping(value="/resource/addDealrecord.do")
    public @ResponseBody
    String addDealrecord(Dealrecord dealrecord, Student student){
        System.out.println("添加资源成交信息dealrecord: "+dealrecord);
        System.out.println("添加资源成交信息student: "+student);
        if(dealrecord!=null && student!=null){
                //添加资源成交信息
                int i = resourceService.addDealrecord(dealrecord);
                //添加学生信息
                int j = resourceService.addResourceStudent(student);
                System.out.println("添加资源信息："+i);
                System.out.println("添加资源学生信息："+j);
                return ReturnConstants.SUCCESS;
        }
        return ReturnConstants.PARAM_NULL;
    }
    //添加回访记录
    @RequestMapping("/resource/addResourceVisitrecord.do")
    public @ResponseBody String addResourceVisitrecord(Integer userid,String resourceId,String visitRecord){
        if (StringUtils.isNotBlank(resourceId)){
            int i=resourceService.addResourceVisitrecord(userid,resourceId,visitRecord);
            return ReturnConstants.SUCCESS;
        }
        return ReturnConstants.PARAM_NULL;
    }

}
