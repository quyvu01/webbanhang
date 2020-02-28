<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<a class="nav-link" href="#">DỊCH VỤ</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">LIÊN HỆ</a>
				</li>
				<li class="dropdown product-List">
					<a class="dropdown-toggle" role="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						SẢN PHẨM
					</a>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<c:forEach var="item" items="${danhsach}">
							<li><a href="<c:url value="/sanpham/${item.madanhmuc}"/>">${item.tendanhmuc}</a></li>
						</c:forEach>
					</ul>
				</li>
			</ul>
			<ul class=" nav navbar-right">
				<li>
					<c:if test="${email == null}">
						<a class="nav-link" href="login">ĐĂNG NHẬP</a>
					</c:if>
					<c:if test="${email != null}">
						<a class="nav-link circle-loged-in" href="#">${firt-Char}</a>
					</c:if>
				</li>
				<li style="display: flex">
					<a style="margin-top: -5px" class="nav-link" href="<c:url value="/giohang"/>">
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
<!-- Body -->
<div class="container-fluid" style="margin-top: 15px">
	<div class="row">
		<div class="col-lg-2 col-md-2">
			<h3>Danh mục sản phẩm</h3>
			<ul class="menu-general list-group">
				<c:forEach var="danhmuc" items="${danhsach}">
					<li><a href="<c:url value="/sanpham/${danhmuc.madanhmuc}"/>">
						${danhmuc.tendanhmuc}
					</a></li>
				</c:forEach>
<%--				<li>Quần Jean--%>
<%--					<ul>--%>
<%--						<li>Áo dài</li>--%>
<%--						<li>Áo sơ mi</li>--%>
<%--						<li>Áo khoác</li>--%>
<%--						<li>Quần Jean</li>--%>
<%--					</ul>--%>
<%--				</li>--%>
			</ul>
		</div>
		<div class="col-lg-8 col-md-8">
			<div class="row">
				<div class="col-md-4 col-lg-4">
					<img style="max-width: 100%" src="<c:url value="/resource/Image/Product/${sanpham.hinhsanpham}.jpg"/>">
				</div>
				<div class="col-md-8 col-lg-8">
					<h3 id="tensanpham" data-masanpham="${sanpham.masanpham}"> ${sanpham.tensanpham}</h3><br/>
					<h4 id="giatien" data-giatien="${sanpham.giatien}" style="color: red">${sanpham.giatien} đ</h4><br/>
					<table class="table">
						<thead>
							<td><h5>Kích thước</h5></td>
							<td><h5>Màu sắc</h5></td>
							<td><h5>Số lượng</h5></td>
							<td><h5>Thêm giỏ hàng</h5></td>
						</thead>
						<tbody>
						<c:forEach var="chitiet" items="${sanpham.setChiTietSanPham}">
							<tr>
								<td class="masize" data-masize="${chitiet.size.masize}">${chitiet.size.tenkichthuoc}</td>
								<td class="mamau" data-mamau="${chitiet.mauSanPham.mamau}">${chitiet.mauSanPham.tenmau}</td>
								<td class="soluong" data-soluong="${chitiet.soluong}">${chitiet.soluong}</td>
								<td><button class="btn-add-adj btn-Plus">+</button>
									<span class="spCount" style="margin-left: 20px; margin-right: 20px">1</span>
									<button class="btn-add-adj btn-Sub">-</button>
									<button class="btn-add-cart btn-giohang" data-machitietsanpham="${chitiet.machitietsanpham}">Giỏ hàng</button>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-lg-2 col-md-2">
			<h3>Mô tả sản phẩm</h3><br/>
			<span>${sanpham.mota}</span>
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
						<textarea style="height: 90px; margin-top: 10px; min-height: 90px; max-height: 90px"
								  type="text" placeholder="Nội dung" name="tuoi"></textarea><br/>
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