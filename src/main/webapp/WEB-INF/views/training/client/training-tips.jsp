

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
.font-sizable {
	font-size: 20px !important;
}

@media ( max-width : 960px) {
	.font-sizable {
		font-size: 16px !important;
	}
}

@media ( max-width : 768px) {
	.font-sizable {
		font-size: 16px !important;
	}
}
</style>



	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"> <em class="fa fa-home"></em>
			</a></li>
			<li class="active">Treino</li>
		</ol>
	</div>


	<div class="row">

		<div class="col-lg-12 content ">
			<div class="text-center">

				<h2>${training.titulo}</h2>
				<h3>Cardio: ${training.cardio}</h3>
			</div>

			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">

				<c:forEach items="${training.exercicios}" var="exercise" varStatus="s">
					<div class="row">

						<div class="col-md-6 col-md-offset-3">
							<div class="panel panel-danger">
								<div class="panel-heading clickable panel-collapsed">
									<span class="font-sizable" style="text-transform: capitalize;">
										${exercise.descricao} </span>
								</div>
								<div class="panel-body text-center" style="display: none;">
									<img src="${exercise.gif}" width="250" />
								</div>
							</div>
						</div>

					</div>
					<br />
				</c:forEach>
				<div class="row">

					<div class="col-md-6 col-md-offset-3 text-center">
						<h4>Abdominais Supra e Infra: 2x20 cada</h4>
					</div>
				</div>
			</div>

			<form:form action="/avaliado/treino/adicionaDia" method="POST"
				id="finalizaTreino">
				<input type="submit" class="btn btn-primary center-block"
					value="Finalizar
						treino">
			</form:form>
			<br />

		</div>

	</div>
</myTags:template>

