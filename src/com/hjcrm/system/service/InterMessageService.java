package com.hjcrm.system.service;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Message;
import com.hjcrm.system.entity.Subject;

import java.util.List;

public interface InterMessageService {

    public List<Message> queryMessage(PageBean pageBean);

    public int queryMessageCount();

    public int updateMessage(Message message);

    public int addMessage(Message message);

    public int sendMessage(Message message);
}
