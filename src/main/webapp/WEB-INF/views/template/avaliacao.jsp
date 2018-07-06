<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="text-center">
	<label>DADOS DO AVALIADO:</label>
</div>

<div class="form-group">
	<label>Nome completo *</label>
	<p class="alert-warning text-center">
		<form:errors path="avaliado.usuario.nome" />
	</p>
	<form:input path="avaliado.usuario.nome"
		placeholder="Digite seu nome completo" class="form-control" />
</div>
<div class="form-group">
	<div class="row">
		<div class="col-md-6">
			<label>E-Mail *</label>
			<div id="emailDiv"></div>
			<p class="alert-warning text-center">
				<form:errors path="avaliado.usuario.email" />
			</p>
			<form:input path="avaliado.usuario.email"
				placeholder="Digite seu email" id="email" type="email"
				class="form-control" />
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label>Confirmação de e-mail *</label>
				<p class="alert-warning text-center">
					<form:errors path="avaliado.usuario.email" />
				</p>
				<input id="email1" onblur="validaEmail()"
					placeholder="Confirme seu email" type="email" class="form-control" />
			</div>
		</div>
	</div>
</div>

<div class="form-group">
	<label>Data de nascimento *</label>
	<p class="alert-warning text-center">
		<form:errors path="avaliado.dataNascimento" />
	</p>
	<form:input path="avaliado.dataNascimento"
		onkeyup="mascara(this, mdata);" placeholder="00/00/0000" size="14"
		maxlength="10" class="form-control" />
</div>

<div class="form-group">
	<label>Hora que acorda *</label>
	<p class="alert-warning text-center">
		<form:errors path="avaliado.horaAcorda" />
	</p>
	<form:select class="form-control" path="avaliado.horaAcorda">
		<form:option value="24">00:00</form:option>
		<form:option value="1">01:00</form:option>
		<form:option value="2">02:00</form:option>
		<form:option value="3">03:00</form:option>
		<form:option value="4">04:00</form:option>
		<form:option value="5">05:00</form:option>
		<form:option value="6">06:00</form:option>
		<form:option value="7">07:00</form:option>
		<form:option value="8">08:00</form:option>
		<form:option value="9">09:00</form:option>
		<form:option value="10">10:00</form:option>
		<form:option value="11">11:00</form:option>
		<form:option value="12">12:00</form:option>
		<form:option value="13">13:00</form:option>
		<form:option value="14">14:00</form:option>
		<form:option value="15">15:00</form:option>
		<form:option value="16">16:00</form:option>
		<form:option value="17">17:00</form:option>
		<form:option value="18">18:00</form:option>
		<form:option value="19">19:00</form:option>
		<form:option value="20">20:00</form:option>
		<form:option value="21">21:00</form:option>
		<form:option value="22">22:00</form:option>
		<form:option value="23">23:00</form:option>
	</form:select>

</div>

<div class="form-group">
	<label>Hora que dorme *</label>
	<p class="alert-warning text-center">
		<form:errors path="avaliado.horaDorme" />
	</p>
	<form:select class="form-control" path="avaliado.horaDorme">
		<form:option value="24">00:00</form:option>
		<form:option value="1">01:00</form:option>
		<form:option value="2">02:00</form:option>
		<form:option value="3">03:00</form:option>
		<form:option value="4">04:00</form:option>
		<form:option value="5">05:00</form:option>
		<form:option value="6">06:00</form:option>
		<form:option value="7">07:00</form:option>
		<form:option value="8">08:00</form:option>
		<form:option value="9">09:00</form:option>
		<form:option value="10">10:00</form:option>
		<form:option value="11">11:00</form:option>
		<form:option value="12">12:00</form:option>
		<form:option value="13">13:00</form:option>
		<form:option value="14">14:00</form:option>
		<form:option value="15">15:00</form:option>
		<form:option value="16">16:00</form:option>
		<form:option value="17">17:00</form:option>
		<form:option value="18">18:00</form:option>
		<form:option value="19">19:00</form:option>
		<form:option value="20">20:00</form:option>
		<form:option value="21">21:00</form:option>
		<form:option value="22">22:00</form:option>
		<form:option value="23">23:00</form:option>
	</form:select>
</div>

<div class="form-group">
	<label>Sexo</label><br />
	<p class="alert-warning text-center">
		<form:errors path="avaliado.sexo" />
	</p>
	<c:forEach items="${sexos}" var="sexo">
		<label class="radio-inline"> <form:radiobutton
				path="avaliado.sexo" value="${sexo }" />${sexo }
		</label>
	</c:forEach>
</div>

<div class="form-group">
	<label>Peso * (kg)</label>
	<p class="alert-warning text-center">
		<form:errors path="avaliacao.peso" />
	</p>
	<form:input path="avaliacao.peso"
		placeholder="Digite seu peso em kilogramas"
		onkeyup="validar(this,'num')" class="form-control" />
</div>

<div class="form-group">
	<label>Altura * (cm)</label>
	<p class="alert-warning text-center">
		<form:errors path="avaliacao.altura" />
	</p>
	<form:input path="avaliacao.altura" onkeyup="validar(this,'num')"
		placeholder="Digite sua altura em centimetros" class="form-control" />
</div>

<div class="form-group">
	<label>Coaching online</label><br /> <input type="radio"
		name="avaliacao.coaching" checked value="false" /> NÃO <input
		type="radio" name="avaliacao.coaching" value="true" /> SIM
</div>

<br />
<br />
<div class="text-center">
	<label>DADOS DA ANAMNESE:</label>
</div>
<br />
<div class="form-group">
	<label>1. Praticou/Pratica musculação? *</label><br />
	<p class="alert-warning text-center">
		<form:errors path="avaliado.anamnese.praticouMusculacao" />
	</p>
	<label class="radio-inline"> <form:radiobutton
			path="avaliado.anamnese.praticouMusculacao" value="SIM" /> Sim
	</label> <label class="radio-inline"> <form:radiobutton
			path="avaliado.anamnese.praticouMusculacao" value="NAO" /> Nao
	</label>
</div>

<div class="form-group">
	<label>2. Existe doença hereditária na familia? *</label><br />
	<p class="alert-warning text-center">
		<form:errors path="avaliado.anamnese.doencaHereditaria" />
	</p>
	<label class="radio-inline"> <form:radiobutton
			path="avaliado.anamnese.doencaHereditaria" value="SIM" /> Sim
	</label> <label class="radio-inline"> <form:radiobutton
			path="avaliado.anamnese.doencaHereditaria" value="NAO" /> Nao
	</label>
</div>

<div class="form-group">

	<label>3. Tratou alguma doença pessoal? *</label><br />
	<p class="alert-warning text-center">
		<form:errors path="avaliado.anamnese.doencaPessoal" />
	</p>
	<label class="radio-inline"> <form:radiobutton
			path="avaliado.anamnese.doencaPessoal" value="SIM" /> Sim
	</label> <label class="radio-inline"> <form:radiobutton
			path="avaliado.anamnese.doencaPessoal" value="NAO" /> Nao
	</label>
</div>

<div class="form-group">
	<label>4. Restrições para atividades físicas? *</label><br />
	<p class="alert-warning text-center">
		<form:errors path="avaliado.anamnese.restricaoPraticaAtivFisica" />
	</p>

	<label class="radio-inline"><form:radiobutton
			path="avaliado.anamnese.restricaoPraticaAtivFisica" value="SIM" />
		Sim </label> <label class="radio-inline"> <form:radiobutton
			path="avaliado.anamnese.restricaoPraticaAtivFisica" value="NAO" />
		Nao
	</label>
</div>

<div class="form-group">
	<label>5. Passou por alguma cirurgia recentemente? *</label><br />
	<p class="alert-warning text-center">
		<form:errors path="avaliado.anamnese.cirurgiaRecente" />
	</p>
	<label class="radio-inline"> <form:radiobutton
			path="avaliado.anamnese.cirurgiaRecente" value="SIM" /> Sim
	</label> <label class="radio-inline"> <form:radiobutton
			path="avaliado.anamnese.cirurgiaRecente" value="NAO" /> Nao
	</label>
</div>

<div class="form-group">
	<label>6. Possui alergias? *</label><br />

	<p class="alert-warning text-center">
		<form:errors path="avaliado.anamnese.alergias" />
	</p>
	<label class="radio-inline"> <form:radiobutton
			path="avaliado.anamnese.alergias" value="SIM" /> Sim
	</label> <label class="radio-inline"> <form:radiobutton
			path="avaliado.anamnese.alergias" value="NAO" /> Nao
	</label>
</div>

<div class="form-group">
	<label>7. Fumou ou fuma? *</label><br />
	<p class="alert-warning text-center">
		<form:errors path="avaliado.anamnese.fuma" />
	</p>
	<label class="radio-inline"> <form:radiobutton
			path="avaliado.anamnese.fuma" value="SIM" /> Sim
	</label> <label class="radio-inline"> <form:radiobutton
			path="avaliado.anamnese.fuma" value="NAO" /> Nao
	</label>
</div>

<div class="form-group">
	<label>Caso uma das respostas acima seja sim, responda-as</label>
	<textarea name="avaliado.anamnese.complemento" id="complemento"
		class="form-control" rows="5">1. Tempo de pratica:
2. Qual doença hereditária?:
3. Qual doença pessoal?:
4. Qual restrição?:
5. Qual cirurgia?:
6. Quais alergias?:
7. Quanto tempo?:</textarea>
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
		<form:errors path="avaliacao.perimetros.pescoco" />
	</p>
	<form:input path="avaliacao.perimetros.pescoco"
		onkeyup="validar(this,'num')"
		placeholder="Digite a medida do seu pescoço em centimetros"
		class="form-control" />
</div>

<div class="form-group">
	<label>Torax</label>
	<p class="alert-warning text-center">
		<form:errors path="avaliacao.perimetros.torax" />
	</p>
	<form:input path="avaliacao.perimetros.torax"
		onkeyup="validar(this,'num')"
		placeholder="Digite a medida do seu toxax em centimetros"
		class="form-control" />
</div>
<div class="form-group">
	<label>Cintura</label>
	<p class="alert-warning text-center">
		<form:errors path="avaliacao.perimetros.cintura" />
	</p>
	<form:input path="avaliacao.perimetros.cintura"
		onkeyup="validar(this,'num')"
		placeholder="Digite a medida da sua cintura em centimetros"
		class="form-control" />
</div>

<div class="form-group">
	<label>Abdômen</label>
	<p class="alert-warning text-center">
		<form:errors path="avaliacao.perimetros.abdomen" />
	</p>
	<form:input path="avaliacao.perimetros.abdomen"
		onkeyup="validar(this,'num')"
		placeholder="Digite a medida do seu abdômen em centimetros"
		class="form-control" />
</div>

<div class="form-group">
	<label>Quadril</label>
	<p class="alert-warning text-center">
		<form:errors path="avaliacao.perimetros.quadril" />
	</p>
	<form:input path="avaliacao.perimetros.quadril"
		onkeyup="validar(this,'num')"
		placeholder="Digite a medida do seu quadril em centimetros"
		class="form-control" />
</div>

<div class="row">

	<div class="col-md-6">
		<label>Antebraço Esquerdo</label>
		<p class="alert-warning text-center">
			<form:errors path="avaliacao.perimetros.anteBracoE" />
		</p>
		<form:input path="avaliacao.perimetros.anteBracoE"
			onkeyup="validar(this,'num')"
			placeholder="Digite a medida do seu antebraço esquerdo em centimetros"
			class="form-control" />
	</div>
	<div class="col-md-6">
		<label>Antebraço Direito</label>
		<p class="alert-warning text-center">
			<form:errors path="avaliacao.perimetros.anteBracoD" />
		</p>
		<form:input path="avaliacao.perimetros.anteBracoD"
			onkeyup="validar(this,'num')"
			placeholder="Digite a medida do seu antebraço direito em centimetros"
			class="form-control" />
	</div>

</div>

<div class="row">

	<div class="col-md-6">

		<label>Bíceps Esquerdo</label>
		<p class="alert-warning text-center">
			<form:errors path="avaliacao.perimetros.bicepsE" />
		</p>
		<form:input path="avaliacao.perimetros.bicepsE"
			onkeyup="validar(this,'num')"
			placeholder="Digite a medida do seu bíceps em centimetros"
			class="form-control" />

	</div>
	<div class="col-md-6">
		<label>Bíceps Direito</label>
		<p class="alert-warning text-center">
			<form:errors path="avaliacao.perimetros.bicepsD" />
		</p>
		<form:input path="avaliacao.perimetros.bicepsD"
			onkeyup="validar(this,'num')"
			placeholder="Digite a medida do seu bíceps direito em centimetros"
			class="form-control" />
	</div>

</div>

<div class="row">

	<div class="col-md-6">
		<label>Coxa Esquerda</label>
		<p class="alert-warning text-center">
			<form:errors path="avaliacao.perimetros.coxaE" />
		</p>
		<form:input path="avaliacao.perimetros.coxaE"
			onkeyup="validar(this,'num')"
			placeholder="Digite a medida da sua coxa esquerda em centimetros"
			class="form-control" />
	</div>
	<div class="col-md-6">
		<label>Coxa Direita</label>
		<p class="alert-warning text-center">
			<form:errors path="avaliacao.perimetros.coxaD" />
		</p>
		<form:input path="avaliacao.perimetros.coxaD"
			onkeyup="validar(this,'num')"
			placeholder="Digite a medida da sua coxa direita em centimetros"
			class="form-control" />
	</div>

</div>

<div class="row">

	<div class="col-md-6">
		<label>Panturrilha Esquerda</label>
		<p class="alert-warning text-center">
			<form:errors path="avaliacao.perimetros.panturrilhaE" />
		</p>
		<form:input path="avaliacao.perimetros.panturrilhaE"
			onkeyup="validar(this,'num')"
			placeholder="Digite a medida da sua panturrilha esquerda em centimetros"
			class="form-control" />
	</div>
	<div class="col-md-6">
		<label>Panturrilha Direita</label>
		<p class="alert-warning text-center">
			<form:errors path="avaliacao.perimetros.panturrilhaD" />
		</p>
		<form:input path="avaliacao.perimetros.panturrilhaD"
			onkeyup="validar(this,'num')"
			placeholder="Digite a medida da sua panturrilha direita em centimetros"
			class="form-control" />
	</div>

</div>


<br />
<br />