<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recipe Sharing and Meal Planning</title>
<style type="text/css">
@import "compass/css3";

@import url(https://fonts.googleapis.com/css?family=Merriweather);

$
red: #e74c3c ; *, *:before, *:after { @include box-sizing(border-box);
	
}

html, body {
	background: #f1f1f1;
	font-family: 'Merriweather', sans-serif;
	padding: 1em;
}

h1 {
	text-align: center;
	color: #a8a8a8;
	@
	include
	text-shadow(1px
	1px
	0
	rgba(white,
	1));
}

form {
	max-width: 600px;
	text-align: center;
	margin: 20px auto; input , textarea { border : 0;
	outline: 0;
	padding: 1em; @ include border-radius(8px);
	display: block;
	width: 100%;
	margin-top: 1em;
	font-family: 'Merriweather', sans-serif; @ include box-shadow(0 1px 1px
	rgba(black, 0.1));
	resize: none;
	&:
	focus
	{
	@include
	box-shadow(0
	0px
	2px
	rgba($red,
	1)!important);
}

}
#input-submit {
	color: white;
	background: green;
	cursor: pointer;
	&:
	hover
	{
	@include
	box-shadow(0
	1px
	1px
	1px
	rgba(#aaa,
	0.6));
}

}
textarea {
	height: 126px;
}

}
.half {
	float: left;
	width: 48%;
	margin-bottom: 1em;
}

.right {
	width: 50%;
}

.left {
	margin-right: 2%;
}

@media ( max-width : 480px) {
	.half {
		width: 100%;
		float: none;
		margin-bottom: 0;
	}
}

/* Clearfix */
.cf:before, .cf:after {
	content: " "; /* 1 */
	display: table; /* 2 */
}

.cf:after {
	clear: both;
}
</style>
</head>

<body>
	<h1>Add NEW recipe :</h1>
	<form action="RecipeController" method="post" class="cf"
		enctype="multipart/form-data">
		<div>
			<input type="text" value="${sampledata.name}" name="recipe_name"
				id="input-name" placeholder="Name"> <input type="text"
				value="${sampledata.subject}" name="recipe_subject"
				id="input-subject" placeholder="Subject"> <input type="text"
				value="${sampledata.category}" name="recipe_category"
				id="input-subject" placeholder="Category"> <input
				type="text" value="${sampledata.calories}" name="recipe_calories"
				id="input-subject" placeholder="Calories">

			<textarea name="recipe_description" id="input-recipe"
				placeholder="Recipe">${sampledata.description}</textarea>
			<textarea name="recipe_steps" id="input-recipe"
				placeholder="write your recipe steps">${sampledata.steps}</textarea>

		</div>
		<input type="file" name="recipe_img" /> <input type="hidden"
			name="action" value="add" />
		<div class="half right cf"></div>
		<input type="submit" value="Submit" id="input-submit">
	</form>

</body>
</html>