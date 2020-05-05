$(function(){
    Date.prototype.Format = function(fmt) { // author: meizz
        var o = {
            "M+": this.getMonth() + 1, // 月份
            "d+": this.getDate(), // 日
            "h+": this.getHours(), // 小时
            "m+": this.getMinutes(), // 分
            "s+": this.getSeconds(), // 秒
            "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
            "S": this.getMilliseconds()// 毫秒
        };
        if (/(y+)/.test(fmt))
            {fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));}
        for ( var k in o)
            {if (new RegExp("(" + k + ")").test(fmt)) {fmt = fmt.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));}}
        return fmt;
    };

    function getCurrentTime() {
        return new Date().Format("yyyy-MM-dd hh:mm:ss");
    }

    $('.flex-permitUser').on('click',function(e){
        var area = $(".permitUser-Box");
        if(!area.is(e.target) && area.has(e.target).length === 0){
            $('.permitUser').hide();
        }
    });

    $('.permit').on('click',function(){
        var addId = $('.permitUser-Box').attr('data-addUserId');
        var friendMark = $('.addName').val().trim();
        $.ajax({
            type: "post",
            cache: true,
            async: true,
            contentType: "application/x-www-form-urlencoded",
            url: "/AddUser/permitUser",
            dataType: "json",
            data: {
                "addId": addId,
                "friendMark": friendMark,
                "agreeAddingTime": getCurrentTime()
            },
            success: function() {
                $('.conLeft ul li[data-addUserId=' + addId + ']').remove();
                $('.permitUser').hide();
            },
            error: function(){
                alert('数据传输错误，请联系管理员');
            }
        })
    });

    $('.reject').on('click',function(){
        var addId = $('.permitUser-Box').attr('data-addUserId');
        $.ajax({
            type: "post",
            cache: true,
            async: true,
            contentType: "application/x-www-form-urlencoded",
            url: "/AddUser/rejectAddUser",
            data: {
                "addId": addId
            },
            success: function() {
                $('.conLeft ul li[data-addUserId=' + addId + ']').remove();
                $('.permitUser').hide();
            },
            error: function(){
                alert('后台异常，请联系管理员');
            }
        })
    });
});
