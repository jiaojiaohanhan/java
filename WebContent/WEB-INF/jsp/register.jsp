<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%  String path = request.getContextPath();   
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="utf-8">
    <base href="<%=basePath%>"> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>软件工程工作管理系统</title>
    
	<script type="text/javascript" src="resources/assets/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="resources/assets/js/jquery.md5.js"></script>

	<!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="resources/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/assets/css/form-elements.css">
        <link rel="stylesheet" href="resources/assets/css/style.css">
        <link rel="shortcut icon" href="resources/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="resources/assets/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
	<!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>注册</h3>
                            		<p>请输入用户名和密码:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="register" method="post" id="myForm" class="login-form">
							        <table>
							            <tr>
							                <td>用户名：</td>
							                <td>
							                <input type="text" id="userName" name="user_name" >
							                <input type="hidden" id="pwd" name="user_psw">
							                </td>
							            </tr>
							            <tr>
							                <td>密码：</td>
							                <td><input type="text" id="password" name="password" onblur="mdjia()"></td>
							            </tr>
							            <tr>
							                <td><input type="submit"  value="添加用户"></td>
							            </tr>
							        </table>
							    </form>
		                    </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    <!-- Javascript -->
    <script src="resources/assets/js/jquery-1.11.1.min.js"></script>
    <script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/assets/js/jquery.backstretch.min.js"></script>
    <script src="resources/assets/js/scripts.js"></script>
    <script src="resources/assets/js/jquery.md5.js"></script>
</body>
<script type="text/javascript">

function mdjia(){
    var password=$("#password").val();
    var pwd=$.md5(password);
    $("#pwd").val(pwd);
}

</script>
</html>