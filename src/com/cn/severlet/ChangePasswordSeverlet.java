package com.cn.severlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.Userservice;

/**
 * Servlet implementation class ChangePasswordSeverlet
 */
@WebServlet("/ChangePasswordSeverlet")
public class ChangePasswordSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordSeverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		int userid = Integer.parseInt(id);
		String oldPass =request.getParameter("passwd");
		String newPass = request.getParameter("pass");
		
		System.out.println(userid+" "+oldPass+" "+newPass);
		
		Userservice service = new Userservice();
		int i = service.updatePassword(userid, oldPass, newPass);
		response.setContentType("text/html;charset=utf-8");
		 PrintWriter out=response.getWriter();
		if(i>0) {
			out.write("success");
		}else {
			out.write("fail");
		}
	}

}
