$(function(){
    $("#register").click(function(){
        var username = $("#registerUsername").val();
        var address = $("#registerPassword").val();
        var sureAddress = $("#passwordConfirm").val();
        $.ajax({
            saync:true,
            cache:true,
            url:"ForAllList/register",
            contentType:"application/x-www-form-urlencoded",
            dataType:"json",
            data:{
                "username":username,
                "address":address,
                "sureAddress":sureAddress
            },
            success:function(data){
                switch(data["Symbol"]) {
                    case "0":$("#usernameError").text(data["usernameError"]);
                    $("#passwordError").text(data["addressError"]);
                    $("#passwordConfirmError").text(data["sureAddressError"]);
                    break;
                    case "1":window.location.href = "ForAllList/ForUserAndItems";break;
                    case "2":alert("后台出现异常，请联系管理员");break;
                }
            },
            error:function(data){
                alert("数据传输失败，请联系管理员后者查看后台情况");
            }
        });
    });
});