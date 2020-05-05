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
        var e = event || window.event;
        if(e.keyCode === 40){
            loginPassword.focus();
        }
        if(e.keyCode === 13) {
                login.click();
        }
        if(loginEmail.val().trim().length > 25 || loginEmail.val().trim().length < 4) {
            emailError.text("邮箱长度不符合要求");
            loginInvalid();
        } else {
            emailError.text("");
        }
    });

    loginPassword.keyup(function(){
       var e = event || window.event;
       if(e.keyCode === 38){
           loginEmail.focus();
       } else if(e.keyCode === 13){
               login.click();
       }
       if(loginPassword.val().trim().length < 4 || loginPassword.val().trim().length > 15) {
           passwordError.text("密码长度为4-15位");
           loginInvalid();
       } else {
           passwordError.text("");
       }
    });

    $('#loginEmail,#loginPassword').keyup(function(){
        if(loginEmail.val().trim().length && loginPassword.val().trim().length) {
            if (emailError.text().length || passwordError.text().length) {
                loginInvalid();
            } else {
                loginValid();
            }
        } else {
                loginInvalid();
            }
    });

    var rememberMe = $('#rememberMe');
    login.click(function(){
        var email = loginEmail.val().trim();
        var password = loginPassword.val().trim();
        var rememberMeval = "0";
        if(rememberMe.is(":checked")){
            rememberMeval = rememberMe.val();
        }
        $.ajax({
            async: true,
            cache: true,
            type: "post",
            url: "/ChatPage/login",
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            data: {
                "email": email,
                "password": password,
                "rememberMe": rememberMeval
            },
            success: function(data){
                if(JSON.stringify(data) === "{}"){
                    window.location.href = "ChatPage/main";
                } else {
                    for(key in data){
                        if (key !== ""){
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
            error: function () {
                alert("ajax数据注入失败！");
            }
        });
    });

});
