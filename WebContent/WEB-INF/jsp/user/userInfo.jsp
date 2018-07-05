<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%> 
<%   String path = request.getContextPath();   
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()       
	+ path + "/"; %> 
<!DOCTYPE html> 
<html lang="zh-CN"> 
<head>
<base href="<%=basePath%>"> 
<meta charset="utf-8"> 
<title></title> 
<style type="text/css">
	.table{
		position: absolute;
		left: 25%;
		top:20%;
		width:50%;
		background: #2DCC70;
		border: 1px solid #ffffff; 
		border-radius: 5px;
	}
	.table th{
		width: 30%;
		color: #ff0000;
	}
	.change{ 
		position: absolute;
		left: 45%;
		top:50%;
		display: block;
		width: 100px;
		height: 30px;
		line-height: 30px;
		background:#2DCC70;
		border-radius: 5px;
		text-decoration: none;
		color: #000000;
		border: 2px solid #ffffff; 
	}
	.back{ 
		position: fixed;
		left: 12%;
		display: block;
		width: 100px;
		height: 30px;
		line-height: 30px;
		text-align:center;
		background:#2DCC70;
		border-radius: 5px;
		text-decoration: none;
		color: #000000;
		border: 2px solid #ffffff; 
	}
</style>
</head>
<body>
	<table border="1" class="table">
		<tr>
			<th>个人简介</th>
			<td>${detail}</td>
		</tr>
		<tr>
			<th>身份</th>
			<td>${identity}</td>
		</tr>
		<tr>
			<th>真实姓名</th>
			<td>${name}</td>
		</tr>
		<tr>
			<th>密码</th>
			<td>${password}</td>
		</tr>
		<tr>
			<th>电话</th>
			<td>${phone}</td>
		</tr>
		<tr>
			<th>职称</th>
			<td>${title}</td>
		</tr>
		<tr>
			<th>用户名</th>
			<td>${username}</td>
		</tr>
	</table>
	<a href="user/change" class="change">修改个人资料</a><br/>
	<a href="indexUSER" class="back">返回</a>
	<!-- Javascript -->
    <script src="resources/assets/js/jquery-1.11.1.min.js"></script>
    <script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/assets/js/jquery.backstretch.min.js"></script>
    <script src="resources/assets/js/scripts.js"></script>
</body>
</html>