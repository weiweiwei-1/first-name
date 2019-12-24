<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>

</head>
<body> 

<form id="itemForm" action="${pageContext.request.contextPath }/usernewList/submitUser" method="post" >
<input type="hidden" name="id" value="${user.id }"/>
修改用户信息：
<table width="100%" border=1 cellspacing="0px">
    <%--<tr>--%>

        <%--<td>用户id</td>--%>
        <%--<td><input type="text" name="id" value="${user.id }"/></td>--%>
    <%--</tr>--%>
<tr>

	<td>用户姓名</td>
	<td><input type="text" name="username" value="${user.username }"/></td>
</tr>
<tr>
	<td>用户生日</td>
	<td><input type="text" name="birthday" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>"/></td>
</tr>
    <tr>

        <td>用户性别</td>
        <td><input type="text" name="sex" value="${user.sex }"/></td>
    </tr>
<tr>
	<td>用户地址</td>
	<td>
	<textarea rows="3" cols="30" name="address">${user.address }</textarea>
	</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>