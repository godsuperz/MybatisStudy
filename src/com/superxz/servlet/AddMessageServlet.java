package com.superxz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superxz.service.AddService;

@WebServlet(name = "addMessage", urlPatterns = { "/addMessage" })
public class AddMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符编码
		request.setCharacterEncoding("UTF-8");	
		response.setContentType("text/html;charset=UTF-8");
		// 获取数据
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		String content = request.getParameter("content");
		AddService addService = new AddService();
		addService.addMessage(command, description, content);
		response.sendRedirect("/list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
