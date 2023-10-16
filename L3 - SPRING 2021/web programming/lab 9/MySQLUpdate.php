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

<br />
		<form action="MySQLUpdateComplete.php" method="post">
			<input type="hidden" name="updatepersonId" value="<?php echo  $_POST['personId']; ?>" />
			First Name: <input type="text" name="updatefirstName" value="<?php echo  $_POST['firstName']; ?>" />
			<br />
			Last Name: <input type="text" name="updatelastName" value="<?php echo  $_POST['lastName']; ?>" />
			<br />
			Email address: <input type="text" name="email" value="<?php echo  $_POST['email']; ?>" />
			<br />
			Telephone number: <input type="text" name="phoneNum" value="<?php echo  $_POST['phoneNum']; ?>" />
			<br />
			SIN Number: <input type="text" name="sinNum" value="<?php echo  $_POST['sinNum']; ?>" />
			<br />
			Password: <input type="text" name="password" value="<?php echo  $_POST['password']; ?>" />
			<br />
			<br />
			<input type="submit" value="Update Record" />
		</form>
		<br />
		</div>	
		
		<div id="footer">
			<footer>
				<?php include_once 'footer.php'?>
			</footer>
		</div>	
	</body>
</html>

