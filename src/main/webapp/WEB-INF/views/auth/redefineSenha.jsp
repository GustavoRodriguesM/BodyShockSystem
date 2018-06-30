<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="security"%>
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

<script type="text/javascript">
	function validaSenha() {
		document.getElementById("senhaDiv").innerHTML = "";
		var senha = document.getElementById('senha');
		var senha1 = document.getElementById('senha1');
		if (senha.value != senha1.value) {
			document.getElementById("senhaDiv").innerHTML = "<p class='text-center'>Senhas diferentes!</p>";
		} else {
			document.getElementById("senhaDiv").innerHTML = "";
		}
	}
</script>
</head>

<body>



	<div class="col-sm-4 col-sm-offset-4 col-lg-4 col-lg-offset-4">



		<div class="row">

			<div class="content text-center"
				style="padding: 20px; margin-top: 10em">

				<div class="row">

					<div class="col-lg-10 col-lg-offset-1 content text-center">



						<form:form servletRelativeAction="/redefine/senha/t"
							modelAttribute="usuario" method="POST">


							<div id="senhaDiv" class="alert-danger"
								style="margin-bottom: 2em">
								<form:errors path="senha" />
							</div>
							<form:input type="password" path="senha" id="senha"
								class="form-control" placeholder="Senha" autofocus="true" />
							<br />

							<input type="password" id="senha1" onkeyup="validaSenha()"
								class="form-control" placeholder="Confirmação de senha" required>
							<br />

							<form:input type="hidden" path="token" />

							<br />
							<button class="btn btn-primary btn-block" type="submit">Redefinir
								senha</button>
						</form:form>




					</div>

				</div>




			</div>


		</div>
	</div>
	<div class="row">


		<div class="col-lg-12">
			<p class="back-link">
				Desenvolvido por <a href="#">Gustavo Rodrigues</a>
			</p>
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


</body>

</html>

