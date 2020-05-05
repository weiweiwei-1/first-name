$(function () {
    var sendCode = $('#sendCode');
    function sendButtonInValid(){
        sendCode.css('background-color','gray');
        sendCode.attr('disabled',true);
        sendCode.text('倒计时5分钟');
    }

    function sendButtonValid() {
        sendCode.attr("disabled",false);
        sendCode.css("background-color","#f40");
        sendCode.text('发送验证码');
    }

    sendCode.on('click',function(){
        sendButtonInValid();
        $.post(
            '/User/sendCode',
            function(data){
                for(var key in data){
                    switch(key){
                        case 'emailExistError':sendButtonValid();$('.code-error').text(data.emailExistError);break;
                        case 'success':setTimeout(sendButtonValid(),300000);break;
                    }
                }

            }
        )
    });
})

