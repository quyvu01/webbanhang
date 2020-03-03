$(document).ready(function () {
    TinhTongTienGioHang();
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
    $(".btn-Plus").click(function () {        
        var value = parseInt($(this).parent().find(".spCount").text(), 10) + 1;
        $(this).parent().find(".spCount").text(value);
    });
    $(".btn-Sub").click(function () {
        var value = parseInt($(this).parent().find(".spCount").text(), 10) - 1;
        value = value <= 1 ? 1 : value;
        $(this).parent().find(".spCount").text(value);
    });
    $(".btn-giohang").click(function () {
        let mamau = $(this).closest("tr").find(".mamau").attr("data-mamau");
        let tenmau=$(this).closest("tr").find(".mamau").text();
        let masize = $(this).closest("tr").find(".masize").attr("data-masize");
        let tensize=$(this).closest("tr").find(".masize").text();
        let tensanpham=$("#tensanpham").text();
        let masanpham=$("#tensanpham").attr("data-masanpham");
        let giatien=$("#giatien").attr("data-giatien");
        let soluong=parseInt($(this).parent().find(".spCount").text());
        let machitietsanpham=$(this).attr("data-machitietsanpham");
        $.ajax({
            url:"/com_quyvu_webbanhang_war_exploded/api/themgiohang",
            type:"GET",
            data:{
                mamau: mamau,
                tenmau: tenmau,
                masize:masize,
                tensize: tensize,
                tensanpham:tensanpham,
                masanpham: masanpham,
                giatien: giatien,
                soluong: soluong,
                machitietsanpham:machitietsanpham
            },
            success: function (value) {
                if(value=="0"){
                    $(".product-Count").hide();
                }
                else {
                    $(".product-Count").show();
                    $(".product-Count").html("<span>"+value+"</span>");
                    $("#product-Count").css("display","block");
                }
            }
        })
    });
    
    $(".btn-remove").click(function () {
        let mamau = $(this).closest("tr").find(".mamau").attr("data-mamau");
        let masize = $(this).closest("tr").find(".masize").attr("data-masize");
        let masanpham=$(this).closest("tr").find(".tensanpham").attr("data-masanpham");
        $.ajax({
            url:"/com_quyvu_webbanhang_war_exploded/api/xoasanpham",
            type:"GET",
            data:{
                mamau: mamau,
                masize:masize,
                masanpham: masanpham,
            },
            success: function (value) {
                if(value=="0"){
                    $(".product-Count").hide();
                    $("#product-Count").hide();
                }
                else {
                    $(".product-Count").show();
                    $(".product-Count").html("<span>"+value+"</span>");
                    $("#product-Count").css("display","block");
                }
            }
        })
        $(this).closest("tr").remove();
        TinhTongTienGioHang();
    });

    $("#scroll-end").click(function () {
        let temp=document.getElementById("page-end");
        temp.scrollIntoView();
    });
    
    $(".product-Change").change(function () {
        let soluong=parseInt($(this).val());
        let giatien=parseInt(ChangeCurrentToString($(this).closest("tr").find(".giatien").text()));
        
        let item_price=(soluong*giatien);
        $(this).closest("tr").find(".items-price").html(ChangeStringToCurrent(item_price));
        
        TinhTongTienGioHang();

        let mamau = $(this).closest("tr").find(".mamau").attr("data-mamau");
        let masize = $(this).closest("tr").find(".masize").attr("data-masize");
        let masanpham=$(this).closest("tr").find(".tensanpham").attr("data-masanpham");
        $.ajax({
            url:"/com_quyvu_webbanhang_war_exploded/api/updategiohang",
            type:"GET",
            async:true,
            data:{
                mamau: mamau,
                masize:masize,
                masanpham: masanpham,
                soluong: soluong
            },
            success: function (value) {
                
            }
        })
    });
    
    function ChangeCurrentToString(Current) {
        let temp=Current.replace(/[,.]/g,'');
        return temp;
        
    }
    function ChangeStringToCurrent(String) {
        let temp = (parseInt(String)).toFixed(1).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString().replace('.','');
        return temp.substr(0, temp.length-1);
    }
    
    function TinhTongTienGioHang() {
        let total_price=0;
        $(".items-price").each(function () {
            let current=ChangeCurrentToString($(this).text());
            let giatien=parseInt(current);
            total_price+=giatien;
        });
        $(".total-price").html(ChangeStringToCurrent(total_price));
    };
    $(".themsanpham-page").click(function () {
        let page=parseInt($(this).text());
        $(".themsanpham-page").removeClass("pageIsOnActive");
        $(this).addClass("pageIsOnActive");
        $.ajax({
            url:"/com_quyvu_webbanhang_war_exploded/api/themsanpham/"+page,
            type:"GET",
            async:true,
            data:{
                page:page
            },
            success: function (value) {
                let tbodysanpham=$(".table-sanpham").find("tbody");
                tbodysanpham.empty();
                tbodysanpham.append(value);
            }
        })        
    });
    $(".btn-remove-product").click(function () {
        $(".table-sanpham > tbody input:checked").each(function () {
            let productId=parseInt($(this).val());
            this.closest("tr").remove();
            $.ajax({
                url:"/com_quyvu_webbanhang_war_exploded/api/removeproduct",
                type:"GET",
                data:{
                    productId:productId
                },
                success: function (value) {
                    
                }
            })
        });
    });
    $(".checkbox-all").change(function () {
        if(this.checked){
            $(".table-sanpham input:checkbox").prop('checked',true);
        }
        else 
            $(".table-sanpham input:checkbox").prop('checked',false);
    })
    $(".checkbox-item").change(function () {
        $(".table-sanpham > tbody input:checkbox").each(function () {
            if(!this.checked)
                $(".checkbox-all").prop('checked',false);
        })
    });
    let hinhsanpham;
    $("#hinhanh").change(function (event) {
        let files=event.target.files;
        hinhsanpham=files[0].name;
        let forms = new FormData();
        forms.append("file", files[0]);
        $.ajax({
            url:"/com_quyvu_webbanhang_war_exploded/api/uploadFile",
            type:"POST",
            data:forms,
            contentType: false,
            processData: false,
            enctype:"multipart/form-data",
            success: function (value) {

            }
        })
    });
    $("body").on('click',".btn-themchitiet",function () {
        let chitietclone=$("#themchitietsanpham").clone();
        chitietclone.removeAttr("id");
        $("#clonechitietsanpham").append(chitietclone);
        
    });
    $("#btn-add-product").click(function (event) {
        event.preventDefault();
        let productSerialize=$("form").serializeArray();
        let json = {};
        $.each(productSerialize, function(i, field){
            json[field.name]=field.value;
        });
        
        let arrayDetail=[];
        
        $(".themchitietsanpham").each(function () {
            if($(this).attr('id')!="themchitietsanpham"){
                let objecDetail={};
                let productSize = $(this).find(".productSize").val();
                let productColor = $(this).find(".productColor").val();
                let productCount = $(this).find(".productCount").val();
                objecDetail[$(this).find(".productSize").attr("dataId")]=productSize;
                objecDetail[$(this).find(".productColor").attr("dataId")]=productColor;
                objecDetail[$(this).find(".productCount").attr("dataId")]=productCount;
                arrayDetail.push(objecDetail);
            }
        })
        json["setChiTietSanPham"]=arrayDetail;
        json["hinhsanpham"]=hinhsanpham;
        $.ajax({
            url:"/com_quyvu_webbanhang_war_exploded/api/addproduct",
            type:"POST",
            data:{
                dataJson:JSON.stringify(json)
            },
            success: function (value) {
                
            }
        })
    })
})