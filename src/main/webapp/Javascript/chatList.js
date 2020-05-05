$(function(){
    var friendImg = $('.friendImg');
    var messageImg = $('.messageImg');
    var addfriendImg = $('.addfriendImg');
    messageImg.on('click',function(){
        friendImg.css('border',"transparent");
        messageImg.css("border","1px solid #f40");
        addfriendImg.css('border',"transparent");
        $('.conLeft ul').load(
            "/Message/chatMessageList",
            function(){
                $('.conLeft ul').find('.unreadMessage-count').each(function(){
                    if($(this).text() === '0'){
                        $(this).hide();
                    } else {
                        $(this).show();
                    }
                })
            }
        )
    });
});