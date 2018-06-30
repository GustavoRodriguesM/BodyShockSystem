
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
			<li class="active">Admin / Valida / Avaliação</li>
		</ol>
	</div>
	<!--/.row-->

	<div class="row">
		<div class="col-lg-10 col-lg-offset-1">
			<div class="panel panel-default">
				${mensagem}
				<div class="panel-heading">
					<h4 class="title">Avaliações</h4>

				</div>
				<div class="content table-responsive">

					<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th><span class="color-red">CÓDIGO AVALIAÇÃO</span></th>
								<th><span class="color-red">STATUS</span></th>
								<th><span class="color-red">AVALIADO</span></th>
								<th><span class="color-red">EMAIL</span></th>
								<th><span class="color-red">COACHING</span></th>
								<th><span class="color-red">VALIDAR</span></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${avaliacoes}" var="avaliacao"
								varStatus="status">
								<tr>

									<td><a href="<c:url value='/admin/avaliacao/${avaliacao.id}'/>">${avaliacao.id}</a></td>
									<td>${avaliacao.status}</td>
									<td>${avaliacao.avaliado.usuario.nome}</td>
									<td>${avaliacao.avaliado.usuario.email}</td>
									<td><c:if test="${avaliacao.coaching}">
											<span class="color-red">Sim</span>
										</c:if> <c:if test="${!avaliacao.coaching}">
											<span>Não</span>
										</c:if></td>
									<td><form:form servletRelativeAction="/admin/avaliacao"
											method="POST">
											<input type="hidden" name="id" value="${avaliacao.id}" />
											<c:if test="${avaliacao.status == 'PAGO'}">
												<button type="submit" class="btn btn-default">Invalidar</button>
											</c:if>
											<c:if test="${avaliacao.status == 'PENDENTE'}">
												<button type="submit" class="btn btn-primary">Validar</button>
											</c:if>
										</form:form></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>

			</div>
		</div>
	</div>
</myTags:template>
