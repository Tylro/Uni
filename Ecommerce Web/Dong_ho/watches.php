<?php
    require_once './data/dbconnect.php';
    include './ultility/userultilities.php';
    session_start();
    
function getCountProducts() {
    if (isset($_SESSION['GuestCarts'])) {
        return count($_SESSION['GuestCarts']);
    }
    else {
        return 0;
    }
}
    
    $watchesCodeName = '';
    $watchesId = '';
    if (isset($_GET['id'])) {
        $watchesId = $_GET['id'];
    }
    
    if ($watchesId === '') {
        header("Location: 404.php");
    }
    else {
        $sql = "SELECT * FROM `watches` WHERE Id = '$watchesId'";
        $result = mysqli_query($con, $sql);
        
        if (mysqli_num_rows($result) === 1) {
            $watches = mysqli_fetch_array($result);
            $watchesCodeName = $watches['CodeName'];
        }
        else {
            header("Location: 404.php");
        }

    }
?>
<!doctype html>
<html>
    <!-- Head HTML -->
    <head>
        <meta charset="utf-8">
        <title><?php echo $watches['Name']; ?></title>
        <link href="styles/site.css" rel="stylesheet" type="text/css">
        <link href="styles/watches.css" rel="stylesheet" type="text/css">
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
                            <div class="divWatchesPicture">
                                <img class="imgWatchesPicture" src="images/<?php echo $watches['Picture']; ?>"/>
                            </div>
                            
                            <div class="divWatchesRight">
                                <p id="pProductName"><?php echo $watches['Name']; ?></p>
                          
                                <p class="pWatchesBasicInfo">Mã sản phẩm: <?php echo $watches['CodeName']; ?> </p>
                                <p class="pWatchesBasicInfo">Hãng sản xuất: <?php echo $watches['Type']; ?> </p>
                                <p class="pWatchesBasicInfo">Xuất xứ: <?php echo $watches['Origin']; ?> </p>
                                <p class="pWatchesBasicInfo">Năm sản xuất: <?php echo $watches['Year']; ?></p>
                                <p class="pWatchesBasicInfo">Giá bán: <span class="spanProductPrice"><?php echo number_format(floatval($watches['Price']), 0, ".", ","); ?> VNĐ</span> </p>
                                
                                <form id="AddCart" action="guestcart.php" method="post">
                                <div class="divAddCart">
                                    <input type="hidden" name="txtProductId" value="<?php echo $watchesId; ?>"/>
                                    Số lượng: <input type="number" value="1" min="1" name="txtProductQuantity" id="inputQuantity"/> <input type="submit" value="MUA HÀNG" name="btnButton" id="btnSubmitAddCart"/>
                                </div>
                                </form>
                            </div>

                            <div class="divWatchesDetails">
                                <div class="divProdutDetailTitle">
                                    <p class="pProductDetailTitle">Mô tả sản phẩm</p>
                                </div>
                                <div class="divProductDetails">
                                    <pre class="preWatchesDetails"><?php echo $watches['Details']; ?></pre>
                                </div>
                            </div>
                        </article>
                    </div>
                </div>
            </div>
            
            <!-- Footer -->
            <?php include './Templates/footer.php'; ?>
        </div>
    </body>
</html>
