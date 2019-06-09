package com.cn.severlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.Newservice;
import com.cn.vo.News;

/**
 * Servlet implementation class NewsSeverlet
 */
@WebServlet("/NewsSeverlet")
public class NewsSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsSeverlet() {
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
		String query = request.getParameter("news");
		Newservice news = new Newservice();
		List<News> list = new ArrayList<News>();
		if(query ==null) {
			list = news.getAllNews();
		}else {
			query="%"+query+"%";
			list = news.getNews(query);
		}
		
		request.getSession().setAttribute("NewsList", list);
		response.sendRedirect("newsManager.jsp");
	}

}
