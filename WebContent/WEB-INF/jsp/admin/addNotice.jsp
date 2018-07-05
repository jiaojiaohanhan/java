<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<!DOCTYPE html>
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
	.back{ 
		position: fixed;
		left: 5%;
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
	<form action="../admin/addN" method="post" class="form">
		<table>
			<tr>
				<th>标题:</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>内容:</th>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<th>类型:</th>
				<td><input type="text" name="kind" value="file/reply"></td>
			</tr>
			<tr>
				<th>开始时间:</th>
				<td><input type="text" name="start" value="<%
                       Date dNow = new Date( );
                       SimpleDateFormat ft = 
                       new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
                       out.print(ft.format(dNow));
                %>"></td>
			</tr>
			<tr>
				<th>结束时间:</th>
				<td><input type="text" name="end" value="<%
                       Date dNow2 = new Date( );
                       SimpleDateFormat ft2 = 
                       new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
                       out.print(ft.format(dNow));
                %>"></td>
			</tr>
			<tr>
				<th>状态:</th>
				<td><input type="text" name="state" value="OVERTIME_UNDO/OVERTIME_DO/UNFINISHED/FINISHED"></td>
			</tr>
		</table>
		<button type="submit">完成</button>
	</form>
	<br/>
	<a href="notice2" class="back">返回</a>
	<!-- Javascript -->
    <script src="../resources/assets/js/jquery-1.11.1.min.js"></script>
    <script src="../resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../resources/assets/js/jquery.backstretch.min.js"></script>
    <script src="../resources/assets/js/scripts2.js"></script>
</body>
</html>