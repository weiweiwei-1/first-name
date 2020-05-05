$(function(){
    var username = $('#username');
    var company = $('#company');
    var school = $('#school');
    var age = $('#age');
    var sex = $('#sex');
    var occupation = $('#occupation');
    var hobby = $('#hobby');
    var introduction = $('#introduction-content');
    var usernameval = username.val().trim();
    var companyval = company.val().trim();
    var schoolval = school.val().trim();
    var ageval = age.val().trim();
    var sexval = sex.val().trim();
    var occupationval = occupation.val().trim();
    var hobbyval = hobby.val().trim();
    var introductionval = introduction.val().trim();
    $('.userBox').on('click',function(e){
        var area = $(".userCenter");
        if(!area.is(e.target) && area.has(e.target).length === 0){
            $(this).hide();
        }
    });

    $('.img-Box').on('click',function(e){
        var img = $('.preview-img');
        if(!img.is(e.target) && img.has(e.target).length === 0){
            $(this).hide();
        }
    });

    $('.update-password').on('click',function(e){
        var img = $('.update-content');
        if(!img.is(e.target) && img.has(e.target).length === 0){
            $(this).hide();
        }
    });


    //图片预览
    $('#preview').on('click',function(){
        $('.preview-img').attr("src",$('.user-img').attr('src'));
        $('.img-Box').show();
    });

    $('#updatePassword').on('click',function(){
        $('.update-password').show();
    });


    $(".img-block").on("change", ".img-file",togglePic ); //图片替换
    function togglePic(){
        var srcs = getObjectURL(this.files[0]); //获取路径
        $('.user-img').attr("src", srcs);//展示图片
    }

    $('.close-block span').on('click',function(){
        $('.update-password').hide();
    });

    function getObjectURL(file) { //获取上传的URL
        var url = null;
        if (window.createObjectURL !== undefined) {
            url = window.createObjectURL(file)
        } else if (window.URL !== undefined) {
            url = window.URL.createObjectURL(file)
        } else if (window.webkitURL !== undefined) {
            url = window.webkitURL.createObjectURL(file)
        }
        return url;
    }

    //图片删除
    $('#delete').on('click',function(){
        if(!!window.ActiveXObject || "ActiveXObject" in window){
            // $('.img-file').replaceWith($('.img-file').clone(true));
            $('.user-img').attr("src",$('.headImg img').attr('src'));
        } else{
            $('.img-file').val("");
            $('.user-img').attr("src",$('.headImg img').attr('src'));
        }
    });

    var edit = $('#edit');
    var edText = $('.edit-text');
    edit.on('click',function(){
        if(edit.text() === '编辑') {
            edit.text('取消');
            edText.attr('readonly',false);
            edText.css({'border': '1px solid deepskyblue','outline': 'none'});
            $('#introduction-content').attr('readonly',false);
        } else if($('#edit').text() === '取消') {
            username.val(usernameval);
            company.val(companyval);
            school.val(schoolval);
            age.val(ageval);
            sex.val(sexval);
            occupation.val(occupationval);
            hobby.val(hobbyval);
            introduction.val(introductionval);
            edit.text('编辑');
            edText.css({'border': '1px transparent','outline': 'none'});
            edText.attr('readonly',true);
            $('#introduction-content').attr('readonly',true);
        }
    });

    $('#save').on('click',function(){
        var newusername = username.val().trim();
        var newcompany = company.val().trim();
        var newschool = school.val().trim();
        var newage = age.val().trim();
        var newsex = sex.val().trim();
        var newoccupation = occupation.val().trim();
        var newhobby = hobby.val().trim();
        var newintroduction = introduction.val().trim();
        var formData = new FormData();
        var file = $('.img-file')[0].files[0];
        formData.append("username",newusername);
        formData.append("company",newcompany);
        formData.append("school",newschool);
        formData.append("age",newage);
        formData.append("sex",newsex);
        formData.append("occupation",newoccupation);
        formData.append("hobby",newhobby);
        formData.append("introduction",newintroduction);
        formData.append("file",file);
        $.ajax({
            async: true,
            type: "POST",
            url: "/User/updateUser",
            cache: false,
            contentType: false,
            processData: false,
            dataType: "json",
            data: formData,
            success: function(data){
                switch(data['symbol']){
                    case '0':
                        edText.attr("readonly",false);
                        edit.text('取消');
                        $('.introduction-content').css("readonly",false);
                        if(typeof data['usernameError'] !== 'undefined'){$('#username').css('border','1px solid red');}
                        if(typeof data['sameUsernameError'] !== 'undefined'){$('#username').css('border','1px solid red');alert('已存在该用户名，请重新输入');}
                        if(typeof data['companyError'] !== 'undefined'){$('#company').css('border','1px solid red')}
                        if(typeof data['schoolError'] !== 'undefined'){$('#school').css('border','1px solid red')}
                        if(typeof data['ageError'] !== 'undefined'){$('#age').css('border','1px solid red')}
                        if(typeof data['sexError'] !== 'undefined'){$('#sex').css('border','1px solid red')}
                        if(typeof data['occupationError'] !== 'undefined'){$('#occupation').css('border','1px solid red')}
                        if(typeof data['hobbyError'] !== 'undefined'){$('#hobby').css('border','1px solid red')}
                        if(typeof data['introductionError'] !== 'undefined'){$('#introduction').css('border','1px solid red')}
                        break;
                    case '1':
                        $('.internetName').text(newusername);
                        edit.text('编辑');
                        edText.attr("readonly",true);
                        $('#introduction-content').attr('readonly',true);
                        edText.css("border","0");
                        usernameval = newusername;
                        companyval = newcompany;
                        schoolval = newschool;
                        ageval = newage;
                        sexval = newsex;
                        occupationval = newoccupation;
                        hobbyval = newhobby;
                        introductionval = newintroduction;
                        $('.overflow-hide .recomendContent').load('/AddUser/SystemRecommend',
                        function(){});
                        if(typeof data['photo'] !== 'undefined'){
                            $('.BoxHead .headImg img').attr("src","/web-store/" + data['photo']);
                            $('.user-img').attr("src","/web-store/" + data['photo']);
                            if($('.RightCont').children('.clearfloat')){
                                $('.right .chat-avatars img').attr('src',"/web-store/" + data['photo']);
                            }

                        }
                        break;
                }
            },
            error: function(){
                alert('后台出现错误，请联系管理员');
            }
        });
    });

    $('#logout').on('click',function(){
        $.post(
            "/ChatPage/logout",
            function () {
                window.location.href = "/";
            }
        )
    });
});