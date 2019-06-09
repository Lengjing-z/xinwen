<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td{ text-align:center; border:1px #F60 soid; outline:none; border-radius: 5px;}
.inp{ border:1px #F60 soid; outline:none; width:200px; height:30px; padding-left:10px; padding-right:10px; border-radius:5px; transition:all 0.2s;}/*输入框属性*/
.inp:focus{ border-color:#F00;}
.but{margin-bottom:20px; border:1px #F60 soid; outline:none; width:80px; height:40px; padding-left:10px; padding-right:10px; border-radius:5px; transition:all 0.2s;}/*输入框属性*/
}
</style>
</head>
<body>
<input class="but" type="button" value="添加新闻" onclick="addNews()">
<form action="NewsSeverlet" method="post">
<input class="inp" name = "news" type ="text" id = "news"><input type = "submit" value="查询" class="but">
</form>
<%List<News> list = (List<News>)session.getAttribute("NewsList");
User u = (User)session.getAttribute("user");

%>
<table  border="1">
	<tr>
		<td width="79">序号</td>
		<td width="103">新闻标题</td>
		<td width="83">发布人</td>
		<td width="95">发布时间</td>
		<td width="92">操作
		</td>
	</tr>
	<%if(list !=null)
		for(int i = 0;i<list.size();i++){
			News n = list.get(i);
		%>
		<tr>
		<td width="103"><%=i+1%></td>
		<td width="103"><%= n.getTitle()%></td>
		<td width="103"><%= n.getUsername()%></td>
		<td width="103"><%= n.getPubtime()%></td>
		<td width="143" class="cloor">
		<%if(u.getType().equals("1")||u.getUsername().equals(n.getUsername())){ %>
		<a href="updateNews.jsp?id=<%= i%>">修改</a>
		<a href="DeleteSeverlet?id=<%=n.getId()%>">删除</a>
		<a href="Show.jsp?id=<%= i%>">查看详情</a></td>
	</tr>
		<%}else{ %>
			<a href="Show.jsp?id=<%= i%>">查看详情</a>
		<%} %>
		<%} %>
	
</table>
<script type="text/javascript">
function addNews(){
	window.location.href="addNews.jsp";
}


</script>
</body>
</html>