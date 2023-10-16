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

if(!isset($_POST["firstName"]) || !isset($_POST["lastName"]))
{
	$error = "Please enter employee information.";
}
else
{
	if($_POST["firstName"] != "" && $_POST["lastName"] != "")
	{		
		try {
			$pdo = new PDO("mysql:host=$host;dbname=$database", $username, $password);
			  // set the PDO error mode to exception
			$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			 echo "Connected successfully" . "</br>";				
				
			$sqlQuery = "INSERT INTO person (FirstName, LastName, EmailAddress, TelephoneNumber, SocialInsuranceNumber, Password) VALUES('".$_POST["firstName"]."', '".$_POST["lastName"]."', '".$_POST["email"]."', '".$_POST["phoneNum"]."', '".$_POST["sinNum"]."', '".$_POST["password"]."')";
			
			try {
				$result = $pdo->query( $sqlQuery );
				echo "Person Successfully Added". "<br>";
			}
			catch(PDOException $e) {
				  echo "Person Could not be added:  " . $e->getMessage();
			}		
			
			$pdo = null;
			}
		
		catch(PDOException $e) {
				  echo "Connection failed:  " . $e->getMessage();
		}
			
	}
	else	
		$error = "Please enter employee information.";	
}

?>	
		<form action="MySQLInsert.php" method="post">
			First Name: <input type="text" name="firstName" />
			<br />
			Last Name: <input type="text" name="lastName" />
			<br />
			Email address: <input type="text" name="email" />
			<br />
			Telephone number: <input type="text" name="phoneNum" />
			<br />
			SIN Number: <input type="text" name="sinNum" />
			<br />
			Password: <input type="text" name="password" />
			<br />
			<br />
			<input type="submit" value="Submit to Database" />
		</form>
		<br />
		<br />
		<?php 
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

