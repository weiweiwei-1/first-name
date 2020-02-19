<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <c:forEach items="${chatMessageList}" var="chatList">
        <li id="${chatList.friendId}">
            <div class="liLeft">
                <img src="/web-store/${chatList.friendPhoto}">
            </div>
            <div class="liRight">
                <span class="friendName">${chatList.friendMark}</span>
                <span class="lastUnReadMessage">${chatList.content}</span>
            </div>
            <div class="unreadMessage">
                <div class="unreadMessage-count">${chatList.unReadMessageCount}</div>
                <div class="unreadMessage-time"><fmt:formatDate value="${chatList.sendTime}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
            </div>
        </li>
    </c:forEach>
</div>
</body>
</html>