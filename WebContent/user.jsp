<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*,com.cn.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>

<style type="text/css">
td{ text-align:center; border:1px #F60 soid; outline:none; border-radius: 5px;}
table{margin-left: auto; margin-right: auto;}
#updateuser{
	background-color: white;
	width: 400px;
	height: 200px;
	margin: auto;
	position: absolute;
	z-index: 2;
	left: 71px;
	top: 53px;
	border: #000 thick solid;
	padding-top:20px;
	padding-left:50px;
}
#show{
background-color: white;
	width: 400px;
	height: 200px;
	margin: auto;
	position: absolute;
	z-index: 2;
	left: 71px;
	top: 53px;
	border: #000 thick solid;
	padding-top:20px;
	padding-left:50px;
	}
</style>

</head>
<body>
<%User u = (User)session.getAttribute("user"); 
List<User> list = (List<User>)session.getAttribute("userlist");
%>

<div>
	<table border="1">
	<tr>
		<td width="79">序号</td>
		<td width="103">用户名</td>
		<td width="83">性别</td>
		<td width="95">权限</td>
		<td width="92">操作</td>
	</tr>
	<%
	if(list !=null)
		for(int i = 0;i<list.size();i++){
			User user = list.get(i);
		%>
		<tr>
		<td width="103"><%=i+1%></td>
		<td width="103" id="<%=user.getUsername()%>"><%= user.getUsername()%></td>
		<td width="103"><%= user.getSex()%></td>
		<td width="103"><% if(user.getType().equals("1")) out.print("管理员"); else if(user.getType().equals("0")) out.print("普通用户"); else{out.print("已失效");}%></td>
		<td width="143" class="cloor">
		
		<a href="#" onclick="updateUser(this)">修改</a>
		<%if(user.getType().equals("-1")){ %>
		<a href="#" onclick="loseUser(this)">恢复</a>
		<%}else{ %>
		<a href="#" onclick="loseUser(this)">失效</a>
		<%} %>
		<a href="#" onclick="showUser(this)">查看详情</a></td>
	</tr>
		
		<%} %>
  </table>
  </div>
<div id = "show">
	用户详细信息
<hr>
<form action="">
<input type="hidden"  id = "id1" name = "id">
用户名：<input type="text"  id="username1" name = "username" /><br>
性别：<input type="radio" name="sex1" value="男">男
<input type="radio" name="sex1" value="女">女<br>
类型：<select id="type1" name = "type">
<option value="1">管理员</option>
<option value="0">普通用户</option>
</select><br>
<input type="button" onclick="close_div()" value="关闭">

</form>
</div>

<div id="updateuser">
修改用户信息
<hr>
<form action="Updateseverlet">
<input type="hidden"  id = "id" name = "id">
用户名：<input type="text"  id="username" name = "username" /><br>
性别：<input type="radio" name="sex" value="男">男
<input type="radio" name="sex" value="女">女<br>
类型：<select id="type" name = "type">
<option value="1">管理员</option>
<option value="0">普通用户</option>
</select><br>
<input type="submit" value="修改">
<input type="reset" value="重置">
<input type="button" onclick="close_div()" value="关闭">

</form>

</div>
<script type="text/javascript">
$("#updateuser").hide();//隐藏updateuser的div
$("#show").hide();
function updateUser(el){
	
	var node = el.parentNode.parentNode;//获取当前行
	var a=node.children[1].innerHTML;//获取用户名	
	$.post("UpdateQueryseverlet",{"user":a},function(data){
		
		$("#updateuser").show();//显示被影藏的div
		$("#username").val(data.username);//将id为username的文本框value属性赋值
		$("#id").val(data.id);
		//$("#password").val(data.password);
		//alert(data.sex);
		if(data.sex=='0'){
			
			$('input:radio[name=sex]:nth(1)').removeAttr('checked');
			$('input:radio[name=sex]:nth(0)').attr('checked',true);//将name为sex的单选按钮的第0个，添加checked属性并赋值为true（相当于被选中）
			
		}else{
			$('input:radio[name=sex]:nth(0)').removeAttr('checked');
			$('input:radio[name=sex]:nth(1)').attr('checked',true);
		}
		
	   if(data.type=="0"){//0是普通用户
		   $("#type").val("0");//将属性value属性值为0的选中
	   }else{
		   $("#type").val("1");
	   }
	});
}
function loseUser(t){
	var node = t.parentNode.parentNode;
	var name = node.children[1].innerHTML;
	var tp =  node.children[3].innerHTML;
	$.post("LoseUserSeverlet",{"name":name,"tp":tp},function(data){
		window.location.reload();
	});
}
function showUser(t){
	
	var node = t.parentNode.parentNode;
	var name = node.children[1].innerHTML;
	var id =  node.children[0].innerHTML;
	$.post("PersonalSeverlet",{"username":name,"id":id},function(data){
		$("#show").show();//显示被影藏的div
		$("#username1").val(data.username);//将id为username的文本框value属性赋值
		//$("#id1").val(data.id);
		//$("#password").val(data.password);
		//alert(data.sex);
		if(data.sex=='0'){
			
			$('input:radio[name=sex1]:nth(1)').removeAttr('checked');
			$('input:radio[name=sex1]:nth(0)').attr('checked',true);//将name为sex的单选按钮的第0个，添加checked属性并赋值为true（相当于被选中）
			
		}else{
			$('input:radio[name=sex1]:nth(0)').removeAttr('checked');
			$('input:radio[name=sex1]:nth(1)').attr('checked',true);
		}
		
	   if(data.type=="0"){//0是普通用户
		   $("#type1").val("0");//将属性value属性值为0的选中
	   }else{
		   $("#type1").val("1");
	   }
		
		
	});
}
function close_div(){
	$("#updateuser").hide();
	$("#show").hide();
}

</script>
</body>
</html>