
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
			<li class="active">Admin / Valida / Comentário</li>
		</ol>
	</div>
	<!--/.row-->

	<div class="row">
		<div class="col-lg-10 col-lg-offset-1">
			<div class="panel panel-default">
				${mensagem}
				<div class="panel-heading">
					<h4 class="title">Comentários</h4>

				</div>
				<div class="content table-responsive">

					<table class="table table-hover table-striped">
						<thead>
							<tr>

								<th class="color-red">#</th>
								<th class="color-red">NOME</th>
								<th class="color-red">MENSAGEM</th>
								<th class="color-red">VALIDAR</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${comentarios}" var="comentario"
								varStatus="status">
								<tr>

									<td>${comentario.id}</td>
									<td>${comentario.nome}</td>
									<td>${comentario.mensagem}</td>

									<c:if test="${comentario.activated}">
										<td><form:form servletRelativeAction="/admin/comentario"
												method="POST">
												<input type="hidden" name="idComentario"
													value="${comentario.id}" />
												<button type="submit" class="btn btn-default">Invalidar</button>
											</form:form></td>
									</c:if>
									<c:if test="${!comentario.activated}">

										<td><form:form servletRelativeAction="/admin/comentario"
												method="POST">
												<input type="hidden" name="idComentario"
													value="${comentario.id}" />
												<button type="submit" class="btn btn-primary">Validar</button>
											</form:form></td>



									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>

			</div>
		</div>
	</div>
</myTags:template>
