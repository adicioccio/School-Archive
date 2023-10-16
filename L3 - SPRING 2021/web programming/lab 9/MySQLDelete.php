<html>
	
	<head>
		<title>Lab09 - Insert</title>
		<link href="style.css" rel="stylesheet">
	</head>
	
	<body>
		<div id = "header">
			<header>
				<?php include_once 'header.php';?>
			</header>
		</div>
		
		<div id="menu">
				<h2><?php include_once "MySQLMenu.php" ?></h2>
		</div>	
		
		<div id= "content">
		<?php

require "MySQLConnectionInfo.php";

$error = "";

if(!isset($_POST['personId']))
{
	$error = "Person could not be deleted.";
}
else
{
	try {
		$pdo = new PDO("mysql:host=$host;dbname=$database", $username, $password);
			  // set the PDO error mode to exception
		$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		echo "Connected successfully" . "</br>";
		
		$sqlQuery = "DELETE FROM person WHERE PersonId = ".$_POST['personId'];
		
		try {
			$result = $pdo->query( $sqlQuery );
			echo "Person Successfully Deleted". "<br>";
			}
		catch(PDOException $e) {
			echo "Person Could not be deleted:  " . $e->getMessage();
		}	
		
		$pdo = null;		
	}	
	catch(PDOException $e) {
		echo "Connection failed:  " . $e->getMessage();
	}	

}
echo $error;
?>
		</div>	
		
		<div id="footer">
			<footer>
				<?php include_once 'footer.php'?>
			</footer>
		</div>	
	</body>
</html>

