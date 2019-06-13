<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""
 pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/public.css">
<script type="text/javascript" src = "js/jquery-3.2.1.min.js"></script>
<style type="text/css">
h4{ font-size:30px; margin-bottom:20px;}/*标题*/
.content{ margin-top:50px; margin-left:50px;}/*界面位置*/
.inputs{ border:1px #F60 soid; outline:none; width:200px; height:30px; padding-left:10px; padding-right:10px; border-radius:5px; transition:all 0.2s;}/*输入框属性*/
.inputs:focus{ border-color:#F00;}/*聚焦时属性*/
p{ margin-bottom:20px;}/*p标签间距*/
input{ outline:none;}
.red{ border:1px #0000FF solid;}
.dl{ background:#F30; width:100px; height:30px; margin-left:55px; color:#FFF; border:none;}/*登录按钮属性*/
</style>
</head>

<body>
<form name="form1" method="post" action="Registerseverlet" id ="subm">
<div class="content">
    <h4>注册:</h4>
  <p>账户：
    <input class="inputs" type="text" name="username" id = "user" onblur="checkUser()">
    <span id = "ck"></span>
  </p>
  <p>密码：
    <input class="inputs" type="password" name="pass" id ="pass">
  </p>
  <p>确认密码：
    <input class="inputs" type="password" name="repass" id = "repass">
  </p>
  <p>性别：
    <input type="radio" name="sex" value="男">
    男 
    <input type="radio" name="sex" value="女">
  女</p>
  <p>爱好：
    <input type="checkbox" name="hob" id="checkbox" value="java">
    Java 
    <input type="checkbox" name="hob" id="checkbox2" value="上课">
    上课 
    <input type="checkbox" name="hob" id="checkbox3" value="看书">
  看书</p>
  <p>籍贯： 
    <select name="addr">
      <option value="四川">四川</option>
      <option value="重庆">重庆</option>
      <option value="贵州">贵州</option>
    </select>
  </p>
  <p>个人简介：
    <textarea name="intrd" id="textarea"></textarea>
  </p>
  <p>
    <input class="dl" type="button" name="button"  value="注册"  onclick="check()" >
    <input class="dl" type="submit" name="button2" id="button2" value="重置">
  </p>
  </div>
</form>

<script type="text/javascript">
function checkUser(){
	var user = document.getElementById("user").value;
	$.post("CheckSeverlet",{"user":user},function(data){
		if(data == "success" && user != ""){
			document.getElementById("ck").innerHTML = "可用";
		}else{
			document.getElementById("ck").innerHTML = "不可用";
		}
	});
	
}

function check() {
	var pass = document.getElementById("pass").value;
	var repass = document.getElementById("repass").value;
	if(pass.length<6||pass.length>18){
		alert("密码必须在6到18位");
	}else if(pass!=repass){
		alert("两次输入密码不一致");
	}else{
		
		document.getElementById("subm").submit();
	}
	
}
</script>
</body>
</html>