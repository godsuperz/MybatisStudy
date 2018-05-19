package com.superxz.service;

import java.util.ArrayList;
import java.util.List;

import com.superxz.dao.ListDAO;

public class MaintainService {

	/**
	 * 单条删除
	 * @param id
	 */
	public String deleteMessage(String id) {
		int result = 0;
		if(id != null && !"".equals(id)) {
			ListDAO listDAO = new ListDAO();
			result = listDAO.deleteMessage(Integer.parseInt(id));
		}
		if(result > 0) {
			return "成功删除！";
		}else {
			return "删除失败！";
		}
	}
	
	public String deleteMessages(String[] ids) {
		ListDAO listDAO = new ListDAO();
		List<Integer> idList = new ArrayList<Integer>();
		if(ids != null && ids.length > 0) {
			for (String id : ids) {
				idList.add(Integer.parseInt(id));
			}
			listDAO.deleteMessages(idList);
			return "删除成功！";
		}else {
			return "请至少选择一个消息！";
		}
	}
}
