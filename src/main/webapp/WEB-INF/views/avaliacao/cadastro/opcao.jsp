<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

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

<script src="<c:url value='/assets/front/js/jquery-1.11.1.min.js'/>"></script>
<script src="<c:url value='/assets/front/js/bootstrap.min.js'/>"></script>

<script
	src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/src/loadingoverlay.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/extras/loadingoverlay_progress/loadingoverlay_progress.min.js"></script>

<!--Custom Font-->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">
<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->

<style>
.content {
	background-color: #fff;
}

.nav-tabs>li, .nav-pills>li {
	float: none;
	display: inline-block;
	*display: inline; /* ie7 fix */
	zoom: 1; /* hasLayout ie7 trigger */
}

.nav-tabs, .nav-pills {
	text-align: center;
}
</style>


<script src="<c:url value='/assets/js/registerEvaluation.js'/>"></script>

</head>

<body>


	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value='/'/>"><span>BodyShock</span>
					System</a>

			</div>
		</div>
		<!-- /.container-fluid -->
	</nav>



	<div class="col-sm-12  col-lg-12  main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"> <em class="fa fa-home"></em>
				</a></li>
				<li class="active">Cadastro avaliação</li>
			</ol>
		</div>


		<div class="row" style="margin-top: 3em;">
			<div class="col-lg-6 col-lg-offset-3 content">

				<div class="row">

					<div class="col-lg-8 col-lg-offset-2">


						<a href="<c:url value='/'/>"><img
							src="<c:url value='/assets/images/logoPreto.png'/>"
							class="img img-responsive center-block" /></a>
						<h4 class="text-center" style="margin-top: 40px;">Saiba seu
							percentual de gordura excedente</h4>

						<div class="text-justify">

							<p style="margin-top: 40px;">Preencha o cadastro com seu
								dados: circunferências, peso, altura e um teste de abdominais e
								flexões. Além disso, o sistema gera para você, o percentual de
								gordura que você deve perder para chegar na sua taxa ideal. Há a
								necessidade de utilizar uma fita métrica para prosseguir. Caso
								opte em comprar o plano, você terá acesso total a:</p>
							<ul>
								<li>Programa de treinamento de 10 semanas.</li>
								<li>Dicas de alimentação e suplementação.</li>
								<li>Taxas de gordura ideal e atual.</li>
								<li>Direito a uma nova medição de gordura em 10 semanas
									para comparar sua evolução!</li>
							</ul>


						</div>

						<div class="row" style="padding-bottom: 2em; padding-top: 2em;">

							<div class="col-md-4 col-md-offset-1">
								<span><a
									href="<c:url value='/cadastro/avaliacao/adipometro'/>"
									class="btn btn-primary btn-lg">AVALIAÇÃO COM ADIPÔMETRO</a></span>
							</div>
						</div>
						<div class="row" style="padding-bottom: 2em; padding-top: 2em;">
							<div class="col-md-4 col-md-offset-1">
								<span><a
									href="<c:url value='/cadastro/avaliacao/fita-metrica'/>"
									class="btn btn-primary btn-lg">AVALIAÇÃO COM FITA MÉTRICA</a></span>
							</div>

						</div>

					</div>

				</div>

			</div>
		</div>
		<div class="row" style="margin-top: 2%;">
			<div class="col-sm-12">
				<p class="back-link">
					Desenvolvido por <a href="#">Gustavo Rodrigues</a>
				</p>
			</div>
		</div>

	</div>

	<script src="<c:url value='/assets/front/js/chart.min.js'/>"></script>
	<script src="<c:url value='/assets/front/js/chart-data.js'/>"></script>
	<script src="<c:url value='/assets/front/js/easypiechart.js'/>"></script>
	<script src="<c:url value='/assets/front/js/easypiechart-data.js'/>"></script>
	<script src="<c:url value='/assets/front/js/bootstrap-datepicker.js'/>"></script>
	<script src="<c:url value='/assets/front/js/custom.js'/>"></script>

</body>

</html>

