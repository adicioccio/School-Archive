<?php

?>



<!DOCTYPE html>
<html>
	
	<head>
		<title>Lab06 - Homepage</title>
		<link href="stylesheet.css" rel="stylesheet">
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
				<h3>This is the homepage.</h3>
				<p><?php echo 'Today\'s time: '.date("h:i:a");?></p>
				<p><?php echo 'Today\'s date: '.date("d-m-y");?><br></p>
		</div>	
		
		<div id="footer">
			<footer>
				<?php include_once 'footer.php'?>
			</footer>
		</div>	
	</body>
</html>