
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>BodyShock System</title>
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="shortcut icon" href="favicon.ico">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="apple-mobile-web-app-title" content="BodyShock System" />
<meta name="application-name" content="BodyShock System" />
<meta name="msapplication-TileColor" content="#000000" />

<link rel="icon" type="image/png" sizes="32x32"
	href="<c:url value ="/assets/images/favicon/favicon-32x32.png"/>">
<link rel="icon" type="image/png" sizes="96x96"
	href="<c:url value='/favicon-96x96.png'/>">
<link rel="icon" type="image/png" sizes="16x16"
	href="<c:url value='/favicon-16x16.png'/>">
<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
<link href="<c:url value ="/assets/css/bootstrap.css"/>"
	rel="stylesheet" />
<link href="<c:url value='/assets/css/home.css'/>" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="<c:url value='/assets/css/animate.css'/>">
<link rel="stylesheet" href="<c:url value='/assets/css/icomoon.css'/>">
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>">
<link rel="stylesheet" href="<c:url value='/assets/css/superfish.css'/>">
<link rel="stylesheet"
	href="<c:url value='/assets/css/navbar-fixed-side.css'/>">
<script src="<c:url value='/assets/js/modernizr-2.6.2.min.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/assets/css/style.css'/>">

<script>
	$(document).ready(function() {

		$('html, body').animate({
			scrollTop : $("#comoFunciona").offset().top
		}, 2000);
		return false;
	});
</script>
</head>
<body>
	<div id="fh5co-wrapper">
		<div id="fh5co-page">

			<div id="fh5co-header">
				<header id="fh5co-header-section">
					<div class="container">
						<div class="nav-header">

							<h1 id="fh5co-logo">
								<a href="<c:url value='/'/>"><img
									src="<c:url value='/assets/images/logo.png'/>" width="80%" /></a>
							</h1>
						</div>
					</div>
				</header>
			</div>


			<div class="fh5co-hero">
				<div class="fh5co-cover" data-stellar-background-ratio="0.5"
					style="background-image: url(assets/images/home-image1.jpg);">
					<div class="desc animate-box">
						<div class="container">
							<div class="row">
								<div class="col-md-7">
									<h2>
										<b>BODYSHOCK</b> <br>System
									</h2>
									<p>
										<span>Saiba seu percentual de gordura excedente.<br />Cadastre-se
											já!
										</span>
									</p>
									<span><a class="btn btn-primary"
										href="<c:url value='/cadastro/avaliacao'/>">Avaliação
											grátis!</a></span> <span><a class="btn btn-primary"
										href="<c:url value='/login'/>">Entrar!</a></span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="fh5co-parallax" id="comoFunciona"
				style="width: 100%; background-image: url('<c:url value='/assets/images/vjJ4plu.jpg'/>');"
				data-stellar-background-ratio="0.5">
				<div class="overlay"></div>
				<div class="container">
					<div class="row">
						<div
							class="col-md-8 col-md-offset-2 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 fh5co-table">
							<div class="fh5co-intro fh5co-table-cell animate-box">
								<h1 class="text-center">COMO FUNCIONA O BODYSHOCK SYSTEM?</h1>
								<div class="text-center">
									<span><a class="btn btn-primary"
										href="<c:url value='/amostra/dashboard'/>">Veja uma
											amostra do sistema.</a></span>
								</div>
								<p class="text-center">
									<b>Até 10% à menos de gordura corporal em 10 semanas!</b> <br />Mude
									seu corpo em 10 semanas com o seu personal virtual!<br /> <br>Cadastre-se
									já e saiba quanto sua taxa de gordura está acima ou abaixo do
									ideal e quantas refeições podem ser feitas de acordo com o
									horário que você marcou no formulário caso opte pelo pagamento,
									seu programa estará liberado pra usar e tenha:
								</p>
								<ul class="parallax">
									<li>Um programa de treinamento completo por 10 semanas.</li>
									<li>Avaliação com direito a retorno após 10 semanas.</li>
									<li>Dicas de alimentação</li>
									<li>Dicas de suplementação</li>
									<li>100% online!</li>
								</ul>
								<p class="text-center">Mude seu corpo em 10 semanas com o
									seu personal virtual!</p>
							</div>
						</div>
					</div>
				</div>
			</div>

			<hr />
			<div id="fh5co-contact">
				<div class="container">
					<form:form action="/contato" method="post"
						modelAttribute="contactWrapper">
						<div class="row">
							<div class="col-md-6 animate-box">
								<h3 class="section-title">Portal de contato</h3>
								<p>Esta area é destinada a qualquer tipo de informação que
									os avaliados ou visitantes queiram passar à equipe BodyShock.
									Sugestões, reclamações e elogios :)</p>
							</div>
							<div class="col-md-6 animate-box">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<form:input type="text" path="name" class="form-control"
												placeholder="Nome" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<form:input type="text" path="email" class="form-control"
												placeholder="Email" />
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<form:textarea path="message" class="form-control" id=""
												cols="30" rows="7" placeholder="Mensagem" />
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<input type="submit" value="Enviar mensagem"
												class="btn btn-primary">
										</div>
									</div>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>


			<footer>
				<div id="footer">
					<div class="container">
						<div class="row copy-right">
							<div class="col-md-6 col-md-offset-3 text-center">
								<p class="fh5co-social-icons">
									<a
										href="https://www.facebook.com/BODY-SHOCK-System-142324855879434/"><i
										class="icon-facebook2"></i></a> <a href="#"><i
										class="icon-instagram"></i></a>
								</p>
								<p>
									Copyright 2018 - BodyShock System<br />Feito por <a href="">Gustavo
										Rodrigues</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</footer>


		</div>
	</div>

	<script src="<c:url value='/assets/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/assets/js/jquery.easing.1.3.js'/>"></script>
	<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/assets/js/jquery.waypoints.min.js'/>"></script>
	<script src="<c:url value='/assets/js/jquery.stellar.min.js'/>"></script>
	<script src="<c:url value='/assets/js/hoverIntent.js'/>"></script>
	<script src="<c:url value='/assets/js/superfish.js'/>"></script>
	<script src="<c:url value='/assets/js/main.js'/>"></script>
</body>
</html>

