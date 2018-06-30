<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>



<myTags:template bodyName="Dashboard">

	<style>
.content {
	background-color: #fff;
}
</style>


	<script>
function validaEmail(){
	var email = document.getElementById('email');
	var email1 = document.getElementById('email1');
	if(email.value != email1.value){
		document.getElementById("emailDiv").innerHTML = "<p class='text-center alert-danger'>Email incorreto</p>";
	}else{
		document.getElementById("emailDiv").innerHTML = "";
	}
}

function loadValidaEmail(){
	var email = document.getElementById('email');
	var email1 = document.getElementById('email1');
	if(email.value != email1.value){
		document.getElementById("emailDiv").innerHTML = "<p class='text-center alert-warning'>Confirme novamente seu email.</p>";
	}else{
		document.getElementById("emailDiv").innerHTML = "";
	}
}

function mascaraInteiro(){
    if (event.keyCode < 48 || event.keyCode > 57){
            event.returnValue = false;
            return false;
    }
    return true;
}

function MascaraCPF(cpf){
    if(mascaraInteiro(cpf)==false){
            event.returnValue = false;
    }       
    return formataCampo(cpf, '000.000.000-00', event);
}

function formataCampo(campo, Mascara, evento) { 
    var boleanoMascara; 

    var Digitato = evento.keyCode;
    exp = /\-|\.|\/|\(|\)| /g
    campoSoNumeros = campo.value.toString().replace( exp, "" ); 

    var posicaoCampo = 0;    
    var NovoValorCampo="";
    var TamanhoMascara = campoSoNumeros.length;; 

    if (Digitato != 8) { // backspace 
            for(i=0; i<= TamanhoMascara; i++) { 
                    boleanoMascara  = ((Mascara.charAt(i) == "-") || (Mascara.charAt(i) == ".")
                                                            || (Mascara.charAt(i) == "/")) 
                    boleanoMascara  = boleanoMascara || ((Mascara.charAt(i) == "(") 
                                                            || (Mascara.charAt(i) == ")") || (Mascara.charAt(i) == " ")) 
                    if (boleanoMascara) { 
                            NovoValorCampo += Mascara.charAt(i); 
                              TamanhoMascara++;
                    }else { 
                            NovoValorCampo += campoSoNumeros.charAt(posicaoCampo); 
                            posicaoCampo++; 
                      }              
              }      
            campo.value = NovoValorCampo;
              return true; 
    }else { 
            return true; 
    }
}

function mascara(o,f){
    v_obj=o
    v_fun=f
    setTimeout("execmascara()",1)
}

function execmascara(){
    v_obj.value=v_fun(v_obj.value)
}

function validar(dom, tipo) {
	switch (tipo) {
	case 'num':
		var regex = /[A-Za-z,:;.]/g;
		break;
	case 'text':
		var regex = /\d/g;
		break;
	}
	dom.value = dom.value.replace(regex, '');
}

function mdata(v){
    v=v.replace(/\D/g,"");                  
    v=v.replace(/(\d{2})(\d)/,"$1/$2");       
    v=v.replace(/(\d{2})(\d)/,"$1/$2");       
                                             
    v=v.replace(/(\d{2})(\d{2})$/,"$1$2");
    return v;
}
</script>

	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"> <em class="fa fa-home"></em>
			</a></li>
			<li class="active">Retorno</li>
		</ol>
	</div>


	<div class="row">
		<div class="col-lg-10 col-lg-offset-1 content">


			<a href="<c:url value='/'/>"><img
				src="<c:url value='/assets/images/logoPreto.png'/>"
				class="img img-responsive center-block" /></a>
			<p class="color-red text-center">
				<b>ATENÇÃO</b>
			</p>
			<p class="text-center">
				Algumas medidas já pré-escritas devem ser revisadas antes de
				cadastrar o retorno. <b>Não</b> será realizada a alteração de
				avaliações que forem salvas de maneira errada.
			</p>


			<c:if test="${avaliado.diasTreinados >= 70}">

				<div class="col-md-8 col-md-offset-2">

					<form:form servletRelativeAction="/avaliado/retorno"
						modelAttribute="avaliacao" method="post">

						<div class="text-center">
							<label>INFORMAÇÕES DE RETORNO:</label>

						</div>

						<div class="form-group">
							<label>Peso * (kg)</label>
							<p class="alert-warning text-center">
								<form:errors path="peso" />
							</p>
							<form:input path="peso" onkeyup="validar(this,'num')"
								class="form-control" />
						</div>

						<div class="form-group">
							<label>Altura * (cm)</label>
							<p class="alert-warning text-center">
								<form:errors path="altura" />
							</p>
							<form:input path="altura" onkeyup="validar(this,'num')"
								class="form-control" />
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
							<form:input path="perimetros.pescoco"
								onkeyup="validar(this,'num')" class="form-control" />
						</div>

						<div class="form-group">
							<label>Torax</label>
							<p class="alert-warning text-center">
								<form:errors path="perimetros.torax" />
							</p>
							<form:input path="perimetros.torax" onkeyup="validar(this,'num')"
								class="form-control" />
						</div>
						<div class="form-group">
							<label>Cintura</label>
							<p class="alert-warning text-center">
								<form:errors path="perimetros.cintura" />
							</p>
							<form:input path="perimetros.cintura"
								onkeyup="validar(this,'num')" class="form-control" />
						</div>

						<div class="form-group">
							<label>Abdomen</label>
							<p class="alert-warning text-center">
								<form:errors path="perimetros.abdomen" />
							</p>
							<form:input path="perimetros.abdomen"
								onkeyup="validar(this,'num')" class="form-control" />
						</div>

						<div class="form-group">
							<label>Quadril</label>
							<p class="alert-warning text-center">
								<form:errors path="perimetros.quadril" />
							</p>
							<form:input path="perimetros.quadril"
								onkeyup="validar(this,'num')" class="form-control" />
						</div>

						<div class="form-group">
							<label>Antebraço Direito</label>
							<p class="alert-warning text-center">
								<form:errors path="perimetros.anteBracoD" />
							</p>
							<form:input path="perimetros.anteBracoD"
								onkeyup="validar(this,'num')" class="form-control" />
						</div>
						<div class="form-group">
							<label>Antebraço Esquerdo</label>
							<p class="alert-warning text-center">
								<form:errors path="perimetros.anteBracoE" />
							</p>
							<form:input path="perimetros.anteBracoE"
								onkeyup="validar(this,'num')" class="form-control" />
						</div>

						<div class="form-group">
							<label>Bíceps Direito</label>
							<p class="alert-warning text-center">
								<form:errors path="perimetros.bicepsD" />
							</p>
							<form:input path="perimetros.bicepsD"
								onkeyup="validar(this,'num')" class="form-control" />
						</div>
						<div class="form-group">
							<label>Bíceps Esquerdo</label>
							<p class="alert-warning text-center">
								<form:errors path="perimetros.bicepsE" />
							</p>
							<form:input path="perimetros.bicepsE"
								onkeyup="validar(this,'num')" class="form-control" />
						</div>

						<div class="form-group">
							<label>Coxa Direita</label>
							<p class="alert-warning text-center">
								<form:errors path="perimetros.coxaD" />
							</p>
							<form:input path="perimetros.coxaD" onkeyup="validar(this,'num')"
								class="form-control" />
						</div>
						<div class="form-group">
							<label>Coxa Esquerda</label>
							<p class="alert-warning text-center">
								<form:errors path="perimetros.coxaE" />
							</p>
							<form:input path="perimetros.coxaE" onkeyup="validar(this,'num')"
								class="form-control" />
						</div>

						<div class="form-group">
							<label>Panturrilha Direita</label>
							<p class="alert-warning text-center">
								<form:errors path="perimetros.panturrilhaD" />
							</p>
							<form:input path="perimetros.panturrilhaD"
								onkeyup="validar(this,'num')" class="form-control" />
						</div>
						<div class="form-group">
							<label>Panturrilha Esquerda</label>
							<p class="alert-warning text-center">
								<form:errors path="perimetros.panturrilhaE" />
							</p>
							<form:input path="perimetros.panturrilhaE"
								onkeyup="validar(this,'num')" class="form-control" />
						</div>

						<br />
						<br />
						<c:if test="${avaliacao.tipoAvaliacao == 'ADIPOMETRO'}">


							<div class="text-center">
								<label>DOBRAS:</label>
								<p class="color-red">
									<b>AS MEDIAS DEVEM ESTAR EM CENTIMETROS</b>
								</p>
							</div>
							<br />

							<div class="form-group">
								<label>Dobra Toracica (HOMEM)*</label>
								<p class="alert-warning text-center">
									<form:errors path="dToracica" />
								</p>
								<form:input path="dToracica" onkeyup="validar(this,'num')"
									maxlength="6" value="0" class="form-control" />
							</div>

							<div class="form-group">
								<label>Dobra Abdominal (HOMEM)*</label>
								<p class="alert-warning text-center">
									<form:errors path="dAbdominal" />
								</p>
								<form:input path="dAbdominal" onkeyup="validar(this,'num')"
									maxlength="6" value="0" class="form-control" />
							</div>

							<div class="form-group">
								<label>Dobra Triciptal (MULHER)*</label>
								<p class="alert-warning text-center">
									<form:errors path="dTriciptal" />
								</p>
								<form:input path="dTriciptal" onkeyup="validar(this,'num')"
									maxlength="6" value="0" class="form-control" />
							</div>

							<div class="form-group">
								<label>Dobra Supra Ilíaca (MULHER)*</label>
								<p class="alert-warning text-center">
									<form:errors path="dSupraIliaca" />
								</p>
								<form:input path="dSupraIliaca" onkeyup="validar(this,'num')"
									maxlength="6" value="0" class="form-control" />
							</div>

							<div class="form-group">
								<label>Dobra Coxa (AMBOS)*</label>
								<p class="alert-warning text-center">
									<form:errors path="dCoxa" />
								</p>
								<form:input path="dCoxa" maxlength="6" value="0"
									onkeyup="validar(this,'num')" class="form-control" />
							</div>


						</c:if>

						<div class="form-group">
							<form:input type="hidden" path="coaching" />
							<form:input type="hidden" path="tipoAvaliacao" />
							<form:input type="hidden" path="avaliado.id" />
							<form:input type="hidden" path="porcentagemGorduraIdeal" />
						</div>
						<br />
						<input type="submit" class="btn btn-primary center-block"
							value="CADASTRAR" />
						<br />
						<br />
					</form:form>

				</div>

			</c:if>

			<c:if
				test="${avaliado.diasTreinados < 70 && avaliacao.status == 'PAGO'}">
				<div class="col-md-12">
					<p>Opa! Parece que você ainda não está apto a fazer o retorno!
						Volte mais tarde :)</p>
				</div>
			</c:if>


			<br /> <br /> <br />

		</div>

	</div>

</myTags:template>
