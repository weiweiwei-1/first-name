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
    <script type="text/javascript">
        function search(){
            document.formPost.action="${pageContext.request.contextPath }/usernewList/searchforall";
            document.formPost.submit();
        }
        function reenter(){
            document.formPost.action="${pageContext.request.contextPath }/ForAllList/ForUserAndItems";
            document.formPost.submit();
        }
        function deleteSome(){
            document.formPost.action="${pageContext.request.contextPath }/usernewList/deleteSome";
            document.formPost.submit();
        }
        function edit(){
            document.formPost.action="${pageContext.request.contextPath }/usernewList/eidtAll";
            document.formPost.submit();
        }
        function Post(){
            document.formPost.action="${pageContext.request.contextPath }/usernewList/post";
            document.formPost.submit();
        }
    </script>
</head>
<body>
<%--/item--%>
<%--<form action="/usernewList/searchforall">--%>
<%--<tr>--%>
<%--<td>查询条件</td>--%>
<%--<td><input type="text" name="condition" value="${condition}"></td>--%>
<%--<td><input type="submit" value="查询"></td>--%>
<%--</tr>--%>
<%--</form>--%>
<%--<form action="/usernewList/userList">--%>
<%--<tr>--%>
<%--<input type="submit" value="重新进入主页面">--%>
<%--</tr>--%>
<%--</form>--%>
<form name="formPost" action="${pageContext.request.contextPath }/ForAllList/ForUserAndItems" method="post">
    <tr>
        <td>查询条件</td>
        <td><input type="text" name="condition" value="${condition}"></td>
        <td><input type="button" value="查询" onclick="search()"></td>
    </tr>
    <tr>
        <input type="button" value="重新进入主页面" onclick="reenter()">
    </tr>
    <tr>
        <input type="button" value="批量删除" onclick="deleteSome()">
    </tr>
    <tr>
        <input type="button" value="编辑" onclick="edit()">
    </tr>
    <tr>
        <input type="button" value="提交" onclick="Post()">
    </tr>
    <table width="100%" border=1 cellspacing="0px">
        <tr>
            <td ><a href="<%=appPath%>/usernewList/add"/>添加</td>
        </tr>
    </table>
    用户信息：
    <table width="100%" border=1 cellspacing="0px">
        <tr>
            <td>用户Id</td>
            <td>用户姓名</td>
            <td>用户生日</td>
            <td>用户性别</td>
            <td>用户地址</td>
        </tr>
        <c:forEach items="${userList}" var="item" varStatus="status">
            <tr>
                <td><input type="text" name="userList[${status.index}].id" value="${item.id}"></td>
                <td><input type="text" name="userList[${status.index}].username" value="${item.username}"></td>
                <td><input type="text" name="userList[${status.index}].birthday" value="<fmt:formatDate value="${item.birthday}" pattern="yyyy-MM-dd"/>"/></td>
                <td><input type="text" name="userList[${status.index}].sex" value="${item.sex}"></td>
                <td><input type="text" name="userList[${status.index}].address" value="${item.address}"></td>
                <td>
                    <a href="<%=appPath%>/usernewList/toUpdateUser?id=${item.id}">更改</a> |
                    <a href="<%=appPath%>/usernewList/deleteuser?id=${item.id}">删除</a> |
                        <%--<a href="<%=appPath%>/ordersList/"--%>
                </td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>

</html>