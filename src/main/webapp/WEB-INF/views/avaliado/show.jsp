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

	<style>
.content {
	background-color: #fff;
}
</style>

	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"> <em class="fa fa-home"></em>
			</a></li>
			<li class="active">Admin / Avaliado / Perfil</li>
		</ol>
	</div>
	<!--/.row-->


	<c:if test="${avaliado == null}">
		<div class="row content text-center">
			<div class="col-md-4 col-md-offset-4"
				style="margin-top: 10%; margin-bottom: 10%;">
				<h3>Avaliado não encontrado! :(</h3>
			</div>
		</div>

	</c:if>
	<c:if test="${avaliado != null}">
		<div class="row">
			<div class="col-md-10 col-md-offset-1 content">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="title">Avaliado - ${avaliado.usuario.nome}</h4>

					</div>
					<div class="row text-center">
						<h2>Dados pessoais</h2>
						<div class="row">
							<div class="col-md-4">
								<p>Email
								<p />
								<span class="color-red">${avaliado.usuario.email}</span>
							</div>
							<div class="col-md-4">
								<p>Sexo
								<p />
								<span class="color-red">${avaliado.sexo}</span>
							</div>
							<div class="col-md-4">
								<p>Idade
								<p />
								<span class="color-red">${avaliado.idade}</span>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<p>Dias de treino
								<p />
								<span class="color-red">${avaliado.diasTreinados}</span>
							</div>
							<div class="col-md-6">
								<p>Refeições
								<p />
								<span class="color-red">${avaliado.protocolo}</span>
							</div>

						</div>


						<h2>Treino / Dieta</h2>
						<div class="row">
							<div class="col-md-4 col-md-offset-1">
								<p>Código de treino
								<p />
								<span class="color-red">${avaliado.treino.id}</span>
							</div>
							<div class="col-md-4 col-md-offset-1">
								<p>Código de dieta
								<p />
								<span class="color-red">${avaliado.dieta.id}</span>
							</div>

						</div>

						<c:forEach items="${avaliado.avaliacoes}" var="avaliacao">

							<h2>Avaliação</h2>
							<div class="row">
								<div class="col-md-4">
									<p>Código da avaliação
									<p />
									<span class="color-red">${avaliacao.id}</span>
								</div>
								<div class="col-md-4">
									<p>Tipo da avaliação
									<p />
									<span class="color-red">${avaliacao.tipoAvaliacao}</span>
								</div>
								<div class="col-md-4">
									<p>Data da avaliação
									<p />
									<span class="color-red"><fmt:formatDate
											value="${avaliacao.data.time}" pattern="dd/MM/yyyy HH:mm" /></span>
								</div>
							</div>

							<div class="row">

								<div class="col-md-4">
									<p>Peso
									<p />
									<span class="color-red">${avaliacao.peso}</span>
								</div>
								<div class="col-md-4">
									<p>Altura
									<p />
									<span class="color-red">${avaliacao.altura}</span>
								</div>
								<div class="col-md-4">
								<p>Porcentagem de gordura atual
									<p />
									<span class="color-red">${avaliacao.porcentagemGordura}</span>
								</div>

							</div>

							<h3>Perimetros</h3>
							<p>
								Pescoço: <span class="color-red">${avaliacao.perimetros.pescoco}</span>
							</p>
							<p>
								Torax: <span class="color-red">${avaliacao.perimetros.torax}</span>
							</p>
							<p>
								Cintura: <span class="color-red">${avaliacao.perimetros.cintura}</span>
							</p>
							<p>
								Abdomen: <span class="color-red">${avaliacao.perimetros.abdomen}</span>
							</p>
							<p>
								Quadril: <span class="color-red">${avaliacao.perimetros.quadril}</span>
							</p>

							<br />
							<p>
								Antebraços - Direito: <span class="color-red">${avaliacao.perimetros.anteBracoD}</span>
								; Esquerdo: <span class="color-red">${avaliacao.perimetros.anteBracoE}</span>
							</p>

							<p>
								Braços - Direito: <span class="color-red">${avaliacao.perimetros.bicepsD}</span>
								; Esquerdo: <span class="color-red">${avaliacao.perimetros.bicepsE}</span>
							</p>

							<p>
								Coxa - Direita: <span class="color-red">${avaliacao.perimetros.coxaD}</span>
								; Esquerda: <span class="color-red">${avaliacao.perimetros.coxaE}</span>
							</p>

							<p>
								Panturrilha - Direita: <span class="color-red">${avaliacao.perimetros.panturrilhaD}</span>
								; Esquerda: <span class="color-red">${avaliacao.perimetros.panturrilhaE}</span>
							</p>

							<hr />
						</c:forEach>
					</div>

					<div class="row text-center">
						<h3>Abdominais</h3>
						<div class="row">
							<div class="col-md-6">
								<p>Quantidade</p>
								<span class="color-red">${avaliado.testeResistencia.abdominais}</span>
							</div>
							<div class="col-md-6">
								<p>Classificação</p>
								<span class="color-red">${avaliado.testeResistencia.resultAbdominais}</span>
							</div>

						</div>

						<h3>Flexões</h3>
						<div class="row">
							<div class="col-md-6">
								<p>Quantidade</p>
								<span class="color-red">${avaliado.testeResistencia.flexao}</span>
							</div>
							<div class="col-md-6">
								<p>Classificação</p>
								<span class="color-red">${avaliado.testeResistencia.resultFlexao}</span>
							</div>
						</div>
					</div>
				</div>

				<div class="row">

					<h3 class="text-center">Alteração de dieta e treino</h3>

					<form:form
						servletRelativeAction="/admin/avaliado/dietaTreino/alteracao"
						method="post">
						<div class="col-md-4 col-md-offset-1">
							<h4>Alterar dieta</h4>
							<select class="form-control" name="idDieta">
								<option value="${avaliado.dieta.id}">${avaliado.dieta.id}</option>
								<c:forEach var="dieta" items="${dietas}">
									<option value="${dieta.id}">${dieta.id}</option>
								</c:forEach>
							</select>
						</div>

						<div class="col-md-4 col-md-offset-1">
							<h4>Alterar treino</h4>
							<select class="form-control" name="idTreino">
								<option value="${avaliado.treino.id}">${avaliado.treino.id}</option>
								<c:forEach var="treino" items="${treinos}">
									<option value="${treino.id}">${treino.id}</option>
								</c:forEach>
							</select>
						</div>
						<input type="hidden" value="${avaliado.id}" name="idAvaliado" />
						<br />
						<br />

						<div class="row col-md-12 text-center"
							style="margin-top: 2em; margin-bottom: 2em">

							<input type="submit" class="btn btn-primary center-block"
								value="Alterar" />
						</div>
					</form:form>


				</div>

				<div class="row">

					<h3 class="text-center">Alteração de horarios</h3>
					<form:form servletRelativeAction="/admin/avaliado/horario/alteracao"
						method="post">
						<div class="col-md-4 col-md-offset-1">
							<p>Horario que acorda</p>
							<select class="form-control" name="horaAcorda">
								<option value="${avaliado.horaAcorda}">${avaliado.horaAcorda}:00</option>
								<option value="24">00:00</option>
								<option value="1">01:00</option>
								<option value="2">02:00</option>
								<option value="3">03:00</option>
								<option value="4">04:00</option>
								<option value="5">05:00</option>
								<option value="6">06:00</option>
								<option value="7">07:00</option>
								<option value="8">08:00</option>
								<option value="9">09:00</option>
								<option value="10">10:00</option>
								<option value="11">11:00</option>
								<option value="12">12:00</option>
								<option value="13">13:00</option>
								<option value="14">14:00</option>
								<option value="15">15:00</option>
								<option value="16">16:00</option>
								<option value="17">17:00</option>
								<option value="18">18:00</option>
								<option value="19">19:00</option>
								<option value="20">20:00</option>
								<option value="21">21:00</option>
								<option value="22">22:00</option>
								<option value="23">23:00</option>
							</select>
						</div>

						<div class="col-md-4 col-md-offset-1">
							<p>Horario que dorme</p>
							<select class="form-control" name="horaDorme">
								<option value="${avaliado.horaDorme}">${avaliado.horaDorme}:00</option>
								<option value="24">00:00</option>
								<option value="1">01:00</option>
								<option value="2">02:00</option>
								<option value="3">03:00</option>
								<option value="4">04:00</option>
								<option value="5">05:00</option>
								<option value="6">06:00</option>
								<option value="7">07:00</option>
								<option value="8">08:00</option>
								<option value="9">09:00</option>
								<option value="10">10:00</option>
								<option value="11">11:00</option>
								<option value="12">12:00</option>
								<option value="13">13:00</option>
								<option value="14">14:00</option>
								<option value="15">15:00</option>
								<option value="16">16:00</option>
								<option value="17">17:00</option>
								<option value="18">18:00</option>
								<option value="19">19:00</option>
								<option value="20">20:00</option>
								<option value="21">21:00</option>
								<option value="22">22:00</option>
								<option value="23">23:00</option>
							</select>
						</div>
<input type="hidden" value="${avaliado.id}" name="idAvaliado" />
						<div class="row col-md-12 text-center"
							style="margin-top: 2em; margin-bottom: 2em">

							<input type="submit" class="btn btn-primary center-block"
								value="Alterar" />
						</div>
					</form:form>
				</div>

			</div>
		</div>
	</c:if>
</myTags:template>