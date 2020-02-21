<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>好友申请列表</title>
</head>
<body>
<c:forEach items="${addUserList}" var="user">
    <li data-addUserId="${user.addId}">
        <div class="addUser-img">
            <img src="/web-store/${user.userPhoto}">
        </div>
        <div class="addUser-name">${user.addName}</div>
        <div class="system-confirm">
            <div class="addUser-time"><fmt:formatDate value="${user.addTime}" pattern="yyyy-MM-dd"/></div>
            <div class="addconfirm">请求添加好友</div>
        </div>
    </li>
</c:forEach>
</body>
</html>