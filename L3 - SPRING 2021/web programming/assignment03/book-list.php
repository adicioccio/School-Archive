<?php
require "MySQLConnectionInfo.php";
?>


<!DOCTYPE html>
<html lang="en">
<head>
   <meta http-equiv="Content-Type" content="text/html; 
   charset=UTF-8" />
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta name="description" content="">
   <meta name="author" content="">
   <title>Book Template</title>

   <link rel="shortcut icon" href="../../assets/ico/favicon.png">   

   <!-- Bootstrap core CSS -->
   <link href="bootstrap3_bookTheme/dist/css/bootstrap.min.css" rel="stylesheet">
   <!-- Bootstrap theme CSS -->
   <link href="bootstrap3_bookTheme/theme.css" rel="stylesheet">


   <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
   <!--[if lt IE 9]>
   <script src="bootstrap3_bookTheme/assets/js/html5shiv.js"></script>
   <script src="bootstrap3_bookTheme/assets/js/respond.min.js"></script>
   <![endif]-->
</head>

<body>

<?php include 'includes/book-header.inc.php'; ?>
   
<div class="container">
   <div class="row">  <!-- start main content row -->

      <div class="col-md-2">  <!-- start left navigation rail column -->
         <?php include 'includes/book-left-nav.inc.php'; ?>
      </div>  <!-- end left navigation rail --> 

      <div class="col-md-6">  <!-- start main content column -->
        
         <!-- book panel  -->
         <div class="panel panel-danger spaceabove">           
           <div class="panel-heading"><h4> </h4></div>
           <table class="table">
             <tr>
               <th>Cover</th>
               <th>ISBN</th>
               <th>Title</th>
             </tr>
             <?php 
			try {
			  $pdo = new PDO("mysql:host=$host;dbname=$database", $username, $password);
			  // set the PDO error mode to exception
			$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			  
      if (isset($_GET['category'])) {
              $sqlQuery = "SELECT * FROM Books WHERE SubcategoryID = ".$_GET['category'];;
           } else if (isset($_GET['imprints'])) {
              $sqlQuery = "SELECT * FROM Books WHERE ImprintID = ".$_GET['imprints'];;
           } else if (isset($_GET['status'])) {
              $sqlQuery = "SELECT * FROM Books WHERE ProductionStatusID = ".$_GET['status'];;
           } else if (isset($_GET['binding'])) {
              $sqlQuery = "SELECT * FROM Books WHERE BindingTypeID = ".$_GET['binding'];;
           } else {
              $sqlQuery = "SELECT * FROM Books ORDER BY Title";
           }
         		
				
			  $result = $pdo->query( $sqlQuery );
			
			  $rowCount = $result->rowCount();
			
			if($rowCount == 0)
				echo "DATABASE IS EMPTY!";
			else
			{
				for($i=0; $i<$rowCount; ++$i)
				{
					$row = $result->fetch();
										
					echo "<tr>";													
					echo '<td><img src ="images/tinysquare/'.$row[1].'.jpg"></td>';				
					echo "<td>".$row[2]."</td>";
					echo "<td><a href = book-details.php?title=".$row[2].">".$row[3]."</a></td>";
					echo "</tr>";
					
				}
			}
			
			$pdo = null;
			
			} catch(PDOException $e) {
			  echo "Connection failed: " . $e->getMessage();
			}				
			
		?>	
           </table>
         </div>           
      </div>
      
      <div class="col-md-2">  <!-- start left navigation rail column -->
         <div class="panel panel-info spaceabove">
            <div class="panel-heading"><h4>Categories</h4></div>
               <ul class="nav nav-pills nav-stacked">
                  <?php 
			try {
			  $pdo = new PDO("mysql:host=$host;dbname=$database", $username, $password);
			  // set the PDO error mode to exception
			$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			  
			  $sqlQuery = "SELECT * FROM Subcategories ORDER BY SubcategoryName";		
				
			  $result = $pdo->query( $sqlQuery );
			
			  $rowCount = $result->rowCount();
			
			if($rowCount == 0)
				echo "NOT FOUND!";
			else
			{
				for($i=0; $i<$rowCount; ++$i)
				{
					$row = $result->fetch();
															
					echo "<li><a href = book-list.php?category=".$row[0].">".$row[2]."</a><li>";

				}
			}
			
			$pdo = null;
			
			} catch(PDOException $e) {
			  echo "Connection failed: " . $e->getMessage();
			}				
			
		?>	
             </ul> 
         </div>
                 
      </div>  <!-- end left navigation rail --> 
      
      <div class="col-md-2">  <!-- start left navigation rail column -->
         <div class="panel panel-info spaceabove">
            <div class="panel-heading"><h4>Imprints</h4></div>
            <ul class="nav nav-pills nav-stacked">
               <?php 
			try {
			  $pdo = new PDO("mysql:host=$host;dbname=$database", $username, $password);
			  // set the PDO error mode to exception
			$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			  
			  $sqlQuery = "SELECT * FROM Imprints";		
				
			  $result = $pdo->query( $sqlQuery );
			
			  $rowCount = $result->rowCount();
			
			if($rowCount == 0)
				echo "DATABASE IS EMPTY!";
			else
			{
				for($i=0; $i<$rowCount; ++$i)
				{
					$row = $result->fetch();
															
					echo "<li><a href = book-list.php?imprints=".$row[0].">".$row[1]."</a><li>";

				}
			}
			
			$pdo = null;
			
			} catch(PDOException $e) {
			  echo "Connection failed: " . $e->getMessage();
			}				
			
		?>	
             </ul>
         </div>    

         <div class="panel panel-info">
            <div class="panel-heading"><h4>Status</h4></div>
            <ul class="nav nav-pills nav-stacked">
               <?php 
			try {
			  $pdo = new PDO("mysql:host=$host;dbname=$database", $username, $password);
			  // set the PDO error mode to exception
			$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			  
			  $sqlQuery = "SELECT * FROM ProductionStatuses";		
				
			  $result = $pdo->query( $sqlQuery );
			
			  $rowCount = $result->rowCount();
			
			if($rowCount == 0)
				echo "DATABASE IS EMPTY!";
			else
			{
				for($i=0; $i<$rowCount; ++$i)
				{
					$row = $result->fetch();
															
					echo "<li><a href = book-list.php?status=".$row[0].">".$row[1]."</a><li>";

				}
			}
			
			$pdo = null;
			
			} catch(PDOException $e) {
			  echo "Connection failed: " . $e->getMessage();
			}				
			
		?>	
             </ul>
         </div>  
         
         <div class="panel panel-info">
            <div class="panel-heading"><h4>Binding</h4></div>
            <ul class="nav nav-pills nav-stacked">
               <?php 
			try {
			  $pdo = new PDO("mysql:host=$host;dbname=$database", $username, $password);
			  // set the PDO error mode to exception
			$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			  
			  $sqlQuery = "SELECT * FROM BindingTypes";		
				
			  $result = $pdo->query( $sqlQuery );
			
			  $rowCount = $result->rowCount();
			
			if($rowCount == 0)
				echo "DATABASE IS EMPTY!";
			else
			{
				for($i=0; $i<$rowCount; ++$i)
				{
					$row = $result->fetch();
															
					echo "<li><a href = book-list.php?binding=".$row[0].">".$row[1]."</a><li>";

				}
			}
			
			$pdo = null;
			
			} catch(PDOException $e) {
			  echo "Connection failed: " . $e->getMessage();
			}				
			
		?>	
             </ul>
         </div>           
      </div>  <!-- end left navigation rail -->       


      </div>  <!-- end main content column -->
   </div>  <!-- end main content row -->
</div>   <!-- end container -->
   


   
   
 <!-- Bootstrap core JavaScript
 ================================================== -->
 <!-- Placed at the end of the document so the pages load faster -->
 <script src="bootstrap3_bookTheme/assets/js/jquery.js"></script>
 <script src="bootstrap3_bookTheme/dist/js/bootstrap.min.js"></script>
 <script src="bootstrap3_bookTheme/assets/js/holder.js"></script>
</body>
</html>