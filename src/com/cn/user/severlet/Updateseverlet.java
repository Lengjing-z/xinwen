package com.cn.user.severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.cn.service.Userservice;
import com.cn.vo.User;

/**
 * Servlet implementation class Updateseverlet
 */
@WebServlet("/Updateseverlet")
public class Updateseverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateseverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("username");
		String type = request.getParameter("type");
		String sex = request.getParameter("sex");
		System.out.println(id+name+type+sex);
		Userservice userservice = new Userservice();
		int i = userservice.updateUser(name, sex, type, Integer.parseInt(id));
		if(i>0) {
			List<User> list = userservice.alluser();
			request.getSession().setAttribute("userlist", list);
		}
		
		
		
		response.sendRedirect("user.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
		}

}
