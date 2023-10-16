<?php

?>



<!DOCTYPE html>
<html>
	
	<head>
		<title>Lab07 - Objects</title>
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
				<h3>Objects page.<br></h3>
				<p><?php
				   
				interface Vehicle {
				    public function displayVehicleInfo();
				}
				
				class LandVehicle implements Vehicle {
                    protected $make;
                    protected $model;
                    protected $year;
                    protected $price;
                    
                    function __construct($make, $model, $year, $price) {
                        $this->make = $make;
                        $this->model = $model;
                        $this->year = $year;
                        $this->price = $price;
                    }
				    
				    function displayVehicleInfo() {
				        echo "Make: ", $this->make, " | Model: ", $this->model, " | Year: ", $this->year, " | Price: ", $this->price;
                    }
				}
				
				class WaterVehicle implements Vehicle {
				    protected $make;
				    protected $model;
				    protected $year;
				    protected $price;
				    
				    function __construct($make, $model, $year, $price) {
				        $this->make = $make;
				        $this->model = $model;
				        $this->year = $year;
				        $this->price = $price;
				    }
				    
				    function displayVehicleInfo() {
				        echo "Make: ", $this->make, " | Model: ", $this->model, " | Year: ", $this->year, " | Price: ", $this->price;
				    }
				}
                
                class Car extends LandVehicle {
                    private $speedLimit;  
                    
                    function __construct($make, $model, $year, $price, $speedLimit) {
                        parent::__construct($make, $model, $year, $price);
                        $this->speedLimit = $speedLimit;
                    }
                    
                    function displayVehicleInfo() {
                        echo "Make: ", $this->make, " | Model: ", $this->model, " | Year: ", $this->year, " | Price: ", $this->price, " | Speed Limit: ", $this->speedLimit;
                    }
                    
                }
                
                class Boat extends WaterVehicle {
                    private $boatCap;
                    
                    function __construct($make, $model, $year, $price, $boatCap) {
                        parent::__construct($make, $model, $year, $price);
                        $this->boatCap = $boatCap;
                    }
                    
                    function displayVehicleInfo() {
                        echo "Make: ", $this->make, " | Model: ", $this->model, " | Year: ", $this->year, " | Price: ", $this->price, " | Boat Capacity: ", $this->boatCap;
                    }
                    
                }
                
                echo "<strong>Car</strong><br>";
                
                $toyota = new Car("Toyota", "Corolla", "2002", "3799", "190km/h");
                $toyota->displayVehicleInfo();
                echo "<br>";
                $chevy = new Car("Chevrolet", "Cobalt", "2010", "4000", "211km/h");
                $chevy->displayVehicleInfo();
                
                echo "<br><br><strong>Boat</strong><br>";
                
                $toyota = new Boat("Yacht", "LuxuryV2", "2021", "1.1m", "25");
                $toyota->displayVehicleInfo();
                echo "<br>";
                $chevy = new Boat("Speedboat", "Fishing Package", "2019", "19899", "2");
                $chevy->displayVehicleInfo();
               
				    
                ?><br><br><br><br><br><br><br><br></p>
		</div>	
		
		<div id="footer">
			<footer>
				<?php include_once 'footer.php'?>
			</footer>
		</div>	
	</body>
</html>