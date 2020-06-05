<?php


$myfile = fopen("..\\test.txt", "r") or die("Unable to open file!");
$x = explode("|", (fgets($myfile)));
echo fgets($myfile);
fclose($myfile);

if(!empty($_GET['code'])){
    echo $_GET['code'];
} else{
//header('Location: http://145.24.222.26/web/LandNode/index.php?source=77.173.174.44/gui4/src/updatesaldo.php&cardnumber=OZ-TEST-12345678&request=updatesaldo&amount=-10000');
header('Location: http://145.24.222.26/web/LandNode/index.php?source=77.173.174.44/gui4/src/updatesaldo.php&cardnumber='. $x[1].  '&request=updatesaldo&amount=' .$x[2]);
}


?>