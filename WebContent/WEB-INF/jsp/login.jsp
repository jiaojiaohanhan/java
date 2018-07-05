<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String path = request.getContextPath();   
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%> 
<!DOCTYPE html>
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
                        			<h3>登录</h3>
                            		<p>请输入用户名和密码:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="login" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" name="userName" placeholder="用户名" class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="hidden" id="pwd" name="psw">
			                        	<input type="password" name="password" placeholder="密码" class="form-password form-control" id="form-password" onblur="mdjia()">
			                        </div>
			                        <button type="submit" class="btn">登陆</button>
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
		    var password=$("#form-password").val();
		    var pwd=$.md5(password);
		    $("#pwd").val(pwd);
		}

	</script>
</html>