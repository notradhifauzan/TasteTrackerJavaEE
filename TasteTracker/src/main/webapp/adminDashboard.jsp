<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Recipe Sharing and Meal Planning</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">


<!-- Libraries Stylesheet -->
<link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">


<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Navbar start -->
	<div class="container-fluid fixed-top">
		<div class="container topbar bg-primary d-none d-lg-block">
			<div class="d-flex justify-content-between">
				<div class="top-info ps-2">
					<small class="me-3"><i
						class="fas fa-map-marker-alt me-2 text-secondary"></i> <a href="#"
						class="text-white">UITM JASIN, MELAKA.</a></small>

				</div>
			</div>
		</div>
		<div class="container px-0">
			<nav class="navbar navbar-light bg-white navbar-expand-xl">
				<a href="index.html" class="navbar-brand"><h1
						class="text-primary display-6">Taste Tracker</h1></a>
				<button class="navbar-toggler py-2 px-3" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
					<span class="fa fa-bars text-primary"></span>
				</button>
				<div class="collapse navbar-collapse bg-white" id="navbarCollapse">
					<div class="navbar-nav mx-auto">
						<a href="RecipeController?action=pending"
							class="nav-item nav-link ${current_page == 'pending' ? 'active' : ''}">Pending
							Recipes</a> <a href="RecipeController?action=home&role=admin"
							class="nav-item nav-link ${current_page == 'all' ? 'active' : ''}">All
							Recipes</a> <a href="RecipeController?action=dashboard"
							class="nav-item nav-link ${current_page == 'dashboard' ? 'active' : ''}">Dashboard</a>

					</div>
					<div class="d-flex m-3 me-0">
						<a href="welcome.jsp" class="my-auto"> <i
							class="fas fa-user fa-2x"></i>
						</a>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- Navbar End -->
	
	<!-- Hero Start -->
	<div class="container-fluid py-5 mb-5 hero-header">
		<div class="container py-5">
			<div class="row g-5 align-items-center">
				<div class="col-md-12 col-lg-7">
					<h4 class="mb-3 text-secondary">Recipe Sharing & Meal Planning
						System</h4>
					<h1 class="mb-5 display-3 text-primary">Admin Dashboard</h1>
					<div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
						<div class="col">
							<div class="card mb-4 rounded-3 shadow-sm">
								<div class="card-header py-3">
									<h4 class="my-0 fw-normal">Pending Recipes</h4>
								</div>
								<div class="card-body">
									<h1 class="card-title pricing-card-title">
										<c:out value="${pending_recipes}" />
									</h1>


								</div>
							</div>
						</div>
						<div class="col">
							<div class="card mb-4 rounded-3 shadow-sm">
								<div class="card-header py-3">
									<h4 class="my-0 fw-normal">Total Recipes Uploaded</h4>
								</div>
								<div class="card-body">
									<h1 class="card-title pricing-card-title">
										<c:out value="${public_recipes}" />
									</h1>


								</div>
							</div>
						</div>
						<div class="col">
							<div class="card mb-4 rounded-3 shadow-sm border-primary">
								<div class="card-header py-3 text-bg-primary border-primary">
									<h4 class="my-0 fw-normal">Community members</h4>
								</div>
								<div class="card-body">
									<h1 class="card-title pricing-card-title">
										<c:out value="${total_members}" />
									</h1>


								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Hero End -->
</head>
</body>
</html>