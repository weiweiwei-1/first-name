<%--<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<html>--%>
<%--<head>--%>
<%--&lt;%&ndash;<meta http-equiv="Content-Type" context="text/html;charset=UTF-8">&ndash;%&gt;--%>
<%--<title>first try</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--&lt;%&ndash;web-source/&ndash;%&gt;--%>
<%--<a href="Html/hide.html">跳转第一个页面</a>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询用户列表</title>
</head>
<body>
<%--/item--%>
<form action="${pageContext.request.contextPath }/usero/itemlist" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td><input type="submit" value="查询"/></td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemList}" var="item">
            <tr>
                <td>${item.id }</td>
                <td>${item.username }</td>
                <td><fmt:formatDate value="${item.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${item.sex }</td>
                <td>${item.address}</td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>

</html>