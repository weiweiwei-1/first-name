<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>增加用户</title>
</head>
<body>
<form action="/usernewList/addUser" method="post">
    <table>
        <tr>
            <td>用户id</td>
            <td><input type="text" name="id" value="${user.id}"></td>
            <td>${id_error}</td>
        </tr>
        <tr>
            <td>用户姓名</td>
            <td><input type="text" name="username" value="${user.username}"></td>
            <td>${username_error}</td>
        </tr>
        <tr>
            <td>用户性别</td>
            <td><input type="text" name="sex" value="${user.sex}"></td>
        </tr>
        <tr>
            <td>用户生日</td>
            <td><input type="text" name="birthday" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>"/></td>
            <td>${birthday_error}</td>
        </tr>
        <tr>
            <td>用户地址</td>
            <td><input type="text" name="address" value="${user.address}"></td>
            <td>${address_error}</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="添加">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
