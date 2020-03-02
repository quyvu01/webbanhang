<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
    <title>Pooled Admin Panel Category Flat Bootstrap Responsive Web Template | Home :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resource/bootstrap-4.4.1/css/bootstrap.min.css"/>" rel='stylesheet' type='text/css' />
    <!-- Custom CSS -->
    <link href="<c:url value="/resource/bootstrap-4.4.1/css/style.css"/>" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="<c:url value="/resource/bootstrap-4.4.1/css/morris.css"/>" type="text/css"/>
    <!-- Graph CSS -->
    <link href="<c:url value="/resource/bootstrap-4.4.1/css/font-awesome.css"/>" rel="stylesheet">
    <!-- jQuery -->
    <script src="<c:url value="/resource/JS/jquery-3.4.1.min.js"/>"></script>
    <!-- //jQuery -->
    <link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
    <link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <!-- lined-icons -->
    <link rel="stylesheet" href="<c:url value="/resource/bootstrap-4.4.1/css/icon-font.min.css"/>" type='text/css' />
    <jsp:include page="header.jsp"></jsp:include>
    <!-- //lined-icons -->
</head>
<body>
<div class="page-container">
    <!--/content-inner-->
    <div class="left-content">
        <div class="row">
            <div class="col-md-7 col-sm-12 row">
                <div class="col-md-6">
                    <h3 style="margin-top: 20px;">TẤT CẢ SẢN PHẨM</h3>
                </div>
                <div class="col-md-6">
                    <a class="btn btn-danger btn-remove-product" style="margin-top: 20px;">XÓA SẢN PHẨM</a>
                </div>
                
                <table class="table table-sanpham">
                    <thead>
                    <tr>
                        <td>
                            <div>
                                <input class="checkbox-all" type="checkbox">
                            </div>
                        </td>
                        <td>Tên sản phẩm</td>
                        <td>Giá tiền</td>
                        <td>Giành cho(Nam/Nữ)</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="danhsachsanpham" items="${danhsachsanpham}">
                        <tr>
                            <td>
                                <div>
                                    <input class="checkbox-item" type="checkbox" value="${danhsachsanpham.masanpham}">
                                </div>
                            </td>
                            <td>${danhsachsanpham.tensanpham}</td>
                            <td>${danhsachsanpham.giatien}</td>
                            <td>${danhsachsanpham.danhcho}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <c:forEach var="page" begin="${1}" end="${tongsotrang}">
                                <li style="cursor: pointer" class="page-item"><a class="page-link themsanpham-page">${page}</a></li>
                            </c:forEach>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="col-md-5 col-sm-12" style="margin-top: 20px">
                <div class="form-group">
                    <label>Tên sản phẩm: </label><input class="form-control" name="tensp" placeholder="Nhập tên sản phẩm"><br/>
                    <label>Tên danh mục: </label>
                    <select name="madanhmuc" class="form-control">
                        <c:forEach var="danhmuc" items="${listdanhmucsanpham}">
                            <option value="${danhmuc.madanhmuc}">${danhmuc.tendanhmuc}</option>
                        </c:forEach>
                    </select>
                    <label>Giá tiền: </label><input class="form-control" name="giatien" placeholder="Nhập giá tiền"><br/>
                    <label>Mô tả: </label><textarea class="form-control" name="mota" placeholder="Mô tả sản phẩm"></textarea><br/>
                    <label>Hình sản phẩm: </label><input id="hinhanh" type="file" class="form-control" name="hinhanh" placeholder="Nhập giá tiền"><br/>
                    <label>Dành cho Nam/Nữ: </label>
                    <select name="danhcho" class="form-control">
                        <option value="nam">Nam</option>
                        <option value="nu">Nữ</option>
                    </select>
                    <div style="text-align: center; margin-top: 30px">
                        <a class="btn btn-success btn-add-product" style="margin-top: 20px;">THÊM SẢN PHẨM</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--//content-inner-->
    <!--/sidebar-menu-->
    <div class="sidebar-menu">
        <header class="logo1">
            <a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a>
        </header>
        <div style="border-top:1px ridge rgba(255, 255, 255, 0.15)"></div>
        <div class="menu">
            <ul id="menu" >
                <li><a href="dashboard.jsp"><i class="fa fa-tachometer"></i> <span>Dashboard</span><div class="clearfix"></div></a></li>
                <li id="menu-academico" ><a href="inbox.html"><i class="fa fa-envelope nav_icon"></i><span>Inbox</span><div class="clearfix"></div></a></li>
                <li><a href="gallery.html"><i class="fa fa-picture-o" aria-hidden="true"></i><span>Gallery</span><div class="clearfix"></div></a></li>
                <li id="menu-academico" ><a href="charts.html"><i class="fa fa-bar-chart"></i><span>Charts</span><div class="clearfix"></div></a></li>
                <li id="menu-academico" ><a href="#"><i class="fa fa-list-ul" aria-hidden="true"></i><span> Short Codes</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
                    <ul id="menu-academico-sub" >
                        <li id="menu-academico-avaliacoes" ><a href="icons.html">Icons</a></li>
                        <li id="menu-academico-avaliacoes" ><a href="typography.html">Typography</a></li>
                        <li id="menu-academico-avaliacoes" ><a href="faq.html">Faq</a></li>
                    </ul>
                </li>
                <li id="menu-academico" ><a href="errorpage.html"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i><span>Error Page</span><div class="clearfix"></div></a></li>
                <li id="menu-academico" ><a href="#"><i class="fa fa-cogs" aria-hidden="true"></i><span> UI Components</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
                    <ul id="menu-academico-sub" >
                        <li id="menu-academico-avaliacoes" ><a href="button.html">Buttons</a></li>
                        <li id="menu-academico-avaliacoes" ><a href="grid.html">Grids</a></li>
                    </ul>
                </li>
                <li><a href="tabels.html"><i class="fa fa-table"></i>  <span>Tables</span><div class="clearfix"></div></a></li>
                <li><a href="maps.html"><i class="fa fa-map-marker" aria-hidden="true"></i>  <span>Maps</span><div class="clearfix"></div></a></li>
                <li id="menu-academico" ><a href="#"><i class="fa fa-file-text-o"></i>  <span>Pages</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
                    <ul id="menu-academico-sub" >
                        <li id="menu-academico-boletim" ><a href="calendar.html">Calendar</a></li>
                        <li id="menu-academico-avaliacoes" ><a href="signin.html">Sign In</a></li>
                        <li id="menu-academico-avaliacoes" ><a href="signup.html">Sign Up</a></li>
                    </ul>
                </li>
                <li><a href="#"><i class="fa fa-check-square-o nav_icon"></i><span>Forms</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
                    <ul>
                        <li><a href="input.html"> Input</a></li>
                        <li><a href="validation.html">Validation</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="clearfix"></div>
</div>
<script>
    var toggle = true;
    $(".sidebar-icon").click(function() {
        if (toggle)
        {
            $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
            $("#menu span").css({"position":"absolute"});
        }
        else
        {
            $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
            setTimeout(function() {
                $("#menu span").css({"position":"relative"});
            }, 400);
        }
        toggle = !toggle;
    });
</script>
<!--js -->
<script src="<c:url value="/resource/JS/jquery.nicescroll.js"/>"></script>
<script src="<c:url value="/resource/JS/scripts.js"/>"></script>
<%--<script src="<c:url value="/resource/JS/custom.js"/>"></script>--%>
<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resource/JS/bootstrap.min.js"/>"></script>
<!-- /Bootstrap Core JavaScript -->
<!-- morris JavaScript -->
<script src="<c:url value="/resource/JS/raphael-min.js"/>"></script>
<script src="<c:url value="/resource/JS/morris.js"/>"></script>
<script>
    $(document).ready(function() {
        //BOX BUTTON SHOW AND CLOSE
        jQuery('.small-graph-box').hover(function() {
            jQuery(this).find('.box-button').fadeIn('fast');
        }, function() {
            jQuery(this).find('.box-button').fadeOut('fast');
        });
        jQuery('.small-graph-box .box-close').click(function() {
            jQuery(this).closest('.small-graph-box').fadeOut(200);
            return false;
        });

        //CHARTS
        function gd(year, day, month) {
            return new Date(year, month - 1, day).getTime();
        }

        graphArea2 = Morris.Area({
            element: 'hero-area',
            padding: 10,
            behaveLikeLine: true,
            gridEnabled: false,
            gridLineColor: '#dddddd',
            axes: true,
            resize: true,
            smooth:true,
            pointSize: 0,
            lineWidth: 0,
            fillOpacity:0.85,
            data: [
                {period: '2014 Q1', iphone: 2668, ipad: null, itouch: 2649},
                {period: '2014 Q2', iphone: 15780, ipad: 13799, itouch: 12051},
                {period: '2014 Q3', iphone: 12920, ipad: 10975, itouch: 9910},
                {period: '2014 Q4', iphone: 8770, ipad: 6600, itouch: 6695},
                {period: '2015 Q1', iphone: 10820, ipad: 10924, itouch: 12300},
                {period: '2015 Q2', iphone: 9680, ipad: 9010, itouch: 7891},
                {period: '2015 Q3', iphone: 4830, ipad: 3805, itouch: 1598},
                {period: '2015 Q4', iphone: 15083, ipad: 8977, itouch: 5185},
                {period: '2016 Q1', iphone: 10697, ipad: 4470, itouch: 2038},
                {period: '2016 Q2', iphone: 8442, ipad: 5723, itouch: 1801}
            ],
            lineColors:['#ff4a43','#a2d200','#22beef'],
            xkey: 'period',
            redraw: true,
            ykeys: ['iphone', 'ipad', 'itouch'],
            labels: ['All Visitors', 'Returning Visitors', 'Unique Visitors'],
            pointSize: 2,
            hideHover: 'auto',
            resize: true
        });


    });
</script>
<jsp:include page="footer.jsp"/>
</body>
</html>