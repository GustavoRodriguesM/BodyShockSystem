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

<script type="text/javascript"
	src="https://stc.pagseguro.uol.com.br/pagseguro/api/v2/checkout/pagseguro.lightbox.js"></script>
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

p {
	color: #444 !important;
}

li {
	color: #666 !important;
}
</style>

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
				<li class="active">Degustação</li>
			</ol>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-md-8 col-md-offset-2 content" style="margin-top:3em">


				<div class="text-center">
					<img src="http://i.imgur.com/0TW8bR9.png" /> <br />

					<c:if test="${!avaliacao.coaching}">
						<form
							action="https://pagseguro.uol.com.br/checkout/v2/payment.html"
							method="post" onsubmit="PagSeguroLightbox(this); return false;">
							<input type="hidden" name="code"
								value="7AF41F21D0D099E554DE9F8C3160B0D9" /> <input
								type="hidden" name="iot" value="button" /> <input type="image"
								src="https://stc.pagseguro.uol.com.br/public/img/botoes/pagamentos/209x48-comprar-assina.gif"
								name="submit"
								alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
						</form>
					</c:if>
					<c:if test="${avaliacao.coaching}">
						<!-- INICIO FORMULARIO BOTAO PAGSEGURO -->
						<form
							action="https://pagseguro.uol.com.br/checkout/v2/payment.html"
							method="post" onsubmit="PagSeguroLightbox(this); return false;">

							<input type="hidden" name="code"
								value="41E9E324777789BAA487BFB73F3F10D4" /> <input
								type="hidden" name="iot" value="button" /> <input type="image"
								src="https://stc.pagseguro.uol.com.br/public/img/botoes/pagamentos/209x48-comprar-assina.gif"
								name="submit"
								alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
						</form>
						<script type="text/javascript"
							src="https://stc.pagseguro.uol.com.br/pagseguro/api/v2/checkout/pagseguro.lightbox.js"></script>

					</c:if>

					<br />
				</div>

				<div class="row">

					<div class="col-md-8 col-md-offset-2 text-justify">
						<p>
							Muito obrigado por usar o BodyShock System!<br /> Agora você
							terá algumas informações de seu interesse para lhe ajudar no seu
							desempenho na academia. <br />Você está <b class="color-red">${mediaGordura}%</b>
							da sua porcentagem de gordura <b class="color-red">ideal</b> e
							para melhorar isso siga os horários de suas dicas de alimentação!
							<br />Você tem <b class="color-red">${avaliado.protocolo}</b>
							refeições por dia, todas baseadas em uma sugestão de alimentos
							comumente usadas por praticantes de musculação que é uma variante
							da dieta paleolítica, com um cardápio sugerido de proteinas,
							carboidratos e gorduras, bem como o uso adequado de suplementos e
							vitaminas, todos voltados para uma melhor performance. <br />Um
							programa de treinamento de 10 semanas tambem já está pronto!
							Treino rápido, objetivo e muito fácil de ser executado!<br />
							Caso adquira o programa completo você terá acesso a:
						</p>
						<ul>
							<li>Sua taxa de gordura atual e ideal.</li>
							<li>Dicas de alimentação e um cardápio sugerido encaixado
								nos seus horários.</li>
							<li>Um programa de treinamento de 10 semanas.</li>
							<li>Direito a um retorno para comparar os dados colhidos
								hoje com os colhidos daqui há 10 semanas.</li>
							<li>Atendimento on line para tirar duvidas.</li>
						</ul>
						<p>
							<c:if test="${!avaliacao.coaching}">
							Tudo isso por apenas R$100,00! <br />Compre já!
							</c:if>
							<c:if test="${avaliacao.coaching}">
							Tudo isso por apenas R$300,00! <br />Compre já!
							</c:if>
						</p>
					</div>

				</div>

				<div class="text-center">
					<c:if test="${!avaliacao.coaching}">
						<form
							action="https://pagseguro.uol.com.br/checkout/v2/payment.html"
							method="post" onsubmit="PagSeguroLightbox(this); return false;">
							<input type="hidden" name="code"
								value="7AF41F21D0D099E554DE9F8C3160B0D9" /> <input
								type="hidden" name="iot" value="button" /> <input type="image"
								src="https://stc.pagseguro.uol.com.br/public/img/botoes/pagamentos/209x48-comprar-assina.gif"
								name="submit"
								alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
						</form>
					</c:if>
					<c:if test="${avaliacao.coaching}">
						<!-- INICIO FORMULARIO BOTAO PAGSEGURO -->
						<form
							action="https://pagseguro.uol.com.br/checkout/v2/payment.html"
							method="post" onsubmit="PagSeguroLightbox(this); return false;">

							<input type="hidden" name="code"
								value="41E9E324777789BAA487BFB73F3F10D4" /> <input
								type="hidden" name="iot" value="button" /> <input type="image"
								src="https://stc.pagseguro.uol.com.br/public/img/botoes/pagamentos/209x48-comprar-assina.gif"
								name="submit"
								alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
						</form>
						<script type="text/javascript"
							src="https://stc.pagseguro.uol.com.br/pagseguro/api/v2/checkout/pagseguro.lightbox.js"></script>

					</c:if>

					<h4>A LIBERAÇÃO DE SEU PROGRAMA É LIBERADA EM ATÉ 24 HORAS DA
						CONFIRMAÇÃO DO PAGAMENTO PELA PAGSEGURO</h4>
					<h4>Ao ser processada, será enviado um email para você para
						avisar tal liberação!</h4>
				</div>

			</div>
		</div>

		<div class="row" style="margin-top: 2%;">
			<div class="col-sm-12">
				<p class="back-link">
					Desenvolvido por <a href="">Gustavo Rodrigues</a>
				</p>
			</div>
		</div>
	</div>

	<script src="<c:url value='/assets/front/js/jquery-1.11.1.min.js'/>"></script>
	<script src="<c:url value='/assets/front/js/bootstrap.min.js'/>"></script>


</body>

</html>


