<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/public.css">
</head>
<body>
<form name="form1" method="post" action="AddNewsSeverlet" id="form1">
  <table width="531" border="1">
    <tr>
      <td colspan="2" bgcolor="#66CC00">发布新闻</td>
    </tr>
    <tr>
      <td width="89">新闻标题</td>
      <td width="426"><label for="newsTitle02"></label>
      <input name="title" type="text" id="title" size="60"></td>
    </tr>
    <tr>
      <td>新闻正文</td>
      <td>
      <textarea name="content" cols="50" rows="10" id="content"></textarea></td>
    </tr>
    <tr>
      <td colspan="2"><div align="center">
        <input type="button"  value="提交" onclick="checkNews()">
        <input type="reset"   value="重置">
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
	 $.post("AddNewsSeverlet",{"title":title,"content":content}, function(data) {
			
		 if(data == "success"){
			 history.go(-1);
		alert("添加成功");
			 
		 }else{
			 alert("添加失败");
		 }
		 }); 
}

</script>
</body>
</html>