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
			<li class="active">Dicas de Alimentação</li>
		</ol>
	</div>


	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="title">Dicas de alimentação para ganho de massa
					magra e redução de gorduras</h4>
			</div>

			<div class="row">
				<div class="col-lg-12 content">

					<div class="col-lg-8 col-lg-offset-2">
						<div class="row text-center">

							<p style="margin-top: 3em">
								Procure comer de <b class="color-red">3 em 3 horas</b> começando
								pela hora que se acorda até a hora de dormir. <br />Toda
								refeição deve contém carboidratos e proteínas. Suplementos e
								vitaminas são de <b class="color-red">suma</b> importância para
								um bom resultado.
							</p>


						</div>

						<div class="row">

							<div class="col-md-8 col-md-offset-2">
								<h3 class="color-red text-center">Cardápio sugerido</h3>
								<table class="table">
									<thead class="background-red">
										<tr>
											<th class="color-white">HORÁRIO</th>
											<th class="color-white">REFEIÇÃO</th>
										</tr>
									</thead>

									<tbody>
										<tr>
											<td>${client.horarios.get(0).horario}:00hrs</td>
											<td>${client.dieta.ref1}</td>
										</tr>
										<tr>
											<td>${client.horarios.get(1).horario}:00hrs</td>
											<td>${client.dieta.ref2}</td>
										</tr>
										<tr>
											<td>${client.horarios.get(2).horario}:00hrs</td>
											<td>${client.dieta.ref3}</td>
										</tr>
										<tr>
											<td>${client.horarios.get(3).horario}:00hrs</td>
											<td>${client.dieta.ref4}</td>
										</tr>
										<tr>
											<td>${client.horarios.get(4).horario}:00hrs</td>
											<td>${client.dieta.ref5}</td>
										</tr>
										<c:if test="${client.horarios.size() > 5}">
											<tr>
												<td>${client.horarios.get(5).horario}:00hrs</td>
												<td>${client.dieta.ref6}</td>
											</tr>
										</c:if>
										<c:if test="${client.horarios.size() > 6}">
											<tr>
												<td>${client.horarios.get(6).horario}:00hrs</td>
												<td>${client.dieta.ref7}</td>
											</tr>
										</c:if>

									</tbody>


								</table>
							</div>

						</div>

						<div class="row">
							<h3 class="color-red">Carboidratos</h3>
							<ul>
								<li>${client.dieta.carbo1}</li>
								<li>${client.dieta.carbo2}</li>
								<li>${client.dieta.carbo3}</li>
								<li>${client.dieta.carbo4}</li>
							</ul>

						</div>

						<div class="row">
							<h3 class="color-red">Proteinas</h3>
							<ul>
								<li>${client.dieta.prot1}</li>
								<li>${client.dieta.prot2}</li>
								<li>${client.dieta.prot3}</li>
							</ul>
						</div>

						<div class="row">
							<h3 class="color-red">Suplementos</h3>
							<ul>
								<li>${client.dieta.suplem1}</li>
								<li>${client.dieta.suplem2}</li>
							</ul>
						</div>

						<div class="row">
							<h3 class="color-red">Vitaminas</h3>
							<ul>
								<li>${client.dieta.vit1}</li>
								<li>${client.dieta.vit2}</li>
								<li>${client.dieta.vit3}</li>
							</ul>
						</div>

						<div class="row">
							<h3 class="color-red">Mais</h3>
							<ul>
								<li>Salada com folhas verdes à vontade.</li>
								<li>Uso reduzido de sal.</li>
								<li>Evitar óleos de qualquer tipo nos alimentos.</li>
							</ul>
						</div>

						<br /> <br />
					</div>

				</div>
			</div>

		</div>
	</div>

</myTags:template>