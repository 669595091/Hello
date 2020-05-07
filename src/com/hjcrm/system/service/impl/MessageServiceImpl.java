package com.hjcrm.system.service.impl;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Course;
import com.hjcrm.system.entity.Message;
import com.hjcrm.system.mapper.CourseDao;
import com.hjcrm.system.mapper.MessageDao;
import com.hjcrm.system.service.InterCourseService;
import com.hjcrm.system.service.InterMenuService;
import com.hjcrm.system.service.InterMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements InterMessageService{
    @Autowired
    private MessageDao messageDao;

    @Override
    public List<Message> queryMessage(PageBean pageBean) {
        return messageDao.queryMessage(pageBean);
    }

    @Override
    public int queryMessageCount() {
        return messageDao.queryMessageCount();
    }

    @Override
    public int updateMessage(Message message) {
        return messageDao.updateMessage(message);
    }

    @Override
    public int addMessage(Message message) {
        return messageDao.addMessage(message);
    }

    @Override
    public int sendMessage(Message message) {
        return messageDao.sendMessage(message);
    }
}
