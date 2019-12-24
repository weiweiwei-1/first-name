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
/*对于contenType，指定的是从前端传到服务器的数据类型，如果是String类型，那么必须要为application/x-www-form-urlencoded，
它将数据以String类型传到后台，也就是json字符串，后台必须要有String接收，并且注解@ResquestBody，
如果是json对象或者赋值的语句，那么contentType必须为application/json，后台直接对象接收或者参数传递，但是不能用map接收，
不用注解@ResquestBody。contentType默认是application/x-www-form-urlencoded。必须为application开头，否则会出错
对于datatype，他是服务器返回的数据类型，一般都是指定为json，后台返回对象用@ResponseBody注解，否则会出错，后台用了注解，
也是可以不用指定dataType，直接将后台的对象转为json对象，引用key得到key值对应的value。*/

       $(function(){
          $("#submit").click(function(){
          /*1 $.ajax({
              async:true,
              cache:true,
              type:"POST",
              url:"/AjaxPackget/jsonObj",
              contentType:"application/json",/!*传到服务器的数据类型可以为json字符串*!/
              dataType:"json",/!*从服务器返回的数据类型是json类型，也就是success函数的data，将返回的类或者对象等转换为json对象*!/
              data: JSON.stringify({"username":$("#username").val(),"address":$("#address").val()}),
              success:function (data) {
                 alert("success");
                  $("#h1").text("username:"+data.username+"  "+"address："+data.address);
              },
              error:function(){
                  alert("failure");
              }
           });*/
              /*2 $.ajax({
                  async:true,
                  cache:true,
                  type:"POST",
                  url:"/AjaxPackget/jsonObj",
                  contentType:"application/json",
                  dataType:"json",
                  data: JSON.stringify({"username":$("#username").val(),"address":$("#address").val()}),
                  success:function (data) {
                      alert("success");
                      $("#h1").text(data);
                  },
                  error:function(){
                      alert("failure");
                  }
              });*/
              /*3 $.ajax({
                  async:true,
                  cache:true,
                  type:"POST",
                  url:"/AjaxPackget/jsonObj",
                  contentType:"application/json",
                  dataType:"json",//不能用text/html，否则出现错误404
                  data: JSON.stringify({"username":$("#username").val(),"address":$("#address").val()}),
                  success:function (data) {
                      alert("success");
                      $("#h1").text("username:"+data.username+"  "+"address："+data.address);
                  },
                  error:function(){
                      alert("failure");
                  }
              });
*/
             /*4  $.ajax({
                  async:true,
                  cache:true,
                  type:"POST",
                  url:"/AjaxPackget/jsonObj",
                  contentType:"application/x-www-form-urlencoded",
                  dataType:"json",//不能用text/html，否则出现错误404
                  data: {"username":$("#username").val(),"address":$("#address").val()},
                  success:function (data) {
                      alert("success");
                      $("#h1").text("username:"+data.username+"  "+"address："+data.address);
                  },
                  error:function(){
                      alert("failure");
                  }
              });*/
              /* 5$.ajax({
                  async:true,
                  cache:true,
                  type:"POST",
                  url:"/AjaxPackget/jsonObj",
                  contentType:"application/x-www-form-urlencoded",
                  dataType:"json",//不能用text/html，否则出现错误404
                  data: {"username":$("#username").val(),"address":$("#address").val()},
                  success:function (data) {
                      alert("success");
                      $("#h1").text("username:"+data.username+"  "+"address："+data.address);
                  },
                  error:function(){
                      alert("failure");
                  }
              });*/

              $.ajax({
                  async:true,
                  cache:true,
                  type:"POST",
                  url:"/AjaxPackget/jsonObj",
                  contentType:"application/x-www-form-urlencoded",
                  dataType:"json",//不能用text/html，否则出现错误404
                  data:"username="+$("#username").val()+"&address="+$("#address").val(),
                  success:function (data) {
                      alert("success");
                      $("#h1").text("username:"+data.username+"  "+"address："+data.address);
                  },
                  error:function(){
                      alert("failure");
                  }
              });
          });
       });
    </script>
</head>

<body>
<form action="" method="post">
<input type="text" name="username" id="username">
<input type="text" name="address" id="address">
<input type="button" value="提交" id="submit">
</form>
<h1 id="h1"></h1>
</body>
</html>