<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<style type="text/css">
.inputs{ border:1px #F60 soid; outline:none; width:200px; height:30px; padding-left:10px; padding-right:10px; border-radius:5px; transition:all 0.2s;}/*输入框属性*/
.inputs:focus{ border-color:#F00;}
input{ outline:none;}
</style>
</head>
<body>
<%User u = (User)session.getAttribute("user"); 

%>
<form action="ChangePasswordSeverlet" method="post" id = "form1">
<input name = "id" id="id" value="<%=u.getId() %>" type="hidden">
<p>原密码： <input id="passwd" class="inputs" name="passwd" type="password"></p>
<p>新密码： <input id="pass" class="inputs" name="pass" type="password"></p>
<p>新密码： <input id="repass" class="inputs" name="repass" type="password"></p>
  <p>
    <input type="button"  value="提交" onclick="check()">
     <input type="reset"   value="重置">
  </p>
</form>
<script type="text/javascript">
function check() {
	var id = document.getElementById("id").value;
	var passwd = document.getElementById("passwd").value;
	var pass = document.getElementById("pass").value;
	var repass = document.getElementById("repass").value;
	var f=document.getElementById("form1");
	
	if(passwd==""){
		alert("原密码不能为空");
		return;
	}else if(pass.length<6||pass.length>18){
		alert("密码必须在6到18位");
		return;
	}else if(pass!=repass){
		alert("两次输入新密码不一致");
		return;
	}
	$.post("ChangePasswordSeverlet",{"id":id,"passwd":passwd,"pass":pass}, function(data) {
		 if(data == "success"){
			 history.go(-1);
		alert("修改成功");
			 
		 }else{
			 alert("修改失败");
		 }
		 }); 
	
}
</script>
</body>
</html>