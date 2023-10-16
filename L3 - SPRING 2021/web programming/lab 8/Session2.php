
<!DOCTYPE html>
<html>
	
	<head>
		<title>Lab08 - Session2</title>
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
				<?php 
				session_start();
				echo "Employee Name: ";
			    echo $_SESSION["name"];
			    echo "<br>Employee ID: ";
			    echo $_SESSION["id"];
			    echo "<br>Employee Phone number: ";
			    echo $_SESSION["phonenum"];
			    echo "<br>Email: ";
			    echo $_SESSION["email"];
			    echo "<br>Role: ";
			    echo $_SESSION["role"];
			    echo "<br>Project: ";
			    echo $_SESSION["project"];
				
				?>
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