package com.superxz.service;

import com.superxz.bean.Message;
import com.superxz.dao.ListDAO;

public class AddService {

	public void addMessage(String command, String description, String content) {
		ListDAO listDAO = new ListDAO();
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		message.setContent(content);
		listDAO.addMessage(message);
	}
}
