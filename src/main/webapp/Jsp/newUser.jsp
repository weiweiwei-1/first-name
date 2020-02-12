<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询用户列表</title>
    <script type="text/javascript" src="../jquery_jar/jquery-3.0.0.js"></script>
    <script type="text/javascript">
        /*function edit(){
            document.formPost.action="{pageContext.request.contextPath }/usernewList/eidtAll";
            document.formPost.submit();
        }
        function post(){
            document.formPost.action="{pageContext.request.contextPath }/usernewList/post";
            document.formPost.submit();
        }*/

$(function () {
    //主页面，全局搜索按钮
    $("#searchforall").click(function(){
        var condition=$("#condition").val();
        $.ajax({
            async:true,
            cache:true,
            type:"post",
            url:"/ForAllList/searchforall",
            contentType:"application/x-www-form-urlencoded",
            dataType:"json",
            data:{"condition":condition},
            success:function(data){
                $("#table").empty();
                $("#table").append("<tr>\n" +
                    "            <td>选择</td>\n" +
                    "            <td>用户Id</td>\n" +
                    "            <td>用户姓名</td>\n" +
                    "            <td>用户生日</td>\n" +
                    "            <td>用户性别</td>\n" +
                    "            <td>用户地址</td>\n" +
                    "        </tr>");
                $("#table2").empty();
                $("#table2").append("<tr>\n" +
                    "            <td>商品id</td>\n" +
                    "            <td>商品名称</td>\n" +
                    "            <td>商品价格</td>\n" +
                    "            <td>商品详情</td>\n" +
                    "            <td>商品图片</td>\n" +
                    "            <td>创建时间</td>\n" +
                    "        </tr>");
                for(var i=0; i<data.users.length; i++){
                    var user=data.users;
                    var tr=document.createElement("tr");
                    var select=document.createElement("td");
                    select.innerHTML="<input type=\"checkbox\" value=\""+user[i].id+"\" name=\"selectId\">";
                    var id=document.createElement("td");
                    id.innerHTML=user[i].id;
                    var username=document.createElement("td");
                    username.innerHTML=user[i].username;
                    var birthday=document.createElement("td");
                    var date=new Date(parseInt(user[i].birthday,10));
                    var datetrue=date.getFullYear()+"-"+date.getMonth()+1+"-"+date.getDate();
                    birthday.innerHTML=datetrue;
                    var sex=document.createElement("td");
                    sex.innerHTML=user[i].sex;
                    var address=document.createElement("td");
                    address.innerHTML=user[i].address;
                   var edit=document.createElement("td");
                    var a1=document.createElement("a");
                    a1.setAttribute("href","<%=appPath%>/usernewList/toUpdateUser?id="+user[i].id);
                    a1.setAttribute("target","_blank");
                    a1.innerHTML="更改";
                    var a2=document.createElement("a");
                    a2.setAttribute("href","<%=appPath%>/usernewList/deleteuser?id="+user[i].id);
                    a2.setAttribute("target","_blank");
                    a2.innerHTML="删除";
                    var a3=document.createElement("a");
                    a3.setAttribute("href","<%=appPath%>/usernewList/searchOrders?id="+user[i].id);
                    a3.setAttribute("target","_blank");
                    a3.innerHTML="查询订单信息";
                    edit.append(a1,"|",a2,"|",a3);
                    tr.append(select,id,username,birthday,sex,address,edit);
                  $("#table").append(tr);
                        }
                for(var j=0;j<data.items.length;j++){
                     var item=data.items;
                     var tr2=document.createElement("tr");
                     var id2=document.createElement("td");
                     id2.innerHTML=item[j].id;
                     var name=document.createElement("td");
                     name.innerHTML=item[j].name;
                     var price=document.createElement("td");
                    price.innerHTML=item[j].price;
                     var detail=document.createElement("td");
                    detail.innerHTML=item[j].detail;
                     var pic=document.createElement("td");
                    pic.innerHTML=item[j].pic;
                    var createtime=document.createElement("td");
                    var date2=new Date(parseInt(item[j].createtime,10));
                    var datetrue2=date2.getFullYear()+"-"+date2.getMonth()+1+"-"+date2.getDate();
                    createtime.innerHTML=datetrue2;
                    var edit2=document.createElement("td");
                    var a11=document.createElement("a");
                    a11.setAttribute("href","/itemsRelate/editItems?id="+item[j].id);
                    a11.setAttribute("target","_blank");
                    a11.innerHTML="修改商品";
                    var a22=document.createElement("a");
                    a22.setAttribute("href","/itemsRelate/addItems?id="+item[j].id);
                    a22.setAttribute("target","_blank");
                    a22.innerHTML="修改商品";
                    edit2.append(a11,a22);
                    tr2.append(id2,name,price,detail,pic,createtime,edit2);
                    $("#table2").append(tr2);
                }
                    },
            error:function(){
                alert("数据传输失败");
            }
        });
    });

    //主页面,刷新的按钮函数
    $("#reenter").click(function () {
        $("#condition").val("");
        $("#searchforall").click();
    });

    $("#condition").keydown(function (e) {
        var e=e||window.event;
        if(e.keyCode==13){
            $("#searchforall").click();
        }
    });
    //主页面删除用户信息的按钮函数
    $("#deleteSome").click(function(){
        var selectId=document.getElementsByName("selectId");
        var list=new Array();
        for(var i=0;i<selectId.length;i++){
            if(selectId[i].checked==true){
                list.push(selectId[i].value);
            }
        }
        console.log(list);
        $.ajax({
            async:false,
            cache:true,
            type:"post",
            url:"/usernewList/deleteSome",
            contentType:"application/json",
            dataType:"json",
            data:JSON.stringify(list),
            success:function(data){
               if(data.result=="0"){
               alert("请登录后操作");
               window.location.href="<%=appPath%>/ForAllList/forlogin";}
               else {
                   alert("删除成功");
                   for (var i = 0; i < data.result.length; i++) {
                       for(var j=0;j<selectId.length;j++){
                           if (data.result[i]==selectId[j].value){
                               selectId[j].parentNode.parentNode.remove();
                           }
                       }
                   }
               }
            },
            error:function(){
                alert("数据错误");
            }
        });
    });

    //点击登录，页面显示函数
    $("#loginorigin").click(function(){
        $("#form4").remove();
        $("#form2").remove();
        if(document.getElementById("form3")){
            document.getElementById("div2").style.display='block';
            document.getElementById("div1").style.display='block';
        }
        else{
            var $form3=$("<form>");
            $form3.attr({"method":"post","id":"form3"});
            var $table=$("<table>");
            $table.attr({"align":"center","cellspacing":"0px","width":"400","height":"150"});
            var $tr1=$("<tr>");
            var $td1=$("<td>");
            $td1.attr({"align":"center","colspan":"2"});
            $td1.append("您好，欢迎登陆网站");
            $tr1.append($td1);
            var $tr2=$("<tr>");
            var $td21=$("<td>");
            $td21.attr("align","right");
            $td21.append("姓名：");
            var $td22=$("<td>");
            $td22.attr("align","left");
            var $input2=$("<input>");
            $input2.attr({"type":"text","name":"username","id":"username3","placeholder":"请输入用户名","class":"input1"});
            var $span2=$("<span>");
            $span2.attr({"id":"usernameerror2","style":"font-size: 8px;color:red"});
            $td22.append($input2,$span2);
            $tr2.append($td21,$td22);
            var $tr3=$("<tr>");
            var $td31=$("<td>");
            $td31.attr("align","right");
            $td31.append("地址：");
            var $td32=$("<td>");
            $td32.attr("align","left");
            var $input3=$("<input>");
            $input3.attr({"type":"text","name":"address","id":"address3","placeholder":"请输入地址","class":"input1"});
            var $span3=$("<span>");
            $span3.attr({"id":"addresserror2","style":"font-size: 8px;color:red"});
            $td32.append($input3,$span3);
            $tr3.append($td31,$td32);
            var $tr4=$("<tr>");
            $tr4.attr("align","center");
            var $td4=$("<td>");
            $td4.attr("colspan","2");
            var $input4=$("<input>");
            $input4.attr({"type":"button","id":"submit3","value":"登陆"});
            $td4.append($input4);
            var $td42=$("<td>");
            $td42.attr("colspan","2");
            var $input42=$("<input>");
            $input42.attr({"type":"button","id":"submit4","value":"关闭"});
            $td42.append($input42);
            $tr4.append($td4,$td42);
            $table.append($tr1,$tr2,$tr3,$tr4);
            $form3.append($table);
            $("#div2").append($form3);
            document.getElementById("div2").style.display='block';
            document.getElementById("div1").style.display='block';
            $("#username3").keyup(function (e) {
                var e=e||window.event;
                if(e.keyCode==40){
                    $("#address3").focus();
                }
            });
            $("#address3").keyup(function (e) {
                var e=e||window.event;
                if(e.keyCode==38){
                    $("#username3").focus();
                }
            });
            $(".input1").keydown(function (e) {
                var e=e||window.event;
                if(e.keyCode==13){
                    $("#submit3").click();
                }
            });

            //登录按钮的函数
            $("#submit3").click(function () {
                var username=$("#username3").val();
                var address=$("#address3").val();
                $.ajax({
                    async:true,
                    cache:true,
                    url:"/ForAllList/login",
                    contentType:"application/x-www-form-urlencoded",
                    dataType:"json",
                    data:{
                        "username":username,
                        "address":address
                    },
                    success:function(data){
                        switch(data.result){
                            case "0":$("#usernameerror2").text("用户名不为空");$("#addresserror2").text("");$("#readdresserror").text("");break;
                            case "1":$("#usernameerror2").text("用户不存在");$("#addresserror2").text("");$("#readdresserror").text("");break;
                            case "2":$("#usernameerror2").text("");$("#addresserror2").text("地址错误");$("#readdresserror").text("");break;
                            case "3":$("#usernameerror2").text("");$("#addresserror2").text("");$("#readdresserror").text("");alert("欢迎您！");
                                <%--window.location.href="${pageContext.request.contextPath}/ForAllList/ForUserAndItems";break;--%>
                                window.location.href="${pageContext.request.contextPath}/WebSocket/Websocket1";break;
                        }
                    },
                    error:function(data){
                        alert("数据注入失败");
                    }
                });
            });

            //登录界面关闭按钮的函数
            $("#submit4").click(function () {
                document.getElementById("div2").style.display='none';
                document.getElementById("div1").style.display='none';
            });
        }
    });

$("#register").click(function () {
    $("#form2").remove();
    $("#form3").remove();
    if(document.getElementById("form4")){
        document.getElementById("div2").style.display='block';
        document.getElementById("div1").style.display='block';
    }
    else{
        var form4=$("<form>");
        form4.attr({"name":"form4","method":"post","id":"form4"});
        var table=$("<table>");
        table.attr({"align":"center","border":"0.2","cellspacing":"0px"});
        var tr1=$("<tr>");
        var td11=$("<td>");
        td11.append("用户名");
        var td12=$("<td>");
        var input1=$("<input>");
        input1.attr({"name":"username","type":"text","id":"username4"});
        var span1=$("<span>");
        span1.attr({"style":"font-size: 10px;color:red","id":"usernameError4"});
        td12.append(input1,span1);
        tr1.append(td11,td12);
        var tr2=$("<tr>");
        var td21=$("<td>");
        td21.append("地址");
        var td22=$("<td>");
        var input2=$("<input>");
        input2.attr({"name":"address","type":"text","id":"address4"});
        var span2=$("<span>");
        span2.attr({"style":"font-size:10px;color:red","id":"addressError4"});
        td22.append(input2,span2);
        tr2.append(td21,td22);
        var tr3=$("<tr>");
        var td31=$("<td>");
        var input31=$("<input>");
        input31.attr({"type":"button","id":"register2","value":"注册"});
        td31.append(input31);
        var td32=$("<td>");
        var input32=$("<input>");
        input32.attr({"type":"button","id":"close","value":"关闭"});
        td32.append(input32);
        tr3.append(td31,td32);
        table.append(tr1,tr2,tr3);
        form4.append(table);
        $("#div2").append(form4);
        document.getElementById("div2").style.display='block';
        document.getElementById("div1").style.display='block';
        $("#close").click(function () {
            document.getElementById("div2").style.display='none';
            document.getElementById("div1").style.display='none';
        });
        $("#register2").click(function () {
            var username=$("#username4").val();
            var address=$("#address4").val();
            $.ajax({
                async:true,
                cache:true,
                url:"/ForAllList/register",
                contentType:"application/x-www-form-urlencoded",
                dataType:"json",
                data:{
                    "username":username,
                    "address":address
                },
                success:function (data) {
                    if(data["Symbol"]=="0"){
                        // alert("失败");
                        $("#usernameError4").text(data["usernameError"]);
                        $("#addressError4").text(data["addressError"]);
                    }
                    else{
                        alert("注册成功");
                        location.reload();
                    }
                },
                error:function(data){
                    alert("数据注入失败");
                }
            });
        });
    }
});
    //用户登录后点击，显示用户信息，用户信息可以编辑
     $("#user-name").click(function(){
         document.getElementById("div1").style.display='block';
         document.getElementById("div2").style.display='block';

     });

    $(".input3").keydown(function (e) {
        var e=e||window.event;
        if(e.keyCode==13){
            $("#preserve").click();
        }
    });
     //编辑用户信息后保存的函数
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
                "username":username,
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

    //编辑按钮的函数
    $("#edit").click(function(){
        if($("#edit").val()=='编辑'){
            $("#username").attr("readonly",false);
            $("#birthday").attr("readonly",false);
            $("#sex").attr("readonly",false);
            $("#address").attr("readonly",false);
            $("#edit").val('取消编辑');
        }
        else{
            $("#birthdayError").text("");
            $("#sexError").text("");
            $("#addressError").text("");
            $("#username").val("${user.username}");
            $("#birthday").val("<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>");
            $("#sex").val("${user.sex}");
            $("#address").val("${user.address}");
            $("#username").attr("readonly",true);
            $("#birthday").attr("readonly",true);
            $("#sex").attr("readonly",true);
            $("#address").attr("readonly",true);
            $("#edit").val('编辑');
        }
    });

    //点击注销的函数
     $("#logout").click(function(){
         var affirm=confirm("您确定要注销吗");
         if(affirm==true){
         $.ajax({
             url:"/ForAllList/logout",
             success:function(){
                 document.getElementById("div1").style.display='none';
                 document.getElementById("div2").style.display='none';
                 location.reload();
                 <%--window.location.href="${pageContext.request.contextPath}/ForAllList/ForUserAndItems";--%>
             },
             error:function(){
                 alert("注入失败");
             }
         });
         }

     });

     //通过ajax定位到修改的页面
    $("#updatePassword").click(function(){
        $.ajax({
            url:"/ForAllList/forupdateaddress",
            success:function () {
                alert("ajax链接成功");
                window.location.href="{pageContext.request.contextPath}/ForAllList/forupdateaddress";
            },
            error:function(){
                alert("ajax链接错误");
            }
        });
    });

    //关闭用户信息悬浮窗的函数
     $("#Close_window").click(function(){
         document.getElementById("div1").style.display='none';
         document.getElementById("div2").style.display='none';
     });

     //修改密码的按钮
     $("#reupdatePassword").click(function(){
         // $("#form").remove();
         if(document.getElementById("form")){
             $("#form").show();
         }
         else{
         var $form=$("<form>");
         $form.attr({"id":"form","method":"post"});
         var $table=$("<table>");
         $table.attr({"align":"center","cellspacing":"0px","width":"400","height":"150","id":"table3","border":"0.5"});
         var $tr1=$("<tr>");
         var $td11=$("<td>");
         $td11.attr("align","right");
         $td11.append("用户名");
         var $td12=$("<td>");
         $td12.attr("align","left");
         $td12.append("${user.username}");
         $tr1.append($td11);
         $tr1.append($td12);
         var $tr2=$("<tr>");
         var $td21=$("<td>");
         $td21.attr("align","right");
         $td21.append("原地址");
         var $td22=$("<td>");
         $td22.attr("align","left");
         var $input2=$("<input>");
         $input2.attr({"type":"text","name":"address","id":"address2","class":"input2"});
         var $span2=$("<span>");
         $span2.attr({"style":"font-size: 10px;color:red","id":"addressError2"});
         $td22.append($input2,$span2);
         $tr2.append($td21,$td22);
         var $tr3=$("<tr>");
         var $td31=$("<td>");
         $td31.attr("align","right");
         $td31.append("新的地址");
         var $td32=$("<td>");
         $td32.attr("align","left");
         var $input3=$("<input>");
         $input3.attr({"type":"text","name":"newaddress","id":"newaddress","class":"input2"});
         var $span3=$("<span>");
         $span3.attr({"style":"font-size: 10px;color:red","id":"newaddressError"});
         $td32.append($input3,$span3);
         $tr3.append($td31,$td32);
         var $tr4=$("<tr>");
         var $td41=$("<td>");
         $td41.attr("align","right");
         $td41.append("确认新的地址");
         var $td42=$("<td>");
         $td42.attr("align","left");
         var $input4=$("<input>");
         $input4.attr({"type":"text","name":"sureaddress","id":"sureaddress","class":"input2"});
         var $span4=$("<span>");
         $span4.attr({"style":"font-size: 10px;color:red","id":"sureaddressError"});
         $td42.append($input4,$span4);
         $tr4.append($td41,$td42);
         var $tr5=$("<tr>");
         var $td51=$("<td>");
         $td51.attr("align","right");
         var $input51=$("<input>");
         $input51.attr({"type":"button","value":"提交修改","id":"updatapassword"});
         $td51.append($input51);
         var $td52=$("<td>");
         $td52.attr("align","left");
         var $input52=$("<input>");
         $input52.attr({"type":"button","value":"取消修改","id":"resign"});
         $td52.append($input52);
         $tr5.append($td51,$td52);
         $table.append($tr1,$tr2,$tr3,$tr4,$tr5);
         $form.append($table);
         $("#div2").append($form);
         $(".input2").keydown(function (e) {
             var e=e||window.event;
             if(e.keyCode==13){
                 $("#updatapassword").click();
             }
         });

         //通过ajax修改密码
         $("#updatapassword").click(function () {
             var address=$("#address2").val();
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
                     for(var key in data){
                         if(key=="0"){
                             $("#addressError2").text(data[key]);$("#newaddressError").text("");$("#sureaddressError").text("");break;
                         }
                         if(key=="1"){
                             $("#addressError2").text("");$("#newaddressError").text(data[key]);$("#sureaddressError").text("");break;
                         }
                         if(key=="2"){
                             $("#addressError2").text("");$("#newaddressError").text("");$("#sureaddressError").text(data[key]);break;
                         }
                         if(key=="3"){
                             $("#addresserror2").text("");$("#newaddressError").text("");$("#sureaddressError").text("");
                             alert("修改成功！点击确定回到主页");
                             window.location.href="${pageContext.request.contextPath}/ForAllList/ForUserAndItems";break;
                         }
                     }
                 },
                 error:function(data){
                     alert("系统出现错误");
                 }
         });
     });
         $("#resign").click(function(){
             $("#form").hide();
         });

         }
     });

});

    </script>
    <style type="text/css">
        a{
            text-decoration:none;
        }

        .div11{
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color:gray;
            z-index:1001;
            -moz-opacity: 0.8;
            opacity:.80;
            filter: alpha(opacity=88);
        }

        .div22{
            display: none;
            position: absolute;
            top: 25%;
            left: 25%;
            width: 55%;
            height: 55%;
            padding: 20px;
            border: 10px solid orange;
            background-color: white;
            z-index:1002;
            overflow: auto;
        }
    </style>
</head>
<body id="body">
<form name="formPost" method="post" id="formPost">
    <tr>
        <td>查询条件</td>
        <td><input type="text" name="condition" id="condition" placeholder="请输入查询条件"></td>
        <td><input type="button" id="searchforall" value="查询"></td>
    </tr>
    <tr>
        <input type="button" value="刷新页面" id="reenter">
    </tr>
    <tr>
        <input type="button" value="批量删除" id="deleteSome">
    </tr>

    <tr>
        <span id="user-name" style="font-size:9px;color:red;cursor:pointer;font-size:20px">${username}</span>
        <input type="hidden" name="username" value="${username}" id="username">
        <span id="loginorigin" style="color:red;cursor:pointer">${logininfo}</span>
        <span id="register" style="color:red;cursor:pointer">${register}</span>
    </tr>

    <table width="100%" border=1 cellspacing="0px">
        <tr>
            <td ><a href="<%=appPath%>/usernewList/add" target="_blank"/>添加</td>
        </tr>
    </table>
    用户信息：
    <table width="100%" border=1 cellspacing="0px" id="table">
        <tr>
            <td>选择</td>
            <td>用户Id</td>
            <td>用户姓名</td>
            <td>用户生日</td>
            <td>用户性别</td>
            <td>用户地址</td>
        </tr>
        <c:forEach items="${userList}" var="item">
            <tr>
                <td><input type="checkbox" value="${item.id}" name="selectId"></td>
                <td>${item.id }</td>
                <td>${item.username }</td>
                <td><fmt:formatDate value="${item.birthday}" pattern="yyyy-MM-dd"/></td>
                <td>${item.sex }</td>
                <td>${item.address}</td>
                <td>
                    <a href="<%=appPath%>/usernewList/toUpdateUser?id=${item.id}" target="_blank">更改</a> |
                    <a href="<%=appPath%>/usernewList/deleteuser?id=${item.id}" target="_blank">删除</a> |
                    <a href="<%=appPath%>/usernewList/searchOrders?id=${item.id}" target="_blank">查询订单信息</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <br/>
    <table width="100%" border=1 cellspacing="0px" id="table2">
        <tr>
            <td>商品id</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>商品详情</td>
            <td>商品图片</td>
            <td>创建时间</td>
        </tr>
        <c:forEach items="${itemsList}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.detail}</td>
                <td>${item.pic}</td>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                <td>
                    <a href="/itemsRelate/editItems?id=${item.id}" target="_blank">修改商品</a>
                    <a href="/itemsRelate/addItems?id=${item.id}" target="_blank">增加商品</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
<div id="div2" class="div22">
    <form name="reupdate" method="post" id="form2">
        <input type="hidden" name="id" value="${user.id}">
        <table align="center" border="0.5" cellspacing="0px">
            <tr><input type="hidden" name="id" value="${user.id}"></tr>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" value="${user.username}" readonly="true" id="username1" class="input3"></td>
            </tr>
            <tr>
                <td>生日</td>
                <td><input type="text" name="birthday" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>" readonly="true" id="birthday" class="input3">
                    <span style="font-size: 10px;color:red" id="birthdayError"><%--${addressError}--%></span></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" name="sex" value="${user.sex}" readonly="true" id="sex" class="input3">
                    <span style="font-size: 10px;color:red" id="sexError"><%--${addressError}--%></span></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><input type="text" name="address" value="${user.address}" readonly="true" id="address" class="input3">
                    <span style="font-size: 10px;color:red" id="addressError"><%--${addressError}--%></span></td>
            </tr>
            <tr>
                <td><input type="button" value="保存" <%--onclick="submitReupdate()" --%>align="middle" id="preserve"></td>
                <td><input type="button" value="编辑" id="edit"></td>
                <td><input type="button" value="注销" align="middle" id="logout"></td>
                <td><input type="button"  value="修改密码" id="reupdatePassword"></td>
                <td><input type="button" value="关闭窗口" id="Close_window"></td>
            </tr>
        </table>
    </form>
</div>
<div id="div1" class="div11"></div>
</body>

</html>