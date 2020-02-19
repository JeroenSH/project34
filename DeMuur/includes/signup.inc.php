<?php
if(isset($_POST['signup-submit'])){

  require 'dbh.inc.php';

  $name = $_POST['name'];
  $lastname = $_POST['lastname'];
  $username = $_POST['uid'];
  $email = $_POST['mail'];
  $date = $_POST['date'];
  $rekeningnummer = $_POST['Rnr'];
  $nationaliteit = $_POST['nationaliteit'];
  $adres = $_POST['adres'];
  $telnr = $_POST['telnr'];
  $cadres = $_POST['cadres'];
  $gender = $_POST['gender'];
  $password = $_POST['pwd'];
  $passwordRepeat = $_POST['pwd-repeat'];

if(empty($name) || empty($lastname) || empty($username) || empty($email) || empty($date) || empty($rekeningnummer) || empty($nationaliteit) || empty($adres) || empty($cadres) || empty($telnr) || empty($gender) || empty($password) ||
empty($passwordRepeat)) {
    header("Location: ../signup.php?error=emptyfields&name=".$name."&lastname=".$lastname."&uid=".$username."&mail=".$email);
    exit();
  }
  /*else if (!filter_var($email, FILTER_VALIDATE_EMAIL) && !preg_match("/^[a-zA-Z0-9]*$/", $username && !preg_match("/^[a-zA-Z0-9]*$/", $name)) {
    header("Location: ../signup.php?error=invalidmailuid");
    exit();
  }*/
  if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    header("Location: ../signup.php?error=invalidmail&name=".$name."&uid=".$username);
    exit();
  }
  else if (!preg_match("/^[a-zA-Z0-9]*$/", $username)) {
    header("Location: ../signup.php?error=invaliduid&name=".$name."&mail=".$email);
    exit();
  }
  /*else if (!preg_match("/^[a-zA-Z0-9]*$/", $name)) {
    header("Location: ../signup.php?error=invalidname&uid=".$username."&mail=".$email);
    exit();
  }*/
  else if ($password !== $passwordRepeat) {
    header("Location: ../signup.php?error=passwordcheck&name=".$name."&uid=".$username."&mail=".$email);
    exit();
  }
  /*else if ($pin !== $pinRepeat) {
    header("Location: ../signup.php?error=pincheck&name=".$name."&uid=".$username."&mail=".$email);
    exit();
  }*/
  else{

    $sql = "SELECT USERNAME FROM gegevens WHERE USERNAME=?";
    $stmt = mysqli_stmt_init($conn);
    if (!mysqli_stmt_prepare($stmt, $sql)) {
      header("Location: ../signup.php?error=sqlerror1");
      exit();
    }
    else {
      mysqli_stmt_bind_param($stmt, "s", $username);
      mysqli_stmt_execute($stmt);
      mysqli_stmt_store_result($stmt);
      $resultCheck = mysqli_stmt_num_rows($stmt);
      if ($resultCheck > 0) {
        header("Location: ../signup.php?error=usertaken&mail=".$email);
        exit();
      }
      else {

        $sql = "INSERT INTO gegevens (NAAM, ACHTERNAAM, USERNAME, EMAIL, PWD, GEBDATUM, REKENINGNUMMER, NATIONALITEIT, WOONADRES, TELNUMMER, CORRESPONDENTIEADRES, GESLACHT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
        $stmt = mysqli_stmt_init($conn);
        if (!mysqli_stmt_prepare($stmt, $sql)) {
          header("Location: ../signup.php?error=sqlerror");
          exit();
        } else {
          $hashedPwd = password_hash($password, PASSWORD_DEFAULT);
          //$hashedPin= password_hash($pin, PASSWORD_DEFAULT);

          mysqli_stmt_bind_param($stmt, "ssssssssssss", $name, $lastname, $username, $email, $hashedPwd, $date, $rekeningnummer, $nationaliteit, $adres, $telnr, $cadres, $gender);
          mysqli_stmt_execute($stmt);
          header("Location: ../login.php?signup=succes");
          exit();
        }
      }
    }
  }
  mysqli_stmt_close($stmt);
  mysqli_close($conn);

}
else{
  header("Location: ../signup.php");
  exit();

}
