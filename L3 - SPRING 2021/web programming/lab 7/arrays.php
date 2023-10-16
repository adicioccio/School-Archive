<?php

?>



<!DOCTYPE html>
<html>
	
	<head>
		<title>Lab07 - Arrays</title>
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
				<h3>Arrays page.<br></h3>
				<p><?php
				   
				$november = array();
				
				
				$november[] = array("day" => "Friday", "1st" => 5, "2nd" => 12, "3rd" => 19, "4th" => 26);
				$november[] = array("day" => "Saturday", "1st" => 6, "2nd" => 13, "3rd" => 20, "4th" => 27);
				$november[] = array("day" => "Sunday", "1st" => 7, "2nd" => 14, "3rd" => 21, "4th" => 28);
				$november[] = array("day" => "Monday", "1st" => 1, "2nd" => 8, "3rd" => 15, "4th" => 22, "5th" => 29);
				$november[] = array("day" => "Tuesday", "1st" => 2, "2nd" => 9, "3rd" => 16, "4th" => 23, "5th" => 30);
				$november[] = array("day" => "Wednesday", "1st" => 3, "2nd" => 10, "3rd" => 17, "4th" => 24);
				$november[] = array("day" => "Thursday", "1st" => 4, "2nd" => 11, "3rd" => 18, "4th" => 25,);
				
				//output 1
				for ($i = 0; $i < count($november); $i++) {
				    print_r($november[$i]);
				    echo "<br>";
				}
				
				echo "<br>";
				
				//output 2
				$i = 0;
				for ($i = 0; $i < count($november); $i++) {
				    echo $november[$i]["1st"], " is the 1st ", $november[$i]["day"], " in November. <br>";
				    echo $november[$i]["2nd"], " is the 2nd ", $november[$i]["day"], " in November. <br>";
				    echo $november[$i]["3rd"], " is the 3rd ", $november[$i]["day"], " in November. <br>";
				    echo $november[$i]["4th"], " is the 4th ", $november[$i]["day"], " in November. <br>";
				    
				    if (isset($november[$i]["5th"])) {
				        echo $november[$i]["5th"], " is the 5th ", $november[$i]["day"], " in November. <br>";
				    } else {
				        echo "";
				    }
				    
				    echo "...........................................................<br>";
				    
				}
				
				//output 3
				for ($i = count($november)-1; $i >= 0; $i--) {
				    print_r($november[$i]);
				    echo "<br>";
				}
				
				echo "<br>";
				
				//output 4
				$november[5]["5th"] = 31;
				
				echo "Added to array.<br>";
				
				
				for ($i = 0; $i < count($november); $i++) {
				    print_r($november[$i]);
				    echo "<br>";
				}
				
				echo "<br>";
				
				
				    
                ?><br><br><br><br><br><br><br><br></p>
		</div>	
		
		<div id="footer">
			<footer>
				<?php include_once 'footer.php'?>
			</footer>
		</div>	
	</body>
</html>