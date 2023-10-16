<?php
clearstatcache();
require "MySQLConnectionInfo.php";

?>
	
<html>
	
	<head>
		<title>Lab09 - Select</title>
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
			try {
			  $pdo = new PDO("mysql:host=$host;dbname=$database", $username, $password);
			  // set the PDO error mode to exception
			$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			 echo "Connected successfully" . "</br>";
			  
			  $sqlQuery = "SELECT * FROM person";		
				
			  $result = $pdo->query( $sqlQuery );
			
			  $rowCount = $result->rowCount();
			
			if($rowCount == 0)
				echo "DATABASE IS EMPTY!";
			else
			{
				for($i=0; $i<$rowCount; ++$i)
				{
					$row = $result->fetch();
										
					echo "<table><tr><td>";										
					echo "<br />";					
					echo "<form action=\"MySQLDelete.php\" method=\"post\">";		
						echo "<input type=\"hidden\" name=\"personId\" value=\"".$row[0]."\" />";
						echo "<input type=\"submit\" name=\"deleteButton\" value=\"Delete Person\" />";
					echo "</form>";	
					
					echo "<form action=\"MySQLUpdate.php\" method=\"post\">";							
						echo "<input type=\"hidden\" name=\"personId\" value=\"".$row[0]."\" />";
						echo "<input type=\"hidden\" name=\"firstName\" value=\"".$row[1]."\" />";	
						echo "<input type=\"hidden\" name=\"lastName\" value=\"".$row[2]."\" />";	
						echo "<input type=\"submit\" name=\"editButton\" value=\"Edit Person\" />";
					echo "</form>";
					echo "</td>";
					
					echo "<td>";					
					echo "First Name: ".$row[1]."<br />";
					echo "Last Name: ".$row[2]."<br />";
					echo "Email Address: ".$row[3]."<br />";
					echo "Phone Number: ".$row[4]."<br />";
					echo "SIN Number: ".$row[5]."<br />";	
					echo "</td></tr></table>";
					
					echo "<br />";
				}
			}
			
			$pdo = null;
			
			} catch(PDOException $e) {
			  echo "Connection failed: " . $e->getMessage();
			}				
			
		?>	
		
		</div>	
		
		<div id="footer">
			<footer>
				<?php include_once 'footer.php'?>
			</footer>
		</div>	
	</body>
</html>	