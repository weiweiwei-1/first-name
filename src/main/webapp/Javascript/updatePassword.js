$(function(){
    var password = $('#origin-password');
    var newpassword = $('#new-password');
    var surepassword = $('#sure-password');
    var confirmpassword = $('#confirm-updatepassword');

    function butttonValid() {
        confirmpassword.attr("disabled",false);
        confirmpassword.css('background-color','#f40');
    }

    function buttonInvalid() {
        confirmpassword.attr('disabled',true);
        confirmpassword.css('background-color','grey');
    }

    $('#origin-password,#new-password,#sure-password').keyup(function(){
        var passwordval = password.val().trim();
        var newpasswordval = newpassword.val().trim();
        var surepasswordval = surepassword.val().trim();
        if (3 < passwordval.length < 16 && 3 < newpasswordval < 16 && 3 < surepassword < 16) {
            if (newpasswordval!==surepasswordval) {
                $('#sure-password span').text('前后密码不一致');
                buttonInvalid();
            }
        }
    });

    $('#save').click(function(){
        var passwordval = password.val().trim();
        var newpasswordval = newpassword.val().trim();
        $.ajax({
            type:"post",
            async:true,
            cache:true,
            url:"/User/updatePassword",
            contentType:"application/x-www-form-urlencoded",
            dataType:"json",
            data:{
                "password":passwordval,
                "newPassword":newpasswordval
            },
            success:function(data){
                for(var key in date) {
                    switch(key) {
                        case 'passwordError':$('#origin-password span').text(data['passwordError']);break;
                        case 'newPasswordError':$('#new-password span').text(data['newPasswordError']);break;
                        case 'success':$('#origin-password').val('');
                        $('#new-password').val('');
                        $('#sure-password').val('');
                        $('.updatepassword-block').css('display','none');
                        break;
                        default:alert('后台故障');
                    }
                }
            },
            error:function(){
                alert("后台数据传输错误，联系管理员");
            }
        })
    });
});
