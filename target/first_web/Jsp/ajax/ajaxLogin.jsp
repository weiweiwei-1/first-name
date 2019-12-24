<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'ajax1.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="../../jquery_jar/jquery-3.0.0.js"></script>
    <script type="text/javascript">
        function createXMLHttpRequest() {
            try {
                return new XMLHttpRequest();//大多数浏览器
            } catch (e) {
                try {
                    return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
                } catch (e) {
                    try {
                        return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本
                    } catch (e) {
                        alert("浏览器不兼容");
                        throw e;
                    }
                }
            }
        }
        $(function(){
            $("#submit").click(function(){
                var username=$("#username").val();
                var address=$("#address").val();
                $.ajax({
                    async:true,
                    cache:true,
                    url:"/ajaxTra/login3",
                    contentType:"application/x-www-form-urlencoded",
                    dataType:"json",
                    data:{
                        "username":username,
                        "address":address,
                    },
                    success:function(data){
                        switch(data.result){
                            case "0":$("#usernameerror").text("用户名不能为空");$("#addresserror").text("");$("#readdresserror").text("");break;
                            case "1":$("#usernameerror").text("用户不存在");$("#addresserror").text("");$("#readdresserror").text("");break;
                            case "2":$("#usernameerror").text("");$("#addresserror").text("地址错误");$("#readdresserror").text("");break;
                            case "3":alert("登录成功");window.location.href="${pageContext.request.contextPath}/ForAllList/ForUserAndItems";break;
                        }
                    },
                    error:function(data){
                        alert("数据注入失败");
                    }
                });
            });
        });
        function EnterPress(e){
            var e=e||window.event;
            if(e.keyCode==13){
                $("#submit").click();
            }
        }
    </script>
</head>
<body<%-- onkeydown="keyOnClick(event);"--%>>
<form action="" method="post">
    <table align="center" cellspacing="0px" width="300" heigth="200">
        <tr>
            <td align="center" colspan="2">
                您好，欢迎登陆网站
            </td>
        </tr>
        <tr>
            <td align="right">姓名：</td>
            <td align="left"><input type="text" name="username" id="username" placeholder="请输入用户名"  onkeypress="EnterPress(event)" onkeydown="EnterPress()" <%--onkeyup="cityNameTrim()"--%>><span id="usernameerror"></span><br/>
            </td>
        </tr>
        <tr>
            <td align="right">地址：</td>
            <td align="left"><input type="text" name="address" id="address" placeholder="请输入地址" onkeypress="EnterPress(event)" onkeydown="EnterPress()"><span id="addresserror"></span><br/>
            </td>
        </tr>
        <tr align="center">
            <%--<td>&nbsp;</td>--%>
            <td colspan="2"><input type="button" id="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>