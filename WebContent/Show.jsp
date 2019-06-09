<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import = "java.util.*,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.title{ text-align: center;}
.username{ text-align: center; font-size: 12px;}
.time{ text-align: right;}
.content{ text-indent: 2em; font-size: 14px;}
</style>
</head>

<body>
<%List<News> list = (List<News>)session.getAttribute("NewsList");
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
int i = Integer.parseInt(id);
News n = list.get(i);
%>
<div class="title"><h3><%=n.getTitle() %></h3><p class="username" >作者：<%=n.getUsername() %></p></div>
<div class="content"><%=n.getContent() %>


</div>
<p class="time"><span><%=n.getPubtime() %></span></p>
</body>
</html>