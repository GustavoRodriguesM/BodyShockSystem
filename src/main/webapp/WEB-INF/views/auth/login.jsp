<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BodyShock System</title>
<link href="<c:url value='/assets/front/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/assets/front/css/datepicker3.css'/>"
	rel="stylesheet">
<link href="<c:url value='/assets/front/css/styles.css'/>"
	rel="stylesheet">
<script src="<c:url value='/assets/front/js/jquery-1.11.1.min.js'/>"></script>
<script src="<c:url value='/assets/front/js/bootstrap.min.js'/>"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
	$(document).ready(function() {
		${sweetAlert}
	});
</script>
<style>
.img-responsive {
	margin: 0 auto;
}
</style>
<link rel="icon" type="image/png" sizes="32x32"
	href="<c:url value ="/assets/images/favicon/favicon-32x32.png"/>">
<link rel="icon" type="image/png" sizes="96x96"
	href="<c:url value='/favicon-96x96.png'/>">
<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<div class="row" style="margin-top: 5em">
		<div
			class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
			<div class="login-panel panel panel-default">
				<c:if test="${param.error != null}">
					<p class="text-center alert-danger">
						<fmt:message key="invalid.usernamePassword" />
					</p>
				</c:if>
				<c:if test="${param.logout != null}">
					<p class="text-center alert-success">
						<fmt:message key="logout" />
					</p>
				</c:if>

				${message}
				<div class="text-center">
					<a href="<c:url value='/'/>"><img
						src="<c:url value='/assets/images/logoPreto.png'/>"
						class="img img-responsive" style="margin-bottom: 2em" /></a>
				</div>
				<div class="panel-body">

					<div class="col-md-8 col-md-offset-2">

						<form:form servletRelativeAction="/login" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="E-mail"
										name="username" type="email" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Senha" name="password"
										type="password" value="">
								</div>
								<div class="checkbox">
									<label> <a href="<c:url value='/redefine/senha'/>">Esqueceu
											sua senha?</a>
									</label>
								</div>
								<div class="col-md-6 col-md-offset-3">
									<input type="submit" style="width: 100%"
										class="btn btn-primary" value="Entrar">
								</div>
							</fieldset>
						</form:form>

					</div>

				</div>



			</div>
		</div>
		<!-- /.col-->
	</div>
	<!-- /.row -->



</body>
</html>