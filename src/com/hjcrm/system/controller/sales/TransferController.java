package com.hjcrm.system.controller.sales;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.UserSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TransferController {


    /**
     * 跳转主页面
     */
    @RequestMapping(value="/sales/transferRecord.do",method=RequestMethod.GET)
    public String companySalesIndex(){
        if(UserSessionContext.getLoginUser()!=null){
            return JumpView.SALES_TRANSFERRECORD;
        }

        return JumpView.LOGIN_VIEW;
    }
}
