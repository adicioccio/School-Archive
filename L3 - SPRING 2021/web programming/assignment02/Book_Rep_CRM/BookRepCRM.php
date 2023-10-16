<?php


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

   <!-- Google fonts used in this theme  -->
<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic,700italic' rel='stylesheet' type='text/css'>  

   <!-- Bootstrap core CSS -->
   <link href="bootstrap3_bookTheme/dist/css/bootstrap.min.css" rel="stylesheet">
   <!-- Bootstrap theme CSS -->
   <link href="bootstrap3_bookTheme/theme.css" rel="stylesheet">


   <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
   <!--[if lt IE 9]>
   <script src="bootstrap3_bookTheme/assets/js/html5shiv.js"></script>
   <script src="bootstrap3_bookTheme/assets/js/respond.min.js"></script>
   <![endif]-->
	<link href="stylesheet.css" rel="stylesheet">
</head>

<body>

<?php include 'book-header.inc.php'; ?>
   
<div class="container">
   <div class="row">  <!-- start main content row -->

      <div class="col-md-2">  <!-- start left navigation rail column -->
         <?php include 'book-left-nav.inc.php'; ?>
      </div>  <!-- end left navigation rail --> 

      <div class="col-md-10">  <!-- start main content column -->
        
         <!-- Customer panel  -->
         <div class="panel panel-danger spaceabove">           
           <div class="panel-heading"><h4>My Customers</h4></div>
           <table class="table">
             <tr>
               <th>Name</th>
               <th>Email</th>
               <th>University</th>
               <th>City</th>
             </tr>
             
             <?php 
             
             function readFromFile() {
                 
                 $customers = file("customers.txt") or die ("Unable to open file.");
                 
                 $delimiter = ',';
                 
                 foreach ($customers as $line) {
                     
                     $splitcontents = explode($delimiter, $line);
                    
                     $customersArray = array();
                     
                     $customersArray['id'] = $splitcontents[0];
                     $customersArray['name'] = utf8_encode($splitcontents[1].' '.$splitcontents[2]);
                     $customersArray['email'] = utf8_encode($splitcontents[3]);
                     $customersArray['university'] = utf8_encode($splitcontents[4]);
                     $customersArray['city'] = utf8_encode($splitcontents[6]);
                     
                     
                     echo "<tr><td><a href='BookRepCRM.php?customer=$customersArray[id]'>$customersArray[name]</a></td><td>$customersArray[email]</td><td>$customersArray[university]</td><td>$customersArray[city]</td></tr>";
                 }
     
             }
             
             function getName($id) {
                 $customers = file("customers.txt") or die ("Unable to open file.");
                 
                 $delimiter = ',';
                 
                 foreach ($customers as $line) {
                     
                     $splitcontents = explode($delimiter, $line);
                     
                     $customersArray = array();
                     
                     $customersArray['id'] = $splitcontents[0];
                     $customersArray['name'] = utf8_encode($splitcontents[1].' '.$splitcontents[2]);
                     $customersArray['email'] = utf8_encode($splitcontents[3]);
                     $customersArray['university'] = utf8_encode($splitcontents[4]);
                     $customersArray['city'] = utf8_encode($splitcontents[6]);
                     
                     
                     if ($id == $customersArray['id']) {
                         return $customersArray['name'];
                     }
                 }
             }
             
             readFromFile();
             
             ?>
			
           </table>
         </div> 
         
         <div class="panel panel-danger spaceabove">           
           <div class="panel-heading"><h4 id="output">Orders for </h4></div>
           <table class="table">
             <tr>
               <th>ISBN</th>
               <th>Title</th>
               <th>Category</th>
             </tr>
             
             <?php 
                
                function readFromOrders($orders, $id) {
                    $orders = file($orders) or die ("Unable to open file.");
                    
                    $delimiter = ',';
                    $newLine = '\n';
                    
                    foreach ($orders as $line) {
                        explode($newLine, $line);
                        $splitcontents = explode($delimiter, $line);
                        
                        $ordersArray = array();
                        
                        $ordersArray['orderid'] = $splitcontents[0];
                        $ordersArray['customerid'] = utf8_encode($splitcontents[1]);
                        $ordersArray['isbn'] = utf8_encode($splitcontents[2]);
                        $ordersArray['title'] = utf8_encode($splitcontents[3]);
                        $ordersArray['category'] = utf8_encode($splitcontents[4]);
                        
                        
                        if ($id == $ordersArray['customerid']) {
                            echo "<tr><td>$ordersArray[isbn]</td><td>$ordersArray[title]</td><td>$ordersArray[category]</td></tr>";
                        } else {
                            
                        }
                       
                    } 
                    
                }
             
                if (isset($_GET['customer'])) {
                    $id =  $_GET['customer'];
                } else {
                 // Fallback behaviour goes here
                }
                
                
                readFromOrders("orders.txt", $id);
                
             ?>
			
           </table>
         </div> 
         <p><br><br><br><br><br><br></p>
         
            <script type="text/javascript">
             	document.getElementById("output").innerHTML = "Orders for <?php echo getName($id);?>";
             </script>
                   
           	<div id="footer">
			<footer>
				<?php include_once 'footer.php'?>
			</footer>
		</div>	
      </div>


      </div>  <!-- end main content column -->
   </div>  <!-- end main content row -->
   


   
   
 <!-- Bootstrap core JavaScript
 ================================================== -->
 <!-- Placed at the end of the document so the pages load faster -->
 <script src="bootstrap3_bookTheme/assets/js/jquery.js"></script>
 <script src="bootstrap3_bookTheme/dist/js/bootstrap.min.js"></script>
 <script src="bootstrap3_bookTheme/assets/js/holder.js"></script>
</body>
</html>