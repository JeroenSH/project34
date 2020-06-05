<?php

$myfile = fopen("..\\test.txt", "r") or die("Unable to open file!");
$x = explode("|", (fgets($myfile)));
//echo fgets($myfile);
fclose($myfile);

if(!empty($_GET['code'])){
    echo $_GET['code'];
} else {
header('Location: http://145.24.222.26/web/LandNode/index.php?source=77.173.174.44/gui4/src/inloggen.php&pincode=' . $x[2] . '&request=' . $x[0] . '&cardnumber='. $x[1]); //verander de ?source = naar de path waar je file word bereikt.
//header('Location: http://145.24.222.26/web/LandNode/index.php?source=77.173.174.44/gui4/src/inloggen.php&pincode=4201&request=pincode&cardnumber=OZ-TEST-12345678');
}




?>