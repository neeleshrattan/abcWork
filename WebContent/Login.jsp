<!DOCTYPE html>
<html lang="en">
<head>
<title>Login To MOM</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Login Form</h2>
		<form role="form" action="LoginServlet">
			<div class="form-group">
				<label for="email">Email:</label> <input type="text"
					class="form-control" id="email" placeholder="Enter username"
					name="username">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter password"
					name="password">
			</div>

			<div>
				<select name="team">
					<option value="Team">Team1</option>
					<option value="Team">Team2</option>
					<option value="Team">Team3</option>
					<option value="Team">Team4</option>
					<option value="Team">Team5</option>
					<option value="Team">Team6</option>
				</select><br>
	
			</div>
			<input type="submit" value="Login" class="btn btn-default center-block">
		</form>
	</div>

</body>
</html>