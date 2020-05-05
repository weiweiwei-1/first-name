$(function(){
    var friendImg = $('.friendImg');
    var messageImg = $('.messageImg');
    var addfriendImg = $('.addfriendImg');
    $('.search-submit').on('click',function(){
        var condition = $('.search-condition').val();
        $('.conLeft ul').load(
            "/Friend/searchFriend",
            {
                condition: condition
            },
            function(){
                friendImg.css("border","1px solid #f40");
                messageImg.css('border',"transparent");
                addfriendImg.css('border',"transparent");
            }
        )
    });

    $(".search-condition").keydown(function () {
        var e = e || window.event;
        if(e.keyCode === 13){
            $(".search-submit").click();
        }
    });
});