<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">

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
						<a href="RecipeController?action=home" class="nav-item nav-link">Home</a>
						<a href="RecipeController?action=myRecipe"
							class="nav-item nav-link">My Recipes</a>

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


	<!-- Modal Search Start -->
	<div class="modal fade" id="searchModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-fullscreen">
			<div class="modal-content rounded-0">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Search by
						keyword</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body d-flex align-items-center">
					<div class="input-group w-75 mx-auto d-flex">
						<input type="search" class="form-control p-3"
							placeholder="keywords" aria-describedby="search-icon-1">
						<span id="search-icon-1" class="input-group-text p-3"><i
							class="fa fa-search"></i></span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal Search End -->


	<!-- Single Page Header start -->
	<div class="container-fluid page-header py-5">
		<h1 class="text-center text-white display-6">Recipe Details</h1>
		<ol class="breadcrumb justify-content-center mb-0">
			<li class="breadcrumb-item"><a href="#">Home</a></li>
			<li class="breadcrumb-item active text-white">Recipes</li>
		</ol>
	</div>
	<!-- Single Page Header End -->


	<!-- Single Product Start -->
	<div class="container-fluid py-5 mt-5">
		<div class="container py-5">
			<div class="row g-4 mb-5">
				<div class="col-lg-8 col-xl-9">
					<div class="row g-4">
						<div class="col-lg-6">
							<div class="border rounded">
								<a href="#"> <img
									src='images/<c:out value='${recipe.imgAddress}' />'
									class="img-fluid rounded" alt="Image">
								</a>
							</div>
						</div>
						<div class="col-lg-6">
							<h4 class="fw-bold mb-3">
								<c:out value='${recipe.name}' />
							</h4>
							<p class="mb-3">
								Category:
								<c:out value='${recipe.category}' />
							</p>
							<h5 class="fw-bold mb-3">
								<c:out value='${recipe.calories}' />
								Calories
							</h5>
							<p class="mb-4">
								Ingredients:
								<c:out value='${recipe.description}' />
							</p>
						</div>
						<div class="col-lg-12">
							<nav>
								<div class="nav nav-tabs mb-3">
									<button class="nav-link active border-white border-bottom-0"
										type="button" role="tab" id="nav-about-tab"
										data-bs-toggle="tab" data-bs-target="#nav-about"
										aria-controls="nav-about" aria-selected="true">Description</button>
									<button class="nav-link border-white border-bottom-0"
										type="button" role="tab" id="nav-mission-tab"
										data-bs-toggle="tab" data-bs-target="#nav-mission"
										aria-controls="nav-mission" aria-selected="false">Reviews</button>
								</div>
							</nav>
							<div class="tab-content mb-5">
								<div class="tab-pane active" id="nav-about" role="tabpanel"
									aria-labelledby="nav-about-tab">
									<p>
										<c:out value='${recipe.steps}' />
									</p>
								</div>
								<!-- Reviews Tab -->
								<div class="tab-pane" id="nav-mission" role="tabpanel"
									aria-labelledby="nav-mission-tab">
									<c:forEach items="${comments}" var="comment">
										<div class="d-flex">
											<div class="me-3">
												<!-- Display user profile image if available -->
												<img src='images/user_icon.jpg'
													class="img-fluid rounded-circle p-3"
													style="width: 100px; height: 100px;" alt="">
											</div>
											<div>
												<p class="mb-2" style="font-size: 14px;">${comment.dateCreated}</p>
												<p class="mb-2" style="font-size: 14px;">by
													${comment.commenterName}</p>
												<div class="d-flex justify-content-between">
													<h5>${comment.name}</h5>
													<div class="d-flex mb-3">
														<!-- Display star ratings or other user rating information -->
													</div>
												</div>
												<p>${comment.commentText}</p>
											</div>
										</div>
										<a role="button" class="btn btn-outline-danger"
											href="CommentController?action=delete&delete_request_by=inventor&commentId=${comment.id_comment}&recipeId=${recipe.recipeID}&inventorId=${recipe.inventorID}">delete</a>
									</c:forEach>
								</div>
							</div>
						</div>
						<!-- Reviews Section End -->


					</div>

				</div>
			</div>


			<!-- Comment Form Section -->
			<form action="CommentController" method="post">
				<h4 class="mb-5 fw-bold">Leave a Comment</h4>
				<div class="row g-4">
					<div class="col-lg-12">
						<div class="border-bottom rounded my-4">
							<textarea name="review" id="review" class="form-control border-0"
								cols="30" rows="8" placeholder="Your Review *"
								spellcheck="false"></textarea>
						</div>
					</div>
					<input type="hidden" name="recipeId" value="${recipe.recipeID}" />
					<div class="col-lg-12">
						<div class="d-flex justify-content-between py-3 mb-5">
							<div class="d-flex align-items-center">
								<button
									class="btn border border-secondary text-primary rounded-pill px-4 py-3"
									value="submit" type="submit">Post Comment</button>
							</div>
						</div>
					</div>
				</div>
			</form>
			<!-- Comment Form Section End -->
		</div>
	</div>



	<!-- Footer Start -->
	<div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5">
		<div class="container py-5">
			<div class="pb-4 mb-4"
				style="border-bottom: 1px solid rgba(226, 175, 24, 0.5);">
				<div class="row g-4">
					<div class="col-lg-3">
						<a href="#">
							<h1 class="text-primary mb-0">Taste Tracker</h1>
							<p class="text-secondary mb-0">Recipe Sharing and Meal
								Planning</p>
						</a>
					</div>

					<div class="col-lg-3">
						<div class="d-flex justify-content-end pt-3">
							<a
								class="btn  btn-outline-secondary me-2 btn-md-square rounded-circle"
								href=""><i class="fab fa-twitter"></i></a> <a
								class="btn btn-outline-secondary me-2 btn-md-square rounded-circle"
								href=""><i class="fab fa-facebook-f"></i></a> <a
								class="btn btn-outline-secondary me-2 btn-md-square rounded-circle"
								href=""><i class="fab fa-youtube"></i></a> <a
								class="btn btn-outline-secondary btn-md-square rounded-circle"
								href=""><i class="fab fa-linkedin-in"></i></a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-6">
				<div class="footer-item">
					<h4 class="text-light mb-3">Contact</h4>
					<p>Address: UiTM JASIN, MELAKA.</p>
					<p>Email: tastetracker@gmail.com</p>
					<p>Phone: +0123 4567 8910</p>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- Footer End -->

	<!-- Back to Top -->
	<a href="#"
		class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i
		class="fa fa-arrow-up"></i></a>


	<!-- JavaScript Libraries -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/waypoints/waypoints.min.js"></script>
	<script src="lib/lightbox/js/lightbox.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
</body>

</html>