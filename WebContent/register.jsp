<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""
 pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<script type="text/javascript" src = "js/jquery-3.2.1.min.js"></script>
</head>

<body>
<form name="form1" method="post" action="Registerseverlet" id ="subm">
  <div>账户：
    <input type="text" name="username" id = "user" onblur="checkUser()">
    <span id = "ck"></span>
  </div>
  <p>密码：
    <input type="password" name="pass" id ="pass">
  </p>
  <p>确认密码：
    <input type="password" name="repass" id = "repass">
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
    <input type="button" name="button"  value="注册"  onclick="check()" >
    <input type="submit" name="button2" id="button2" value="重置">
  </p>
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