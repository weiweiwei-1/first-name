$(function(){
    var friendImg = $('.friendImg');
    var messageImg = $('.messageImg');
    var addfriendImg = $('.addfriendImg');
    addfriendImg.on('click',function(){
        friendImg.css('border',"transparent");
        messageImg.css('border',"transparent");
        addfriendImg.css("border","1px solid #f40");
        $('.conLeft ul').load(
            "/AddUser/showAddUser",
            function(){
            }
        )
    });
});
