<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>    
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
	<form action="../userUpdateE" method="post" class="form">
		<table>
			<tr>
				<th>考试ID:</th>
				<td><input type="text" name="id"  value="${id}"></td>
			</tr>
			<tr>
				<th>考试科目:</th>
				<td><input type="text" name="name"  value="${name}"></td>
			</tr>
			<tr>
				<th>考场:</th>
				<td><input type="text" name="address"  value="${address}"></td>
			</tr>
			<tr>
				<th>开始时间:</th>
				<td><input type="text" name="start"  value="${start}"></td>
			</tr>
			<tr>
				<th>结束时间:</th>
				<td><input type="text" name="end"  value="${end}"></td>
			</tr>
			<tr>
				<th>考试状态:</th>
				<td><input type="text" name="state"  value="${state}(UNALLOCATION/ALLOCATION/FINISHED)"></td>
			</tr>
			<tr>
				<th>学生人数:</th>
				<td><input type="text" name="student" value="${student}"></td>
			</tr>
			<tr>
				<th>老师ID:</th>
				<td>
				<c:forEach items="${users}" var="user">
	  				<input type="text" name="userId" value="${user.id}">
	  			</c:forEach>
	  			</td>
			</tr>
		</table>
		<button type="submit">完成</button>
	</form>
	<!-- Javascript -->
    <script src="../../resources/assets/js/jquery-1.11.1.min.js"></script>
    <script src="../../resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../../resources/assets/js/jquery.backstretch.min.js"></script>
    <script src="../../resources/assets/js/scripts3.js"></script>
</body>
</html>