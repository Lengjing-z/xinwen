<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/public.css">
<style type="text/css">
h4{ font-size:30px; margin-bottom:20px;}/*标题*/
.inputs{ border:1px #F60 soid; outline:none; width:200px; height:30px; padding-left:10px; padding-right:10px; border-radius:5px; transition:all 0.2s;}/*输入框属性*/
.inputs:focus{ border-color:#F00;}/*聚焦时属性*/
p{ margin-bottom:20px;}/*p标签间距*/
input{ outline:none;}
.red{ border:1px #0000FF solid;}
.content{ margin-top:50px; margin-left:50px;}/*界面位置*/
.dl{ background:#F30; width:100px; height:30px; margin-left:55px; color:#FFF; border:none;}/*登录按钮属性*/
</style>
</head>
<body>
<form name="form1" method="post" action="LoginServlet">
  <div class="content">
    <h4>登录:</h4>
    <p>
        用户名： <input class="inputs" id="yhm" name="username" type="text">
        <span id="yhm.ts">由数字，字母，下划线，4—16位组成</span>
    </p>
    <p>
        密&nbsp;&nbsp;&nbsp;码： <input id="pwd" class="inputs" name="passwd" type="password">
        <span id="pwd_ts">密码长度为由8—16位字符组成</span>
    </p>
    <p>
        <input class="dl"type="submit" value="登陆">
    </p>
</div>
</form>

</body>
</html>