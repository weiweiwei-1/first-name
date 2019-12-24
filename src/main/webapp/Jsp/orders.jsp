<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询用户列表</title>
</head>
<body>
<form name="back" action="/ForAllList/backtotable" method="post">
    <table width="100%" border=1 cellspacing="0px">
    <tr>
        <td>商品id</td>
        <td>用户id</td>
        <td>订单号</td>
        <td>创建时间</td>
        <td>说明</td>
    </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.userId}</td>
                <td>${order.number}</td>
                <td><fmt:formatDate value="${order.createtime}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                <td>${order.note}</td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="返回主页面">
</form>
</body>
</html>
