<!-- save as validate.php -->

<?php

$name = $_POST['username'];

$error = false;

// Name Validation
if (!preg_match("/^[a-zA-Z ]+$/", $name)) {
    echo "Invalid Name<br>";
    $error = true;
}

// Success Message
if (!$error) {
    echo "Form Submitted Successfully";
}

?>