$(function(){
    $("#register-confirm").click(function(){
        $("#content2").css("display","flex");
    });

    $("#close").click(function(){
        $("#content2").css("display","none");
    });

    $("#loginUsername").keyup(function(e){
        var e = e||window.event;
        if(e.keyCode==40){
            $("#loginPassword").focus();
        }
    });

    $("#loginPassword").keyup(function(e){
       var e= e||window.event;
       if(e.keyCode==38){
           $("#loginUsername").focus();
       }
    });

    $("#login").click(function(){
        var loginUsername = $("#loginUsername").val();
        var loginPassword = $("#loginPassword").val();
        $.ajax({
            async:true,
            cache:true,
            url:"ForAllList/login",
            contentType:"application/x-www-form-urlencoded",
            dataType:"json",
            data:{
                "username":loginUsername,
                "address":loginPassword
            },
            success:function(data){
                for(key in data){
                switch(key) {
                    case ("NullAccountError"): $(".usernameError").text(data["NullAccountError"]); $(".passwordError").text("");break;
                    case ("UnknownAccountError"): $(".usernameError").text(data["UnknownAccountError"]); $(".passwordError").text("");break;
                    case ("NullCredentialsError"): $(".usernameError").text(""); $(".passwordError").text(data["NullCredentialsError"]);break;
                    case ("IncorrectCrdentialsError"): $(".usernameError").text(""); $(".passwordError").text(data["IncorrectCrdentialsError"]);break;
                    // default:window.open("ForAllList/ForUserAndItems");break;  在新打开的页面进行跳转
                    //default:window.location.replace("ForAllList/ForUserAndItems");break; 原来窗口进行跳转替换，不能返回
                    default: window.location.href = "ForAllList/ForUserAndItems";break;
                }
                }
            },
            error:function (data) {
                alert("ajax数据注入失败！");
            }
        });
    });

});
