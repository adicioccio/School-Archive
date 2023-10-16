<?php
require "MySQLConnectionInfo.php";

$cover = "";
$isbn10 = "";
$authors = "";
$isbn13 = "";
$copyrightyear = "";
$instockdate = "";
$trimsize = "";
$pagecount = "";
$description = "";
$subcategory = "";
$imprint = "";
$bindingtype = "";
$productionstatus = "";

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

      <div class="col-md-10">  <!-- start main content column -->
        
         <!-- book panel  -->
         <div class="panel panel-danger spaceabove">           
           <div class="panel-heading"><h4>Book Details</h4></div>
           
           <table class="table">
             <?php 
			try {
			  $pdo = new PDO("mysql:host=$host;dbname=$database", $username, $password);
			  // set the PDO error mode to exception
			$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			  
			$sqlQuery = "SELECT * FROM Books WHERE ISBN13 = ".$_GET['title'];
         		
				
			  $result = $pdo->query( $sqlQuery );
			
			  $rowCount = $result->rowCount();
			
			if($rowCount == 0)
				echo "NOT FOUND!";
			else
			{
		      $row = $result->fetch();
										
					if (isset($_GET['title'])) {
            $isbn10 = $row[1];
            $title = $row[3];
            $authors = "NOT SET";
            $isbn13 = $row[2];;
            $copyrightyear = $row[4];
            $instockdate = $row[11];
            $trimsize = $row[9];
            $pagecount = $row[10];
            $description = $row[12];
            $subcategory = $row[6];
            $imprint = $row[7];
            $bindingtype = $row[8];
            $productionstatus = $row[13];
            
          }
					
			}
			
			$pdo = null;
			
			} catch(PDOException $e) {
			  echo "Connection failed: " . $e->getMessage();
			}				
			
		?>
             
             <tr>
               <th>Cover</th>
               <td><?php echo '<img src ="images/tinysquare/'.$isbn10.'.jpg">';	 ?></td>
             </tr>            
             <tr>
               <th>Title</th>
               <td><em><?php echo $title;?></em></td>
             </tr>    
             <tr>
               <th>Authors</th>
               <td>
                  <?php echo $authors;?>
               </td>
             </tr>   
             <tr>
               <th>ISBN-10</th>
               <td><?php echo $isbn10;?></td>
             </tr>
             <tr>
               <th>ISBN-13</th>
               <td><?php echo $isbn13;?></td>
             </tr>
             <tr>
               <th>Copyright Year</th>
               <td><?php echo $copyrightyear;?></td>
             </tr>   
             <tr>
               <th>Instock Date</th>
               <td>
               <?php echo $instockdate;?>
               </td>
             </tr>              
             <tr>
               <th>Trim Size</th>
               <td><?php echo $trimsize;?></td>
             </tr> 
             <tr>
               <th>Page Count</th>
               <td><?php echo $pagecount;?></td>
             </tr> 
             <tr>
               <th>Description</th>
               <td><?php echo $description;?></td>
             </tr> 
             <tr>
               <th>Sub Category</th>
               <td><?php echo $subcategory;?></td>
             </tr>
             <tr>
               <th>Imprint</th>
               <td><?php echo $imprint;?></td>
             </tr>   
             <tr>
               <th>Binding Type</th>
               <td><?php echo $bindingtype;?></td>
             </tr> 
             <tr>
               <th>Production Status</th>
               <td><?php echo $productionstatus;?></td>
             </tr>              
           </table>

         </div>           
      </div>



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