<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<jsp:include page="header.jsp"/>
<jsp:include page="footer.jsp"/>
</head>
<body id="body-login">
	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
				<div id="header-top-left" class="header-login">
					<!-- dùng class cho sử dụng lại, dùng id không cho sử dụng lại được -->
					<span id="text-logo">Welcome</span> <br /> <span
						id="hint-text-logo">Hãy tạo lên phong cách của bạn cùng
						MiniShop!</span>
				</div>
				<div id="header-buttom-left">
					<p>
						<img alt="icon_oval"
							src='<c:url value="/resource/Image/icon_oval.png" />'
							width="15px" height="15px" /><span>Luôn cập nhật xu hướng</span>
					</p>
					<p>
						<img alt="icon_oval"
							src='<c:url value="/resource/Image/icon_oval.png" />'
							width="15px" height="15px" /><span>Giảm 50% cho khách
							hàng VIP</span>
					</p>
					<p>
						<img alt="icon_oval"
							src='<c:url value="/resource/Image/icon_oval.png" />'
							width="15px" height="15px" /><span>Tận tình tư vấn tạo
							nên phong cách của bạn</span>
					</p>
				</div>
			</div>
			<div id="container-login-right">
				<div id="header-top-right" class="header-login">
					<span id="btn-login" class="actived">Đăng nhập</span>/<span id="btn-signup">Đăng ký</span>
				</div>
				<div id="container-center-right">
					<div id="container-login-pre">
						<input id="ipemail-login" name="email" class="input-icon-email" type="text" placeholder="Email"> <br/>
						<input id="ippassword-login" name="matkhau" class="input-icon-password" type="password" placeholder="Mật khẩu"> <br/>
						<button class="material-primary-button" id="btnDangNhap">ĐĂNG NHẬP</button>
					</div>
					
					<div id="container-signup-pre" style="display: none">
						<form method="post" action="">
							<input id="ipemail-signip" name="email" class="input-icon-email" type="text" placeholder="Email"> <br/>
							<input id="ippassword-signup" name="matkhau" class="input-icon-password" type="password" placeholder="Mật khẩu"> <br/>
							<input id="ipre-password-signup" name="nhaplaimatkhau" class="input-icon-password" type="password" placeholder="Nhập lại mật khẩu"> <br/>
							<button class="material-primary-button" id="btnDangKy">ĐĂNG KÝ</button>
						</form>
					</div>
					<div>
						<span>
							<c:if test="${Status == 2002}">
								Yêu cầu tên đăng nhập và mật khẩu!
							</c:if>
							<c:if test="${Status == 2003}">
								Vui lòng nhập mật khẩu nhập lại giống mật khẩu!
							</c:if>
							<c:if test="${Status == 2001}">
								Đăng ký thành công!
							</c:if>
							<c:if test="${Status == 2004}">
								Mật khẩu không đúng định dạng, vui lòng kiểm tra lại!
							</c:if>
							<c:if test="${Status == 2006}">
								Tên đăng ký đã tồn tại!
							</c:if>
						</span>
					</div>
				</div>
				<div id="container-social-login">
				<img alt="login_facebook" src='<c:url value="/resource/Image/icon_facebook.png" />'
							width="40px" height="40px" />
				<img alt="login_google" src='<c:url value="/resource/Image/icon_google.png" />'
							width="40px" height="40px" />
				</div>
			</div>
		</div>
	</div>
</body>

</html>