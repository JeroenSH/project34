<?php
  require 'includes/dbh.inc.php';

session_start();

?>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <meta name="keywords" content="Web Design, school projects, ..... , .....">
    <meta name="author" content="Glenn Capelle">
    <title>DeMuur | Profile</title>
    <link rel="stylesheet" href="styling/style.css">
  </head>
  <body>
    <header>
        <div class="container">
            <div id="branding">
               <h1><span class="highlight">DeMuur</span> Banking</h1>
            </div>
            <nav>
                <ul>
                    <li><a href="index1.html">Home</a></li>
                    <li class="current"><a href="Profile.php">Profile</a></li>
                    <li><a href="aboutus2.html">About</a></li>
                    <li><a href="includes/logout.inc.php">Logout</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <section>
      <div id="data">
        <?php
          //include 'login.inc.php';
          //$sql = "SELECT * FROM website WHERE USERNAME=" .$_SESSION['userUid'];
          $sql = "SELECT * FROM gegevens";
          $result = mysqli_query($conn, $sql);
          if (mysqli_num_rowS($result) > 0) {
            while ($row = mysqli_fetch_assoc($result)) {
              echo "<p>";
              ?>Naam: <?php echo $_SESSION['userName'];
              ?><br>Achternaam: <?php echo $_SESSION['userLastName'];
              ?><br>Username: <?php echo $_SESSION['userUid'];
              ?><br>Email: <?php echo $_SESSION['userMail'];
              ?><br>Geboortedatum: <?php echo $_SESSION['userDate'];
              ?><br>Rekeningnummer: <?php echo $_SESSION['userRnr'];
              ?><br>Nationaliteit: <?php echo $_SESSION['userNationaliteit'];
              ?><br>Woonadres: <?php echo $_SESSION['userAdres'];
              ?><br>Telefoonnummer: +31 <?php echo $_SESSION['userTel'];
              ?><br>Correspondentieadres: <?php echo $_SESSION['userCadres'];
              ?><br>Geslacht: <?php echo $_SESSION['userGender'];
              echo "</p>";
              break;

            }
          }
        ?>
      </div>
    </section>
    <footer>
        <p>DeMuur Banking, Copyright &copy; 2020</p>
    </footer>
  </body>
</html>
