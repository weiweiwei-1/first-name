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
    </head>
<script type="text/javascript" src="../../jquery_jar/jquery-3.0.0.js"></script>
<script type="text/javascript">
    $(function () {
    $("#submit").click(function () {
            $.ajax({
                async:true,
                cache:true,
                type:"GET",//这是请求方式，由于是url发送，因此用get
                url:"/AjaxPack/urlget?name="+$("#name").val()+"&password="+$("#password").val(),
                success:function(data){
                    /*// 方法：将json字符串转化为json对象
                    alert("success");
                    var data1=JSON.parse(data);
                    var name=data1.name1;
                    var password=data1.password1;
                    $("#h1").text(name+"   "+password);
                    // 成功*/
                    /*alert("success");
                    var name1=data.name1;
                    var password1=data.password1;
                    $("#h1").text(name1+"   "+password1);
                    // map对象转换成功*/
                    alert("success");
                    $("#h1").text(data.username+"   "+data.address);
                },
                error:function(){
                    alert("失败");
                }
            });
        });
    });
</script>
<body>

    <input type="text" name="name" id="name">
    <input type="text" name="password" id="password">
    <input type="button" value="提交" id="submit">
    <h1 id="h1"></h1>
</body>
</html>