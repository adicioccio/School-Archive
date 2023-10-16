<?php

?>



<!DOCTYPE html>
<html>
	
	<head>
		<title>Lab06 - Even Odd</title>
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
				<h3>Even Odd page.<br></h3>
				<p><?php
				   
				    for ($i = 99; $i > 0; $i-- ) {
				        
				        if ($i % 2 == 0) {
				            echo $i, ' bottles of beer can serve and even amount of guests.<br>';
				        } else if ($i == 1) {
				            echo $i, ' bottles of beer can serve ONLY ONE more guest.<br>';
				        } else {
				            echo $i, ' bottles of beer can serve and odd amount of guests.<br>';
				        }
				    }
				    
                ?><br><br><br><br><br><br><br><br></p>
		</div>	
		
		<div id="footer">
			<footer>
				<?php include_once 'footer.php'?>
			</footer>
		</div>	
	</body>
</html>