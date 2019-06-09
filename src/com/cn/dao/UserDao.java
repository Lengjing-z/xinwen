package com.cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.db.Jdbcutil_new;
import com.cn.vo.User;

public class UserDao {//所有用户相关的增删改查
	Jdbcutil_new  jp=null;
	
	public UserDao() {
		jp=new Jdbcutil_new("web");
	}
	
public List<User> selectUser(String user,String pass) {
		List<User> list = new ArrayList<User>();
		String sql="select * from user where username=? and password=md5(?)";
		Object  param[]= {user,pass};
		ResultSet rSet=jp.QueryData(sql, param);
		try {
		while(rSet.next()) {
			  User user1 = new User();
			  user1.setId(rSet.getInt("id"));
			  user1.setUsername(rSet.getString("username"));
			  user1.setPassword(rSet.getString("password"));
			  user1.setSex(rSet.getString("sex"));
			  user1.setHobby(rSet.getString("hobby"));
			  user1.setAddr(rSet.getString("address"));
			  user1.setIntro(rSet.getString("intrd"));
			  user1.setType(rSet.getString("type"));
			  list.add(user1);
		  }
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  list;
	}
	
	public boolean addUser(String user,String pass,String sex,String hobby,String addr,String intrd) {
		String sql = "insert into user(username,password,sex,hobby,address,intrd)values(?,md5(?),?,?,?,?)";
		Object  param[]= {user,pass,sex,hobby,addr,intrd};
		int t=jp.updateData(sql, param);
		boolean re=false;
		if(t > 0) {
			re=true;
			
		}
		return  re;
	}
	public List<User> selectAll() {
		List<User> list = new ArrayList<User>();
		String sql = "select *from user";
		Object params[] = {};
		ResultSet rSet=jp.QueryData(sql, params);
		try {
		while(rSet.next()) {
			  User user1 = new User();
			  user1.setId(rSet.getInt("id"));
			  user1.setUsername(rSet.getString("username"));
			  user1.setPassword(rSet.getString("password"));
			  user1.setSex(rSet.getString("sex"));
			  user1.setHobby(rSet.getString("hobby"));
			  user1.setAddr(rSet.getString("address"));
			  user1.setIntro(rSet.getString("intrd"));
			  user1.setType(rSet.getString("type"));
			  list.add(user1);
		  }
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  list;
	}
	
	public int updatePassword(int id,String oldpass,String newpass) {
		String sql = "update user set password = md5(?) where id =? and password=md5(?)";
		Object params[] = {newpass,id,oldpass};
		return jp.updateData(sql, params);
		
	}
	public int deleteUser(String name,String type) {
		String sql  = "";
		if(!type.equals("-1")) {
			sql ="update user set type = '-1' where username = ?";
		}else {
			sql = "update user set type = '0' where username = ?";
		}
		
		Object params[] = {name};
		
		return jp.updateData(sql, params);
	}
	
	public boolean checkUser(String user) {
		
		String sql = "select * from user where username=?";
		Object params[]= {user};
		ResultSet rSet=jp.QueryData(sql, params);
		boolean f = false;
		try {
			if(rSet.next()) {
				f = true;
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  f;
	}

	public User getUserByName(String name) {
		String sql="select * from user where username = ?";
		Object params[] = {name};
		ResultSet resultSet=jp.QueryData(sql, params);
		User user=new User();
		try {
			if(resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setSex(resultSet.getString("sex"));
				user.setHobby(resultSet.getString("hobby"));
				user.setAddr(resultSet.getString("address"));
				user.setIntro(resultSet.getString("intrd"));
				user.setType(resultSet.getString("type"));
				user.setUsername(resultSet.getString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	public int updateUser(String name,String sex,String type,int id) {
		String sql = "update user set username= ? ,sex=?,type=? where id = ?";
		Object params[] = {name,sex,type,id};
		return jp.updateData(sql, params);
	}
	
}


