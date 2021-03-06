package com.icss.ch.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.ch.dao.MessagesDao;
import com.icss.ch.dao.NoticesDao;

@WebServlet("/DelMessagesServlet")
public class DelMessagesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//获取请求参数
				String messageip = request.getParameter("messageip");
				//调用dao
				MessagesDao dao =  new MessagesDao();
				//转型
				dao.DeleteMessages(Integer.parseInt(messageip));	
				request.setAttribute("msg", "嘻嘻，操作成功了！");
				request.getRequestDispatcher("SelectMessagesServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
