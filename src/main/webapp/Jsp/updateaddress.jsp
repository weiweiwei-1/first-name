<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改登录地址</title>
    <script type="text/javascript" src="../jquery_jar/jquery-3.0.0.js"></script>
    <script type="text/javascript">
       /* function addresssubmit(){
            document.updateaddress.action="{pageContext.request.contextPath }/ForAllList/updateaddress";
            document.updateaddress.submit();
        }*/
        $(function(){
            $("#updatapassword").click(function(){
                var address=$("#address").val();
                var newaddress=$("#newaddress").val();
                var sureaddress=$("#sureaddress").val();
                $.ajax({
                    async:true,
                    cache:true,
                    url:"/ForAllList/updateaddress",
                    contentType:"application/x-www-form-urlencoded",
                    dataType:"json",
                    data:{
                        "address":address,
                        "newaddress":newaddress,
                        "sureaddress":sureaddress
                    },
                    success:function(data){
                        /*switch(data.result){
                            case "0":$("#addresserror").text("原来地址错误");$("#newaddressError").text("");$("#sureaddressError").text("");break;
                            case "1":$("#addresserror").text("");$("#newaddressError").text(data.result.data);$("#sureaddressError").text("");break;
                            case "2":$("#addresserror").text("");$("#newaddressError").text("");$("#sureaddressError").text(data.result.data);break;
                            case "3":$("#addresserror").text("");$("#newaddressError").text("");$("#sureaddressError").text("");alert("修改成功！点击确定回到主页");
                            window.location.href="{pageContext.request.contextPath}/ForAllList/ForUserAndItems";break;*/
                                for(var key in data){
                                    if(key=="0"){
                                        $("#addressError").text(data[key]);$("#newaddressError").text("");$("#sureaddressError").text("");break;
                                    }
                                    if(key=="1"){
                                        $("#addressError").text("");$("#newaddressError").text(data[key]);$("#sureaddressError").text("");break;
                                    }
                                    if(key=="2"){
                                        $("#addressError").text("");$("#newaddressError").text("");$("#sureaddressError").text(data[key]);break;
                                    }
                                    if(key=="3"){
                                        $("#addresserror").text("");$("#newaddressError").text("");$("#sureaddressError").text("");alert("修改成功！点击确定回到主页");
                                        window.location.href="${pageContext.request.contextPath}/ForAllList/ForUserAndItems";break;
                                    }
                                }
                    },
                    error:function(data){
                        alert("系统出现错误");
                    }
                });
            });
        });
    </script>
</head>
<body>
<form name="updateaddress" <%--action="<%=request.getContextPath()%>/ForAllList/login"--%> method="post">
    <table align="center" cellspacing="0px" width="400" height="180">
        <tr>
            <td>用户名</td>
            <td>${user.username}</td>

        </tr>
        <tr>
            <td>原地址</td>
            <td><input type="text" name="address" <%--value="${address}" --%>id="address">
                <span style="font-size: 10px;color:red" id="addressError"><%--${addressError}--%></span>
            </td>
        </tr>
        <tr>
            <td>新的地址</td>
            <td><input type="text" name="newaddress" <%--value="${newaddress}"--%>id="newaddress">
                <span style="font-size: 10px;color:red" id="newaddressError"><%--${nulladdressError}--%></span>
            </td>
        </tr>
        <tr>
            <td>确定新的地址</td>
            <td><input type="text" name="sureaddress" <%--value="${sureaddress}"--%>id="sureaddress">
                    <span style="font-size: 10px;color:red" id="sureaddressError"><%--${newaddressError}--%></span>
            </td>
        </tr>
        <tr><input type="button" value="提交修改" <%--onclick="addresssubmit()"--%>id="updatapassword"></tr>
    </table>

</form>
</body>
</html>