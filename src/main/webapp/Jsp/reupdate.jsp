 <%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改用户资料</title>
    <script type="text/javascript" src="../jquery_jar/jquery-3.0.0.js"></script>
    <script type="text/javascript">
       /* function submitReupdate(){
            document.reupdate.action="{pageContext.request.contextPath }/ForAllList/submitReupdate";
            document.reupdate.submit();
        }*/
        function logout(){
        document.reupdate.action="${pageContext.request.contextPath }/ForAllList/logout";
        document.reupdate.submit();}
        function forupdateaddress(){
            /*document.reupdate.action="{pageContext.request.contextPath }/ForAllList/forupdateaddress?id{user.id}";*/
            document.reupdate.action="${pageContext.request.contextPath }/ForAllList/forupdateaddress";
            document.reupdate.submit();
        }
        $(function(){
            $("#edit").click(function(){
                $("#username").attr("readonly",false);
                $("#birthday").attr("readonly",false);
                $("#sex").attr("readonly",false);
                $("#address").attr("readonly",false);
            });
            $("#preserve").click(function(){
                var username=$("#username").val();
                var birthday=$("#birthday").val();
                var sex=$("#sex").val();
                var address=$("#address").val();
                $.ajax({
                    async:true,
                    cache:true,
                    url:"/ForAllList/submitReupdate",
                    contentType:"application/x-www-form-urlencoded",
                    dataType:"json",
                    data:{
                        /*"username":username,*/
                        "birthday":birthday,
                        "sex":sex,
                        "address":address
                    },
                    success:function(data){
                        $("#birthdayError").text(data.result0);$("#sexError").text(data.result1);$("#addressError").text(data.result2);
                        for(key in data){
                            if(key=="result3")
                            {
                                alert("修改成功！");
                            window.location.href="${pageContext.request.contextPath}/ForAllList/ForUserAndItems";break;}
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
                $("#preserve").click();
            }
        }
    </script>
</head>
<body>
<form name="reupdate" <%--action="" --%>method="post">
    <input type="hidden" name="id" value="${user.id}">
    <table align="center" border="0.5" cellspacing="0px">
        <tr><input type="hidden" name="id" value="${user.id}"></tr>
    <tr>
        <td>用户名</td>
        <td><input type="text" name="username" value="${user.username}" readonly="true" id="username" onkeypress="EnterPress(event)" onkeydown="EnterPress()"></td>
    </tr>
    <tr>
        <td>生日</td>
        <td><input type="text" name="birthday" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>" onkeypress="EnterPress(event)" onkeydown="EnterPress()" readonly="true" id="birthday">
            <span style="font-size: 10px;color:red" id="birthdayError"><%--${addressError}--%></span></td>
    </tr>
    <tr>
        <td>性别</td>
        <td><input type="text" name="sex" value="${user.sex}" readonly="true" id="sex" onkeypress="EnterPress(event)" onkeydown="EnterPress()">
            <span style="font-size: 10px;color:red" id="sexError"><%--${addressError}--%></span></td>
    </tr>
    <tr>
        <td>地址</td>
        <td><input type="text" name="address" value="${user.address}" readonly="true" id="address" onkeypress="EnterPress(event)" onkeydown="EnterPress()">
            <span style="font-size: 10px;color:red" id="addressError"><%--${addressError}--%></span></td>
    </tr>
    <tr>
        <td><input type="button" value="保存" <%--onclick="submitReupdate()" --%>align="middle" id="preserve"></td>
        <td><input type="button" value="编辑" id="edit"></td>
        <td><input type="button" value="注销" onclick="logout()" align="middle"></td>
        <td><input type="button"  value="修改密码" onclick="forupdateaddress()"></td>
    </tr>
    </table>
</form>
</body>
</html>