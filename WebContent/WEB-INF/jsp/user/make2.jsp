<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.reply{
		position:absolute;
		left:30%;
		top:100px;
		display:block;
		color:#ffffff;
		text-decoration: none;
		border-radius: 6px;
		border:2px solid #ffffff;
		background:#2DCC70;
		height: 50px;
		width: 40%;
		text-align: center;
		line-height: 50px;
		font-size: 25px;
		font-family: "FangSong";
	}
	.reply input{
		margin:0 auto;
		text-align:left;
		width: 70%;	
		height: 50%;
	}
	.reply2{
		position:absolute;
		left:30%;
		top:200px;
		display:block;
		color:#ffffff;
		text-decoration: none;
		border-radius: 6px;
		border:2px solid #ffffff;
		background:#2DCC70;
		height: 50px;
		width: 40%;
		text-align: center;
		line-height: 50px;
		font-size: 25px;
		font-family: "FangSong";
	}
	.reply2 a{
		display:block;
		width: 100%;
		height: 100%;
		text-decoration: none;
		color: #ffffff;
	}
</style>
</head>
<body>
	<div class="reply">
		<form action="../make3" method="post">
			回复：<input type="text" name="reply">
			<input type="hidden" name="id" value="${id}">
			<button type="submit">完成</button>
		</form>
	</div>
	<div class="reply2">
		<a href="../../file-up-down">文件上传</a>
	</div>
	<!-- Javascript -->
    <script src="../../resources/assets/js/jquery-1.11.1.min.js"></script>
    <script src="../../resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../../resources/assets/js/jquery.backstretch.min.js"></script>
    <script src="../../resources/assets/js/scripts3.js"></script>
</body>
</html>