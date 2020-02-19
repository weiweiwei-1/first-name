$(function(){
    $('.addfriendImg').on('click',function(){
        $('.conLeft ul').load(
            "/AddUser/showAddUser",
            function(){
            }
        )
    });
})
