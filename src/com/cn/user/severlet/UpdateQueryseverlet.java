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
 * Servlet implementation class UpdateQueryseverlet
 */
@WebServlet("/UpdateQueryseverlet")
public class UpdateQueryseverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQueryseverlet() {
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
		String name=request.getParameter("user");
		Userservice userservice=new Userservice();
		User user=userservice.getUserByName(name);
		int sex = 0;
		if(user.getSex().equals("Ů")) {
			sex = 1;
		}else {
			sex = 0;
		}
		System.out.println(user.getUsername());
		
		JSONObject json=new JSONObject();
		json.put("id", user.getId());
		json.put("username", user.getUsername());
		
		json.put("sex",sex);
		json.put("type", user.getType());
		response.setContentType("text/json");
		PrintWriter out=response.getWriter();
		out.write(json.toJSONString());
		out.flush();
		out.close();
	}

}
