$(function(){
    var friendImg = $('.friendImg');
    var messageImg = $('.messageImg');
    var addfriendImg = $('.addfriendImg');
    friendImg.on('click',function(){
        $('.conLeft ul').load(
            "/Friend/friendList",
            function(){
                friendImg.css("border","1px solid #f40");
                messageImg.css('border',"transparent");
                addfriendImg.css('border',"transparent");
            }
        )
    });

});
