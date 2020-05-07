package com.hjcrm.system.mapper;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Message;

import java.util.List;

public interface MessageDao {//消息接口
    public List<Message> queryMessage(PageBean pageBean);

    public int queryMessageCount();

    public int updateMessage(Message message);

    public int addMessage(Message message);

    public int sendMessage(Message message);
}
