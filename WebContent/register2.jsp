<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/public.css">
<style type="text/css">
.z {
	color: #FF00FF;
}
table{ margin-left: auto;margin-right: auto;}
</style>
</head>
<body>
<form name="form1" method="post" action="Registerseverlet" id = "subm">
  <table width="656" border="1">
    <tr>
      <td colspan="4" bgcolor="#99CC00">新用户注册</td>
    </tr>
    <tr>
      <td width="110">用户名</td>
      <td colspan="3"><label for="user"></label>
      
      <input name="username" type="text" id="user" size="25"></td>
    </tr>
    <tr>
      <td bgcolor="#99FF33">密码</td>
      <td width="197"><label for="pass"></label>
      <input name="pass" type="password" id="pass" size="25"></td>
      <td width="103" bgcolor="#99FF33">确认密码</td>
      <td width="218"><label for="qpass"></label>
      <input name="repass" type="password" id="repass" size="25"></td>
    </tr>
    <tr>
      <td>性别</td>
      <td><label for="sex">
        <input type="radio" name="radio" id="sex" value="sex">
      </label>
      男 
      <input type="radio" name="radio" id="sex2" value="sex">
      女</td>
      <td bgcolor="#99FF33">职业</td>
      <td><label for="work"></label>
        <select name="work" id="work">
          <option value="学生">学生</option>
          <option value="老师">老师</option>
          <option value="家长">家长</option>
      </select></td>
    </tr>
    <tr>
      <td bgcolor="#99FF33">个人爱好</td>
      <td colspan="3"><p>
        <label>
          <input type="checkbox" name="hobby" value="电脑网络" id="hobby_0">
          电脑网络</label>
        <input type="checkbox" name="hobby_" value="棋牌娱乐" id="hobby_2">
        <label>棋牌娱乐</label>
        <input type="checkbox" name="hobby_2" value="影视娱乐" id="hobby_1">
        <label>影视娱乐</label>
        <br>
      </p></td>
    </tr>
    <tr>
      <td height="149" bgcolor="#99FF33">个人说明</td>
      <td colspan="3"><label for="grsm"></label>
      <textarea name="grsm" cols="60" rows="10" id="grsm"></textarea></td>
    </tr>
    <tr>
      <td colspan="4"><div align="center">
        <input type="button" name="提交"  value="注册" onclick="check()" >
        <input type="reset" name="重置" id="重置" value="重置">
      </div></td>
    </tr>
  </table>
</form>
<script type="text/javascript">
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