package cn.edu.hqu.javaee.chapter5_2.service;

import java.util.List;

import cn.edu.hqu.javaee.chapter5_2.entity.Message;

public interface MessageService {
	public List<Message> getMessageByUserName(String userName);
	public void saveMessage(Message message);

}
