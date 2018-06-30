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
			<li class="active">Admin / Avaliados</li>
		</ol>
	</div>

	<div class="row">
		<div class="col-lg-10 col-lg-offset-1">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="title">Avaliados</h4>

				</div>
				<div class="content table-responsive ">
					<table class="table table-striped ">
						<thead>
							<tr>
								<th class="color-red">#</th>
								<th class="color-red">AVALIADO</th>
								<th class="color-red">EMAIL</th>
								<th class="color-red">IDADE</th>
								<th class="color-red">DIAS TREINADOS</th>
								<th class="color-red">PROTOCOLO</th>
								<th class="color-red">REMOVER</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${avaliados}" var="avaliado">

								<tr>

									<td>${avaliado.id}</td>
									<td><a
										href="<c:url value='/admin/avaliado/${avaliado.id}'/>">${avaliado.usuario.nome}</a></td>
									<td>${avaliado.usuario.email}</td>
									<td>${avaliado.idade}</td>
									<td>${avaliado.diasTreinados}</td>
									<td>${avaliado.protocolo} refeições</td>
									<td>
										<button type="button" class="btn btn-primary"
											data-toggle="modal" data-target="#myModal${avaliado.id}">Remover</button> <!-- Modal -->
										<div class="modal fade" id="myModal${avaliado.id}" tabindex="-1"
											role="dialog" aria-labelledby="myModalLabel">
											<div class="modal-dialog" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
														<h4 class="modal-title" id="myModalLabel">Remover avaliado</h4>
													</div>
													<div class="modal-body">Deseja realmente remover este avaliado? Isso removerá todos os dados dele.</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">Cancelar</button>
														<form:form action="/admin/avaliado/remover" method="POST">
															<input type="hidden" name="id" value="${avaliado.id}" />
															<input type="submit" class="btn btn-primary"
																value="Remover" />
														</form:form>
													</div>
												</div>
											</div>
										</div>
									</td>

								</tr>

							</c:forEach>

						</tbody>
					</table>
					<div class="text-center">

						<nav aria-label="Page navigation text-center">
							<ul class="pagination">

								<li class="page-item"><a class="page-link"
									href="<c:url value='/admin/avaliado?page=1'/>">1</a></li>
								<li class="page-item"><a class="page-link"
									href="<c:url value='/admin/avaliado?page=2'/>">2</a></li>
								<li class="page-item"><a class="page-link"
									href="<c:url value='/admin/avaliado?page=3'/>">3</a></li>
								<li class="page-item"><a class="page-link"
									href="<c:url value='/admin/avaliado?page=4'/>">4</a></li>
								<li class="page-item"><a class="page-link"
									href="<c:url value='/admin/avaliado?page=5'/>">5</a></li>

							</ul>
						</nav>

					</div>
				</div>
			</div>
		</div>
	</div>
</myTags:template>