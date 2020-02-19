$(function(){
    var friendImg = $('.friendImg');
    friendImg.on('click',function(){
        $('.conLeft ul').load(
            "/Friend/friendList",
            function(){

            }
        )
    });

});