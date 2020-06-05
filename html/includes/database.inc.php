<?php

$servername = "localhost";
$dBUsername = "vincent";
$dBPassword = "SetNewP@ssW0rd";
$dBName = "BankData";
$port = "3306";

$conn = mysqli_connect($servername, $dBUsername, $dBPassword, $dBName, $port);

if(!$conn){
    die("Connection failed: ".mysqli_connect_error());
}
