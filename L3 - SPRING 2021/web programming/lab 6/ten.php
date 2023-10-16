<?php

?>



<!DOCTYPE html>
<html>
	
	<head>
		<title>Lab06 - Ten</title>
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
				<h3>Ten page.<br></h3>
				<p><?php
				   
				    for ($i = 9; $i >= 0; $i-- ) {
				        
				        if ($i == 0) {
				            echo '0 Bottles remaining';
				        } else {
				            echo $i*10, ' Bottles of Beer on the Wall...', '<br>';
				            echo 'You take one down pass it around...', '<br>';
				            echo $i*10-10, ' Bottles of Beer on the Wall...', '<br><br>';
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