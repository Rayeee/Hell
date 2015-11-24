/**
 * Created by ZGY on 15/11/20.
 */
/* 该文件用于实现用户登录，包括cookie，token等验证。 */

/* 本机调用地址 */
window.base_url = "http://127.0.0.1:8080/hell-webapi"

$(function () {
    $("#username").focus();
    /* 登陆按钮点击事件 */
    $("#login_butt").click(function () {
        login();
    });

    //用户名input绑定事件
    $("#username").bind("keypress", function (event) {
        if (event.keyCode == "13") {
            $("#password").focus();
        }
    });
    //密码input绑定回车事件
    $("#password").bind("keypress", function (event) {
        if (event.keyCode == "13") {
            login();
        }
    });
})

/* 检测用户登录时参数是否符合要求 */
function param_check() {
    if ($("#username").val() == "") {
        alert("用户名不能为空！");
        $("#username").focus();
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
    if (param_check()) {
        //用户名
        var userName = $("#username").val();
        //密码
        var password = hex_md5($("#password").val());
        var request = {
            mobile: userName,
            password: password
        };
        var requestStr = $.toJSON(request);
        $.ajax({
            type: "POST",
            url: base_url + "/login",
            data: requestStr,
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                //将cookie中的token存入cookie
                var code = data.code;
                if (code == 200) {
                    //验证成功
                    var token = data.data.token;
                    localStorage.setItem(userName, token);
                    document.cookie = userName + "=" + token;
                    toIndex();
                } else if (code == 50009) {
                    //验证失败
                    alert("账号密码错误");
                    $("#password").val("");
                    $("#password").focus();
                } else if (code == 50010) {
                    alert("该手机尚未注册");
                    $("#username").focus();
                }
            }
        });
    }
}

function toIndex() {
    location.assign("/pages/index.jsp");
}


/* 检测浏览器是否禁用cookie。如果禁用，则直接登出，重定向至登录界面 */
function is_cookie_used() {
    var flag = navigator.cookieEnabled;
    if (!flag) {
        location.assign("/pages/login/login.jsp");
    }
}

