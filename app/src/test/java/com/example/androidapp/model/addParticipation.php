<?php
require "index.php";
$participantName = $_POST["participantName"];
$score = $_POST["score"];
$challengeId = $_POST["challengeId"];

$mysql_qry = "INSERT INTO `participations`(`challenge_id`, `username`, `score`) VALUES ('$challengeId','$participantName','$score')";

$result2 = mysqli_query($conn, $mysql_qry);

echo $result2;

   


?>