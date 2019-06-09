<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/public.css">
<style type="text/css">
p{ text-align: center; line-height: 30px;}
</style>
</head>

<body>
<%User u = (User)session.getAttribute("user");  
if(u.getType().equals("1")){
%>
<p><a href="GetuserSeverlet" target="mainFrame">用户管理</a></p>
<%}else{ %>
<p><a href="PersonalSeverlet?id=0&username=<%=u.getUsername() %>" target="mainFrame">个人中心</a></p>
<%} %>

<p><a href="newsManager.jsp" target="mainFrame">新闻管理</a></p>
<p><a href="changePassword.jsp" target="mainFrame">修改密码</a></p>
<p>&nbsp;</p>
</body>
</html>
