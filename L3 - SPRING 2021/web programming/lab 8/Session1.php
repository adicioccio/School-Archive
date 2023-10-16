<?php

session_start();

if (isset($_POST["nameTextBox"])) {
    $_SESSION["name"] = $_POST["nameTextBox"];
    $_SESSION["id"] = $_POST["idTextBox"];
    $_SESSION["phonenum"] = $_POST["phoneNumberTextBox"];
    $_SESSION["email"] = $_POST["emailTextBox"];
    $_SESSION["role"] = $_POST["button"];
    $_SESSION["project"] = $_POST["project"];
    header("Location: Session2.php");
    exit();
}

?>



<!DOCTYPE html>
<html>
	
	<head>
		<title>Lab08 - Session1</title>
		<link href="style.css" rel="stylesheet">
	</head>
	
	<body>
		<div id = "header">
			<header>
				<?php include_once 'header.php';?>
			</header>
		</div>
		
		<div id="menu">
				<h2><?php include_once 'menu.php'?></h2>
		</div>	
		
		<div id= "content">
				<h3>Input page.</h3>
				<form method="post">
				Employee Name:
				<input type="text" name="nameTextBox" value="Submit" />
				<br>
				Employee ID:
				<input type="text" name="idTextBox" value="Submit" />
				<br>
				Phone Number:
				<input type="text" name="phoneNumberTextBox" value="Submit" />
				<br>
				Email address:
				<input type="text" name="emailTextBox" value="Submit" />
				<br>
				Manager <input type="radio" id="Manager" name="button" value="Manager">
                | Team Leader<input type="radio" id="TeamLeader" name="button" value="TeamLeader">
                | IT Developer<input type="radio" id="Dev" name="button" value="Dev">
                | IT Analyst<input type="radio" id="Analyst" name="button" value="Analyst">
				<br>
				<select name="project" id="project">
            	<option value="Project A">Project A</option>
            	<option value="Project B">Project B</option>
            	<option value="Project C">Project C</option>
            	<option value="Project D">Project D</option></select>
				<br>
				<input type="submit" />
				
				</form>
		</div>
		
		<div id= "content2">
				
		</div>	
		
		<div id="footer">
			<footer>
				<?php include_once 'footer.php'?>
			</footer>
		</div>	
	</body>
</html>