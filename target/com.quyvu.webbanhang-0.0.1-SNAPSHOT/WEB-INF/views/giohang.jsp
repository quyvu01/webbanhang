<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="com.quyvu.entity.GioHang" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="header.jsp"></jsp:include>
    <meta charset="ISO-8859-1">
    <title>Home page</title>
</head>
<body>
<!-- Header-->
<div id="header-detail" class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-light header_background">
        <a class="navbar-brand" href="<c:url value="/"/>"><img src="<c:url value="/resource/Image/icon_logo.png"/>"/></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link active" href="<c:url value="/"/>">TRANG CHỦ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/"/>">DỊCH VỤ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link">LIÊN HỆ</a>
                </li>
                <li class="dropdown product-List">
                    <a class="dropdown-toggle" role="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        SẢN PHẨM
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <c:forEach var="item" items="${danhmuc}">
                            <li><a href="<c:url value="/sanpham/${item.madanhmuc}"/>">${item.tendanhmuc}</a></li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
            <ul class=" nav navbar-right">
                <li>
                    <c:if test="${email == null}">
                        <a class="nav-link" href="<c:url value="/login"/>">ĐĂNG NHẬP</a>
                    </c:if>
                    <c:if test="${email != null}">
                        <a class="nav-link circle-loged-in" href="#">${firt-Char}</a>
                    </c:if>
                </li>
                <li style="display: flex">
                    <a style="margin-top: -5px" class="nav-link" href="#">
                        <img class="icon-size" src="<c:url value="/resource/Image/icon_cash.png"/> ">
                    </a>
                    <c:if test="${countSanpham !=0}">
                        <div id="product-Count"><span class="product-Count">${countSanpham}</span></div>
                    </c:if>
                    <c:if test="${countSanpham ==0}">
                        <div style="display: none" id="product-Count"><span class="product-Count">${countSanpham}</span></div>
                    </c:if>
                </li>
            </ul>
        </div>
    </nav>
</div>
<!--Body-->
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6">
            <h3>Thông tin người nhận/mua</h3>
            <form class="customer-form" method="post">
                <label>Tên người nhận/mua</label><br/>
                <input name="tenkhachhang" type="text" placeholder="Họ tên người nhận"><br/>
                <label>Số điện thoại</label><br/>
                <input name="sodt" type="text" placeholder="Số điện thoại"><br/>
                <label>Địa chỉ người nhận</label><br/>
                <input name="diachigiaohang" type="text" placeholder="Địa chỉ"><br/>
                <label>Ghi chú</label><br/>
                <textarea style="max-height: 150px; min-height: 150px " name="ghichu" placeholder="Ghi chú"></textarea><br/>
                <input type="submit" value="ĐỒNG Ý">
            </form>
        </div>
        <div class="col-md-6">
            <h3>Danh sách sản phẩm trong giỏ hàng</h3>
            <table class="table" style="margin-top: 20px">
                <thead>
                <tr>
                    <td><h6>Tên sản phẩm</h6></td>
                    <td><h6>Kích thước</h6></td>
                    <td><h6>Màu sắc</h6></td>
                    <td><h6>Đơn giá</h6></td>
                    <td><h6>Số lượng</h6></td>
                    <td><h6>Thành tiền</h6></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="sanpham" items="${listGioHang}">
                    <tr>
                        <td class="tensanpham" data-masanpham="${sanpham.masanpham}">${sanpham.tensanpham}</td>
                        <td class="masize" data-masize="${sanpham.masize}">${sanpham.tensize}</td>
                        <td class="mamau" data-mamau="${sanpham.mamau}">${sanpham.tenmau}</td>
                        <td class="giatien">${sanpham.giatien}</td>
                        <td class="soluong"><input min="0" class="product-Change" style="width: 40px; border-radius: 5px" type="number" value="${sanpham.soluong}"></td>
                        <fmt:parseNumber var="item_price" value="${sanpham.giatien}" type="number" integerOnly="true"/>
                        <fmt:formatNumber var="item_per" value="${item_price * sanpham.soluong}" currencySymbol="?"/>
                        <td class="items-price" data-item-price="${sanpham.giatien}">${item_per}</td>
                        <td><button class="btn-remove">Xóa</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <label style="font-size: 30px">Tổng tiền:</label>
            <label class="total-price" style="font-size: 30px; color: red"></label>
            <label style="font-size: 30px; color: red">đ</label>
        </div>
    </div>
</div>
<!--End Body-->
<!--Footer-->
<div id="footer-special" class="container-fluid">
    <div id="footer">
        <div class="row" style="margin-top: 30px">
            <div class="col-md-4 col-lg-4">
                <span class="footer-general">THÔNG TIN SHOP</span><br/>
                <div class="footer-description">
                    <span>Let's Shop là một thương hiệu thời trang đầy uy tín, luôn đảm bảo chất lượng tốt nhất cho khách hàng!</span>
                </div>
            </div>

            <div class="col-md-4 col-lg-4">
                <span class="footer-general">LIÊN HỆ</span><br/>
                <div class="footer-description">
                    <span>Số 8, Đường Tôn Thất Thyết,Quận Từ Liêm,T.P Hà Nội</span><br/>
                    <span>quy.vu.0101@gmail.com</span><br/>
                    <span>0868.493.546</span>
                </div>
            </div>

            <div class="col-md-4 col-lg-4">
                <span class="footer-general">GÓP Ý</span><br/>
                <div>
                    <form method="post">
                        <input type="text" placeholder="Email/Số điện thoại" name="tenNhanVien"/><br/>
                        <textarea style="height: 90px; margin-top: 10px" type="text" placeholder="Nội dung" name="tuoi"></textarea><br/>
                        <button class="submit-style" value="Gửi">ĐỒNG Ý</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>