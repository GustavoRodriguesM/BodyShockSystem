function validaEmail() {
	var email = document.getElementById('email');
	var email1 = document.getElementById('email1');
	if (email.value != email1.value) {
		document.getElementById("emailDiv").innerHTML = "<p class='text-center alert-danger'>Email incorreto</p>";
	} else {
		document.getElementById("emailDiv").innerHTML = "";
	}
}

function dobras(radio) {
	if (radio.value == 'MASCULINO') {
		$('#dobrasM').removeClass('invisible');
		$('#dobrasF').addClass('invisible');
	}
	if (radio.value == 'FEMININO') {
		$('#dobrasF').removeClass('invisible');
		$('#dobrasM').addClass('invisible');
	}

}

$(document).ready(function() {
	if ($('input[name=sexo]:checked').val() == 'MASCULINO') {
		$('#dobrasM').removeClass('invisible');
		$('#dobrasF').addClass('invisible');
	}
	if ($('input[name=sexo]:checked').val() == 'FEMININO') {
		$('#dobrasF').removeClass('invisible');
		$('#dobrasM').addClass('invisible');
	}
});

function loadValidaEmail() {
	var email = document.getElementById('email');
	var email1 = document.getElementById('email1');
	if (email.value != email1.value) {
		document.getElementById("emailDiv").innerHTML = "<p class='text-center alert-warning'>Confirme novamente seu email.</p>";
	} else {
		document.getElementById("emailDiv").innerHTML = "";
	}
}

function mascaraInteiro() {
	if (event.keyCode < 48 || event.keyCode > 57) {
		event.returnValue = false;
		return false;
	}
	return true;
}

function MascaraCPF(cpf) {
	if (mascaraInteiro(cpf) == false) {
		event.returnValue = false;
	}
	return formataCampo(cpf, '000.000.000-00', event);
}

function formataCampo(campo, Mascara, evento) {
	var boleanoMascara;

	var Digitato = evento.keyCode;
	exp = /\-|\.|\/|\(|\)| /g
	campoSoNumeros = campo.value.toString().replace(exp, "");

	var posicaoCampo = 0;
	var NovoValorCampo = "";
	var TamanhoMascara = campoSoNumeros.length;
	;

	if (Digitato != 8) { // backspace
		for (i = 0; i <= TamanhoMascara; i++) {
			boleanoMascara = ((Mascara.charAt(i) == "-")
					|| (Mascara.charAt(i) == ".") || (Mascara.charAt(i) == "/"))
			boleanoMascara = boleanoMascara
					|| ((Mascara.charAt(i) == "(")
							|| (Mascara.charAt(i) == ")") || (Mascara.charAt(i) == " "))
			if (boleanoMascara) {
				NovoValorCampo += Mascara.charAt(i);
				TamanhoMascara++;
			} else {
				NovoValorCampo += campoSoNumeros.charAt(posicaoCampo);
				posicaoCampo++;
			}
		}
		campo.value = NovoValorCampo;
		return true;
	} else {
		return true;
	}
}

function mascara(o, f) {
	v_obj = o
	v_fun = f
	setTimeout("execmascara()", 1)
}

function execmascara() {
	v_obj.value = v_fun(v_obj.value)
}

function validar(dom, tipo) {
	switch (tipo) {
	case 'num':
		var regex = /[A-Za-z,:;]/g;
		break;
	case 'text':
		var regex = /\d/g;
		break;
	}
	dom.value = dom.value.replace(regex, '');
}

function mdata(v) {
	v = v.replace(/\D/g, "");
	v = v.replace(/(\d{2})(\d)/, "$1/$2");
	v = v.replace(/(\d{2})(\d)/, "$1/$2");

	v = v.replace(/(\d{2})(\d{2})$/, "$1$2");
	return v;
}

function submitForm() {
	$.LoadingOverlay("show");
	var form = document.getElementById("avaliado");
	form.submit();
}

$('#myTabs a').click(function(e) {
	e.preventDefault()
	$(this).tab('show')
})