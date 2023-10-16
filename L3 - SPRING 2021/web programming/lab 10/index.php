<!DOCTYPE html>
<html>
	
	<head>
		<title>Lab10 - Books</title>
		<link href="style.css" rel="stylesheet">
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
				<h4>Select category you want to view.</h4>
				<form action="" method="post">
                    <select name="input" onchange="this.form.submit();">
                        <option value="null">Select</option>
                        <option value="Computer">Computer</option>
                        <option value="Fantasy">Fantasy</option>
                        <option value="Romance">Romance</option>
                        <option value="Science Fiction">Science Fiction</option>
                        <option value="Horror">Horror</option>
                    </select>
				</form>

				<?php
                    
				    $reader = new XMLReader;
                    $reader->open('Books.xml');
                    
                    $doc = new DOMDocument;
                    
                    while ($reader->read() && $reader->name !== 'book');
                 
                    while ($reader->name === 'book') {
                        
                        $node = simplexml_import_dom($doc->importNode($reader->expand(), true));
                         
                        if (isset($_POST['input']) && $node->genre == $_POST['input']) {
                            echo "<b>Title: </b>", $node->title, "<br>";
                            echo "<b>Info: </b>", $node->description, "<br>";
                            echo "<b>Price:</b> $", $node->price, "<br>";
                            echo "<b>Author: </b>", $node->author, "<br>";
                            echo "<b>Published: </b>", $node->publish_date, "<br>";
                            echo "<br>";
                        }
                        
                        $reader->next('book');
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