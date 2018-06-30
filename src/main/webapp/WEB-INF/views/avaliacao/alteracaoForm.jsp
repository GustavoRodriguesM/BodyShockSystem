
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<myTags:template bodyName="Dashboard">


	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"> <em class="fa fa-home"></em>
			</a></li>
			<li class="active">Admin / Avaliação / Alteração</li>
		</ol>
	</div>
	<!--/.row-->

	<div class="row">
		<div class="col-lg-8 col-lg-offset-2">

			<h4 class="title text-center">Avaliação - ${id}</h4>

			<form:form action="/admin/avaliacao/altera" method="POST"
				modelAttribute="avaliacao">

				<div class="form-group">
					<label>Peso * (kg)</label>
					<p class="alert-warning text-center">
						<form:errors path="peso" />
					</p>
					<form:input path="peso" placeholder="Digite seu peso em kilogramas"
						onkeyup="validar(this,'num')" class="form-control" />
				</div>

				<div class="form-group">
					<label>Altura * (cm)</label>
					<p class="alert-warning text-center">
						<form:errors path="altura" />
					</p>
					<form:input path="altura" onkeyup="validar(this,'num')"
						placeholder="Digite sua altura em centimetros"
						class="form-control" />
				</div>

				<div class="form-group">
					<label>Coaching online</label><br /> <input type="radio"
						name="coaching" checked value="false" /> NÃO <input type="radio"
						name="coaching" value="true" /> SIM
				</div>

				<br />
				<br />
				<div class="text-center">
					<label>DADOS PERIMETRAIS:</label>
					<p class="color-red">
						<b>AS MEDIAS DEVEM ESTAR EM CENTIMETROS</b>
					</p>
				</div>
				<br />

				<div class="form-group">
					<label>Pescoço</label>
					<p class="alert-warning text-center">
						<form:errors path="perimetros.pescoco" />
					</p>
					<form:input path="perimetros.pescoco" onkeyup="validar(this,'num')"
						placeholder="Digite a medida do seu pescoço em centimetros"
						class="form-control" />
				</div>

				<div class="form-group">
					<label>Torax</label>
					<p class="alert-warning text-center">
						<form:errors path="perimetros.torax" />
					</p>
					<form:input path="perimetros.torax" onkeyup="validar(this,'num')"
						placeholder="Digite a medida do seu toxax em centimetros"
						class="form-control" />
				</div>
				<div class="form-group">
					<label>Cintura</label>
					<p class="alert-warning text-center">
						<form:errors path="perimetros.cintura" />
					</p>
					<form:input path="perimetros.cintura" onkeyup="validar(this,'num')"
						placeholder="Digite a medida da sua cintura em centimetros"
						class="form-control" />
				</div>

				<div class="form-group">
					<label>Abdômen</label>
					<p class="alert-warning text-center">
						<form:errors path="perimetros.abdomen" />
					</p>
					<form:input path="perimetros.abdomen" onkeyup="validar(this,'num')"
						placeholder="Digite a medida do seu abdômen em centimetros"
						class="form-control" />
				</div>

				<div class="form-group">
					<label>Quadril</label>
					<p class="alert-warning text-center">
						<form:errors path="perimetros.quadril" />
					</p>
					<form:input path="perimetros.quadril" onkeyup="validar(this,'num')"
						placeholder="Digite a medida do seu quadril em centimetros"
						class="form-control" />
				</div>

				<div class="form-group">
					<label>Antebraço Direito</label>
					<p class="alert-warning text-center">
						<form:errors path="perimetros.anteBracoD" />
					</p>
					<form:input path="perimetros.anteBracoD"
						onkeyup="validar(this,'num')"
						placeholder="Digite a medida do seu antebraço direito em centimetros"
						class="form-control" />
				</div>
				<div class="form-group">
					<label>Antebraço Esquerdo</label>
					<p class="alert-warning text-center">
						<form:errors path="perimetros.anteBracoE" />
					</p>
					<form:input path="perimetros.anteBracoE"
						onkeyup="validar(this,'num')"
						placeholder="Digite a medida do seu antebraço esquerdo em centimetros"
						class="form-control" />
				</div>

				<div class="form-group">
					<label>Bíceps Direito</label>
					<p class="alert-warning text-center">
						<form:errors path="perimetros.bicepsD" />
					</p>
					<form:input path="perimetros.bicepsD" onkeyup="validar(this,'num')"
						placeholder="Digite a medida do seu bíceps direito em centimetros"
						class="form-control" />
				</div>
				<div class="form-group">
					<label>Bíceps Esquerdo</label>
					<p class="alert-warning text-center">
						<form:errors path="perimetros.bicepsE" />
					</p>
					<form:input path="perimetros.bicepsE" onkeyup="validar(this,'num')"
						placeholder="Digite a medida do seu bíceps em centimetros"
						class="form-control" />
				</div>

				<div class="form-group">
					<label>Coxa Direita</label>
					<p class="alert-warning text-center">
						<form:errors path="perimetros.coxaD" />
					</p>
					<form:input path="perimetros.coxaD" onkeyup="validar(this,'num')"
						placeholder="Digite a medida da sua coxa direita em centimetros"
						class="form-control" />
				</div>

				<div class="form-group">
					<label>Coxa Esquerda</label>
					<p class="alert-warning text-center">
						<form:errors path="perimetros.coxaE" />
					</p>
					<form:input path="perimetros.coxaE" onkeyup="validar(this,'num')"
						placeholder="Digite a medida da sua coxa esquerda em centimetros"
						class="form-control" />
				</div>

				<div class="form-group">
					<label>Panturrilha Direita</label>
					<p class="alert-warning text-center">
						<form:errors path="perimetros.panturrilhaD" />
					</p>
					<form:input path="perimetros.panturrilhaD"
						onkeyup="validar(this,'num')"
						placeholder="Digite a medida da sua panturrilha direita em centimetros"
						class="form-control" />
				</div>
				<div class="form-group">
					<label>Panturrilha Esquerda</label>
					<p class="alert-warning text-center">
						<form:errors path="perimetros.panturrilhaE" />
					</p>
					<form:input path="perimetros.panturrilhaE"
						onkeyup="validar(this,'num')"
						placeholder="Digite a medida da sua panturrilha esquerda em centimetros"
						class="form-control" />
				</div>

				<br />
				<br />
				
				<c:if test="${avaliacao.tipoAvaliacao == 'ADIPOMETRO'}">
					<div class="text-center">
					<label>DADOS DA AVALIAÇÃO:</label>

				</div>
				<br />


				<div id="dobrasM">

					<div class="form-group">
						<label>Dobra Toracica (<b class="color-red">HOMEM</b>)*
						</label>
						<p class="alert-warning text-center">
							<form:errors path="dToracica" />
						</p>
						<form:input path="dToracica"
							onkeyup="validar(this,'num')" maxlength="6"
							class="form-control" />
					</div>

					<div class="form-group">
						<label>Dobra Abdominal (<b class="color-red">HOMEM</b>)*
						</label>
						<p class="alert-warning text-center">
							<form:errors path="dAbdominal" />
						</p>
						<form:input path="dAbdominal"
							onkeyup="validar(this,'num')" maxlength="6"
							class="form-control" />
					</div>

				</div>

				<div id="dobrasF">

					<div class="form-group">
						<label>Dobra Triciptal (<b class="color-red">MULHER</b>)*
						</label>
						<p class="alert-warning text-center">
							<form:errors path="dTriciptal" />
						</p>
						<form:input path="dTriciptal"
							onkeyup="validar(this,'num')" maxlength="6"
							class="form-control" />
					</div>

					<div class="form-group">
						<label>Dobra Supra Ilíaca (<b class="color-red">MULHER</b>)*
						</label>
						<p class="alert-warning text-center">
							<form:errors path="dSupraIliaca" />
						</p>
						<form:input path="dSupraIliaca"
							onkeyup="validar(this,'num')" maxlength="6"
							class="form-control" />
					</div>

				</div>

				<div class="form-group">
					<label>Dobra Coxa (AMBOS)*</label>
					<p class="alert-warning text-center">
						<form:errors path="dCoxa" />
					</p>
					<form:input path="dCoxa" maxlength="6"
						onkeyup="validar(this,'num')" class="form-control" />
				</div>
				</c:if>

				<form:input type="hidden" path="tipoAvaliacao" />
				<form:input type="hidden" path="status" />
				<form:input type="hidden" path="data" />
				<form:input type="hidden" path="dataPagamento" />
				<form:input type="hidden" path="ativacao" />
				<form:input type="hidden" path="perimetros.id" />
				<form:input type="hidden" path="id" />
				<form:input type="hidden" path="avaliado.id" />
				<br />
				<br />

				<div class="form-group text-center">
					<input type="submit" class="btn btn-primary"
						value="Salvar alteração" />
				</div>
			</form:form>

			<br /> <br />

		</div>
	</div>


</myTags:template>