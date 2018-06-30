<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<security:authentication property="principal" var="user" />



<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#sidebar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value='/'/>"><b><span>BodyShock</span>
				System</b></a>

		</div>
	</div>
	<!-- /.container-fluid -->
</nav>
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
	<div class="profile-sidebar">
		<div class="profile-userpic"></div>
		<div class="profile-usertitle">
			<div class="profile-usertitle-name text-center">${user.nome}</div>
			<!-- <label>ddd</label> -->
		</div>
		<div class="clear"></div>
	</div>
	<div class="divider"></div>
	<ul class="nav menu">
		<security:authorize access="hasRole('ROLE_ADMINISTRADOR')">
			<li class="active"><a href="<c:url value='/dashboard'/>"><em
					class="fa fa-home">&nbsp;</em> Dashboard</a></li>

			<li><a href="<c:url value='/admin/avaliado'/>"><em
					class="fa fa-user-o">&nbsp;</em> Avaliados</a></li>

			<li><a class="" href="<c:url value='/admin/avaliacao'/>"> <span
					class="fa fa-heartbeat">&nbsp;</span> Avaliação
			</a></li>

			<li><a href="<c:url value='/admin/relatorios'/>"><em
					class="fa fa-folder">&nbsp;</em> Relatórios</a></li>
			<li><a href="<c:url value='/admin/dieta'/>"> <span
					class="fa fa-cutlery">&nbsp;</span> Dieta
			</a></li>
			<li><a class="" href="/admin/treino"><img width="18px"
					src='https://cdn3.iconfinder.com/data/icons/glyph/227/Dumbbell-48.png' />&nbsp;Treino
			</a></li>

		</security:authorize>

		<security:authorize access="hasRole('ROLE_AVALIADO')">
			<li class="active"><a href="<c:url value='/dashboard'/>"><em
					class="fa fa-home">&nbsp;</em> Dashboard</a></li>
			<li><a href="<c:url value='/avaliado/dicas-alimentacao'/>"><em
					class="fa fa-cutlery">&nbsp;</em> Dicas de Alimentação</a></li>
			<li><a href="<c:url value='/avaliado/treino'/>"><img
					width="18px"
					src='https://cdn3.iconfinder.com/data/icons/glyph/227/Dumbbell-48.png' />&nbsp;Treino</a></li>

			<li><a href="<c:url value='/avaliado/retorno'/>"><em
					class="fa fa-refresh"></em>&nbsp;Retorno</a></li>


		</security:authorize>


		<li><a href="<c:url value='/logout'/>"><em
				class="fa fa-power-off">&nbsp;</em> Deslogar</a></li>
	</ul>
</div>
<!--/.sidebar-->