package com.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * index.jsp文件中的method="GET"
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("GET");
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("GBK");
		String name = request.getParameter("name");//index.jsp文件中的name="name"
		String sayAny =  new String(request.getParameter("sayAny").getBytes("iso-8859-1"), "gbk");
		System.out.println(sayAny);
		request.setAttribute("name","Do get Hello "+name);
		request.setAttribute("say",sayAny);
		request.getRequestDispatcher("/SayHello.jsp").forward(request, response);
	}

	/**
	 *  index.jsp文件中的method="POST"
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=GBK");
		request.setCharacterEncoding("GBK");
		String name = request.getParameter("name");//index.jsp文件中的name="name"
		String sayAny = request.getParameter("sayAny");
		System.out.println(sayAny);
		request.setAttribute("name","Do POST Hello "+name);
		request.setAttribute("say",sayAny);
		request.getRequestDispatcher("/SayHello.jsp").forward(request, response);
	}

}
