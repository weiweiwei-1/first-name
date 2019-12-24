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
                    url:"/ajaxTra/ajaxList",
                    contentType:"application/x-www-form-urlencoded",
                    dataType:"json",
                    data:null,
                    success:function(data){
                        for(var i=0;i<data.length;i++){
                            $("#h").append(data[i].username);
                            $("#h").append(data[i].address);
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
    <tr align="center">
        <td><input type="button" id="submit" value="显示数据"></td>
    </tr>
</form>
<h id="h"></h>
</body>
</html>