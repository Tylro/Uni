<?php
    session_start();
    require_once './data/dbconnect.php';
    include './ultility/userultilities.php';
    
    function getCountProducts() {
    if (isset($_SESSION['GuestCarts'])) {
        return count($_SESSION['GuestCarts']);
    }
    else {
        return 0;
    }
}
    
    $typeWatches = '';
    if (isset($_GET['type'])) {
        $typeWatches = $_GET['type'];
    }
    
    $products = array();
    
    if ($typeWatches === '') {
        $sql = "SELECT * FROM `watches` ORDER BY Id ASC";
    }
    else {
        $sql = "SELECT * FROM `watches` WHERE Type='$typeWatches' ORDER BY Id ASC";   
    }
    
    $result = mysqli_query($con, $sql);
    $products = mysqli_fetch_assoc($result);
?>

<!doctype html>
<html>
    <!-- Head HTML -->
    <head>
        <meta charset="utf-8">
        <title>Danh mục đồng hồ</title>
        <link href="styles/site.css" rel="stylesheet" type="text/css">
        <link href="styles/products.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="javascript.js"></script>
    </head>

    <!-- Body HTML -->
    <body>
        <div class="divContainer">
            <!-- Header -->
            <?php include './Templates/header.php'; ?>

            <!-- Top Menu -->
            <?php include './Templates/topmenu.php'; ?>

            <!-- Body Wrapper Second Level -->
            <div class="divWrapper_2">
                <!-- Body Wrapper First Level -->
                <div class="divWrapper_1">
                    <!-- Left Menu -->
                    <?php include './Templates/leftmenu.php'; ?>

                    <!-- Main -->
                    <div class="divMain">
                        <article class="articleContent">
                            <!-- Page Title -->
                            <p class="pPageTitle">Danh mục đồng hồ - 
                            <?php
                                if ($typeWatches === '') {
                                    echo "Tất cả";
                                }
                                else {
                                    echo $typeWatches;
                                }
                            ?>
                            </p>

                            <section>
                                <div class="divProducts">
                                    <?php
                                        ///$sql = "SELECT * FROM `watches` WHERE Type='$typeWatches' ORDER BY Id ASC";
                                        $result = mysqli_query($con, $sql);
                                        while($product = mysqli_fetch_array($result)) {

                                    ?>
                                    <div class="divProduct">
                                        <a href="watches.php?id=<?php echo $product['Id']; ?>">
                                            <img src="images/<?php echo $product['Picture']; ?>" width="156px" height="280px"/>
                                        </a>
                                        <div class="divProductDetail">
                                            <a href="watches.php?id=<?php echo $product['Id']; ?>">
                                                <span class="spanProductName"><?php echo $product['Name']; ?></span> <br/> 
                                            </a>
                                            <span class="spanProductPriceLabel">Giá bán:</span> <span class="spanProductPrice"><?php echo $product['Price']; ?>đ</span>
                                        </div>
                                    </div>
                                    <?php

                                        }
                                    ?>
                                </div>
                            </section>

                        </article>
                    </div>
                </div>
            </div>
            
            <!-- Footer -->
            <?php include './Templates/footer.php'; ?>
        </div>
    </body>
</html>
