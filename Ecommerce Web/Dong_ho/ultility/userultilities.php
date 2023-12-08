<?php

function getUserById($con, $userId) {
    $sql = "SELECT * FROM `users` WHERE Id = '$userId'";
    $result = mysqli_query($con, $sql);

    if (mysqli_num_rows($result) === 1) {
        return mysqli_fetch_array($result);
    } else {
        return '';
    }
}

function getUserByEmail($con, $userEmail) {
    $sql = "SELECT * FROM `users` WHERE Email = '$userEmail'";
    $result = mysqli_query($con, $sql);
    if ($result) {
        return mysqli_fetch_array($result);
    }
    return '';
}

function getSex($sex) {
    if (intval($sex) === 0) {
        return "Nam";
    } else {
        return "Nữ";
    }
}
?>

