<?php
require "index.php";
$php_type = $_POST["phpType"];
$id = $_POST["id"];

$mysql_qry = "SELECT username, score FROM participations WHERE challenge_id='$id'; ";

$result = mysqli_query($conn, $mysql_qry);

if(mysqli_num_rows($result) > 0){
    while($row = $result->fetch_assoc()){
        echo "{$row["username"]}`".
        "{$row["score"]}~";
     }
}else {
     echo "noResult";
}


?>