$(function(){
    $('.messageImg').on('click',function(){
        $('.conLeft ul').load(
            "/Message/chatMessageList",
            function(){
                $('.conLeft ul').find('.unreadMessage-count').each(function(){
                    console.log("最后测试是否成功");
                    if($(this).text()==0){
                        $(this).hide();
                    } else {
                        $(this).show();
                    }
                })
            }
        )
    });
})