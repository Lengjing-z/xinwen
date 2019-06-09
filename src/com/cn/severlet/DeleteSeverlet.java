package com.cn.severlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.Newservice;
import com.cn.vo.News;

/**
 * Servlet implementation class DeleteSeverlet
 */
@WebServlet("/DeleteSeverlet")
public class DeleteSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSeverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nid = request.getParameter("id");
		int id = Integer.parseInt(nid);
		Newservice n = new Newservice();
		int i = n.deleteNews(id);
		if(i>0) {
			List<News> list = n.getAllNews();
			request.getSession().setAttribute("NewsList", list);
		}
		
		response.sendRedirect("newsManager.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
