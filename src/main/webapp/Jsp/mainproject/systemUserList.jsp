<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>系统推荐内容</title>

</head>
<body>
<c:forEach items="${userList}" var="user">
    <div class="user-block" data-userId="${user.id}">
        <div class="user-img" >
            <img class="appear" src="/web-store/${user.photo}">
        </div>
        <div class="user-name">${user.username}</div>
        <div class="user-school">${user.school}</div>
        <div class="user-company">${user.company}</div>
    </div>
</c:forEach>
</body>
</html>