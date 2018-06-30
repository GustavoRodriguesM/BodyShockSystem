<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags"
	prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BodyShock System</title>
<link href="<c:url value='/assets/front/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/assets/front/css/font-awesome.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/assets/front/css/datepicker3.css'/>"
	rel="stylesheet">
<link href="<c:url value='/assets/front/css/styles.css'/>"
	rel="stylesheet">

<!--Custom Font-->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">
<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
<style>
.back-link {
	margin-top: 30px;
}
</style>
</head>

<body>



	<div class="container">

		<div class="col-md-6 col-md-offset-3">

			<div class="row">

				<div class="content text-center" style="padding: 20px">

					<div class="text-center row">
						<img src="<c:url value='/assets/images/logoPreto.png'/>" /> <br />
						<br /> <br />

						<p>Digite seu email que será enviada uma mensagem com as
							instruções para redefinir sua senha de forma segura.</p>
						<br />
					</div>

					<form:form servletRelativeAction="/redefine/senha" method="POST"
						id="reset">

						<input type="email" name="email" id="email" class="form-control"
							placeholder="Email" required autofocus>
						<br />

						<br />
						<button onclick="submitForm()"
							class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Enviar</button>
					</form:form>
					<br />
					<div class="text-center">
						<a href="<c:url value='/login'/>" class="forgot-password">
							Sabe sua senha? Logue-se! </a><br />
					</div>




				</div>


			</div>
			<div class="col-lg-12">
				<p class="back-link">
					Desenvolvido por <a href="#">Gustavo Rodrigues</a>
				</p>
			</div>
		</div>

	</div>




	<script src="<c:url value='/assets/front/js/jquery-1.11.1.min.js'/>"></script>
	<script src="<c:url value='/assets/front/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/assets/front/js/chart.min.js'/>"></script>
	<script src="<c:url value='/assets/front/js/chart-data.js'/>"></script>
	<script src="<c:url value='/assets/front/js/easypiechart.js'/>"></script>
	<script src="<c:url value='/assets/front/js/easypiechart-data.js'/>"></script>
	<script src="<c:url value='/assets/front/js/bootstrap-datepicker.js'/>"></script>
	<script src="<c:url value='/assets/front/js/custom.js'/>"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/src/loadingoverlay.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/extras/loadingoverlay_progress/loadingoverlay_progress.min.js"></script>
	<script>
		function submitForm() {
			$.LoadingOverlay("show");
			var form = document.getElementById("reset");
			form.submit();
		}
	</script>

</body>

</html>
