package com.hpe.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/one")
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("name","requset");
		HttpSession session = request.getSession();
		session.setAttribute("name", "session");
		ServletContext context = getServletContext();
		context.setAttribute("name", "context");
		
//		request.getRequestDispatcher("/pageContext.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/pageContext.jsp");
	}

}
