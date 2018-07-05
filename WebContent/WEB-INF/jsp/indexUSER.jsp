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
	.admin{
		position:absolute;
		left:35%;
		top:50px;
		display:block;
		color:#ffffff;
		text-decoration: none;
		border-radius: 6px;
		border:2px solid #ffffff;
		background:#2DCC70;
		height: 50px;
		width: 30%;
		text-align: center;
		line-height: 50px;
		font-size: 25px;
		font-family: "FangSong";
	}
	.butt-list{
		position:absolute;
		left:12.5%;
		top:120px;
		list-style: none;
		overflow: hidden;
	}
	.butt-list li{
		float: left;
		margin-right: 50px;
		width: 279px;
	    height: 330px;
	    text-align: center;
	    line-height:330px;
	    background: #2DCC70;
	    border-radius: 6px;
	    border:2px solid #ffffff;
	    font-size: 30px;
		font-family: "FangSong";
	}
	.butt-list li a{
		text-decoration: none;
		color:#ffffff;
		display: block;
		width: 100%;
		height: 100%;
	}
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
	@font-face {
		font-family: 'iconfont';  /* project id 441255 */
		src: url('//at.alicdn.com/t/font_441255_87073j7l275.eot');
		src: url('//at.alicdn.com/t/font_441255_87073j7l275.eot?#iefix') format('embedded-opentype'),
		url('//at.alicdn.com/t/font_441255_87073j7l275.woff') format('woff'),
		url('//at.alicdn.com/t/font_441255_87073j7l275.ttf') format('truetype'),
		url('//at.alicdn.com/t/font_441255_87073j7l275.svg#iconfont') format('svg');
	}
	.iconfont{
	    font-family:"iconfont" !important;
	    font-size:30px;font-style:normal;
	    -webkit-font-smoothing: antialiased;
	    -webkit-text-stroke-width: 0.2px;
	    -moz-osx-font-smoothing: grayscale;
    }
</style>
</head> 
<body>   
	<a class="admin" href="admin/indexADMIN"><i class="iconfont">&#xe6fb;</i>前往管理员主页</a> <br /> 
	<ul class="butt-list">
		<li><a href="user/exam"><i class="iconfont">&#xe60d;</i>我的监考信息</a></li>
		<li><a href="user/notice"><i class="iconfont">&#xe680;</i>通知公告</a></li>
		<li><a href="user/userInfo"><i class="iconfont">&#xe669;</i>我的个人资料</a></li>
	</ul>
	<!-- <a href="file-up-down" class="change">文件上传</a> -->
	<!-- Javascript -->
    <script src="resources/assets/js/jquery-1.11.1.min.js"></script>
    <script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/assets/js/jquery.backstretch.min.js"></script>
    <script src="resources/assets/js/scripts.js"></script>
</body> 
</html>