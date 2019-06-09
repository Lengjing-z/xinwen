<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/public.css">
</head>
<body>
<%List<News> list = (List<News>)session.getAttribute("NewsList");
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
int i = Integer.parseInt(id);
News n = list.get(i);
%>
<form action="UpdateNewsSeverlet" method="post" name="form1" id="form1">
  <table width="844" border="1">
    <tr>
      <th colspan="4" bgcolor="#00FF99" scope="col"><div align="left">
      <input name = "id" id="id" type="hidden" value="<%=n.getId() %>">
          <p>修改新闻</p>
      </div></th>
    </tr>
    
    <tr>
      <td height="26">新闻标题</td>
      <td colspan="3"><input name="title" type="text" id="title" size="80" value="<%=n.getTitle() %>"></td>
    </tr>
    <tr>
      <td height="137">新闻正文</td>
      <td colspan="3"><label for="zw"></label>
      <textarea name="content" cols="80" rows="10" id="content"><%=n.getContent() %></textarea></td>
    </tr>
   
    <tr>
      <td colspan="4"><div align="center">
          <input type="button" name="提交" id="提交" value="提交" onclick="checkNews()">
          <input type="reset" name="重置" id="重置" value="重置">
          <input type="button" name="返回" id="返回" value="返回">
      </div></td>
    </tr>
  </table>
</form>
<script type="text/javascript">
function checkNews(){
	var title=document.getElementById("title").value;
	var content=document.getElementById("content").value;
	var f=document.getElementById("form1");
	if(title==""){
		alert("标题不能为空");
		return;
	}
	if(content==""){
		alert("请填写内容");
		return;
	}
	
	document.getElementById("form1").submit();
	
}
function re(){
	history.go(-1);
}
</script>
</body>
</html>