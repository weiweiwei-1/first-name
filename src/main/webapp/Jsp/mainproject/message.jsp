<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>聊天内容</title>

</head>
<body>

<c:forEach items="${messages}" var="message">
    <div class="clearfloat">
        <c:choose>
        <c:when test="${message.senderId==userId}">
            <div class="right" data-messageId="${message.id}">
                <div class="message-time">
                    <div class="chat-message">
                        ${message.content}
                    </div>
                    <div class="left-time">
                            <c:choose>
                            <c:when test="${message.status=='0'}">
                                <span class="read">未读</span>
                            </c:when>
                            <c:otherwise>
                                <span class="read">已读</span>
                            </c:otherwise>
                            </c:choose>
                        <%--<fmt:formatDate value="${message.sendTime}" pattern="yyyy-MM-dd HH:mm:ss"/>--%>
                        ${message.sendTime}
                    </div>
                </div>
                <div class="chat-avatars">
                    <img src="/web-store/${userPhoto}">
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="left" id="${message.senderId}">
                <div class="chat-avatars">
                    <img src="/web-store/${friendPhoto}">
                </div>
                <div class="message-time">
                    <div class="chat-message">${message.content}</div>
                    <div class="left-time"><%--<fmt:formatDate value="${message.sendTime}" pattern="yyyy-MM-dd HH:mm:ss"/>--%>${message.sendTime}</div>
                </div>
            </div>
        </c:otherwise>
        </c:choose>
    </div>
</c:forEach>
</body>
</html>