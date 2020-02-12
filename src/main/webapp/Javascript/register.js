$(function(){
    var sendCode = $("#sendCode");
    var register = $("#register");
    var registeremail = $("#registerEmail");
    var registerPassword = $("#registerPassword");
    var passwordConfirm = $("#passwordConfirm");
    var emailCode = $("#emailCode");
    var emailError = $("#emailError");
    var passwordError = $("#passwordError");
    var passwordConfirmError = $("#passwordConfirmError");
    var confirmcodeError = $("#confirmcodeError");
    var close = $("#close");
    close.click(function(){
        $("#content2").css("display","none");
    });

    function buttonValid() {
        register.attr("disabled",false);
        register.css("background-color","#f40");
    }

    function buttonInvalid() {
        register.attr("disabled",true);
        register.css("background-color","grey");
    }

    function sendCodeValid() {
        sendCode.attr("disabled",false);
        sendCode.css("background-color","#317ef3");
        sendCode.text("发送验证码");
    }

    function sendCodeInvalid() {
        sendCode.attr("disabled",true);
        sendCode.css("background-color","grey");
        sendCode.text("2分倒计时");
    }

    function inputClearAndClose() {
        close.click();
        $("#registerEmail,#registerPassword,#passwordConfirm,#emailCode").val("");
    }

    registeremail.keyup(function(){
        var e = event||window.event;
        if(e.keyCode===40){
            registerPassword.focus();
        }
        var email = registeremail.val().trim();
        if(email.length>60 || email.length<4){
            emailError.text("邮箱长度4-60位");
            buttonInvalid();
        } else {
            emailError.text("");
        }
    });

    registerPassword.keyup(function(){
        var e= event||window.event;
        if(e.keyCode===40){
            passwordConfirm.focus();
        } else if(e.keyCode===38) {
            registeremail.focus();
        }
        if(registerPassword.val().trim().length<4||registerPassword.val().trim().length>15) {
            passwordError.text("密码长度4-15位");
            buttonInvalid();
        } else if(registerPassword.val() !== passwordConfirm.val()) {
            passwordError.text("");
            passwordConfirmError.text("前后密码不一致");
            buttonInvalid();
        } else {
            passwordError.text("");
            passwordConfirmError.text("")
        }
    });

    passwordConfirm.keyup(function(){
        var e= event||window.event;
        if(e.keyCode===40){
            emailCode.focus();
        } else if(e.keyCode===38) {
            registerPassword.focus();
        }
        var password = registerPassword.val();
        var surePassword = passwordConfirm.val();
        if(password !== surePassword){
            passwordConfirmError.text("前后密码不一致");
            buttonInvalid();
        } else{
            passwordConfirmError.text("");
        }
    });

    emailCode.keyup(function(){
        var e= event||window.event;
        if(e.keyCode===38){
            passwordConfirm.focus();
        }
        if(emailCode.val().trim().length!==6){
            confirmcodeError.text("验证码格式错误");
            buttonInvalid();
        } else {
            confirmcodeError.text("");
        }
    });

    $('#registerEmail,#registerPassword,#passwordConfirm,#emailCode').keyup(function(){
        if(registeremail.val().trim().length&&registerPassword.val().trim().length&&passwordConfirm.val().trim().length&&emailCode.val().trim().length) {
            if(emailError.text().length || passwordError.text().length || passwordConfirmError.text().length || confirmcodeError.text().length) {
                buttonInvalid();
            } else {
                    buttonValid();
                }
            } else {
        buttonInvalid();
        }
    });

    sendCode.click(function(){
        sendCodeInvalid();
        // sendCode.text("不发送");
        var email = registeremail.val().trim();
        $.ajax({
            async:true,
            cache:true,
            type:"post",
            url:"ChatPage/sendCode",
            contentType:"application/x-www-form-urlencoded;charset=utf-8",
            dataType:"text",
            data:{
                "email":email
            },
            success:function(data) {
                if(data === "") {
                    emailError.text("");
                    sendCode.text("倒计时中");
                    setTimeout(sendCodeValid,120000);
                } else {
                    emailError.text(data);
                    buttonInvalid();
                    sendCodeValid();
                }
            },
            error:function(){
                alert("出现异常，请联系管理员");
            }
        });
    });

    register.click(function(){
        var email = registeremail.val().trim();
        var password = registerPassword.val().trim();
        var confirmCode = emailCode.val().trim();
        $.ajax({
            async:true,
            cache:true,
            url:"ChatPage/register",
            contentType:"application/x-www-form-urlencoded",
            dataType:"json",
            data:{
                "email":email,
                "password":password,
                "confirmCode":confirmCode
            },
            success:function(data){
                switch(data["Symbol"]) {
                    case "0":emailError.text(data["emailError"]);
                    passwordError.text(data["passwordError"]);
                    confirmcodeError.text(data["confirmCodeError"]);
                    buttonInvalid();
                    break;
                    case "1":inputClearAndClose();break;
                    case "2":alert("后台数据库异常，请联系管理员");buttonInvalid();break;
                }
            },
            error:function(){
                alert("数据传输失败，请联系管理员后查看后台情况");
            }
        });
    });

});