package com.superxz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superxz.service.ListService;

@WebServlet(name = "deleteMessage", urlPatterns = { "/deleteMessage" })
public class DeleteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListService listService = new ListService();
		// 设置字符编码
		request.setCharacterEncoding("UTF-8");
		// 获取查询条件
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		request.setAttribute("description", description);
		request.setAttribute("command", command);
		
		// 获取查询结果
		request.setAttribute("messageList", listService.getMessageList(command, description));
		// 跳转到前台
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
