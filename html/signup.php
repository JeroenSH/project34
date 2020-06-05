<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <meta name="keywords" content="Web Design, school projects, ..... , .....">
    <meta name="author" content="Glenn Capelle">
    <title>DeMuur | Registreer</title>
    <link rel="stylesheet" href="styling/project34_v2.css">
  </head>
  <body>
    <header>
        <div class="container">
            <div id="branding">
               <h1><span class="highlight">DeMuur</span> Bankieren</h1>
            </div>
            <nav>
                <ul>
                    <li><a href="index2.html">Algemeen</a></li>
                    <li class="current"><a href="#">Registreer</a></li>
                    <li><a href="includes/logout.inc.php">Log uit</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <section class="box">
        <h1>Registreer</h1>
        <form action="includes/signup.inc.php" method="post">
          <input id="text" type="text" name="name" placeholder="Naam">
          <input id="text" type="text" name="lastname" placeholder="Achternaam">
          <input id="text" type="text" name="uid" placeholder="Gebruikersnaam">
          <input id="text" type="text" name="mail" placeholder="Email">
          <input id="date" type="text" name="date" placeholder="JJJJ-MM-DD">
	        <input id="text" type="text" name="nationaliteit" placeholder="Nationaliteit">
          <input id="text" type="text" name="adres" placeholder="adres">
          <input id="text" type="text" name="telnr" placeholder="Telefoonnummer">
          <input id="text" type="text" name="cadres" placeholder="Correspondentieadres">
          <select id="gender" name="gender">
            <option value="" disabled selected hidden>Selecteer een geslacht</option>
            <option value="O">Other</option>
            <option value="M">Man</option>
            <option value="F">Vrouw</option>
          </select>
          <input id="pwd" type="password" name="pwd" placeholder="Password">
          <input id="pwd" type="password" name="pwd-repeat" placeholder="Repeat password">
          <button type="submit" name="signup-submit">Signup</button>
            <!--<a id="forgot" href="reset-password.php">Forgot your password?</a>-->
        </form>

        <!-- Here we create the form which starts te password reset-->
        <?php
        if (isset($_GET["newpwd"])) {
          if ($_GET["newpwd"] == "passwordupdated") {
            echo '<p class="signupsuccess">Your password has been reset!</p>';
          }
        }
        ?>
    </section>
    <!--<footer>
        <p>Glenn Web Design, Copyright &copy; 2019</p>
    </footer>-->
  </body>
</html>
