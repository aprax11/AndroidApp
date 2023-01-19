<?php
require "index.php";


$mysql_qry = "select * from challenges";
$result = mysqli_query($conn, $mysql_qry);

if(mysqli_num_rows($result) > 0){
    while($row = $result->fetch_assoc()){
        echo "{$row["name"]}`".
         "{$row["id"]}`".
         "{$row["description"]}~";
     }
}else {
     echo "buuuuu";
}


?>