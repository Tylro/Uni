<?php

function getProductById($con, $productId) {
    $sql = "SELECT * FROM `watches` WHERE Id = '$productId'";
    $result = mysqli_query($con, $sql);
    if (mysqli_num_rows($result) === 1) {
        $myWatches = mysqli_fetch_array($result);
        return $myWatches;
    }

    return NULL;
}

?>