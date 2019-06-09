package com.cn.service;

import java.util.List;

import com.cn.dao.UserDao;
import com.cn.vo.User;

public class Userservice {//所有的用户服务
	
	UserDao dao = null;
	public Userservice() {
		dao = new UserDao();
	}

	public List<User> login(String user,String pass) {
		
		return dao.selectUser(user, pass);
	}
	public boolean register(String user,String pass,String sex,String hobby,String addr,String intrd) {
		return dao.addUser(user, pass, sex, hobby, addr, intrd);
	}
	public List<User> alluser() {
		return dao.selectAll();
	}
	public boolean checkUser(String user) {
		return dao.checkUser(user);
	}
	public int updatePassword(int id,String oldpass,String newpass) {
		return dao.updatePassword(id, oldpass, newpass);
	}

	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return dao.getUserByName(name);
	}
	public int updateUser(String name,String sex,String type,int id) {
		return dao.updateUser(name, sex, type,id);
	}
	public int deleteUser(String name,String type) {
		return dao.deleteUser(name,type);
	}
}
