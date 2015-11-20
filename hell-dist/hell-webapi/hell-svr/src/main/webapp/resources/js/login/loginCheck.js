/**
 * Created by ZGY on 15/11/20.
 */
/* 该文件用于实现用户登录，包括cookie，token等验证。 */

$(function(){
    /* 登陆按钮点击事件 */
    $("#login_butt").click(function(){
        login();
    });
})
/* 检测浏览器是否禁用cookie。如果禁用，则直接登出，重定向至登录界面 */
function is_cookie_used(){
    var flag = navigator.cookieEnabled;
    if(!flag){
        location.assign("/pages/login/login.jsp");
    }
}

/* 检测用户登录时参数是否符合要求 */
function param_check() {
    if ($("#loginname").val() == "") {
        alert("用户名不能为空！");
        $("#loginname").focus();
        return false;
    }
    if ($("#password").val() == "") {
        alert("密码不能为空");
        $("#password").focus();
        return false;
    }
    return true;
}

/* 登录 */
function login() {
    //用户名
    var user_name = $("#username").val();
    alert(user_name);
    //密码
    var password = hex_md5($("#password").val());
    $.ajax({
        type:"POST",
        url:"${rt}/login",
        data:{
            user_name:user_name,
            password:password
        },
        datatype:"json",
        success:function(data){
            //将cookie中的token存入cookie
            alert(123);
        }
    })
}

