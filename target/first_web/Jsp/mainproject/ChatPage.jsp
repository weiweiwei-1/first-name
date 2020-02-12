<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>聊天页面</title>
    <link href="../../CSS/ChatBase.css" rel="stylesheet" type="text/css">
    <script src="../../jquery_jar/jquery-3.0.0.js" rel="script" type="text/javascript"></script>
</head>
<body>
<div id="chat-page">
    <div id="unreadmessage-list"></div>
    <div id="chat-content"></div>
    <div id="friend-list"></div>
    <div id="recommend-block"></div>
</div>
</body>
</html>
