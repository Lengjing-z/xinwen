package com.cn.severlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.Newservice;
import com.cn.vo.News;

/**
 * Servlet implementation class UpdateNewsSeverlet
 */
@WebServlet("/UpdateNewsSeverlet")
public class UpdateNewsSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNewsSeverlet() {
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
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String id=request.getParameter("id");
		SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date=simpleDateFormat.format(new Date());
		News  news=new News();
		
		news.setContent(content);
		news.setPubtime(date);
		news.setTitle(title);
		news.setId(Integer.parseInt(id));
		
		Newservice n=new Newservice();
		 int i=n.updateNews(news);
		if(i>0) {
			List<News> list = n.getAllNews();
			request.getSession().setAttribute("NewsList", list);
		}
			response.sendRedirect("newsManager.jsp");
	}

}
