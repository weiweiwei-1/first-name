$(function(){
    $('.friend-Box').on('click',function(e){
        var content = $('.friend-center');
        if(!content.is(e.target) && content.has(e.target).length === 0){
            $(this).hide();
        }
    });

    $('.Righthead .headImg img').on('click',function(){
        var friendId = $('.Righthead').attr('data-friendId');
        $('.friend-center').attr("data-friendId",friendId);
        if(friendId == null) {
            alert('非法输入');
        } else {
            $.ajax({
                type: "post",
                cache: true,
                async: true,
                url: "/Friend/showFriendInformation",
                contentType: "application/x-www-form-urlencoded",
                dataType: "json",
                data: {
                    "friendId": friendId
                },
                success: function(data){
                    $('.friend-center .user-img').attr('src','/web-store/' + data.photo);
                    $('#friendName').text("昵称：" + data.username);
                    $('#friendMark').val(data.userMark);
                    $('#friendCompany').text('公司：' + data.company);
                    $('#friendSchool').text('学校：' + data.school);
                    if(data.age !== null){
                        $('#friendAge').text('年龄：' + data.age);
                    } else {
                        $('#friendAge').text('年龄：');
                    }
                    $('#friendSex').text('性别：' + data.sex + '');
                    $('#friendOccupation').text('职业：' + data.occupation);
                    $('#friendHobby').text('爱好：' + data.hobby);
                    $('#friendIntroduction').text(data.introduction);
                    $('#addTime').text(data.addTime);
                    $('.friend-Box').show();
                },
                error: function(){
                    alert("数据传输错误，请刷新页面");
                }
            });
        }
    });

    var friendMark = $('#friendMark');
    friendMark.keydown(function(){
        var e = event || window.event;
        if(e.keyCode === 13){
            $('.save-friendMark').click();
            friendMark.attr('readonly',true);
            friendMark.css('border','transparent');
        }
    });
    $('.edit-friendMark').on('click',function(){
        friendMark.attr('readonly',false);
        friendMark.css({'border': '1px solid deepskyblue','outline': 'none'});
    });

    $('.save-friendMark').on('click',function(){
        var friendMarkval = friendMark.val().trim();
        var friendId = $('.friend-center').attr("data-friendId");
        if(friendMarkval.length > 10) {
            alert("备注长度不能超过10位");
        } else{
            $.ajax({
                type: "post",
                cache: true,
                async: true,
                url: "/Friend/updateFriendMark",
                contentType: "application/x-www-form-urlencoded",
                data: {
                    "friendId": friendId,
                    "friendMark": friendMarkval
                },
                success: function() {
                    $('li[id=' + friendId + '] .friend-name').text(friendMarkval);
                    $('li[id=' + friendId + '] .friendName').text(friendMarkval);
                    $('.Righthead[data-friendId=' + friendId + '] .headName').text(friendMarkval);
                    friendMark.attr('readonly',true);
                    friendMark.css('border','transparent');
                },
                error: function(){
                    alert('后台错误，请联系管理员');
                }
            });
        }
    });

    $('.delete-friend').on('click',function() {
        var friendId = $('.Righthead').attr('data-friendId');
        var affirm = confirm("您确定要删除该好友吗");
        if (affirm === true) {
            $.ajax({
                type: "post",
                cache: true,
                async: true,
                url: "/Friend/deleteFriend",
                contentType: "application/x-www-form-urlencoded",
                data: {
                    "friendId": friendId
                },
                success: function () {
                    alert('成功删除');
                    $('.friend-Box').hide();
                    $('.bg').remove();
                    $('.RightCont').children().remove();
                    $('.headName').text('');
                },
                error: function () {
                    alert("删除失败，后台异常，联系管理员");
                }
            });
        }
    });

    $('#table2 tr').each(function(){
        $(this).children('td:first').css('width','230px');
    })

});