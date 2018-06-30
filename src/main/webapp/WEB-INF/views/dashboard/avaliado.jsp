<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<myTags:template bodyName="Dashboard">



	<div class="row" style="margin-top: 4em">
		<div class="col-lg-10 col-lg-offset-1 content">

			<div class="row">

				<h2 class="text-center">Avaliação</h2>
				<div class="row text-center alert-warning">${msgRetorno}</div>
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

			</div>
			<div class="row text-center">

				<p>
					Altura: <span class="color-red">${avaliacao.altura} cm</span>
				</p>
				<p>
					Peso: <span class="color-red">${avaliacao.peso} kg</span>
				</p>

				<c:if test="${avaliacao.tipoAvaliacao == 'ADIPOMETRO'}">
					<div class="row">
						<h3>Dobras</h3>
						<c:if test="${avaliado.sexo== 'MASCULINO'}">
							<div class="col-md-4">
								<p>Abdominal</p>
								<span class="color-red">${avaliacao.dAbdominal}</span>

							</div>
							<div class="col-md-4">
								<p>Torácica</p>
								<span class="color-red">${avaliacao.dToracica}</span>
							</div>

						</c:if>
						<c:if test="${avaliado.sexo== 'FEMININO'}">
							<div class="col-md-4">
								<p>Supra Ilíaca</p>
								<span class="color-red">${avaliacao.dSupraIliaca}</span>

							</div>
							<div class="col-md-4">
								<p>Triciptal</p>
								<span class="color-red">${avaliacao.dTriciptal}</span>
							</div>
						</c:if>
						<div class="col-md-4">
							<p>Coxa</p>
							<span class="color-red">${avaliacao.dCoxa}</span>
						</div>
					</div>
				</c:if>

				<div class="row">

					<h3>Perimetros</h3>
					<div class="col-md-3">
						<p>Pescoço</p>
						<span class="color-red">${avaliacao.perimetros.pescoco}</span>
					</div>
					<div class="col-md-2">
						<p>Torax</p>
						<span class="color-red">${avaliacao.perimetros.torax}</span>
					</div>
					<div class="col-md-3">
						<p>Cintura</p>
						<span class="color-red">${avaliacao.perimetros.cintura}</span>
					</div>
					<div class="col-md-2">
						<p>Abdomen</p>
						<span class="color-red">${avaliacao.perimetros.abdomen}</span>
					</div>
					<div class="col-md-2">
						<p>Quadril</p>
						<span class="color-red">${avaliacao.perimetros.quadril}</span>
					</div>
				</div>

				<div class="row">
					<h5>Antebraços</h5>
					<div class="col-md-6">
						<p>Direito</p>
						<span class="color-red">${avaliacao.perimetros.anteBracoD}</span>
					</div>
					<div class="col-md-6">
						<p>Esquerdo</p>
						<span class="color-red">${avaliacao.perimetros.anteBracoE}</span>
					</div>

					<h5>Braços</h5>
					<div class="col-md-6">
						<p>Direito</p>
						<span class="color-red">${avaliacao.perimetros.bicepsD}</span>
					</div>
					<div class="col-md-6">
						<p>Esquerdo</p>
						<span class="color-red">${avaliacao.perimetros.bicepsE}</span>
					</div>

					<h5>Coxas</h5>
					<div class="col-md-6">
						<p>Direita</p>
						<span class="color-red">${avaliacao.perimetros.coxaD}</span>
					</div>
					<div class="col-md-6">
						<p>Esquerda</p>
						<span class="color-red">${avaliacao.perimetros.coxaE}</span>
					</div>

					<h5>Panturrilhas</h5>
					<div class="col-md-6">
						<p>Direita</p>
						<span class="color-red">${avaliacao.perimetros.panturrilhaD}</span>
					</div>
					<div class="col-md-6">
						<p>Esquerda</p>
						<span class="color-red">${avaliacao.perimetros.panturrilhaE}</span>
					</div>


				</div>

			</div>


			<div class="row text-center">
				<h3>Abdominais</h3>
				<p>
					Você fez <span class="color-red">${avaliado.testeResistencia.abdominais}</span>
					abdominais em 1(um) minuto e foi classificado como <span
						class="color-red">${avaliado.testeResistencia.resultAbdominais}</span>.
				</p>
				<p>Para melhorar esse resultado dedique-se ao treinamento
					BodyShock!</p>


				<h3>Flexões</h3>
				<p>
					Você fez <span class="color-red">${avaliado.testeResistencia.flexao}</span>
					abdominais em 1(um) minuto e foi classificado como <span
						class="color-red">${avaliado.testeResistencia.resultFlexao}</span>.
				</p>
				<p>Para melhorar esse resultado dedique-se ao treinamento
					BodyShock!</p>

				<h4>
					<!--   <a href="">Imprima sua dieta,
					caso necessario!</a>-->
				</h4>


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
					labels : [ "Atual Vs. Ideal" ],
					datasets : [ {
						fillColor : "rgba(10,10,10,0.5)",
						strokeColor : "rgba(10,10,10,0.8)",
						highlightFill : "rgba(10,10,10,0.75)",
						highlightStroke : "rgba(10,10,10,1)",
						data : [ ${avaliacao.porcentagemGordura} ]
					}, {
						fillColor : "rgba(233,41,34, 0.7)",
						strokeColor : "rgba(233,41,34, 1)",
						highlightFill : "rgba(233,41,34, 0.75)",
						highlightStroke : "rgba(233,41,34, 1)",
						data : [ ${avaliacao.porcentagemGorduraIdeal} ]
					} ]

				}
			</script>
</myTags:template>