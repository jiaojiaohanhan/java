<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html lang="zh-CN"> 
<head>
<meta charset="utf-8"> 
<title></title> 
<style type="text/css">
	.butt-list{
		position:absolute;
		left:6%;
		top:100px;
		list-style: none;
		overflow: hidden;
	}
	.butt-list li{
		float: left;
		margin-right: 10px;
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
	@font-face {
	  	font-family: 'iconfont';  /* project id 441255 */
	  	src: url('//at.alicdn.com/t/font_441255_rn2bq5duev.eot');
	  	src: url('//at.alicdn.com/t/font_441255_rn2bq5duev.eot?#iefix') format('embedded-opentype'),
	  	url('//at.alicdn.com/t/font_441255_rn2bq5duev.woff') format('woff'),
	  	url('//at.alicdn.com/t/font_441255_rn2bq5duev.ttf') format('truetype'),
	  	url('//at.alicdn.com/t/font_441255_rn2bq5duev.svg#iconfont') format('svg');
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
	<ul class="butt-list">
		<li><a href="teachers"><i class="iconfont">&#xe60a;</i>教师信息</a></li>
		<li><a href="exam"><i class="iconfont">&#xe60d;</i>监考信息</a></li>
		<li><a href="notice"><i class="iconfont">&#xe680;</i>通知公告</a></li>
		<li><a href="data"><i class="iconfont">&#xe669;</i>我的个人资料</a></li>
	</ul>
	<!-- Javascript -->
    <script src="../resources/assets/js/jquery-1.11.1.min.js"></script>
    <script src="../resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../resources/assets/js/jquery.backstretch.min.js"></script>
    <script src="../resources/assets/js/scripts2.js"></script>
</body> 
</html>