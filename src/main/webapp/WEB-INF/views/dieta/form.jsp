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
			<li class="active">Admin / Dieta / Formulário</li>
		</ol>
	</div>
	<!--/.row-->

	<div class="row content">
		<div class="col-lg-10 col-lg-offset-1">


			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="title">Formulário - Modelo de código: GENERO_NOME_PESO_R5</h4>
						</div>
						<form:form action="/admin/dieta" method="POST"
							modelAttribute="dieta">
							<div class="form-group">
								<label>ID:</label>
								<p class="alert-warning text-center">
									<form:errors path="id" />
								</p>
								<form:input class="form-control" path="id" />
							</div>


							<div class="text-center">
								<label>CARBOIDRATOS:</label>
							</div>

							<div class="form-group">
								<div class="row">
									<p class="alert-warning text-center">
										<form:errors path="carbo1" />
									</p>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Carboidrato 1:</label>
										<form:input class="form-control" path="carbo1" />

									</div>
									<div class="col-md-6">
										<label>Carboidrato 2:</label>
										<form:input class="form-control" path="carbo2" />

									</div>
								</div>

							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-md-6">
										<label>Carboidrato 3:</label>
										<form:input class="form-control" path="carbo3" />

									</div>

									<div class="col-md-6">
										<label>Carboidrato 4:</label>
										<form:input class="form-control" path="carbo4" />

									</div>
								</div>
							</div>
							<div class="text-center">
								<label>PROTEINAS:</label>
							</div>

							<div class="form-group">
								<label>Proteina 1:</label>
								<p class="alert-warning text-center">
									<form:errors path="prot1" />
								</p>
								<form:input class="form-control" path="prot1" />
							</div>
							<div class="form-group">

								<label>Proteina 2:</label>
								<form:input class="form-control" path="prot2" />
							</div>
							<div class="form-group">

								<label>Proteina 3:</label>
								<form:input class="form-control" path="prot3" />
							</div>


							<div class="text-center">
								<label>SUPLEMENTOS:</label>
							</div>
							<div class="form-group">
								<label>Suplemento 1:</label>
								<p class="alert-warning text-center">
									<form:errors path="suplem1" />
								</p>
								<form:input class="form-control" path="suplem1" />
							</div>
							<div class="form-group">

								<label>Suplemento 2:</label>
								<form:input class="form-control" path="suplem2" />
							</div>

							<div class="text-center">
								<label>VITAMINAS:</label>
							</div>

							<div class="form-group">
								<label>Vitamina 1:</label>
								<p class="alert-warning text-center">
									<form:errors path="vit1" />
								</p>
								<form:input class="form-control" path="vit1" />
							</div>
							<div class="form-group">

								<label>Vitamina 2:</label>
								<form:input class="form-control" path="vit2" />
							</div>
							<div class="form-group">
								<label>Vitamina 3:</label>
								<form:input class="form-control" path="vit3" />
							</div>

							<div class="text-center">
								<label>REFEIÇÕES:</label>
							</div>
							<div class="form-group">
								<label>Refeição 1:</label>

								<form:input class="form-control" path="ref1" />
							</div>
							<div class="form-group">
								<label>Refeição 2:</label>
								<form:input class="form-control" path="ref2" />
							</div>
							<div class="form-group">
								<label>Refeição 3:</label>
								<form:input class="form-control" path="ref3" />
							</div>
							<div class="form-group">
								<label>Refeição 4:</label>
								<form:input class="form-control" path="ref4" />
							</div>
							<div class="form-group">
								<label>Refeição 5:</label>
								<form:input class="form-control" path="ref5" />
							</div>
							<div class="form-group">
								<label>Refeição 6:</label>
								<form:input class="form-control" path="ref6" />
							</div>
							<div class="form-group">
								<label>Refeição 7:</label>
								<form:input class="form-control" path="ref7" />
							</div>													

							<button type="submit" class="btn btn-primary center-block">Cadastrar</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</myTags:template>


