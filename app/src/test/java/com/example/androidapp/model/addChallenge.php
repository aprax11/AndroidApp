<?php
require "index.php";

$challenge_name = $_POST["challengeName"];
$challenge_description = $_POST["challengeDescription"];

$mysql_qry = "insert into challenges (name, description) values ('$challenge_name', '$challenge_description')";
$result = mysqli_query($conn, $mysql_qry);
if($result){
    echo "added";
}else {
    echo "not added";
}   
?>