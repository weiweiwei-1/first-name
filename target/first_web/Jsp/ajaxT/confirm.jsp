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
window.onload=function(){
         $("#username").blur(function () {
              // 注意，如果是单引号将空白字符算进去，如果是双引号，空白字符也为空，因此用单引号
              if($("#username").val()==''){
                  $("#errorSpan").text("用户名不能为空");}
              else {
                  var xmlHttp = createXMLHttpRequest();
                  xmlHttp.open("POST", "<c:url value="/ajaxTra/dopost"/>", true);
                  xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                  xmlHttp.send("username=" + $("#username").val());
                  xmlHttp.onreadystatechange = function () {
                      if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                          var text = xmlHttp.responseText;
                          switch (text) {
                              case "0":
                                  $("#errorSpan").text("用户名不能为空");
                                  $("#submit").attr("disabled", true);
                                  break;
                              case "1":
                                  $("#errorSpan").text("用户不存在");
                                  $("#submit").attr("disabled", true);
                                  break;
                              case "2":
                                  $("#errorSpan").text("");
                                  $("#submit").attr("disabled", false);
                          }
                      }
                  }
                  };
              });
    $("#submit").click(function () {
        var xmlHttp1 = createXMLHttpRequest();
        var username=$("#username").val();
        var address=$("#address").val();
        xmlHttp1.open("POST","<c:url value="/ajaxTra/login"/>",true);
        xmlHttp1.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xmlHttp1.send("username="+username+"&address="+address);
        xmlHttp1.onreadystatechange=function(){
            if(xmlHttp1.readyState==4&&xmlHttp1.status==200){
                var text=xmlHttp1.responseText;
                switch (text){
                    case "0":$("#errorSpan").text("用户名不能为空");break;
                    case "1":$("#addresserror").text("地址不能为空");break;
                    case "2":$("#addresserror").text("");alert("登录成功");window.location.href="${pageContext.request.contextPath}/ForAllList/ForUserAndItems";break;
                    case "3":$("#addresserror").text("地址错误");break;
                }
            }
        };
    });

    $("#username").keyup(function(){
       /* var username = $("#username").val();
        $("#username").val(username);
        if($("#username").val().length<4){
            $("#errorSpan").text("用户名太短");
        }
        else{*/
            /*var xmlHttp = createXMLHttpRequest();
            xmlHttp.open("POST", "c:url value="/ajaxTra/dopost"/>", true);
            xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xmlHttp.send("username=" + $("#username").val());
            xmlHttp.onreadystatechange = function () {
                if(xmlHttp.readyState==4&&xmlHttp.status==200){
                    var text=xmlHttp.responseText;
                    switch (text){
                        case "0":
                            $("#errorSpan").text("用户名不能为空");
                            $("#submit").attr("disabled", true);
                            break;
                        case "1":
                            $("#errorSpan").text("用户不存在");
                            $("#submit").attr("disabled", true);
                            break;
                        case "2":
                            $("#errorSpan").text("");
                            $("#submit").attr("disabled", false);
                    }
                }
            }*/
        var username=$("#username").val();
        $("#username").val(username);
        $.ajax({
            async:true,
            cache:true,
            url:"/ajaxTra/login2",
            contentType:"application/x-www-form-urlencoded",
            dataType:"json",
            data:{"username":$("#username").val()},
            success:function(data){
                switch (data.result){
                    case "0":$("#errorSpan").text("用户名不能为空");break;
                    case "1":$("#errorSpan").text("用户名太短");break;
                    case "2":$("#errorSpan").text("用户不存在");break;
                    case "3":$("#errorSpan").text("");break;
                }
            },
            error:function(data){
alert("数据传递不成功");
            }
        });
    });

};
       /* // 按钮函数应该放在ajax函数外面才能有效
        function keyOnClick(e){
            var theEvent = window.event || e;
            var code = theEvent.keyCode || theEvent.which;
            if (code==13) {  //回车键的键值为13
                $("#submit").click();
            }
        }*/
        function EnterPress(e){ //传入 event
            var e = e || window.event;
            if(e.keyCode == 13){
                $("#submit").click();
            }
        }
    </script>
</head>
  <body<%-- onkeydown="keyOnClick(event);"--%>>
  <form action="" method="post">
      姓名：<input type="text" name="username" id="username" placeholder="请输入用户名"  onkeypress="EnterPress(event)" onkeydown="EnterPress()"><span id="errorSpan"></span><br/>
      地址：<input type="text" name="address" id="address" placeholder="请输入地址" onkeypress="EnterPress(event)" onkeydown="EnterPress()"><span id="addresserror"></span><br/>
      <input type="button" value="提交" id="submit">
  </form>
  </body>
  </html>