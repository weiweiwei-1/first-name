$(function(){
    var loginEmail = $("#loginEmail");
    var loginPassword = $("#loginPassword");
    var emailError = $(".emailError");
    var passwordError = $(".passwordError");
    var registerButton = $("#register-confirm");
    var login = $("#login");

    function loginValid(){
        login.attr("disabled",false);
        login.css("background-color","#f40");
    }

    function loginInvalid(){
        login.attr("disabled",true);
        login.css("background-color","grey");
    }
    registerButton.click(function(){
        $("#content2").css("display","flex");
    });

    loginEmail.keyup(function(){
        var e = event||window.event;
        if(e.keyCode===40){
            loginPassword.focus();
        }
        if(e.keyCode===13) {
            if(login.attr("disabled")===false) {
                login.click();
            }
        }
        if(loginEmail.val().trim().length>60||loginEmail.val().trim().length<4) {
            emailError.text("邮箱长度不符合要求");
            loginInvalid();
        } else {
            emailError.text("");
        }
    });

    loginPassword.keyup(function(){
        var e = event||window.event;
       if(e.keyCode===38){
           loginEmail.focus();
       }
       if(e.keyCode===13){
           if(login.attr("disabled")===false){
               login.click();
           }
       }
       if(loginPassword.val().trim().length<4||loginPassword.val().trim().length>15) {
           passwordError.text("密码长度为4-15位");
           loginInvalid();
       } else {
           passwordError.text("");
       }
    });

    $('#loginEmail,#loginPassword').keyup(function(){
        if(loginEmail.val().trim().length&&loginPassword.val().trim().length) {
            if (emailError.text().length || passwordError.text().length) {
                loginInvalid();
            } else {
                loginValid();
            }
        } else {
                loginInvalid();
            }
    });


    login.click(function(){
        var email = loginEmail.val().trim();
        var password = loginPassword.val().trim();
        $.ajax({
            async:true,
            cache:true,
            type:"post",
            url:"/ChatPage/login",
            contentType:"application/x-www-form-urlencoded",
            dataType:"json",
            data:{
                "email":email,
                "password":password
            },
            success:function(data){
                if(JSON.stringify(data) === "{}"){
                    window.location.href = "ChatPage/main";
                    // default:window.open("ForAllList/ForUserAndItems");break;  在新打开的页面进行跳转
                    // default:window.location.replace("ForAllList/ForUserAndItems");break;原来窗口进行跳转替换，不能返回
                } else {
                    for(key in data){
                        if (key !==""){
                            switch(key) {
                                case "NullAccountError": emailError.text(data["NullAccountError"]); passwordError.text("");break;
                                case "UnknownAccountError": emailError.text(data["UnknownAccountError"]); passwordError.text("");break;
                                case "NullCredentialsError": emailError.text(""); passwordError.text(data["NullCredentialsError"]);break;
                                case "IncorrectCrdentialsError": emailError.text(""); passwordError.text(data["IncorrectCrdentialsError"]);break;
                                default:alert("后台出现异常");
                            }
                        }

                    }
                }

            },
            error:function () {
                alert("ajax数据注入失败！");
            }
        });
    });

});
