<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String path = request.getContextPath();   
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()       
	+ path + "/"; %> 
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.not-list{
		position:absolute;
		left:25%;
		width:50%;
		border-radius: 5px;
		border:1px solid #ffffff;
	}
	.not-list li{
		margin-bottom:1px;
		height: 100%;
		background: #2DCC70;
		color: #ffffff;
		font-size: 20px;
		line-height:40px;
		font-family: "FangSong";
		border-radius: 5px;
	}
	.not-list li:hover div{
		display: block;
    	animation: show 0.2s ease-in forwards;
	}
	.not-list li div{
		width: 100%;
	    height: 0px;
	    background: #ffffff;
	    color:#000000;
	    overflow: hidden;
	    z-index: 2;
	    border-bottom-left-radius: 5px;
	    border-bottom-right-radius: 5px;
	}
	.title{ 
		position:relative;
		left:45%;
		width:10%;
		margin-top:5%;
		color: #ffffff;
	}
	a{
		text-decoration: none;
		color: #ffffff;
		display: block;
		width: 100%;
		height: 100%;
	}
	.change{ 
		position: fixed;
		left: 5%;
		top:2%;
		display: block;
		width: 120px;
		height: 30px;
		line-height: 30px;
		text-align:center;
		background:#2DCC70;
		border-radius: 5px;
		text-decoration: none;
		color: #000000;
		border: 2px solid #ffffff; 
	}
	.back{ 
		position: fixed;
		left: 15%;
		top:2%;
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
	@keyframes show {
    100%{
        height: 100%;
    }
</style>
</head>
<body>
	<h1 class="title">通知公告</h1>
	<ol class="not-list">
		<c:forEach items="${requestScope.tasks}" var="task">
			<c:if test="${task.kind=='reply'}">
			<li>
				<a href="notice3/${task.id}">${task.kind}${task.name}</a>
				<div>
					&nbsp;&nbsp;${task.content}
				</div>
			</li>
			</c:if>
			<c:if test="${task.kind=='file'}">
			<li>
				<a href="../file-up-down">${task.kind}${task.name}</a>
				<div>
					&nbsp;&nbsp;${task.content}
				</div>
			</li>
			</c:if>
		</c:forEach>
	</ol>
	<a href="notice2" class="change">添加或删除通知</a>
	<a href="indexADMIN" class="back">返回</a>
	<!-- Javascript -->
    <script src="../resources/assets/js/jquery-1.11.1.min.js"></script>
    <script src="../resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../resources/assets/js/jquery.backstretch.min.js"></script>
    <script src="../resources/assets/js/scripts2.js"></script>
</body>
</html>