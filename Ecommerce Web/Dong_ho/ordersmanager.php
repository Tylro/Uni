<?php
require_once './data/dbconnect.php';
include './ultility/userultilities.php';
include './ultility/orderultilities.php';
session_start();

function getCountProducts() {
    if (isset($_SESSION['GuestCarts'])) {
        return count($_SESSION['GuestCarts']);
    } else {
        return 0;
    }
}

/// Get admin's infors
$user = '';
if (isset($_SESSION['userId'])) 
{
    $user = getUserById($con, $_SESSION['userId']);
    
    if (intval($user['Admin']) != 1) {
        header("Location: login.php");
    }
} 
else {
    header("Location: login.php");
}

/// Update user's infos
$result = NULL;
if (isset($_SESSION['userId'])) {
    if (isset($_POST['txtAddress'])) {
        $userId = $user['Id'];
        $userSex = $_POST['txtSex'];
        $userDoB = $_POST['txtDoB'];
        $userIdCard = $_POST['txtIdCard'];
        $userAddress = $_POST['txtAddress'];
        $userPhone = $_POST['txtPhone'];

        $sql = "UPDATE `users` SET `Sex`='$userSex', `DoB`='$userDoB', `IdCard`='$userIdCard', `Address`='$userAddress',`Phone`='$userPhone' WHERE Id='$userId'";
        $result = mysqli_query($con, $sql);
        if ($result) {
            $user = getUserById($con, $_SESSION['userId']);
        }
    }
}

?>
<!doctype html>
<html>
    <!-- Head HTML -->
    <head>
        <meta charset="utf-8">
        <title>Quản lý đơn hàng</title>
        <link href="styles/site.css" rel="stylesheet" type="text/css">
        <link href="styles/usercontrolGuest.css" rel="stylesheet" type="text/css">
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
            <div class="divWrapper_2" style="overflow: hidden">
                <!-- Body Wrapper First Level -->
                <div class="divWrapper_1">
                    <!-- Left Menu -->
                    <?php include './Templates/leftmenu.php'; ?>

                    <!-- Main -->
                    <div class="divMain">
                        <article class="articleContent">
                            <p><a class="aContent" href="admincontrol.php">Trở về Trang Quản lý</a></p>
                            
                            <!-- User's waiting orders -->
                            <p class="pPageTitle">Danh sách đơn hàng đang làm việc.</p>
                            <section>
                                <table class="tableCart" id="tableCart" border="1" cellpadding="5" cellspacing="0">
                                    <!-- Top Table -->
                                    <tr id="trTop_TableCart">
                                        <th width="60px">Mã số</th>
                                        <th width="110px">Thời gian đặt</th>
                                        <th width="160px">Khách hàng</th>
                                        <th width="140px">Tổng cộng</th>
                                        <th width="150px">Trạng thái</th>
                                    </tr>
                                    <!-- Orders List -->
                                    <?php
                                    /// Get user's orders
                                        $sql = "SELECT * FROM `orders` WHERE Status <> 4 AND Status <> 5 ORDER BY Id DESC";
                                        $result = mysqli_query($con, $sql);
                                        if (mysqli_num_rows($result) >= 1) {
                                            while ($row = mysqli_fetch_assoc($result)) {
                                                $order = getOrderById($con, $row['Id']);
                                    ?>
                                    <tr>
                                        <td>
                                            <a class="aContent" href="orderdetails.php?id=<?php echo $order['Id']; ?>"><?php echo $order['Id']; ?></a>
                                        </td>
                                        <td>
                                            <?php echo $order['CreateTime']; ?>
                                        </td>
                                        <td>
                                            <?php
                                            if ($order['UserId'] != NULL) {
                                            ?>
                                            <a class="aContent" href="userdetails.php?id=<?php echo $order['UserId']; ?>"><?php echo $order['Name']; ?></a>
                                            <?php
                                            }
                                            else
                                            {
                                               echo $order['Name'];
                                            }
                                            ?>
                                        </td>
                                        <td>
                                            <span class="spanProductPrice">
                                            <?php echo getOrderTotal($con, $order['Id'])." VNĐ"; ?>
                                            </span>
                                        </td>
                                        <td>
                                            <?php echo getOrderStatus($con, $row['Status']); ?>
                                        </td>
                                    </tr>
                                    <?php
                                            }
                                        }
                                    ?>
                                </table>
                            </section>
                            
                            <!-- User's done orders -->
                            <p class="pPageTitle">Danh sách đơn hàng đã đóng.</p>
                            <section>
                                <table class="tableCart" id="tableCart" border="1" cellpadding="5" cellspacing="0">
                                    <!-- Top Table -->
                                    <tr id="trTop_TableCart">
                                        <th width="60px">Mã số</th>
                                        <th width="110px">Thời gian đặt</th>
                                        <th width="160px">Khách hàng</th>
                                        <th width="140px">Tổng cộng</th>
                                        <th width="150px">Trạng thái</th>
                                    </tr>
                                    <!-- Orders List -->
                                    <?php
                                    /// Get user's orders
                                        $sql = "SELECT * FROM `orders` WHERE Status = 4 OR Status = 5 ORDER BY Id DESC";
                                        $result = mysqli_query($con, $sql);
                                        if (mysqli_num_rows($result) >= 1) {
                                            while ($row = mysqli_fetch_assoc($result)) {
                                                $order = getOrderById($con, $row['Id']);
                                    ?>
                                    <tr>
                                        <td>
                                            <a class="aContent" href="orderdetails.php?id=<?php echo $order['Id']; ?>"><?php echo $order['Id']; ?></a>
                                        </td>
                                        <td>
                                            <?php echo $order['CreateTime']; ?>
                                        </td>
                                        <td>
                                            <?php echo $order['Name']; ?>
                                        </td>
                                        <td>
                                            <span class="spanProductPrice">
                                            <?php echo getOrderTotal($con, $order['Id'])." VNĐ"; ?>
                                            </span>
                                        </td>
                                        <td>
                                            <?php echo getOrderStatus($con, $order['Status']); ?>
                                        </td>
                                    </tr>
                                    <?php
                                            }
                                        }
                                    ?>
                                </table>
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
