<?php

?>



<!DOCTYPE html>
<html>
	
	<head>
		<title>Lab06 - Random</title>
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
				<h3>Random page.<br></h3>
				<p><?php
				$min = 1;
				$max = 50;
				$nums = 500;
				
				$count1 = 0;
				$count2 = 0;
				$count3 = 0;
				$count4 = 0;
				$count5 = 0;
				
				echo 'Generating ', $nums, ' numbers...<br>';
				   
				for ($i = 0; $i < $nums; $i++) {
				    $num = rand($min, $max);
                    
				    if ($num > 0 && $num <= 10) {
				        $count1 += 1;
				        
				    } else if ($num > 10 && $num <= 20) {
				        $count2 += 1;
				        
				    } else if ($num > 20 && $num <= 30) {
				        $count3 += 1;
				        
				    } else if ($num > 30 && $num <= 40) {
				        $count4 += 1;
				        
				    } else if ($num > 40 && $num <= 50) {
				        $count5 += 1;
				        
				    }
				}
				
				echo '<br>Total numbers generated at 01 - 10: ', $count1;
				echo '<br>Total numbers generated at 10 - 20: ', $count2;
				echo '<br>Total numbers generated at 20 - 30: ', $count3;
				echo '<br>Total numbers generated at 30 - 40: ', $count4;
				echo '<br>Total numbers generated at 40 - 50: ', $count5;
				
				echo '<br><br> Histograms represented as percentages:'; 
				
				echo '<br>Range 01 - 10: ', histogram($count1, $nums);
				echo '<br>Range 10 - 20: ', histogram($count2, $nums);
				echo '<br>Range 20 - 30: ', histogram($count3, $nums);
				echo '<br>Range 30 - 40: ', histogram($count4, $nums);
				echo '<br>Range 40 - 50: ', histogram($count5, $nums);
				
				
				
				function histogram($count, $nums) {
				    
				    $percent = ($count / $nums) * 100;
				    
				    for ($i = 0; $i < $percent; $i++) {
				        echo '*';
				    }
				}
				
                ?><br><br><br></p>
                
                <p style="text-align:center"><?php
                
                $size = 12;
                $stars = 1;
                
                pattern($size, $stars);
                
                
                function pattern($size, $stars) {
                    for ($i = 1; $i <= $size/2; $i++) {
                        for ($j = 0; $j < $stars; $j++) {
                            echo '*';
                        }
                        echo '<br>';
                        $stars += 2;
                    }
                    
                    $stars = $size;
                    
                    for ($i = $size/2; $i >= 1; $i++) {
                        for ($j = 1; $j < $stars; $j++) {
                            echo '*';
                        }
                        echo '<br>';
                        $stars -= 2;
                    }
                }
                    
                    //for ($i = $size/2; $size/2 >= 1; $i--) {
                        
                    //}
                
                
                ?></p>
		</div>	
		
		<div id="footer">
			<footer>
				<?php include_once 'footer.php'?>
			</footer>
		</div>	
	</body>
</html>