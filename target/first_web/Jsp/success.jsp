<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功提示</title>
    <script type="text/javascript">
        function backregister(){
            document.backTotable.action="${pageContext.request.contextPath}/ForAllList/forlogin";
            document.backTotable.submit();
        }
    </script>
</head>
<body>
操作成功！点击确定返回页面,点击登录返回登录界面
<form name="backTotable" action="${pageContext.request.contextPath}/ForAllList/ForUserAndItems" method="post">
    <table align="center" border="0.1" cellspacing="0px">
    <input type="submit" value="确定">
    <input type="button" value="返回登录" onclick="backregister()">
    </table>
</form>
</body>
</html>