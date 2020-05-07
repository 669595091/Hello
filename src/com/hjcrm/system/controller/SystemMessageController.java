package com.hjcrm.system.controller;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Message;
import com.hjcrm.system.entity.Subject;
import com.hjcrm.system.service.InterMessageService;
import com.hjcrm.system.service.InterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SystemMessageController {
    @Autowired
    private InterMessageService messageService;

    /**
     * 跳转主页面
     */
    @RequestMapping("/system/systemMessage.do")
    public String messageManger(){
        if(UserSessionContext.getLoginUser()!=null){
            return JumpView.SYSTEM_MESSAGE;
        }
        return JumpView.LOGIN_VIEW;
    }

    //分页查询显示消息信息
    @RequestMapping(value="/system/querySystemmessages.do")
    public @ResponseBody
    String querySystemmessages(Integer pageSize,Integer currentPage){
        System.out.println("querySystemmessages:"+pageSize);
        if(pageSize!=null && currentPage!=null){
            //封装分页查询实体类
            PageBean pageBean=new PageBean();
            pageBean.setPageSize(pageSize);//设置每页记录条数
            pageBean.setCurrentPage( (currentPage-1)*pageSize );//设置当前页
            //分页查询角色信息数据
            List<Message> list = messageService.queryMessage(pageBean);
            for (Message m:list
                    ) {
                System.out.println("subjectList: "+m);
            }
            //设置返回分页数据的json字符串(pageBean的三个key：countResult,total,rows);
            int count = messageService.queryMessageCount();
            String messageJson = PageBean.jsonUserInfoToPage(list,count,currentPage);
            System.out.println("messageJson:"+messageJson);
            return messageJson;
        }
        return ReturnConstants.PARAM_NULL;
    }

    //添加消息
    @RequestMapping(value="/system/saveOrUpdateMessage.do")
    public @ResponseBody
    String addOrUpdateSubject(Message message){
        if(message!=null){
            if(message.getSystemmessageId()!=0){
                int i = messageService.updateMessage(message);
                System.out.println("修改课程："+i);
                return ReturnConstants.SUCCESS;
            }else{
                int i = messageService.addMessage(message);
                System.out.println("添加课程："+i);
                return ReturnConstants.SUCCESS;
            }

        }
        return ReturnConstants.PARAM_NULL;
    }
    //发布
    @RequestMapping(value="/system/sendMessage.do")
    public @ResponseBody
    String sendMessage(Message message){
        if(message!=null){
            if(message.getSystemmessageId()!=0){
                int i = messageService.sendMessage(message);
                System.out.println("发布信息："+i);
                return ReturnConstants.SUCCESS;
            }
        }
        return ReturnConstants.PARAM_NULL;
    }
}



