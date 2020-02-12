<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>弹窗效果</title>
	<link rel="stylesheet" type="text/css" media="all" href="style.css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>

</head>

<body>

<div id="w">
	<div id="content">
		<h1>Welcome to the Site!</h1>
		<p>Just click the login link below to expand the modal window. This is only a demo so the input form will not load anything, but it is easy to connect into a backend system.</p>
		<center><a href="#loginmodal" class="flatbtn" id="modaltrigger">Modal Login</a></center>
	</div>
</div>

<div id="loginmodal" style="display:none;">
	<h1>User Login</h1>
	<form id="loginform" name="loginform" method="post" action="Flow.jsp">
		<label for="username">Username:</label>
		<input type="text" name="username" id="username" class="txtfield" tabindex="1" />
	
		<label for="password">Password:</label>
		<input type="password" name="password" id="password" class="txtfield" tabindex="2" />
	
		<div class="center"><input type="submit" name="loginbtn" id="loginbtn" class="flatbtn-blu hidemodal" value="Log In" tabindex="3"></div>
	</form>
</div>
 

<script type="text/javascript">
$(function(){

	$('#loginform').submit(function(e){
		return false;
	});
	
	//弹出层调用语句
	$('#modaltrigger').leanModal({
		top:110,
		overlay:0.45,
		closeButton:".hidemodal"
	});
	
});
</script>

</body>
</html>