package com.superxz.service;

import java.util.List;

import com.superxz.bean.Message;
import com.superxz.dao.ListDAO;

public class ListService {

	public List<Message> getMessageList(String command, String description){
		ListDAO listDao = new ListDAO();
		List<Message> messageList = listDao.getMessageList(command, description);
		return messageList;
	}
}
