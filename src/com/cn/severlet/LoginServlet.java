package com.cn.severlet;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
	String  user=request.getParameter("username");
	String  pass=request.getParameter("passwd");	
	Userservice  lb=new Userservice();
	List<User> l=lb.login(user, pass);
		if(!l.isEmpty()) {
			try {
				List<User> li = lb.alluser();
				for(int i =0;i<li.size();i++) {
					User u = li.get(i);
					System.out.println(u.getUsername()+"\t\t"+u.getPassword()+"\t\t"+u.getSex()+"\t\t"+u.getHobby()+"\t\t"+u.getAddr()+"\t\t"+u.getIntro()+"\t\t"+u.getType());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(l.get(0).getType().equals("-1")) {
				response.sendRedirect("fail.jsp");
			}else {
				request.getSession().setAttribute("user", (User)l.get(0));
				response.sendRedirect("index.jsp");
			}
		}else {
			response.sendRedirect("fail.jsp");
		}
	}

}
