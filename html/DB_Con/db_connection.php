<?php

function OpenCon()
 {

   
    
 $dbhost = "127.0.0.1";
 $dbuser = "java";
 $dbpass = "SetNewP@ssW0rd"; // wachtwoord database
 $db = "BankData";     // verrander dit naar de juiste database.
 $conn = new mysqli($dbhost, $dbuser, $dbpass,$db) or die("Connect failed: %s\n". $conn -> error);
 
 return $conn;
 }
 
function CloseCon($conn)
 {
 $conn -> close();
 }
   
?>