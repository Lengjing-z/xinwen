package com.cn.user.severlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.cn.service.Userservice;
import com.cn.vo.User;

/**
 * Servlet implementation class PersonalSeverlet
 */
@WebServlet("/PersonalSeverlet")
public class PersonalSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalSeverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("username");
		Userservice userservice=new Userservice();
		User user=userservice.getUserByName(name);

		System.out.println(user.getUsername());
		if(Integer.parseInt(id) == 0) {
			request.getSession().setAttribute("personal",user);
			response.sendRedirect("Personal.jsp");
		}else {
			JSONObject json=new JSONObject();
			json.put("id", user.getId());
			json.put("username", user.getUsername());
			int sex = 0;
			if(user.getSex().equals("Ů")) {
				sex = 1;
			}
			json.put("sex",sex);
			json.put("type", user.getType());
			json.put("hobby",user.getHobby());
			json.put("address",user.getAddr());
			json.put("introduce",user.getIntro());
			response.setContentType("text/json");
			PrintWriter out=response.getWriter();
			out.write(json.toJSONString());
			out.flush();
			out.close();
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
