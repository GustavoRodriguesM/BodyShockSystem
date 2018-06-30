<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<myTags:template bodyName="Dashboard">


	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"> <em class="fa fa-home"></em>
			</a></li>
			<li class="active">Retorno</li>
		</ol>
	</div>

	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="title">Dados comparativos de retorno</h4>
			</div>

			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					<div class="panel panel-default">
						<div class="canvas-heading">
							Porcentagem de gordura

							<div class="panel-body">
								<div class="canvas-wrapper">
									<canvas id="bar-chart" height="200" width="600"></canvas>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-8 col-lg-offset-2 content">

					<div class="row text-center">

						<c:if test="${avaliacoes[0].tipoAvaliacao == 'ADIPOMETRO'}">
							<div class="row">
								<h3>Dobras</h3>
								<c:if test="${avaliado.sexo == 'MASCULINO'}">
									<div class="col-md-4">
										<p>Torácica</p>
										<span class="color-red">${avaliacoes[0].dToracica} -
											${avaliacoes[1].dToracica}</span>
									</div>
									<div class="col-md-4">
										<p>Abdominal</p>
										<span class="color-red">${avaliacoes[0].dAbdominal} -
											${avaliacoes[1].dAbdominal}</span>
									</div>
								</c:if>

								<c:if test="${avaliado.sexo == 'FEMININO'}">
									<div class="col-md-4">
										<p>Triciptal</p>
										<span class="color-red">${avaliacoes[0].dTriciptal} -
											${avaliacoes[1].dTriciptal}</span>
									</div>
									<div class="col-md-4">
										<p>Supra Iliaca</p>
										<span class="color-red">${avaliacoes[0].dSupraIliaca} -
											${avaliacoes[1].dSupraIliaca}</span>
									</div>
								</c:if>

								<div class="col-md-4">
									<p>Coxa</p>
									<span class="color-red">${avaliacoes[0].dCoxa} -
										${avaliacoes[1].dCoxa}</span>
								</div>
							</div>
						</c:if>


						<div class="row">

							<h3>Perimetros</h3>
							<div class="col-md-3">
								<p>Pescoço</p>
								<span class="color-red">${avaliacoes[0].perimetros.pescoco}
									- ${avaliacoes[1].perimetros.pescoco}</span>
							</div>
							<div class="col-md-2">
								<p>Torax</p>
								<span class="color-red">${avaliacoes[0].perimetros.torax}
									- ${avaliacoes[1].perimetros.torax}</span>
							</div>
							<div class="col-md-3">
								<p>Cintura</p>
								<span class="color-red">${avaliacoes[0].perimetros.cintura}
									- ${avaliacoes[1].perimetros.cintura}</span>
							</div>
							<div class="col-md-2">
								<p>Abdomen</p>
								<span class="color-red">${avaliacoes[0].perimetros.abdomen}
									- ${avaliacoes[1].perimetros.abdomen}</span>
							</div>
							<div class="col-md-2">
								<p>Quadril</p>
								<span class="color-red">${avaliacoes[0].perimetros.quadril}
									- ${avaliacoes[1].perimetros.quadril}</span>
							</div>
						</div>

						<div class="row">
							<h5>Antebraços</h5>
							<div class="col-md-6">
								<p>Direito</p>
								<span class="color-red">${avaliacoes[0].perimetros.anteBracoD}
									- ${avaliacoes[1].perimetros.anteBracoD}</span>
							</div>
							<div class="col-md-6">
								<p>Esquerdo</p>
								<span class="color-red">${avaliacoes[0].perimetros.anteBracoE}
									- ${avaliacoes[1].perimetros.anteBracoE}</span>
							</div>

							<h5>Braços</h5>
							<div class="col-md-6">
								<p>Direito</p>
								<span class="color-red">${avaliacoes[0].perimetros.bicepsD}
									- ${avaliacoes[1].perimetros.bicepsD}</span>
							</div>
							<div class="col-md-6">
								<p>Esquerdo</p>
								<span class="color-red">${avaliacoes[0].perimetros.bicepsE}
									- ${avaliacoes[1].perimetros.bicepsE}</span>
							</div>

							<h5>Coxas</h5>
							<div class="col-md-6">
								<p>Direita</p>
								<span class="color-red">${avaliacoes[0].perimetros.coxaD}
									- ${avaliacoes[1].perimetros.coxaD}</span>
							</div>
							<div class="col-md-6">
								<p>Esquerda</p>
								<span class="color-red">${avaliacoes[0].perimetros.coxaE}
									- ${avaliacoes[1].perimetros.coxaE}</span>
							</div>

							<h5>Panturrilhas</h5>
							<div class="col-md-6">
								<p>Direita</p>
								<span class="color-red">${avaliacoes[0].perimetros.panturrilhaD}
									- ${avaliacoes[1].perimetros.panturrilhaD}</span>
							</div>
							<div class="col-md-6">
								<p>Esquerda</p>
								<span class="color-red">${avaliacoes[0].perimetros.panturrilhaE}
									- ${avaliacoes[1].perimetros.panturrilhaE}</span>
							</div>

							<br /> <br /> <br />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
				window.onload = function() {

					var chart2 = document.getElementById("bar-chart")
							.getContext("2d");
					window.myBar = new Chart(chart2).Bar(porcentagemGordura, {
						responsive : true,
						scaleLineColor : "rgba(0,0,0,.2)",
						scaleGridLineColor : "rgba(0,0,0,.05)",
						scaleFontColor : "#444"
					});
				}
				var porcentagemGordura = {
					labels : [ "Anterior Vs. Atual Vs. Ideal" ],
					datasets : [ {
						fillColor : "rgba(10,10,10,0.5)",
						strokeColor : "rgba(10,10,10,0.8)",
						highlightFill : "rgba(10,10,10,0.75)",
						highlightStroke : "rgba(10,10,10,1)",
						data : [ ${avaliacoes[0].porcentagemGordura} ]
					}, {
						fillColor : "rgba(233,41,34, 0.7)",
						strokeColor : "rgba(233,41,34, 1)",
						highlightFill : "rgba(233,41,34, 0.75)",
						highlightStroke : "rgba(233,41,34, 1)",
						data : [ ${avaliacoes[1].porcentagemGordura} ]
					}, {
						fillColor : "rgba(10,10,10,0.5)",
						strokeColor : "rgba(10,10,10,0.8)",
						highlightFill : "rgba(10,10,10,0.75)",
						highlightStroke : "rgba(10,10,10,1)",
						data : [ ${avaliacoes[1].porcentagemGorduraIdeal} ]
					}  ]

				}
			</script>
</myTags:template>
