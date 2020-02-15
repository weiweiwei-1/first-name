$(function(){
    var webSocket = null;
    if ('WebSocket' in window) {
        //Websocket的连接
        webSocket = new WebSocket("ws://localhost:8080/websocket/socketServer");//WebSocket对应的地址
    }
    else if ('MozWebSocket' in window) {
        //Websocket的连接
        webSocket = new MozWebSocket("ws://localhost:8080/websocket/socketServer");//SockJS对应的地址
    }
    else {
        //SockJS的连接
        webSocket = new SockJS("http://localhost:8080/sockjs/socketServer");    //SockJS对应的地址
    }
    webSocket.onopen =  function() {
        alert('webSocket连接成功');
    }
    webSocket.onclose = function() {
        alert('webSocket连接关闭');
    }
    webSocket.onerror = function() {
        alert('webSocket连接错误');
    }
    webSocket.onmessage = function(event) {
        handleMessage(JSON.parse(event.data));
        // alert("发送成");
    }

    function handleMessage(messagedata){
        console.log("开始测试");
        switch(messagedata.messageType) {
            case 'hasRead':
                if(messagedata.receiverId==rightContent.attr('data-id')) {
                $('.right .message-time .left-time span').text("已读");
            }
            break;
            case 'sendMessage':
                console.log(messagedata.senderId);
                console.log(messagedata.receiverId);
                console.log(messagedata.content);
                console.log(messagedata.sendTime);
                if(messagedata.senderId==rightContent.attr('data-id')) {
                    console.log("在左边");
                    $.ajax({
                        type: "post",
                        cache: true,
                        async: false,
                        contentType: "application/x-www-form-urlencoded",
                        url: "/Message/readMessages",
                        data: {
                            'friendId': messagedata.senderId
                        },
                        success: function () {

                        },
                        error: function () {

                        }
                    });
                var left='<div class="clearfloat">' +
                    '<div class="left">' +
                    '<div class="chat-avatars"><img src="' +$(".bg").children('.liLeft').children().attr("src")+
                    '"></div>' +
                    '<div class="message-time">' +
                    '<div class="chat-message">' + messagedata.content +
                    '</div>' +
                    '<div class="left-time">' +messagedata.sendTime+
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>';
                rightContent.append(left);
                rightContent.scrollTop(rightContent[0].scrollHeight);
                break;
            }
        }
    }

    Date.prototype.Format = function(fmt) { // author: meizz
        var o = {
            "M+" : this.getMonth() + 1, // 月份
            "d+" : this.getDate(), // 日
            "h+" : this.getHours(), // 小时
            "m+" : this.getMinutes(), // 分
            "s+" : this.getSeconds(), // 秒
            "q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
            "S" : this.getMilliseconds()// 毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for ( var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }

    function getCurrentTime() {
        return new Date().Format("yyyy-MM-dd hh:mm:ss");
    }

    var sendBtn = $('.sendBtn');
	var Righthead = $('.Righthead');
	var rightContent = $('.RightCont');
	var boxHead = $('.BoxHead');
	var text = $('#dope');

    boxHead.children('.headImg').on('click',function() {
        $('.userBox').show();
        $('.userCenter').show();
    });
	$('.unreadMessage-count').each(function(){
	    if($(this).text()==0) {
	        $(this).hide();
        } else {
	        $(this).show();
        }
    });

	$('.conLeft li').on('click',function(){
	    $('.RightFoot').show();
        $(this).addClass('bg').siblings().removeClass('bg');
        var unreadMessage = $('.bg .unreadMessage .unreadMessage-count');
        var intername=$(this).children('.liRight').children('.friendName').text();
        var id = $('.bg').attr('id');
        var img=$(this).children('.liLeft').children().attr("src");
        Righthead.children('.headImg').children().attr("src",img);
        Righthead.children('.headImg').show();
        rightContent.attr("data-id",id);
        $('.headName').text(intername);
        $('.newsList').html('');
        if(unreadMessage.text()!=='0') {
            $.ajax({
                type:"post",
                cache:true,
                async:false,
                contentType:"application/x-www-form-urlencoded",
                url:"/Message/readMessages",
                data:{
                    'friendId':id
                },
                success:function() {

                },
                error:function() {

                }
            });
        }
        $('.RightCont').load('/Message/messageContent',
            {
                "friendId":id
            },
            function(){
                rightContent.scrollTop(rightContent[0].scrollHeight);
                unreadMessage.text('0');
                unreadMessage.hide();
            }
        )
	});

	sendBtn.on('click', function(){
	    var textContent = text.val().trim();
	    var sendTime = getCurrentTime();
	    var receiverId = $('.bg').attr('id');
        var originalImg = boxHead.children('.headImg').children().attr("src");
	    console.log(sendTime);
        $.ajax({
            type:"post",
            async:true,
            cache:false,
            url:"/Message/sendMessage",
            contentType:"application/x-www-form-urlencoded",
            dataType:"json",
            data:{
                "receiverId":receiverId,
                "content":textContent,
                "sendTime":sendTime
            },
            success:function(data) {
                var right='<div class="clearfloat">' +
                    '<div class="right" data-messageId=' +data+'>' +
                    '<div class="message-time"><div class="chat-message">' +textContent+
                    '</div>' +
                    '<div class="left-time"><span class="read"></span>'+sendTime+'</div></div>' +
                    '<div class="chat-avatars"><img src="' + originalImg+
                    '"></div>' +
                    '</div>' +
                    '</div>';
                rightContent.append(right);
                text.val('');
                rightContent.scrollTop(rightContent[0].scrollHeight);
            },
            error:function(){
                alert("数据传输错误，请联系管理员");
            }
        })
    });

    })















      /*  boxHead.children('.headImg').on('click',function(){
        $('.userBox').show();
        $('.userCenter').show();

});


var originalImg=boxHead.children('.headImg').children().attr("src");

	sendBtn.on('click',function(){
        var textContent = text.val();
        if (textContent !== '') {
            var left='<div class="clearfloat">' +
                '<div class="left">' +
                '<div class="chat-avatars"><img src="' +$(".bg").children('.liLeft').children().attr("src")+
                '"></div>' +
                '<div class="message-time">' +
                '<div class="chat-message">' +
                '我asdhfdhasdgahsghdrgverghrdghrgvuigdfffwo a击杀东方红打法 阿斯顿发放reauighiuerghearatg一开始就' +
                '</div>' +
                '<div class="left-time">12:23:23</div>' +
                '</div>' +
                '</div>' +
                '</div>';
            rightContent.append(left);
            var right='<div class="clearfloat">' +
                // '<div class="author-name"><small class="chat-date"></small></div>' +
                '<div class="right">' +
                '<div class="message-time"><div class="chat-message">' +textContent+
                '</div>' +
                '<div class="left-time"><span class="read">已读  </span>12:00:23</div></div>' +
                '<div class="chat-avatars"><img src="' + originalImg+
                '"></div>' +
                '</div>' +
                '</div>';
            $(".RightCont").append(right);
            $("#dope").val("");
            $(document).ready(function () {
                rightContent.scrollTop(rightContent[0].scrollHeight);
            });
        }
		/!*var news=$('#dope').val();
		if(news==''){
			alert('不能为空');
		}else{
			$('#dope').val('');
		var str='';
		str+='<li>'+
				'<div class="nesHead"><img src="../../Img/6.jpg"/></div>'+
				'<div class="news"><img class="jiao" src="../../Img/20170926103645_03_02.jpg">'+"<span>"+news+"</span>"+'</div>'+
			'</li>';
		$('.newsList').append(str);
		setTimeout(answers,1000);
		$('.conLeft').find('li.bg').children('.liRight').children('.infor').text(news);
		$('.RightCont').scrollTop($('.RightCont')[0].scrollHeight );
	}*!/
	})
	function answers(){
		var arr=["你好","今天天气很棒啊","你吃饭了吗？","我最美我最美","我是可爱的僵小鱼","你们忍心这样子对我吗？","spring天下无敌，实习工资850","我不管，我最帅，我是你们的小可爱","段友出征，寸草不生","一入段子深似海，从此节操是路人","馒头：嗷","突然想开个车","段子界混的最惨的两个狗：拉斯，普拉达。。。"];
		var aa=Math.floor((Math.random()*arr.length));
		var answer='';
		answer+='<li>'+
					'<div class="answerHead"><img src="../../Img/tou.jpg"/></div>'+
					'<div class="answers"><img class="jiao" src="../../Img/jiao.jpg">'+arr[aa]+'</div>'+
				'</li>';
		$('.newsList').append(answer);
		$('.RightCont').scrollTop($('.RightCont')[0].scrollHeight );
	}






	$('.ExP').on('mouseenter',function(){
		$('.emjon').show();
	})
	$('.emjon').on('mouseleave',function(){
		$('.emjon').hide();
	})
	$('.emjon li').on('click',function(){
		var imgSrc=$(this).children('img').attr('src');
		var str="";
		str+='<li>'+
				'<div class="nesHead"><img src="../../Img/6.jpg"/></div>'+
				'<div class="news"><img class="jiao" src="../../Img/20170926103645_03_02.jpg"><img class="Expr" src="'+imgSrc+'"></div>'+
			'</li>';
		$('.newsList').append(str);
		$('.emjon').hide();
		$('.RightCont').scrollTop($('.RightCont')[0].scrollHeight );
	})*/