package com.cn.user.severlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.Userservice;
import com.cn.vo.User;

/**
 * Servlet implementation class LoseUserSeverlet
 */
@WebServlet("/LoseUserSeverlet")
public class LoseUserSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoseUserSeverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String type = request.getParameter("tp");
		if(type.equals("已失效")) {
			type = "-1";
		}else if(type.equals("管理员")) {
			type= "1";
		}else {
			type = "0";
		}
		Userservice userservice = new Userservice();
		int i = userservice.deleteUser(name,type);
		if(i>0) {
			List<User> list = userservice.alluser();
			request.getSession().setAttribute("userlist", list);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
