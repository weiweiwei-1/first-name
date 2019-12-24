<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Java API for WebSocket (JSR-356)</title>
</head>
<body>
<script type="text/javascript" src="../../jquery_jar/jquery-3.0.0.js"></script>
<%--<script type="text/javascript" src="../../WebsocketClient/websocket.js"></script>--%>
<script type="text/javascript">
    var websocket = null;
    if ('WebSocket' in window) {
        //Websocket的连接
        websocket = new WebSocket("ws://localhost:8080/websocket/socketServer");//WebSocket对应的地址
    }
    else if ('MozWebSocket' in window) {
        //Websocket的连接
        websocket = new MozWebSocket("ws://localhost:8080/websocket/socketServer");//SockJS对应的地址
    }
    else {
        //SockJS的连接
        websocket = new SockJS("http://localhost:8080/sockjs/socketServer");    //SockJS对应的地址
    }
    websocket.onopen = onOpen;
    websocket.onmessage = onMessage;
    websocket.onerror = onError;
    websocket.onclose = onClose;

    function onOpen(openEvt) {
        $("#content").append("连接打开"+"<br>"); // 接收后台发送的数据
    }

    function onMessage(evt) {
        $("#content").append(evt.data+"<br>"); // 接收后台发送的数据
    }
    function onError() {
        $("#content").append("连接错误");
    }
    function onClose() {
        $("#content").append("连接关闭");
    }

    function doSend() {

        var data={};
        data["receiver"]=$("#targetName").val();
        data["message"]=$("#inputMsg").val();
        if (websocket.readyState == websocket.OPEN) {
            //调用后台handleTextMessage方法
            websocket.send(JSON.stringify(data));
            $("#inputMsg").val("");
            $("#inputMsg").focus();
        } else {
            alert("连接失败!"+websocket.readyState);
            $("#content").append("连接失败，请重新连接");
        }
    }

    function doSend2(){
        if (websocket.readyState == websocket.OPEN) {
            websocket.send($("#inputMsg2").val());
        }
        else{
            alert("连接失败");
        }
    }

    window.close = function () {
        websocket.onclose();
    }

    $(function () {
        $("#inputMsg").keyup(function (e) {
            var e=e|window.event;
            if(e.keyCode==13){
                $("#send1").click();
            }
        });
        /*$("#send1").click(function () {
            var receiver=$("#inputMsg").val();
            $.ajax({
                async:true,
                cache:true,
                url:"/websocket/websocket",
                contentType:"application/x-www-form-urlencoded",
                data:{"receiver":receiver},
                dataType:"json",
                success:function () {
                    alert("sjax");
                },
                error:function () {
                    alert("fail");
                }
            });
        });*/
    });
</script>
请输入目标名称：<input type="text" id = "targetName" />
请输入：<textarea rows="3" cols="100" id="inputMsg" name="inputMsg"></textarea>
<button onclick="doSend()" id="send1">发送</button>
请输入：<textarea rows="3" cols="100" id="inputMsg2" name="inputMsg2"></textarea>
<button onclick="doSend2()">发送所有</button>
<div id="content"></div>
</body>
</html>
