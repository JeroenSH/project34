<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <meta name="keywords" content="Web Design, school projects, ..... , .....">
    <meta name="author" content="Glenn Capelle">
    <title>DeMuur | Login</title>
    <link rel="stylesheet" href="styling/project34.css">
  </head>
  <body>
    <header>
        <div class="container">
            <div id="branding">
               <h1><span class="highlight">DeMuur</span> Bankieren</h1>
            </div>
            <nav>
                <ul>
                    <li><a href="index.html">Algemeen</a></li>
                    <li><a href="aboutus.html">Ons Team</a></li>
                    <li><a href="simulatie.html">Simulatie</a></li>
		    <li class="current"><a href="#">Login</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <section class="box">
        <h1>Log in</h1>
        <form action="includes/login.inc.php" method="POST">
            <input id="uid" type="text" name="uid" value="<?php if(isset($_GET["uid"])){echo($_GET["uid"]);}?>" placeholder="Username">
            <input id="pwd" type="password" name="pwd" placeholder="Password">
            <button type="submit" name="login-submit" class="button_1">Login</button>
        </form>
    </section>
    <!--<footer>
        <p>Glenn Web Design, Copyright &copy; 2019</p>
    </footer>-->
  </body>
</html>
