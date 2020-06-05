<?php


if(!empty($_GET['code'])){
    	echo "Code returned:".$_GET['code'];
} else {
header('Location: http://145.24.222.26/web/LandNode/index.php?source=145.24.222.25/DB_Con/testconnectie.php&cardnumber=OZ-TEST-12345678&request=login'); //verander de ?source = naar de path waar je file word bereikt.
}
?>