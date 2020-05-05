$(function(){
    var webSocket = null;
    if ('WebSocket' in window) {
        webSocket = new WebSocket("ws://weichat.online:80/websocket/socketServer");//WebSocket对应的地址
    }
    else if ('MozWebSocket' in window) {
        webSocket = new MozWebSocket("ws://weichat.online:80/websocket/socketServer");//SockJS对应的地址
    }
    else {
        webSocket = new SockJS("http://weichat.online:80/sockjs/socketServer"); //SockJS对应的地址
    }
    webSocket.onopen = function() {
    };
    webSocket.onclose = function() {
        var affirm = confirm("tcp连接关闭，点击确定刷新重连");
        if (affirm === true) {
            window.location.href = "/ChatPage/main";
        }
    };
    webSocket.onerror = function() {
        var affirm = confirm("tcp连接错误，点击确定刷新重连");
        if (affirm === true) {
            window.location.href = "/ChatPage/main";
        }
    };
    webSocket.onmessage = function(event) {
        handleMessage(JSON.parse(event.data));
    };

    var sendBtn = $('.sendBtn');
    var rightHead = $('.Righthead');
    var rightFoot = $('.RightFoot');
    var rightContent = $('.RightCont');
    var boxHead = $('.BoxHead');
    var text = $('#dope');

    function messagePosition(messagedata){
        if($('ul li .unreadMessage').length) {
            if($('ul li[id=' + messagedata.senderId + ']').length) {
                var unReadObj = $('ul li[id=' + messagedata.senderId + '] .unreadMessage .unreadMessage-count');
                var count = Number(unReadObj.text()) + 1;
                var messageText = $('ul li[id=' + messagedata.senderId + '] .liRight .lastUnReadMessage');
                messageText.text(messagedata.content);
                unReadObj.text(count);
                unReadObj.show();
            } else {
                var newChat = '<li class="" id="' + messagedata.senderId + '">' +
                    '<div class="liLeft">' +
                    '<img src="/web-store/' + messagedata.senderPhoto + '">' +
                    '</div>' +
                    '<div class="liRight">' +
                    '<span class="friend-name">' + messagedata.senderName +
                    '</span>' +
                    '<span class="lastUnReadMessage">' + messagedata.content +
                    '</span>' +
                    '</div>' +
                    '<div class="unreadMessage">' +
                    '<div class="unreadMessage-count">' + 1 +
                    '</div>' +
                    '<div class="unreadMessage-time">' + messagedata.sendTime +
                    '</div>' +
                    '</div>' +
                    '</li>';
                $('.conLeft ul').prepend(newChat);
                $('ul li[id=' + messagedata.senderId + '] .unreadMessage .unreadMessage-count').show();
            }
        }
    }

    function handleMessage(messagedata){
        switch(messagedata.messageType) {
            case 'hasRead':
                console.log(messagedata.receiverId);
                if(messagedata.receiverId == rightContent.attr('data-id')) {
                    console.log("已读");
                $('.right .message-time .left-time span').text("已读");
            }
            break;
            case 'sendMessage':
                var obj = rightContent.attr('data-id');
                if(typeof obj !== typeof undefined) {
                    if (messagedata.senderId == obj) {
                        $.ajax({
                            type: "post",
                            cache: true,
                            async: true,
                            contentType: "application/x-www-form-urlencoded",
                            url: "/Message/readMessages",
                            data: {
                                'friendId': messagedata.senderId
                            },
                            success: function () {
                                var unReadObj = $('ul li[id=' + messagedata.receiverId + '] .unreadMessage .unreadMessage-count');
                                var unReadContent = $('ul li[id=' + messagedata.receiverId + '] .liRight .lastUnReadMessage');
                                if(typeof unReadObj !== typeof undefined && typeof unReadContent !== typeof undefined) {
                                    unReadObj.text('0');
                                    unReadObj.hide();
                                    unReadContent.text(messagedata.content);
                                }
                            },
                            error: function () {
                                alert('后台错误，刷新重试，或者联系管理员')
                            }
                        });

                        var left = '<div class="clearfloat">' +
                            '<div class="left">' +
                            '<div class="chat-avatars"><img src="' + $('.Righthead .headImg img').attr('src') +
                            '"></div>' +
                            '<div class="message-time">' +
                            '<div class="chat-message">' + messagedata.content +
                            '</div>' +
                            '<div class="left-time">' + messagedata.sendTime +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</div>';
                        rightContent.append(left);
                        rightContent.scrollTop(rightContent[0].scrollHeight);
                        if($('ul li .unreadMessage').length) {
                            if($('ul li[id=' + messagedata.senderId + ']').length) {
                                var unReadObj = $('ul li[id=' + messagedata.senderId + '] .unreadMessage .unreadMessage-count');
                                var unReadContent = $('ul li[id=' + messagedata.senderId + '] .liRight .lastUnReadMessage');
                                unReadObj.text('0');
                                unReadObj.hide();
                                unReadContent.text(messagedata.content);
                            } else {
                                var newChat = '<li class="" id="' + messagedata.senderId + '">' +
                                    '<div class="liLeft">' +
                                    '<img src="/web-store/' + messagedata.senderPhoto + '">' +
                                    '</div>' +
                                    '<div class="liRight">' +
                                    '<span class="friend-name">' + messagedata.senderName +
                                    '</span>' +
                                    '<span class="lastUnReadMessage">' + messagedata.content +
                                    '</span>' +
                                    '</div>' +
                                    '<div class="unreadMessage">' +
                                    '<div class="unreadMessage-count">' + 0 +
                                    '</div>' +
                                    '<div class="unreadMessage-time">' + messagedata.sendTime +
                                    '</div>' +
                                    '</div>' +
                                    '</li>';
                                $('.conLeft ul').prepend(newChat);
                                $('ul li[id=' + messagedata.senderId + '] .unreadMessage .unreadMessage-count').hide();
                            }
                        }
                    } else {
                        messagePosition(messagedata);
                    }
                } else {
                    messagePosition(messagedata);
                }
                break;
            case 'addUser':
        }
    }

    Date.prototype.Format = function(fmt) { // author: meizz
        var o = {
            "M+": this.getMonth() + 1, // 月份
            "d+": this.getDate(), // 日
            "h+": this.getHours(), // 小时
            "m+": this.getMinutes(), // 分
            "s+": this.getSeconds(), // 秒
            "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
            "S": this.getMilliseconds()// 毫秒
        };
        if (/(y+)/.test(fmt))
            {fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));}
        for ( var k in o)
            {if (new RegExp("(" + k + ")").test(fmt)) {fmt = fmt.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));}}
        return fmt;
    };

    function getCurrentTime() {
        return new Date().Format("yyyy-MM-dd hh:mm:ss");
    }

    boxHead.children('.headImg').on('click',function() {
        $('.userBox').show();
    });

	$('.conLeft ul').find('.unreadMessage-count').each(function(){
	    if($(this).text() == '0'){
	        $(this).hide();
        } else {
	        $(this).show();
        }
    });

	$('.friend-content ul').on('click','li',function(){
        if($(this).children('.unreadMessage').length || $(this).children('.friend-img').length){
            rightFoot.show();
            rightHead.find('.headImg').show();
            $(this).addClass('bg').siblings().removeClass('bg');
            var aim = $('.bg');
            var id = aim.attr('id');
            var img = $('.bg img').attr('src');
            rightHead.find('img').attr('src',img);
            rightHead.attr('data-friendId',id);
            rightContent.attr('data-id',id);
            if($(this).children('.unreadMessage').length) {
                var friendName = aim.find('.friendName').text();
                rightHead.find('.headName').text(friendName);
                var unreadMessageCount = $('.bg .unreadMessage .unreadMessage-count');
                if(unreadMessageCount.text() !== '0'){
                    $.ajax({
                        type: "post",
                        cache: true,
                        async: true,
                        contentType: "application/x-www-form-urlencoded",
                        url: "/Message/readMessages",
                        data: {
                            'friendId': id
                        },
                        success: function() {
                            unreadMessageCount.text('0');
                            unreadMessageCount.hide();
                        },
                        error: function() {
                            alert('后台或者网络错误，请刷新');
                        }
                    });
                }
            }
            if($(this).children('.friend-information').length){
                var friendName1 = aim.find('.friend-name').text();
                rightHead.find('.headName').text(friendName1);
                $.ajax({
                    type: "post",
                    cache: true,
                    async: true,
                    contentType: "application/x-www-form-urlencoded",
                    url: "/Message/readMessages",
                    data: {
                        'friendId': id
                    },
                    success: function() {

                    },
                    error: function() {
                        alert('读消息时后台或者网络错误，请刷新，或者联系管理员');
                    }
                });
            }
            rightContent.load('/Message/messageContent',
                {
                    "friendId": id
                },
                function(){
                    rightContent.scrollTop(rightContent[0].scrollHeight);
                }
            )
            } else {
            var unKnownUserId = $(this).attr('data-adduserid');
            $.ajax({
                type: "post",
                cache: true,
                async: true,
                url: "/AddUser/showUser",
                contentType: "application/x-www-form-urlencoded",
                dataType: "json",
                data: {
                    "addUserId": unKnownUserId
                },
                success: function(data){
                    $('.permitUser-Box').attr('data-addUserId',unKnownUserId);
                    $('.permitUserImg').attr("src","/web-store/" + data.photo);
                    $('.addName').val(data.userMark);
                    $('.permitUser-school').text("学校：" + data.school);
                    $('.permitUser-company').text("公司：" + data.company);
                    $('.permitUser').show();
                },
                error: function(){
                    alert("数据传输错误，联系管理员");
                }
            });
        }
    });

	sendBtn.on('click', function(){
	    var textContent = text.val().trim();
	    var sendTime = getCurrentTime();
	    var receiverId = $('.RightCont').attr('data-id');
        var originalImg = boxHead.children('.headImg').children().attr("src");
        if(textContent.length === 0){
            alert('请输入内容');
        }
        if(textContent.length > 400){
            alert('消息长度超过400，请重新输入');
        }
        else{
            $.ajax({
                type: "post",
                async: false,
                cache: false,
                url: "/Message/sendMessage",
                contentType: "application/x-www-form-urlencoded",
                dataType: "json",
                data: {
                    "receiverId": receiverId,
                    "content": textContent,
                    "sendTime": sendTime
                },
                success: function(data) {
                    var right = '<div class="clearfloat">' +
                        '<div class="right" data-messageId=' + data + '>' +
                        '<div class="message-time"><div class="chat-message">' + textContent +
                        '</div>' +
                        '<div class="left-time"><span class="read"></span>' + sendTime + '</div></div>' +
                        '<div class="chat-avatars"><img src="' + originalImg +
                        '"></div>' +
                        '</div>' +
                        '</div>';
                    rightContent.append(right);
                    text.val('');
                    rightContent.scrollTop(rightContent[0].scrollHeight);
                },
                error: function(){
                    alert("数据传输错误，请联系管理员");
                }
            })
        }
    });
	text.keydown(function(){
	    var e = e || window.event;
	    if(e.keyCode === 13){
	        sendBtn.click();
        }
    });
    });