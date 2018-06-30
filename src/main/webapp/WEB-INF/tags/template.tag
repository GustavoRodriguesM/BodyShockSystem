<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags"
	prefix="security"%>
<%@attribute name="bodyName" required="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BodyShock System</title>
<link href="<c:url value='/assets/front/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/assets/front/css/font-awesome.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/assets/front/css/datepicker3.css'/>"
	rel="stylesheet">
<link href="<c:url value='/assets/front/css/styles.css'/>"
	rel="stylesheet">

<link rel="icon" type="image/png" sizes="32x32"
	href="<c:url value ="/assets/images/favicon/favicon-32x32.png"/>">
<link rel="icon" type="image/png" sizes="96x96"
	href="<c:url value='/favicon-96x96.png'/>">

<script src="<c:url value='/assets/front/js/jquery-1.11.1.min.js'/>"></script>
<script src="<c:url value='/assets/js/jquery.mask.js'/>"></script>
<script src="<c:url value='/assets/front/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/assets/front/js/chart.min.js'/>"></script>

<script src="<c:url value='/assets/front/js/bootstrap-datepicker.js'/>"></script>
<script src="<c:url value='/assets/front/js/custom.js'/>"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
	$(document).ready(function() {
		${sweetAlert}
	});
</script>
<style>
.back-link {
	margin-top: 30px;
}

.profile-sidebar {
	margin-top: 4em;
}

.breadcrumb {
	margin-top: 4em;
}
</style>
</head>

<body>


	<jsp:include page="/WEB-INF/views/common/menu.jsp" />
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main  content">
		<jsp:doBody />

		<div class="col-lg-12">
			<p class="back-link">
				Desenvolvido por <a href="#">Gustavo Rodrigues</a>
			</p>
		</div>



	</div>



</body>

</html>