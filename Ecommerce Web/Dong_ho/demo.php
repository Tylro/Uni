<div class="divGuestCart">
    <?php
        if (isset($_SESSION['userId']) && $_SESSION['userId'] != '') 
        {
    ?>
    
        <?php
            if (getUserById($con, $_SESSION['userId'])['Admin'] != 1) 
            {
        ?>
            <a href="usercontrolGuest.php">Chào <span id="txtGuestName"><?php echo $_SESSION['name']; ?></span></a>
        <?php
            } 
            else 
            {
        ?>
            <a href="admincontrol.php">Chào <span id="txtGuestName"><?php echo $_SESSION['name']; ?></span></a>
        <?php
            }
        ?>
            <a href="logout.php">(Đăng xuất)</a> <br>
        
    <?php
        } 
        else
        {
    ?>
        <a href="login.php">Đăng nhập</a> <span style="color:#FFF">|</span>
        <a href="register.php">Đăng ký</a> <br>
    <?php
        }
    ?>
        
    <a href="guestcart.php">Giỏ hàng của bạn: <span id="txtCountGuestCart"><?php echo getCountProducts(); ?></span> sản phẩm</a>
</div>