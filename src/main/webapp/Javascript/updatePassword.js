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

    password.keydown(function(){
        var e = e || window.event;
        if(e.keyCode === 40){
            newpassword.focus();
        }
    });

    newpassword.keydown(function(){
        var e = e || window.event;
        if(e.keyCode === 38){
            password.focus();
        } else if(e.keyCode === 40) {
            surepassword.focus();
        }
    });

    surepassword.keydown(function(){
        var e = e || window.event;
        if(e.keyCode === 38){
            newpassword.focus();
        }
    });

    $('#origin-password,#new-password,#sure-password').keyup(function(){
        var e = event || window.event;
        if(e.keyCode === 13){
            confirmpassword.click();
        }
        var passwordval = password.val().trim();
        var newpasswordval = newpassword.val().trim();
        var surepasswordval = surepassword.val().trim();
        if (3 < passwordval.length && passwordval.length < 16 && 3 < newpasswordval.length && newpasswordval.length < 16 && 3 < surepasswordval.length && surepasswordval.length < 16) {
            if (newpasswordval !== surepasswordval) {
                $('#sure-password').next().text('前后密码不一致');
                buttonInvalid();
            } else {
                butttonValid();
                $('#sure-password').next().text('');
            }
        }
        else if (newpasswordval !== surepasswordval){
            $('#sure-password').next().text('前后密码不一致');
            buttonInvalid();
            } else {
            $('#sure-password').next().text('');
            buttonInvalid();
            }
    });

    confirmpassword.click(function(){
        var passwordval = password.val().trim();
        var newpasswordval = newpassword.val().trim();
        $.ajax({
            type: "post",
            async: true,
            cache: true,
            url: "/User/updatePassword",
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            data: {
                "password": passwordval,
                "newPassword": newpasswordval
            },
            success: function(data){
                for(var key in data) {
                    switch(key) {
                        case 'passwordError':
                            password.next().text(data['passwordError']);break;
                        case 'newPasswordError':
                            newpassword.next().text(data['newPasswordError']);break;
                        case 'success':
                            password.next().text('');
                            newpassword.next().text('');
                            surepassword.next().text('');
                            password.val('');
                            newpassword.val('');
                            surepassword.val('');
                            $('.update-password').hide();
                            break;
                            default:alert('后台故障');
                    }
                }
            },
            error: function(){
                alert("后台数据传输错误，联系管理员");
            }
        })
    });

    $('.resetPassword-confirm').on('click',function(){
        window.open("/User/turnToPage");
    });
});
