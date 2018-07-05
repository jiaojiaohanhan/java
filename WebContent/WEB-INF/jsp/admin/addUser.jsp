<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.form{ 
		position: absolute;
		left: 25%;
		top:20%;
		width:50%;
		border: 2px solid #ffffff; 
		background: #2DCC70;
		border-radius: 5px;
	}
	.form table tr{
		height: 30px;
		line-height: 30px;
	}
	.form table th{ 
		width: 40%;
		color:#ff0000;
	}
	.form table td input{
		width: 300%;
	}
	.form button{
		position:absolute;
		left:40%;
		top:110%;
		border: 2px solid #ffffff; 
		background: #2DCC70;
		border-radius: 5px;
		width:20%;
		font-size:24px;
		height: 40px;
		line-height: 40px;
	}
</style>
</head>
<body>
	<form action="../admin/addUser" method="post" class="form">
		<table>
			<tr>
				<th>个人简介:</th>
				<td><input type="text" name="detail"></td>
			</tr>
			<tr>
				<th>身份:</th>
				<td><input type="text" name="identity"  value="(USER/ADMIN)"></td>
			</tr>
			<tr>
				<th>真实姓名:</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>密码:</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<th>电话:</th>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<th>职称:</th>
				<td><input type="text" name="title" value="(LECTURER/aPROFESSOR/PROFESSOR)"></td>
			</tr>
			<tr>
				<th>用户名:</th>
				<td><input type="text" name="username"></td>
			</tr>
		</table>
		<button type="submit">完成</button>
	</form>
	<!-- Javascript -->
    <script src="../resources/assets/js/jquery-1.11.1.min.js"></script>
    <script src="../resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../resources/assets/js/jquery.backstretch.min.js"></script>
    <script src="../resources/assets/js/scripts2.js"></script>
</body>
</html>