<?php

?>



<!DOCTYPE html>
<html>
	
	<head>
		<title>Lab07 - Calculator</title>
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
				<h3>Calculator page.<br></h3>
				<form>
					<input type="text" name="n1" placeholder="int">
					
					<select name="operator">
						<option>none</option>
						<option>+</option>
						<option>-</option>
						<option>*</option>
						<option>/</option>
					</select>
					
					<input type="text" name="n2" placeholder="int">
					<br>
					<button type="submit" name="submit" value="Calculate">Calculate</button>
				</form>
				<p>Answer: </p>
				<p><?php 
				
				function checkIfPrime($num){
				    if ($num == 2) {
				        return true;
				    }
				    if ($num % 2 == 0) {
				        return false;
				    }
				    for($i = 2; $i < $num; $i++) {
				        if($num % $i==0) {
				            return false;
				        }
				    }
				    return true;
				}
				
				if (isset($_GET["submit"])) {
				    $num1 = $_GET["n1"];
				    $num2 = $_GET["n2"];
				    $operator = $_GET["operator"];
				    
				    
				    switch ($operator) {
				        case "none":
				            echo  "Please set valid operator. ";
				        break;
				        
				        case "+":
				            $result = $num1 + $num2;
				            echo $result;
				            if (checkIfPrime($result)) {
				                echo "<br>", $result, " is a prime number.";
				            } else {
				                echo "<br>", $result, " is not a prime number.";
				            }
				            break;
				        
				        case "-":
				            $result = $num1 - $num2;
				            echo $result;
				            if (checkIfPrime($result)) {
				                echo "<br>", $result, " is a prime number.";
				            } else {
				                echo "<br>", $result, " is not a prime number.";
				            }
				            break;
				        
				        case "*":
				            $result = $num1 * $num2;
				            echo $result;
				            if (checkIfPrime($result)) {
				                echo "<br>", $result, " is a prime number.";
				            } else {
				                echo "<br>", $result, " is not a prime number.";
				            }
				            break;
				        
				        case "/":
				            $result = $num1 / $num2;
				            echo $result;
				            if (checkIfPrime($result)) {
				                echo "<br>", $result, " is a prime number.";
				            } else {
				                echo "<br>", $result, " is not a prime number.";
				            }
				            break;
				    }
				}
				?></p>
		</div>	
		
		<div id="footer">
			<footer>
				<?php include_once 'footer.php'?>
			</footer>
		</div>	
	</body>
</html>