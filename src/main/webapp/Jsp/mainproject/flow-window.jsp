<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>JAVASCRIPT弹出层</title>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <style>
        #popDiv {
            position: absolute;
            visibility: hidden;
            overflow: hidden;
            border: 2px solid #AEBBCA;
            background-color: #EEF1F8;
            /*cursor: move;*/
            padding: 1px;
        }

        #popTitle {
            background: #9DACBF;
            height: 20px;
            line-height: 20px;
            padding: 1px;
            cursor:move;
        }

        #popForm {
            padding: 2px;
        }

        .title_left {
            font-weight: bold;
            padding-left: 5px;
            float: left;
        }

        .title_right {
            float: right;
        }

        #popTitle .title_right a {
            color: #000;
            text-decoration: none;
        }

        #popTitle .title_right a:hover {
            text-decoration: underline;
            color: #FF0000;
        }
    </style>
    <script>
        function showPopup() {//弹出层
            var objDiv = document.getElementById("popDiv");
            objDiv.style.top = "50px";//设置弹出层距离上边界的距离
            objDiv.style.left = "200px";//设置弹出层距离左边界的距离
            objDiv.style.width = "300px";//设置弹出层的宽度
            objDiv.style.height = "200px";//设置弹出层的高度
//objDiv.style.display = "block";
            objDiv.style.visibility = "visible";
        }
        function hidePopup() {//关闭层
            var objDiv = document.getElementById("popDiv");
            objDiv.style.visibility = "hidden";
        }
    </script>
</head>
<body>
<div id="popDiv">
    <div id="popTitle"> <!-- 标题div -->
        <span class="title_left">修改操作</span> <span class="title_right"><a
                href="#" onclick="hidePopup();">关闭</a> </span>
    </div>
    <div id="popForm"> <!-- 表单div -->
        <form action="insert_map.jsp" method="post">
            <p>
                ID :<input type="text" name="id" value="0" /> </br>
                名    称 :<input type="text" name="name" value="aaa" /> </br>
                电压等级 :<input type="text" name="voltage_level" value="110kv" /> </br>
                经    度 :<input type="text" name="lon" value="121." /> </br>
                纬    度 :<input type="text" name="lat" value="28." /> </br>
            </p>
            <input type="submit" value="提交" />
            <input type="reset" value="重置" />
            <input type="reset" value="取消" onclick="hidePopup()" />
        </form>
    </div>
</div>
<p>
    <input name="" type="button" onclick="showPopup()" value="操作" />
</p>

<script type="text/javascript">
    /*-------------------------鼠标左键拖动---------------------*/
    /*--------当不需要实现此功能时，可以将这一部分代码删除------------*/
    var objDiv = document.getElementById("popDiv");
    var isIE = document.all ? true : false;//判断浏览器类型
    document.onmousedown = function(evnt) {//当鼠标左键按下后执行此函数
        var evnt = evnt ? evnt : event;
        if (evnt.button == (document.all ? 1 : 0)) {
            mouseD = true;//mouseD为鼠标左键状态标志，为true时表示左键被按下
        }
    }

    objDiv.onmousedown = function(evnt) {
        objDrag = this;//objDrag为拖动的对象
        var evnt = evnt ? evnt : event;
        if (evnt.button == (document.all ? 1 : 0)) {
            mx = evnt.clientX;
            my = evnt.clientY;
            objDiv.style.left = objDiv.offsetLeft + "px";
            objDiv.style.top = objDiv.offsetTop + "px";
            if (isIE) {
                objDiv.setCapture();
//objDiv.filters.alpha.opacity = 50;//当鼠标按下后透明度改变
            } else {
                window.captureEvents(Event.MOUSEMOVE);//捕获鼠标拖动事件
//objDiv.style.opacity = 0.5;//当鼠标按下后透明度改变
            }
        }
    }
    document.onmouseup = function() {
        mouseD = false;//左键松开
        objDrag = "";
        if (isIE) {
            objDiv.releaseCapture();
//objDiv.filters.alpha.opacity = 100;//当鼠标左键松开后透明度改变
        } else {
            window.releaseEvents(objDiv.MOUSEMOVE);//释放鼠标拖动事件
//objDiv.style.opacity = 1;//当鼠标左键松开后透明度改变
        }
    }

    document.onmousemove = function(evnt) {
        var evnt = evnt ? evnt : event;
        if (mouseD == true && objDrag) {
            var mrx = evnt.clientX - mx;
            var mry = evnt.clientY - my;
            objDiv.style.left = parseInt(objDiv.style.left) + mrx + "px";
            objDiv.style.top = parseInt(objDiv.style.top) + mry + "px";
            mx = evnt.clientX;
            my = evnt.clientY;
        }
    }
</script>

</body>
</html>