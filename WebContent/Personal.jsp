<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{ margin-bottom: 5px; margin-top: 14px;}
</style>
</head>
<body>
<%User pers = (User)session.getAttribute("personal"); %>
<h3>个人中心</h3>
<div>
	<div>用户名:<%=pers.getUsername() %></div>
	<div>爱好:<%=pers.getHobby() %></div>
	<div>性别:<%=pers.getSex() %></div>
	<div>籍贯:<%=pers.getAddr()%></div>
	<div>个性签名:<%=pers.getIntro() %></div>
	<input type= "button" value="修改" onclick="" >
	
</div>
</body>
</html>