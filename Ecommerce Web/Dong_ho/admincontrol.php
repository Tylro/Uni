<?php
require_once './data/dbconnect.php';
include 'ultility/userultilities.php';
session_start();
    
function getCountProducts() {
    if (isset($_SESSION['GuestCarts'])) {
        return count($_SESSION['GuestCarts']);
    }
    else {
        return 0;
    } 
}

/// Get user's infors
$user = '';
if (isset($_SESSION['userId'])) 
{
    $user = getUserById($con, $_SESSION['userId']);
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
        <title>Trang Quản lý</title>
        <link href="styles/site.css" rel="stylesheet" type="text/css">
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
                            <p class="pPageTitle">Trang Quản lý</p>
                            <a class="aContent" href="ordersmanager.php">Quản lý đơn hàng.</a> &nbsp;
                            <!-- User's infos -->
                            <p class="pPageTitle">Thông tin tài khoản</p>
                            <section>
                                <form id="formUpdateUserInfors" action="" method="post">
                                <table>
                                    <tr>
                                        <td width="160px">Email: </td>
                                        <td><?php echo htmlspecialchars($user['Email']); ?></td>
                                    </tr> 
                                    <tr>
                                        <td>Họ tên: </td>
                                        <td><?php echo htmlspecialchars($user['Name']); ?></td>
                                    </tr> 
                                    <tr>
                                        <td>Giới tính: </td>
                                        <td>
                                            <input type="radio" name="txtSex" value="0" <?php if (intval($user['Sex'])===0) {echo "checked=''";} ?>/> Nam &nbsp;
                                            <input type="radio" name="txtSex" value="1" <?php if (intval($user['Sex'])!=0) {echo "checked=''";} ?>/> Nữ 
                                        </td>
                                    </tr> 
                                    <tr>
                                        <td>Ngày sinh: </td>
                                        <td>
                                            <input type="date" name="txtDoB" value="<?php echo htmlspecialchars($user['DoB']); ?>" required="" />
                                        </td>
                                    </tr> 
                                    <tr>
                                        <td>Chứng minh thư: </td>
                                        <td>
                                            <input type="text" name="txtIdCard" value="<?php echo htmlspecialchars($user['IdCard']); ?>" size="30" required="" />
                                        </td>
                                    </tr> 
                                    <tr>
                                        <td>Địa chỉ: </td>
                                        <td><input type="text" name="txtAddress" value="<?php echo htmlspecialchars($user['Address']); ?>" size="30" required="" /></td>
                                    </tr> 
                                    <tr>
                                        <td>Số điện thoại: </td>
                                        <td><input type="text" name="txtPhone" value="<?php echo htmlspecialchars($user['Phone']); ?>" size="30" required="" /></td>
                                    </tr> 
                                    <tr>
                                        <td></td>
                                        <td><input type="submit" name="btnSubmit" value="Cập nhật" /></td>
                                    </tr>
                                </table>
                                </form>

                                <?php
                                if (isset($_SESSION['userId'])) {
                                    if (isset($_POST['txtAddress'])) {
                                        if ($result) {
                                ?>
                                    <p class="pResultLogin">Cập nhập thông tin thành công.</p>
                                <?php
                                        } else {
                                ?>
                                    <p class="pResultLogin">Cập nhập thông tin thất bại.</p>
                                <?php
                                        }
                                    }
                                }
                                ?>
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
