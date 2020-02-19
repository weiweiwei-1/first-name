<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>好友列表</title>--%>
</head>
<body>
<c:forEach items="${friends}" var="friend">
    <li id="${friend.friendId}">
        <div class="friend-img">
            <img src="/web-store/${friend.friendPhoto}"></div>
        <div class="friend-name">${friend.friendMark}</div>
        <div class="friend-information">
            <div class="friend-school">${friend.friendSchool}</div>
            <div class="friend-company">${friend.friendCompany}</div>
        </div>
    </li>
</c:forEach>

</body>
</html>