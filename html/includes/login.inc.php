<?php

if (isset($_POST['login-submit'])) {
  $servername = "localhost";
  $dBUsername = "vincent";
  $dBPassword = "SetNewP@ssW0rd";
  $dBName = "BankData";

  $conn = mysqli_connect($servername, $dBUsername, $dBPassword, $dBName);

  if(!$conn){
    die("Connection failed: ".mysqli_connect_error());
  }
  $uid = $_POST['uid'];
  $password = $_POST['pwd'];

  if (empty($uid) || empty($password)) {
    header("Location: ../login.php?error=emptyfields");

exit();
  }
  else {
    $sql = "SELECT * FROM WebBase WHERE USERNAME=?;";
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
	  echo("gelukt");
         // header("Location: ../login.php?error=wrongpwd");
          exit();
        }

        else if ($password == true) {
          session_start();
          $_SESSION['userId'] = $row['ID'];
          $_SESSION['userUid']= $row['USERNAME'];

          //$sql = "INSERT INTO cookie (SiD, SuID) VALUES ($row['ID'], $row['USERNAME']);";
          //mysqli_query($conn, $sql)
          if($uid == "Admin"){
            header("Location: ../index2.html?login=succes");
            exit();
          }

          else{
          header("Location: ../index1.html?login=succes");
          exit();
          }
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
