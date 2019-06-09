package com.cn.service;

import java.util.List;

import com.cn.dao.NewsDao;
import com.cn.vo.News;

public class Newservice {
	NewsDao Ndao = new NewsDao();

	public List<News> getAllNews(){
		return Ndao.getAllNews();
	}
	public int addNews(News n) {
		return Ndao.addNews(n);
	}
	public int updateNews(News n) {
		return Ndao.updateNews(n);
	}
	public int deleteNews(int id) {
		return Ndao.deleteNews(id);
	}
	public List<News> getNews(String query){
		return Ndao.getNews(query);
	}
}
