<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册页面</title>
    <script type="text/javascript">
       function register(){
            document.register1.action="${pageContext.request.contextPath }/ForAllList/register";
            document.register1.submit();
        }
    </script>
</head>
<body>
<form name="register1" action="${pageContext.request.contextPath }/ForAllList/register" method="post">
    <table align="center" border="0.2" cellspacing="0px">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" value="${user.username}"></td>
            <td>${nullinfo}</td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address" value="${user.address}"></td>
            <td>${nullinfo}</td>
        </tr>
    </table>
    <tr><td><input type="submit" value="注册"<%-- onclick="register()"--%>></td></tr>
</form>
</body>
</html>