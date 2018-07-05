<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String path = request.getContextPath();   
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()       
	+ path + "/"; %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.table{
		position: absolute;
		left: 20%;
		top:20%;
		width: 60%;
		border: 1px solid #ffffff; 
		border-radius:6px;
		background: #2DCC70;
	}
	.table th{
		color:#ff0000;
	}
	.table td{
		text-align: center;
	}
	.title{ 
		color: #ffffff;
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
	<table class="table" border="1">
	<caption><h1 class="title">考试信息</h1></caption>
	  <tr>
	    <th>考场</th>
	    <th>科目</th>
	    <th>开始时间</th>
	    <th>结束时间</th>
	    <th>考试状态</th>
	    <th>学生人数</th>
	  </tr>
	  <c:forEach items="${requestScope.exams}" var="exam">
	  	<tr>
	  		<td>${exam.address}</td>
	  		<td>${exam.examName}</td>
	  		<td>${exam.startTime}</td>
	  		<td>${exam.endTime}</td>
	  		<td>${exam.state}</td>
	  		<td>${exam.studentNumber}</td>
	  	</tr> 
	  </c:forEach>
	</table>
	<a href="../indexUSER" class="back">返回</a>
	<!-- Javascript -->
    <script src="../resources/assets/js/jquery-1.11.1.min.js"></script>
    <script src="../resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../resources/assets/js/jquery.backstretch.min.js"></script>
    <script src="../resources/assets/js/scripts2.js"></script>
</body>
</html>