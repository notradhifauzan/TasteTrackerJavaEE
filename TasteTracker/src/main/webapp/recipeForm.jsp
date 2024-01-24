<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form action="recipeController" method="POST"
			enctype="multipart/form-data">
			<div class="mb-3">
				<label for="recipe_name" class="form-label">Recipe Name</label> <input type="text" class="form-control" id="recipe_name"
					name="recipe_name" placeholder="sambal nyet">
			</div>
			<div class="mb-3">
				<label for="recipe_description" class="form-label"></label>
				<textarea class="form-control" id="recipe_description"
					name="recipe_description" rows="3"></textarea>
			</div>
			<div class="input-group mb-3">
				<input type="file" name="recipe_img" class="form-control"
					id="inputGroupFile02"> <label class="input-group-text"
					for="inputGroupFile02">Upload</label>
			</div>
			<input type="hidden" name="action" value="add"/>
			<button class="btn btn-primary" type="submit">Submit</button>
		</form>
	</div>
</body>
</html>