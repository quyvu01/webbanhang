<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.quyvu.entity.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div id="cot1" class="col-md-3" data-text="Hello Baby">
				Day la Cot 1
			</div>
			<div class="col-md-3">

			</div>
			<div class="col-md-3">

			</div>
			<div class="col-md-3">

			</div>
		</div>
	</div>
	<a href="login">Login Here!</a>
	<br />


	<jsp:include page="footer.jsp"/>
</body>
</html>