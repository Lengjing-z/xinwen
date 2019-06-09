package com.cn.severlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.Userservice;
import com.cn.vo.User;



/**
 * Servlet implementation class Registerseverlet
 */
@WebServlet("/Registerseverlet")
public class Registerseverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registerseverlet() {
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
		
		String name = request.getParameter("username");
		String pass = request.getParameter("pass");
		String sex = request.getParameter("sex");
		String hob[] = request.getParameterValues("hob");
		String aihao = "";
		if(hob !=null){
			for(int i =0;i<hob.length;i++){
				aihao = aihao + hob[i]+" ";
			}
		}
		String addr = request.getParameter("addr");
		String intrd = request.getParameter("intrd");
		User user = new User();
		user.setAddr(addr);
		user.setSex(sex);
		user.setUsername(name);
		user.setIntro(intrd);
		user.setHobby(aihao);
		user.setPassword(pass);
		
		
		
		Userservice rs = new Userservice();
		if(rs.register(name, pass, sex, aihao, addr, intrd)) {
			response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("fail.jsp");
		}
		
	}

}
