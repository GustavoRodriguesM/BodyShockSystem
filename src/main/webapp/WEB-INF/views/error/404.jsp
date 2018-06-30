<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Erro - BodyShock System</title>

<link href="<c:url value='/assets/front/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/assets/front/css/font-awesome.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/assets/front/css/datepicker3.css'/>"
	rel="stylesheet">
<link href="<c:url value='/assets/front/css/styles.css'/>"
	rel="stylesheet">

<link rel="icon" type="image/png" sizes="32x32"
	href="<c:url value ="/assets/images/favicon/favicon-32x32.png"/>">
<link rel="icon" type="image/png" sizes="96x96"
	href="<c:url value='/favicon-96x96.png'/>">

<script src="<c:url value='/assets/front/js/jquery-1.11.1.min.js'/>"></script>
<script src="<c:url value='/assets/js/jquery.mask.js'/>"></script>
<script src="<c:url value='/assets/front/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/assets/front/js/chart.min.js'/>"></script>

<script src="<c:url value='/assets/front/js/bootstrap-datepicker.js'/>"></script>
<script src="<c:url value='/assets/front/js/custom.js'/>"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<style>

.error-box {
	height: 100%;
	position: fixed;
	background: url(../../../assets/images/background/error-bg.jpg)
		no-repeat center center #fff;
	width: 100%;
}

.error-box .footer {
	width: 100%;
	left: 0px;
	right: 0px;
}

.error-body {
	padding-top: 5%;
}

.error-body h1 {
	font-size: 210px;
	font-weight: 900;
	text-shadow: 4px 4px 0 #ffffff, 6px 6px 0 #263238;
	line-height: 210px;
}
	.error-page .footer {
		position: fixed;
		bottom: 0px;
		z-index: 10;
	}
	.fix-sidebar .left-sidebar {
	position: fixed;
}

.fix-header .topbar {
	position: fixed;
	width: 100%;
}

.fix-header .page-wrapper {
	padding-top: 70px;
}

.fix-header .right-side-panel {
	top: 70px;
	height: calc(100% - 70px);
}

</style>

</head>

<body class="fix-header card-no-border fix-sidebar">
	<section id="wrapper" class="error-page">
		<div class="error-box">
			<div class="error-body text-center">
				<h1>404</h1>
				<h3 class="text-uppercase">Página não encontrada !</h3>
				<p class="text-muted m-t-30 m-b-30">Você está procurando por uma
					página que esta indisponivel ou foi deletada.</p>
				<a href="<c:url value='/'/>"
					class="btn btn-primary">Voltar
					para a página inicial</a>
			</div>
		</div>
	</section>

</body>

</html>