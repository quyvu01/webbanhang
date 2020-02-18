$(document).ready(function () {
    $("#btnDangNhap").click(function () {
        $.ajax({
            url:"/com_quyvu_webbanhang_war_exploded/api/dangnhap",
            type:"GET",
            data:{
                email:$("#ipemail-login").val(),
                password:$("#ippassword-login").val()
            },
            success: function (value) {
                if(value == "true")
                    window.location = window.location.href.replace("login","");
                if(value == "false")
                    alert("Sai tên đăng nhập hoặc mật khẩu");
            }
        })
    });
    
    $("#hiden-span").on('DOMSubtreeModified', function () {
        alert("Change");
    });
    
    
    $("#btn-login").click(function () {
        $(this).addClass("actived");
        $("#btn-signup").removeClass("actived");
        $("#container-signup-pre").hide();
        $("#container-login-pre").show();
    });
    $("#btn-signup").click(function () {
        $(this).addClass("actived");
        $("#btn-login").removeClass("actived");
        $("#container-login-pre").hide();
        $("#container-signup-pre").show();
    });
})