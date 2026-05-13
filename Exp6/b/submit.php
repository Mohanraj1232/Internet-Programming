<?php

    $con = mysqli_connect("localhost" ,"root", "" ,"studentdb");

    if(!$con){
        die("Connection Failed");
    }

    $name = $_POST['name'];
    $email = $_POST['email'];
    $sql = "Insert into students(name ,email) values('$name' ,'$email');";

    if(mysqli_query($con ,$sql)){
        echo "Done";
    }else{
        echo "Not Done";
    }

?>