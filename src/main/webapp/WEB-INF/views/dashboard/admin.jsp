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
	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>

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


	<script type="text/javascript">
	
	//ACESSOS DO MES
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
      
      
      google.charts.load("current", {packages:['corechart']});
      google.charts.setOnLoadCallback(drawChartColumn);
      function drawChartColumn() {
        var data = google.visualization.arrayToDataTable([
          ["Element", "Density", { role: "style" } ],
          ["Copper", 8.94, "#b87333"],
          ["Silver", 10.49, "silver"],
          ["Gold", 19.30, "gold"],
          ["Platinum", 21.45, "color: #e5e4e2"],
          ["Platinum", 21.45, "color: #e5e4e2"]
        ]);

        var view = new google.visualization.DataView(data);
        view.setColumns([0, 1,
                         { calc: "stringify",
                           sourceColumn: 1,
                           type: "string",
                           role: "annotation" },
                         2]);

        var options = {
          title: "Density of Precious Metals, in g/cm^3",
          width: 600,
          height: 400,
          bar: {groupWidth: "95%"},
          legend: { position: "none" },
        };
        var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
        chart.draw(view, options);
    }
    </script>

	<div class="row">
		<div class="col-lg-10 col-lg-offset-1">

			<div class="col-lg-6">
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
			
			<div class="col-lg-6">
				<div class="panel panel-default">
					<div class="canvas-heading text-center">
						<div class="panel-body">
							<div class="canvas-wrapper">
								<div id="columnchart_values" style="width: 500px; height: 400px;margin-top: -30px">Test</div>
								<div id="piechart" style="width: 500px; height: 400px;margin-top: -30px"></div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</myTags:template>