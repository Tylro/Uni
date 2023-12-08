<?php
require_once './data/dbconnect.php';
include './ultility/userultilities.php';
session_start();

function getCountProducts() {
    if (isset($_SESSION['GuestCarts'])) {
        return count($_SESSION['GuestCarts']);
    } else {
        return 0;
    }
}

define('REGIS_DIDNOTREGIS', -1);
define('REGIS_SUCCESS', 0);
define('REGIS_INCORRECT', 1);
define('REGIS_FAIL', 2);
$regisResult = REGIS_DIDNOTREGIS;

$email = "null";
$password = "null";
$repeatpassword = "null";
$name = "null";

if (isset($_SESSION['userId']) && $_SESSION['userId'] != '') {
    header("Location: index.php");
} else {
    if (isset($_POST['btnSubmit'])) {
        $email = $_POST['txtEmail'];
        $password = $_POST['txtPassword'];
        $repeatpassword = $_POST['txtRepeatPassword'];
        $name = $_POST['txtName'];

        if ($password != $repeatpassword) {
            $regisResult = REGIS_INCORRECT;
        } else {
            $password = md5($password);
            $sql = "INSERT INTO `users` (`Email`, `Password`, `Name`, `CreateTime`) VALUES ('$email', '$password', '$name', CURRENT_TIME())";
            if (mysqli_query($con, $sql)) {
                $result = REGIS_SUCCESS;
                $myuser = getUserByEmail($con, $email);
                $_SESSION['userId'] = $myuser['Id'];
                $_SESSION['email'] = $myuser['Email'];
                $_SESSION['name'] = $myuser['Name'];
                
                header("Location: usercontrolGuest.php");
            } else {
                $regisResult = REGIS_FAIL;
            }
        }
    }
}
?>
<!doctype html>
<html>
    <!-- Head HTML -->
    <head>
        <meta charset="utf-8">
        <title>Đăng ký tài khoản</title>
        <link href="styles/site.css" rel="stylesheet" type="text/css">
        <link href="styles/register.css" rel="stylesheet" type="text/css">
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
                            <p class="pPageTitle">Đăng ký tài khoản</p>

                            <section>

                                    <form id="formRegister" action="" method="post">
                                        <table class="tableRegister">
                                            <tr>
                                                <td width="200px">Email: <span class="spanRequiredField">*</span></td>
                                                <td width="330px"><input name="txtEmail" type="text" size="30" required=""/></td>
                                            </tr>
                                            <tr>
                                                <td>Mật khẩu: <span class="spanRequiredField">*</span></td>
                                                <td><input name="txtPassword" type="password" size="30" required=""/></td>
                                            </tr>
                                            <tr>
                                                <td>Nhập lại mật khẩu: <span class="spanRequiredField">*</span></td>
                                                <td><input name="txtRepeatPassword" type="password" size="30" required=""/></td>
                                            </tr>
                                            <tr>
                                                <td>Họ tên: <span class="spanRequiredField">*</span></td>
                                                <td><input name="txtName" type="text" size="30" required=""/></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input name="btnSubmit" type="submit" value="Đăng ký"/>
                                                    <input name="btnReset" type="reset" value="Nhập lại"/>
                                                </td>
                                            </tr>
                                        </table>
                                    </form>


                                <p class="pResultLogin">
                                    <?php
                                    if ($regisResult === REGIS_INCORRECT) {
                                        echo "Mật khẩu nhập đã không trùng khớp";
                                    } else {
                                        if ($regisResult === REGIS_FAIL) {
                                            echo "Đăng ký thất bại.";
                                        }
                                    }
                                    ?>
                                </p>
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
