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
<%--
function AjaxAll(){
document.enter.action="{pageContext.request.contextPath }/AjaxAll/enter";
document.enter.submit();
}
function AjaxPack(){
document.enter.action="{pageContext.request.contextPath }/AjaxPack/enterpack";
document.enter.submit();
}
function AjaxPackget(){
document.enter.action="{pageContext.request.contextPath }/AjaxPackget/jsonenter";
document.enter.submit();
}
function ajaxTra(){
document.enter.action="{pageContext.request.contextPath }/ajaxTra/ajaxTenter";
document.enter.submit();
}
function enterregit(){
document.enter.action="{pageContext.request.contextPath }/ajaxTra/enterregit";
document.enter.submit();
}
function enterLogin(){
document.enter.action="{pageContext.request.contextPath }/ajaxTra/enterLogin";
document.enter.submit();
}
function enterList(){
document.enter.action="{pageContext.request.contextPath }/ajaxTra/enterList";
document.enter.submit();
}
function listEnter(){
document.enter.action="{pageContext.request.contextPath }/ajaxList/listEnter";
document.enter.submit();
}enterpage()
function enterpage(){
document.enter.action="{pageContext.request.contextPath }/ForAllList/ForUserAndItems";
document.enter.submit();
}
--%>
<%--<form action="" method="post" name="enter">
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
        </tr>
    </table>
</form>--%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎页面</title>
    <link href="CSS/main.css"  rel="stylesheet" type="text/css">
    <link href="CSS/base.css" rel="stylesheet" type="text/css">
    <link href="CSS/flow-window.css" rel="stylesheet" type="text/css">
    <%--<link rel="icon" href="/static/ico/favicon.ico">--%>
    <script src="jquery_jar/jquery-3.0.0.js" rel="script" type="text/javascript"></script>
    <script src="Javascript/login.js" rel="script" type="text/javascript"></script>
    <script src="Javascript/register.js" rel = "script" type="text/javascript"></script>
</head>
<body>
<div id="content" >
    <div id="login-block">
        <div id="login-head">
            <h2>欢迎登录!</h2>
        </div>
        <div id="login-content">
            <div class="email-block">
                <div class="email-text"><input type="text" name="email" id="loginEmail" placeholder="邮 箱"></div>
                <div class="email-error"><span class="emailError"></span></div>
            </div>
            <div class="password-block">
                <div class="password-text"><input type="password" name="password" id="loginPassword" placeholder="密码"></div>
                <div class="password-error"><span class="passwordError"></span></div>
                <div class="swap-register-login">
                    <div class="rememberme-register"><input id="rememberMe" type="checkbox" name="rememberMe"><span id="rememberMe-text">记住我</span></div>
                    <div class="rememberme-register"><span id="register-confirm">还没有账号？点击注册</span></div></div>
            </div>
            <div class="login-button"><button type="button" id="login" <%--onclick="openwindow()"--%>disabled="disabled">登 录</button></div>
        </div>
    </div>
</div>
<div id="content2">
    <div id="register-block">
        <div id="close"><span class="close">&times;</span></div>
        <div id="register-head"><span id="head-line">欢迎注册!</span></div>
        <div id="register-content">
            <div id="email-block">
                <div id="email-text"><input type="text" name="email" id="registerEmail" placeholder="邮 箱"></div>
                <div id="email-error"><span id="emailError"></span></div>
            </div>
            <div id="password-block">
                <div id="password-text"><input type="password" name="password" id="registerPassword" placeholder="密码"></div>
                <div id="password-error"><span id="passwordError"></span></div>
            </div>
            <div id="password-confirm-block">
                <div id="passwordConfirm-text"><input type="password" name="confirm" id="passwordConfirm" placeholder="确认密码"></div>
                <div id="passwordConfirm-error"><span id="passwordConfirmError"></span></div>
            </div>
            <div id="confirm-code">
                <div id="confirmCode-input">验证码:<%--&nbsp;&nbsp;--%><input type="text" name="confirmCode" id="emailCode"></div>
                <div id="sendConfirmcode">
                    <div id="sendConfirmcode-block"><button type="button" id="sendCode">发送验证码</button></div>
                    <div id="confirmcodeError-block"><span id="confirmcodeError"></span></div>
                </div>
            </div>
            <div id="register-button"><button type="button" id="register" disabled="disabled">注 册</button></div>
        </div>
    </div>
</div>
</div>
</body>
<html>

