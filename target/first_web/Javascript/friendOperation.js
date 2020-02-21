$(function(){
    $('.friend-Box').on('click',function(e){
        var content=$('.friend-center');
        if(!content.is(e.target)&&content.has(e.target).length===0){
            $(this).hide();
        }
    });

    $('.recomend-search').on('click',function(){
        $('.friend-Box').show();
    })

    $('.Righthead .headImg img').on('click',function(){
        var friendId = $('.Righthead').attr('data-friendId');
        console.log(friendId);
        if(friendId==null) {
            alert('非法输入');
        } else {
            $.ajax({
                type:"post",
                cache:true,
                async:true,
                url:"/Friend/showFriendInformation",
                contentType:"application/x-www-form-urlencoded",
                dataType:"json",
                data:{
                    "friendId":friendId
                },
                success:function(data){
                    console.log(data.userMark);
                    $('#friendName').text("姓名："+data.username);
                    $('#friendMark').val(data.userMark);
                    $('#friendCompany').text('公司:'+data.company);
                    $('#friendSchool').text('学校:'+data.school);
                    $('#friendSex').text('性别:'+data.sex);
                    $('#friendAge').text('年龄:'+data.age);
                    $('#friendOccupation').text('职业:'+data.occupation);
                    $('#friendHobby').text('爱好：'+data.hobby);
                    $('#friendIntroduction').text(data.introduction);
                    $('#addTime fmt').val(data.addTime);
                    $('.friend-Box').show();
                },
                error:function(data){

                }
            });
        }
    });

    $('.edit-friendMark').on('click',function(){
        var friendMark = friendMark.val().trim();
        var friendId= $('.friend-center').attr("data-friendId");
        if(friendMark.length > 10) {
            alert("备注长度不能超过10位");
        } else{
            $.ajax({
                type:"post",
                cache:true,
                async:true,
                url:"/Friend/updateFriendMark",
                contentType:"application/x-www-form-urlencoded",
                dataType:"json",
                data:{
                    "friendId":friendId,
                    "friendMark":friendMark
                },
                success:function(data) {

                },
                error:function(data){

                }
            });
        }
    });
});