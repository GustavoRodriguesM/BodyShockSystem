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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>


	<div class="panel panel-container" style="margin-top: 5em">
		<div class="row">
			${mensagem}
			<div class="col-md-4 col-xs-6 no-padding">
				<div class="panel panel-orange panel-widget border-right">
					<div class="row no-padding">
						<em class="fa fa-xl fa-users color-teal"></em>
						<div class="large">${numeroAvaliacoes}</div>
						<div class="text-muted">Avaliações</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-xs-6 no-padding">
				<div class="panel panel-teal panel-widget border-right">
					<div class="row no-padding">
						<em class="fa fa-xl fa-shopping-cart color-blue"></em>
						<div class="large">${numeroAvaliacoesMes}</div>
						<div class="text-muted">Vendas do mês</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-xs-12 no-padding">
				<div class="panel panel-red panel-widget ">
					<div class="row no-padding">
						<em class="fa fa-xl fa-money color-teal"></em>
						<div class="large">R$ ${monetarioPendente}</div>
						<div class="text-muted">Renda a receber</div>
					</div>
				</div>
			</div>
		</div>
		<!--/.row-->
	</div>

	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Objetivo', 'Acessos do mês'],
          ['Home', ${dados.get(0)}],
          ["Cadastro",${dados.get(1)}],
          ["Pagina treino", ${dados.get(2)}],
          ["Pagina dieta", ${dados.get(3)}]
        ]);

        var options = {
          title: 'Acessos este mês'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>

	<div class="row">
		<div class="col-lg-10 col-lg-offset-1">

			<div class="col-lg-6 col-lg-offset-3">
				<div class="panel panel-default">
					<div class="canvas-heading text-center">
						<div class="panel-body">
							<div class="canvas-wrapper">
								<div id="piechart" style="width: 500px; height: 400px;margin-top: -30px"></div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</myTags:template>