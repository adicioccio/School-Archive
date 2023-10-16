
<html>
	
	<head>
		<title>Lab09 - Login Page</title>
		<link href="style.css" rel="stylesheet">
	</head>
	
	<body>
		<div id = "header">
			<header>
				<?php include_once 'header.php';?>
			</header>
		</div>
		
		<div id="menu">
				<h2><?php include_once 'MySQLMenu.php'?></h2>
		</div>	
		
		<div id= "content">
			<form action="MySQLInsert.php" method="post">
			Email address: <input type="text" name="email" />
			<br />
			Password: <input type="text" name="password" />
			<br />
			<br />
			<input type="submit" value="Login" />
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