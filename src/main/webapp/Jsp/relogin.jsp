<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>成功提示</title>
    <script type="text/javascript">
        <%--function relogin(){--%>
            <%--document.relogin.action="${pageContext.request.contextPath}/ForAllList/forlogin";--%>
            <%--document.relogin.submit();--%>
        <%--}--%>
    </script>
</head>
<body>
<h1>由于您修改了用户名，Session失效，点击确定重新登录</h1>
<form name="relogin" action="${pageContext.request.contextPath}/ForAllList/forlogin" method="get">
    <table align="center" border="0.1" cellspacing="0px">
        <tr><td><input type="submit" value="确定"<%--onclick="relogin()"--%>></td></tr>
    </table>
</form>
</body>
</html>