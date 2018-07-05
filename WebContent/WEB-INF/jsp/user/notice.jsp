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
	.change{ 
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
	.back{ 
		position: fixed;
		left: 13%;
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
	@keyframes show {
    100%{
        height: 100%;
    }
</style>
</head>
<body>
	<ol class="not-list">
		<c:forEach items="${requestScope.tasks}" var="task">
			<li>
				${task.kind}${task.name}
				<div>
					&nbsp;&nbsp;${task.content}
				</div>
			</li>
		</c:forEach>
	</ol>
	<a href="make" class="change">去完成任务</a>
	<a href="../indexUSER" class="back">返回</a>
	<!-- Javascript -->
    <script src="../resources/assets/js/jquery-1.11.1.min.js"></script>
    <script src="../resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../resources/assets/js/jquery.backstretch.min.js"></script>
    <script src="../resources/assets/js/scripts2.js"></script>
</body>
</html>