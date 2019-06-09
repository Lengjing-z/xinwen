package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.db.Jdbcutil_new;
import com.cn.vo.News;

public class NewsDao {

	
	Jdbcutil_new  jp=null;
	
	public NewsDao() {
		jp=new Jdbcutil_new("web");
	}
	
	public List<News> getAllNews(){
		
		List<News> list = new ArrayList<News>();
		String sql = "select news.*,user.username from news,user where news.userid = user.id";
		Object params[] = {};
		ResultSet rSet = jp.QueryData(sql, params);
		try {
			while(rSet.next()) {
				News news = new News();
				news.setId(rSet.getInt("Id"));
				news.setTitle(rSet.getString("title"));
				news.setContent(rSet.getString("content"));
				news.setPubtime(rSet.getString("pubtime"));
				news.setUsername(rSet.getString("username"));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int addNews(News n) {
		String sql = "insert into news(title,content,userid,pubtime)values(?,?,?,?)";
		Object params[] = { n.getTitle(), n.getContent(), n.getUserid(), n.getPubtime() };
		return jp.updateData(sql, params);
	}
	
	public int updateNews(News n) {
		Object params[] = {n.getTitle(),n.getContent(),n.getPubtime(),n.getId()};
		
		String sql = "update news set title=?,content=?,pubtime=? where id=?";
	   return jp.updateData(sql, params);

	}

	public int deleteNews(int id) {
		String sql ="delete from news where Id=?";
		Object params[] = {id};
		
		return jp.updateData(sql, params);
	}
	public List<News> getNews(String query){
		List<News> list = new ArrayList<News>();
		String sql = "select n.*,u.username from news n join user u on n.userid= u.id where title like ? or username like ? or content like ?";
		Object params[] = {query,query,query};
		ResultSet rSet = jp.QueryData(sql, params);
		try {
			while(rSet.next()) {
				News news = new News();
				news.setId(rSet.getInt("Id"));
				news.setTitle(rSet.getString("title"));
				news.setContent(rSet.getString("content"));
				news.setPubtime(rSet.getString("pubtime"));
				news.setUsername(rSet.getString("username"));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
