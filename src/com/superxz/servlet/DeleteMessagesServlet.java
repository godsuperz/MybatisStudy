package com.superxz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superxz.service.MaintainService;

@WebServlet(name = "deleteMessages", urlPatterns = { "/deleteMessages" })
public class DeleteMessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		request.setAttribute("description", description);
		request.setAttribute("command", command);
		
		String[] ids = request.getParameterValues("ids");
		// 执行操作
		MaintainService maintainService = new MaintainService();
		maintainService.deleteMessages(ids);
		// 跳转到前台
		request.getRequestDispatcher("/list").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
