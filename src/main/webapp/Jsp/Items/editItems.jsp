<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>编辑商品</title>
    <script type="text/javascript">
       /* function submitItems(){
            document.editItems.action="${pageContext.request.contextPath }/itemsRelate/editSubmit";
            document.editItems.submit();
        }*/
    </script>
</head>
<body>
<form name="editItems" method="post" action="${pageContext.request.contextPath }/itemsRelate/editSubmit" enctype="multipart/form-data">
    <table align="center" cellspacing="0px" border="1">
        <tr>
            <td>商品id</td>
            <td><input type="text" name="id" value="${items.id}"></td>
            <td>${id_error}</td>
        </tr>
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name" value="${items.name}"></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price" value="${items.price}"></td>
        </tr>
        <tr>
            <td>商品详情</td>
            <td><input type="text" name="detail" value="${items.detail}"></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td>
                <c:if test="${items.pic !=null}">
                    <img src="/web-store/${items.pic}" width=100 height=100/>
                    <br/>
                </c:if>
                <input type="file"  name="items_pic"/>
            </td>
        </tr>
        <
        <tr>
            <td>商品创建时间</td>
            <td><input type="text" name="createtime" value="<fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd"/>"></td>
        </tr>
    </table>
    <input type="submit" value="提交" <%--onclick="submitItems()"--%> align="middle">
</form>
</body>
</html>