<?php

if (isset($_POST['login-submit'])) {

  require 'dbh.inc.php';

  $uid = $_POST['uid'];
  $password = $_POST['pwd'];

  if (empty($uid) || empty($password)) {
    header("Location: ../login.php?error=emptyfields");
    exit();
  }
  else {
    $sql = "SELECT * FROM gegevens WHERE USERNAME=?;";
    $stmt = mysqli_stmt_init($conn);
    if (!mysqli_stmt_prepare($stmt, $sql)) {
      header("Location: ../login.php?error=sqlerror");
      exit();
    }
    else {

      mysqli_stmt_bind_param($stmt, "s", $uid);
      mysqli_stmt_execute($stmt);
      $result = mysqli_stmt_get_result($stmt);
      if ($row = mysqli_fetch_assoc($result)) {
        //$pwdCheck = password_verify($password, $row['PWD']);
        if ($password == false) {
          header("Location: ../login.php?error=wrongpwd");
          exit();
        }
        else if ($password == true) {
          session_start();
          $_SESSION['userId'] = $row['ID'];
          $_SESSION['userName']= $row['NAAM'];
          $_SESSION['userLastName']= $row['ACHTERNAAM'];
          $_SESSION['userUid']= $row['USERNAME'];
          $_SESSION['userMail']= $row['EMAIL'];
          $_SESSION['userDate']= $row['GEBDATUM'];
          $_SESSION['userRnr']= $row['Rekeningnummer'];
          $_SESSION['userNationaliteit']= $row['NATIONALITEIT'];
          $_SESSION['userAdres']= $row['WOONADRES'];
          $_SESSION['userTel']= $row['TELNUMMER'];
          $_SESSION['userCadres']= $row['CORRESPONDENTIEADRES'];
          $_SESSION['userGender']= $row['GESLACHT'];


          //$sql = "INSERT INTO cookie (SiD, SuID) VALUES ($row['ID'], $row['USERNAME']);";
          //mysqli_query($conn, $sql);

          header("Location: ../index1.html?login=succes");
          exit();
        }
        else{
          header("Location: ../login.php?error=wrongpwd");
          exit();
        }
      }
      else {
        header("Location: ../login.php?error=nouser");
        exit();
      }
    }
  }


}
else {
  header("Location: ../index.php");
  exit();
}
