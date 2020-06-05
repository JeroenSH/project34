<html>
<header>
    <title>De Muur</title>

</header>

<body>
    <?php
	
    include 'db_connection.php';
	$conn = OpenCon();

	
    if ($_GET['request'] == "login") {
	
	$kaart_nr = $_GET['cardnumber'];
        $sql = "SELECT * FROM BankUsers WHERE Rekeningnummer = '".$_GET['cardnumber']."';";   // sql querry
        $_SESSION['cardnumber'] = $kaart_nr;
        $request = "validate_login";
	
        $result = mysqli_query($conn, $sql);
        $resultCheck = mysqli_num_rows($result);
	
        if ($resultCheck == 1) {                            // checken of er precies 1 resultaat verschijnt
            header("Location: http://145.24.222.26/web/LandNode/index.php?source=" . $_GET['source'] . "&cardnumber=" . $kaart_nr . "&request=" . $request . "&code=200");
        } else { // indien er meer resultaten verschijnen/geen zal de kaartnummer niet kloppen
            header("Location: http://145.24.222.26/web/LandNode/index.php?source=" . $_GET['source'] . "&cardnumber=" . $kaart_nr . "&request=" . $request . "&code=404");
        }
    }

    if ($_GET['request'] == "pincode") {
        $kaart_nr = $_GET['cardnumber'];
        $sql = "SELECT * FROM BankUsers WHERE Rekeningnummer = '".$_GET['cardnumber']."';";   // sql querry
        $request = "validate_pincode";
        $result = mysqli_query($conn, $sql);
        $resultCheck = mysqli_num_rows($result);
        if ($resultCheck == 1) {                            // checken of er precies 1 resultaat verschijnt
            $row = mysqli_fetch_assoc($result);
            $pincode = $row['Pincode'];
            if ($pincode == $_GET['pincode']) {
                header("Location: http://145.24.222.26/web/LandNode/index.php?source=" . $_GET['source'] . "&cardnumber=" . $kaart_nr . "&request=" . $request . "&code=200");
            } else { // indien er meer resultaten verschijnen/geen zal de kaartnummer niet kloppen
		
            }
        }
    }
    if ($_GET['request'] == "pinnen") {
        $kaart_nr = $_GET['cardnumber'];
        $sql = "SELECT * FROM BankUsers WHERE Rekeningnummer = '".$_GET['cardnumber']."';";   // sql querry
        $request = "validate_saldo";
        $result = mysqli_query($conn, $sql);
        $resultCheck = mysqli_num_rows($result);
        if ($resultCheck == 1) {                            // checken of er precies 1 resultaat verschijnt
            $row = mysqli_fetch_assoc($result);
            $saldo = $row['Saldo'];
            if ($saldo >= $_GET['amount']) {
                header("Location: http://145.24.222.26/web/LandNode/index.php?source=" . $_GET['source'] . "&cardnumber=" . $kaart_nr . "&request=" . $request . "&code=200");
            } else { // indien er meer resultaten verschijnen/geen zal de kaartnummer niet kloppen
                header("Location: http://145.24.222.26/web/LandNode/index.php?source=" . $_GET['source'] . "&cardnumber=" . $kaart_nr . "&request=" . $request . "&code=402");
            }
        }
    }
    if($_GET['request']=="updatesaldo"){
	$amount = $_GET['amount'];
       
        $kaart_nr = $_GET['cardnumber'];
        $sql = "SELECT * FROM BankUsers WHERE Rekeningnummer = '".$_GET['cardnumber']."';";   // sql querry
        $result = mysqli_query($conn, $sql);
        $resultCheck = mysqli_num_rows($result);
        if ($resultCheck = 1) {                            // checken of er een resultaat verschijnt
            $row = mysqli_fetch_assoc($result);
            $saldo = $row['Saldo'];
            $newSaldo = $saldo - $amount;
        }
        $sql = "UPDATE `BankUsers` SET `Saldo`=" . $newSaldo . " WHERE `Rekeningnummer`='" . $_GET['cardnumber'] . "';";
        $result = mysqli_query($conn, $sql);
	$request = "validate_update";
        if ($result) {
            echo "Record updated successfully";
            header("Location: http://145.24.222.26/web/LandNode/index.php?source=" . $_GET['source'] . "&cardnumber=" . $kaart_nr . "&request=" . $request . "&code=200");
        } else {
            header("Location: http://145.24.222.26/web/LandNode/index.php?source=" . $_GET['source'] . "&cardnumber=" . $kaart_nr . "&request=" . $request . "&code=");
        }
        mysqli_close($conn);


    }
    if($_GET['request']=="info"){
       
        $kaart_nr = $_GET['cardnumber'];
        $sql = "SELECT * FROM BankUsers WHERE Rekeningnummer = '".$_GET['cardnumber']."';";   // sql querry
        $result = mysqli_query($conn, $sql);
        $resultCheck = mysqli_num_rows($result);
        if ($resultCheck = 1) {                            // checken of er een resultaat verschijnt
            $row = mysqli_fetch_assoc($result);
            
            header("Location: http://145.24.222.26/web/LandNode/index.php?source=" . $_GET['source'] . "&saldo=".$row['Saldo']."&pincode=".$row['Pincode']."&naam=".$row['Naam']. "&cardnumber=" . $kaart_nr . "&request=returninfo" . "&code=200");
        }

               


    }

    mysqli_close($conn);
    ?>
    </div>
</body>

</html>