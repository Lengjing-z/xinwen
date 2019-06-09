package com.cn.severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.Newservice;
import com.cn.vo.News;
import com.cn.vo.User;

/**
 * Servlet implementation class AddNewsSeverlet
 */
@WebServlet("/AddNewsSeverlet")
public class AddNewsSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsSeverlet() {
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
		request.setCharacterEncoding("UTF-8");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		User user=(User)request.getSession().getAttribute("user");
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date=sdf.format(new Date());
		News  news=new News();
		news.setUserid(user.getId());
		news.setContent(content);
		news.setPubtime(date);
		news.setTitle(title);
		Newservice n=new Newservice();
		int i=n.addNews(news);
		response.setContentType("text/html;charset=utf-8");
		 PrintWriter out=response.getWriter();
		if(i>0) {
			out.write("success");
		}else {
			out.write("fail");
		}
	}

}
