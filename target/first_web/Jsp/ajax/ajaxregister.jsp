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
        var readdress=$("#readdress").val();
        $.ajax({
            async:true,
            cache:true,
            url:"/ajaxTra/ajaxRegit",
            contentType:"application/x-www-form-urlencoded",
            dataType:"json",
            data:{
                "username":username,
                "address":address,
                "readdress":readdress
            },
            success:function(data){
                switch(data.result){
                    case "0":$("#usernameerror").text("用户名不能为空");$("#addresserror").text("");$("#readdresserror").text("");break;
                    case "1":$("#usernameerror").text("用户名不能为空字符");$("#addresserror").text("");$("#readdresserror").text("");break;
                    case "2":$("#usernameerror").text("用户名太短");$("#addresserror").text("");$("#readdresserror").text("");break;
                    case "3":$("#usernameerror").text("用户名已经注册过");$("#addresserror").text("");$("#readdresserror").text("");break;
                    case "4":$("#usernameerror").text("");$("#addresserror").text("地址不能为空白");$("#readdresserror").text("");break;
                    case "5":$("#usernameerror").text("");$("#addresserror").text("地址太短");$("#readdresserror").text("");break;
                    case "6":$("#usernameerror").text("");$("#addresserror").text("");$("#readdresserror").text("地址确认错误");break;
                    case "7":$("#usernameerror").text("");$("#addresserror").text("");$("#readdresserror").text("");alert("注册成功，点击确认返回主页面");window.location.href="${pageContext.request.contextPath}/ForAllList/ForUserAndItems";break;
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
    <table align="center" cellspacing="0px">
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
        <tr>
            <td align="right">确认地址：</td>
            <td align="left"><input type="text" name="address" id="readdress" placeholder="请确认地址" onkeypress="EnterPress(event)" onkeydown="EnterPress()"><span id="readdresserror"></span><br/>
        </td>
        </tr>
        <tr align="center">
            <td>&nbsp;</td>
           <td><input type="button" id="submit" value="注册"></td>
        </tr>
    </table>
</form>
</body>
</html>