$(function(){
$('.conLeft li').on('click',function(){
	    $('.RightFoot').show();
		$(this).addClass('bg').siblings().removeClass('bg');
		var intername=$(this).children('.liRight').children('.friendName').text();
		var img=$(this).children('.liLeft').children().attr("src");
		$('.Righthead').children('.headImg').children().attr("src",img);
		$('.Righthead').children('.headImg').show();
		$('.headName').text(intername);
		$('.newsList').html('');
	});

$('.BoxHead').children('.headImg').on('click',function(){
    $('.userBox').show();
    $('.userCenter').show();
});


var originalImg=$('.BoxHead').children('.headImg').children().attr("src");

	$('.sendBtn').on('click',function(){
        var textContent = $("#dope").val();
        if (textContent != "") {
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

                /*'<div class="clearfloat">' +
                '<div class="author-name"><small class="chat-date"></small></div>' +
                '<div class="chat-avatars"><img src="' +$(".headImg").children().attr("src")+'" alt="对方头像"></div>' +
                '<div class="left"><div class="chat-message">sdjlahsfdhafsaiofhiaoshfdiadfiuaohi</div></div>' +
                '</div>';*/
            $(".RightCont").append(left);
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
           /* $(".RightCont").append("<div class=\"clearfloat\">" +
                "<div class=\"author-name\"><small class=\"chat-date\">2017-12-02 14:26:58</small> </div> " +
                "<div class=\"right\"> <div class=\"chat-message\"> " + textContent + " </div> " +
                "<div class=\"chat-avatars\"><img src=\"img/icon01.png\" alt=\"头像\" /></div> </div> </div>");*/
            //发送后清空输入框
            $("#dope").val("");
            $(document).ready(function () {
                $(".RightCont").scrollTop($(".RightCont")[0].scrollHeight);
            });
        }
		/*var news=$('#dope').val();
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
	}*/
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
	})

})