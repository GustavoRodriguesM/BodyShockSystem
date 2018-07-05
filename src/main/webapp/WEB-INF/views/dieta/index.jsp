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
.btn {
	line-height: 1 !important;
}
</style>


	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"> <em class="fa fa-home"></em>
			</a></li>
			<li class="active">Admin / Dietas</li>
		</ol>
	</div>
	<!--/.row-->


	<div class="row">
		<div class="col-lg-10 col-lg-offset-1">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="pull-left">
						<a class="btn btn-primary"
							href="<c:url value='/admin/dieta/form'/>">Adicionar</a>
					</h4>
					<h4 class="title pull-center">Dietas</h4>
				</div>
				<div class="content table-responsive table-full-width">
					<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th><span class="color-red">#</span></th>
								<th><span class="color-red">Alterar</span></th>
								<th><span class="color-red">Deletar</span></th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${dietas}" var="dieta">
								<tr>
									<td>${dieta.id}</td>
									<td><a href="/admin/dieta/form/${dieta.id}">Alterar</a></td>
									<td><a href="/admin/dieta/remove/${dieta.id}">Remover</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


</myTags:template>