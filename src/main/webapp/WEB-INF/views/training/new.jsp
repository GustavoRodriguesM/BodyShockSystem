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


	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"> <em class="fa fa-home"></em>
			</a></li>
			<li class="active">Admin / Treino / Formulário</li>
		</ol>
	</div>
	<!--/.row-->

	<div class="row content">
		<div class="col-lg-10 col-lg-offset-1">


			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading" style="margin-bottom: 2px !important">
							<h4 class="title">Formulário - Modelo de código: GENERO_NOME_PESO_D1</h4>
						</div>
						<form:form servletRelativeAction="/admin/treino"
							method="POST" modelAttribute="treino">

							<jsp:include page="/WEB-INF/views/training/form.jsp"></jsp:include>

							<button type="submit" class="btn btn-primary center-block">Cadastrar</button>
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>



</myTags:template>


