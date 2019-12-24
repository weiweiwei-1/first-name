<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎页面</title>
</head>
<body>
<h1>欢迎来到java-web的世界</h1>
<form action="${pageContext.request.contextPath }/ForAllList/ForUserAndItems" >
    <input type="submit" value="点击按钮进入主页面">
</form>
</body>
<html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎页面</title>
    <script type="text/javascript">
        function AjaxAll(){
            document.enter.action="${pageContext.request.contextPath }/AjaxAll/enter";
            document.enter.submit();
        }
        function AjaxPack(){
            document.enter.action="${pageContext.request.contextPath }/AjaxPack/enterpack";
            document.enter.submit();
        }
        function AjaxPackget(){
            document.enter.action="${pageContext.request.contextPath }/AjaxPackget/jsonenter";
            document.enter.submit();
        }
        function ajaxTra(){
            document.enter.action="${pageContext.request.contextPath }/ajaxTra/ajaxTenter";
            document.enter.submit();
        }
        function enterregit(){
            document.enter.action="${pageContext.request.contextPath }/ajaxTra/enterregit";
            document.enter.submit();
        }
        function enterLogin(){
            document.enter.action="${pageContext.request.contextPath }/ajaxTra/enterLogin";
            document.enter.submit();
        }
        function enterList(){
            document.enter.action="${pageContext.request.contextPath }/ajaxTra/enterList";
            document.enter.submit();
        }
        function listEnter(){
            document.enter.action="${pageContext.request.contextPath }/ajaxList/listEnter";
            document.enter.submit();
        }enterpage()
        function enterpage(){
            document.enter.action="${pageContext.request.contextPath }/ForAllList/ForUserAndItems";
            document.enter.submit();
        }
    </script>
</head>
<body>
<h1>欢迎</h1>
<form action="" method="post" name="enter">
    <table align="center" cellspacing="0px">
        <tr>
            <td align="left"><input type="button" value="ajax初始" onclick="AjaxAll()"></td>
            <td align="right"><input type="button" value="ajax包装" onclick="AjaxPack()"></td>
        </tr>
        <tr>
            <td align="left"><input type="button" value="ajax的json传输" onclick="AjaxPackget()"></td>
            <td align="right"><input type="button" value="传统ajax异步" onclick="ajaxTra()"></td>
        </tr>
        <tr>
            <td align="left"><input type="button" value="ajax包装注册" onclick="enterregit()"></td>
            <td align="right"><input type="button" value="ajax包装登录" onclick="enterLogin()"></td>
        </tr>
        <tr>
            <td align="left"><input type="button" value="ajax的list显示" onclick="enterList()"></td>
            <td align="right"><input type="button" value="ajax的list测试" onclick="listEnter()"></td>
        </tr>
        <tr>
            <td align="left"><input type="button" value="主页面" onclick="enterpage()"></td>
            <%--<td align="right"><input type="button" value="ajax的list测试" onclick="listEnter()"></td>--%>
        </tr>
    </table>
</form>
</body>
<html>
