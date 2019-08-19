<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!-- ======================================= LES TAGLIBS ========================================== -->
<!-- taglib de jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- taglib de Spring Security -->
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Titre de la page</title>

<!-- Spécification du chemin de la lib Popper -->
<script
	src="<c:url value="/resources/bootstrap-Litera/js/popper.min.js" />"></script>

<!-- Spécification du chemin de la lib jQuery -->
<script
	src="<c:url value="/resources/bootstrap-Litera/js/jquery-3.4.1.js" />"></script>

<!-- Spécification du chemin la lib js Bootrap à la page -->
<script
	src="<c:url value="/resources/bootstrap-Litera/js/bootstrap.min.js" />"></script>

<!-- Spécification du chemin la lib css Bootrap à la page -->
<link
	href="<c:url value="/resources/bootstrap-Litera/css/bootstrap.min.css" />"
	rel="stylesheet">

</head>
<body>

	<!-- =============== inclusion du header ========================== -->
	<%@ include file="/resources/template/header.jsp"%>
	<!-- ============================================================== -->
	<br />
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-sm-10 ">

				<!-- =============== inclusion Carousel ========================== -->
				<%@ include file="/resources/template/carousel.jsp"%>

				<!-- =============== end carousel ========================== -->

				<br /> <br />
				<div class="row">
					<!-- =============== inclusion menu gauche ========================== -->

					<div class="col-2">

						<%@ include file="/resources/template/menu_gauche.jsp"%>

					</div>
					<!-- end col-2 -->

					<!-- =============== fin menu gauche ========================== -->


					<!-- =============== début du Core ========================== -->

					<div class="col-8 ">

						<!--//////////////////////////////////////////////////////////////-->
						<!--////////////////////// Contenu ici ///////////////////////////-->
						<!--//////////////////////////////////////////////////////////////-->

					</div>
					<!-- end col-8 -->
					<!-- =============== fin du Core ========================== -->


				</div>
				<!-- end row -->
			</div>
			<!-- end col-sm-10 -->
		</div>
		<!-- end row justify-content-center -->
	</div>
	<!-- end container-fluid -->

	<br />
	<br />
	<!-- =============== inlusion du footer ========================== -->
	<%@ include file="/resources/template/footer.jsp"%>

</body>
</html>