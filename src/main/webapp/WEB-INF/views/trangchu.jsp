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
	<div id="header" class="container-fluid">
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
						<a class="nav-link" id="scroll-end" style="cursor: pointer">LIÊN HỆ</a>
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
							<a class="nav-link" href="<c:url value="/login"/> ">ĐĂNG NHẬP</a>
						</c:if>
						<c:if test="${email != null}">
							<a class="nav-link circle-loged-in" href="#">${firt-Char}</a>
						</c:if>
					</li>
					<li style="display: flex"><a style="margin-top: -5px" class="nav-link" href="<c:url value="/giohang"/>"><img class="icon-size" src="<c:url value="/resource/Image/icon_cash.png"/> "></a>
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
		<div class="event-header container wow rubberBand" data-wow-duration="5s">
			<span>Ngày 17/10 - 23/10/2017</span><br/>
			<span style="font-size: 50px">MUA 1 TẶNG 1</span><br/>
			<button>Xem ngay</button>
		</div>
	</div>
	<!-- Body -->
	<div id="info" class="container">
		<div class="row">
			<div class="col-md-4 col-lg-4 wow fadeInLeft">
				<img src="<c:url value="/resource/Image/icon_quality.png"/> "/><br/>
				<span style="font-size: 32px; font-weight: bold">CHẤT LƯỢNG</span><br/>
				<span>Chúng tôi cam kết sẽ mang đến cho các bạn chất lượng sản phẩm tốt nhất</span>
			</div>

			<div class="col-md-4 col-lg-4 wow fadeInUp" data-wow-delay="1s">
				<img src="<c:url value="/resource/Image/icon_saving.png"/> "/><br/>
				<span style="font-size: 32px; font-weight: bold">TIẾT KIỆM CHI PHÍ</span><br/>
				<span>Cam kết giá rẻ nhất Việt Nam, giúp bạn tiết kiệm hơn 20% cho từng sản phẩm</span>
			</div>

			<div class="col-md-4 col-lg-4 wow fadeInRight" data-wow-delay="2s">
				<img src="<c:url value="/resource/Image/icon_transfer.png"/> "/><br/>
				<span style="font-size: 32px; font-weight: bold">GIAO HÀNG</span><br/>
				<span>Cam kết giao hàng tận nơi trong ngày. Để mang sản phẩm tới cho khách hàng nhanh nhất</span>
			</div>
		</div>
	</div>
	<div id="titleProduct" class="container">
		<span>SẢN PHẨM HOT</span>
	</div>
	<div  class=" row img-sample-size">
		<c:forEach var="sanpham" items="${pageProduct}">
			<a href="<c:url value="/chitiet/${sanpham.masanpham}"/>" class="col-md-3 col-sm-6">
			<div class="product wow zoomIn">
				<img alt="${sanpham.tensanpham}" src="<c:url value="/resource/Image/Product/${sanpham.hinhsanpham}.jpg" />"/>
				<span>${sanpham.tensanpham}</span><br/>
				<span class="produc-price">Giá: ${sanpham.giatien} đ</span>
			</div>
			</a>
		</c:forEach>
	</div>
	<div>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:forEach var="page" begin="${1}" end="${tongsotrang}">
					<li style="cursor: pointer" class="page-item"><a href="<c:url value="/${page}"/>" class="page-link home-page">${page}</a></li>
				</c:forEach>
			</ul>
		</nav>
	</div>
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

				<div class="col-md-4 col-lg-4" id="page-end">
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