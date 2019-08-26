<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- taglib de jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- taglib de Spring Security -->
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- lib icone : Fontawesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

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

				<!-- =============== inclusion Barre recherche ==================== -->
				<Br />
				<%@ include file="/resources/template/barre_recheche.jsp"%>
				<Br />
				<!-- =============== end Barre recherche ========================== -->
<br />
				<form action="${pageContext.request.contextPath}/user/add"
					method="post" enctype="multipart/form-data">

					<div class="row">
						<div class="col-6">

							
							<div class="form-group row justify-content-md-center">

								<label class="col-sm-2 col-form-label">Email</label>

								<div class="col-sm-7">
									<input type="email" name="mail" class="form-control"
										placeholder="Email" />
								</div>

							</div>
							
							</div>
						<!-- end col-6 -->
						<div class="col-6">

							<div class="form-group row justify-content-md-center">

								<label class="col-sm-2 col-form-label">Mot de passe</label>

								<div class="col-sm-7">
									<input type="password" class="form-control"
										placeholder="Mot de passe" name="password"
										/>
								</div>

							</div>
					
						</div>
						<!-- end col-6 -->
					</div>
					<!-- end row -->
					<br /> <br />
					<div class="row justify-content-center">
						<div class="col-4">
							<div class="form-group row justify-content-md-center">
								<button class="btn btn-outline-primary btn-lg btn-block"
									type="submit">Ajouter ce user</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<br />
	<br />
	<!-- =============== inlusion du footer ========================== -->
	<%@ include file="/resources/template/footer.jsp"%>
	
</body>
</html>