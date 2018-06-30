<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<li class="active">Admin / Avaliacao / Perfil</li>
		</ol>
	</div>
	<!--/.row-->

	<c:if test="${avaliacao == null}">
		<div class="row content text-center">
			<div class="col-md-4 col-md-offset-4"
				style="margin-top: 10%; margin-bottom: 10%;">
				<h3>Avaliação não encontrado! :(</h3>
			</div>
		</div>

	</c:if>
	<c:if test="${avaliacao != null}">
		<div class="row">
			<div class="col-md-10 col-md-offset-1 content">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="title">Avaliação - ${avaliacao.id}</h4>

					</div>
					<div class="row text-center">

						<p>
							Altura: <span class="color-red">${avaliacao.altura} cm</span>
						</p>
						<p>
							Peso: <span class="color-red">${avaliacao.peso} kg</span>
						</p>
						<p>
							Nivel de gordura atual: <span class="color-red">${avaliacao.porcentagemGordura} %</span>
						</p>

						<c:if test="${avaliacao.tipoAvaliacao == 'ADIPOMETRO'}">
							<div class="row">
								<h3>Dobras</h3>
								<c:if test="${avaliacao.avaliado.sexo== 'MASCULINO'}">
									<div class="col-md-4">
										<p>Abdominal</p>
										<span class="color-red">${avaliacao.dAbdominal}</span>

									</div>
									<div class="col-md-4">
										<p>Torácica</p>
										<span class="color-red">${avaliacao.dToracica}</span>
									</div>

								</c:if>
								<c:if test="${avaliacao.avaliado.sexo== 'FEMININO'}">
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
						
						<a href="<c:url value='/admin/avaliacao/altera/${avaliacao.id}'/>" class="btn btn-primary">Alterar</a>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</myTags:template>