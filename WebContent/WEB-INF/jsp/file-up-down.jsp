<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String path = request.getContextPath();   
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()       
	+ path + "/"; %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.div1,.div2,.div3{
		margin: 3% 35%;
		background: #2DCC70;
		border-radius: 6px;
		border:2px solid #ffffff;
	}
	div input{
		background: #ffffff;
	}
</style>
</head>
<body>
	<div class="div1">
		<p>单文件上传</p>
		<form action="upload" method="post" enctype="multipart/form-data">
			<input type="file" name="file">
			<button type="submit">完成</button>
		</form>
	</div>
	<div class="div2">
		<p>多文件上传</p>
		<form action="batch/upload" method="post" enctype="multipart/form-data">
		    <p>文件1：<input type="file" name="file" /></p>
		    <p>文件2：<input type="file" name="file" /></p>
		    <p>文件3：<input type="file" name="file" /></p>
		    <p><input type="submit" value="上传" /></p>
		</form>
	</div>
	<c:if test="${requestScope.ident!='USER'}">
		<div class="div3">
			<p>文件下载</p>
			<form action="download" method="post">
				<c:forEach items="${requestScope.files}" var="file">
				  	<input type="checkbox" name="filename" value="${file}"/>${file}<br/>
				</c:forEach>
				<button type="submit">下载</button>
			</form>
		</div>
	</c:if>
	<!-- Javascript -->
    <script src="resources/assets/js/jquery-1.11.1.min.js"></script>
    <script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/assets/js/jquery.backstretch.min.js"></script>
    <script src="resources/assets/js/scripts.js"></script>
</body>
</html>