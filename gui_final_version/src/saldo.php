<?php

$myfile = fopen("..\\test.txt", "r") or die("Unable to open file!");
$x = explode("|", (fgets($myfile)));
//echo fgets($myfile);
fclose($myfile);

if(!empty($_GET['saldo'])){
    echo $_GET['saldo'];
} else{
//header('Location: http://145.24.222.26/web/LandNode/index.php?source=77.173.174.44/gui4/src/saldo.php&cardnumber=OZ-TEST-12345678&request=info');
//header('Location: http://145.24.222.26/web/LandNode/index.php?source=77.173.174.44/gui4/src/saldo.php&cardnumber=OZ-TEST-12345678&request=info');
header('Location: http://145.24.222.26/web/LandNode/index.php?source=77.173.174.44/gui4/src/saldo.php&cardnumber='. $x[1].  '&request=info');
}


?>