<?php
define('studentNum', '041019241');
$firstName = 'Adam';
$middleName = 'Maico';
$lastName = 'Di Cioccio';
date_default_timezone_set("America/Toronto");
$tmr = strtotime("Tomorrow");
$nextMonday = strtotime("next Monday");
?>



<!DOCTYPE html>
<html>
	
	<head>
		<title>Lab05 - Adam Di Cioccio</title>
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
				<p><?php echo $firstName . " " . $middleName . " " . $lastName;?></p>
				<p><?php echo studentNum;?></p>
				<p><?php echo 'Hello World!!' . " " . 'This is the first time I am using PHP!!';?></p>
				<p><?php echo 'Today\'s time: '.date("h:i:s:a");?></p>
				<p><?php echo 'Today\'s date: '.date("d-m-y");?><br></p>
				<p><?php echo 'Tomorrow\'s date: '.date("d-m-y", $tmr);?></p>
				<p><?php echo 'Next monday: '.date("d-m-y", $nextMonday);?></p>
		</div>	
		
		<div id="footer">
			<footer>
				<?php include_once 'footer.php'?>
			</footer>
		</div>	
	</body>
</html>