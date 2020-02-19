$(function(){
    $('.refresh span').on('click',function(){
        console.log("测试系统推荐");
        $('.overflow-hide .recomendContent').load('/AddUser/SystemRecommend',
            function(){
            if(!$('.recomendContent').children('.user-block').length) {
                alert('请编辑公司和学校或者通过公司和学校模糊查找');
            }
            })
    });

    $('.system-confirm').on('click',function(){
        $('.BoxHead').children('.headImg').click();
        $('#school,#company').css('border','1px solid deepskyblue');
        $('#company').attr('readonly',false);
        $('#school').attr('readonly',false);
    });

    $('.recomendContent').on('click','.appear',function(){
        var userId = $(this).parent().parent().attr("data-userId");
        $('.unKnownUserImg').attr('src',$(this).attr('src'));
        $('.unKnowUser-name').text($(this).parent().parent().children('.user-name').text());
        $('.unKnownUser-Box').attr('data-userId',userId);
        $('.unKnownUser').show();
    });

    $('.flex-center').on('click',function(e){
        var area=$(".unKnownUser-Box");
        if(!area.is(e.target)&&area.has(e.target).length===0){
            $('.unKnownUser').hide();
        }
    });

    $('.add').on('click',function(){
        var addName = $('#addName').val().trim();
        var beAddId = $('.unKnownUser-Box').attr('data-userId');
        console.log(addName);
        if(addName.length > 15 || addName.length < 2) {
            alert("输入名称长度介于2-15");
        } else {
            $.ajax({
                type:"post",
                async:true,
                cache:false,
                url:"/AddUser/sendAddUser",
                contentType:"application/x-www-form-urlencoded",
                dataType:"json",
                data:{
                    "beAddId":beAddId,
                    "addName":addName
                },
                success:function(data){
                    console.log(data);
                    if(data!==0) {
                        $('.unKnownUser').hide();
                        alert("发送好友申请成功");
                        $('.recomendContent .user-block[data-userId='+beAddId+']').remove();
                    } else {
                        alert("发送失败，查看该用户是否已经在您的好友列表中");
                    }
                },
                error:function(data){
                    alert("发送失败，后台错误，联系管理员");
                }
            });
        }
    });

});
