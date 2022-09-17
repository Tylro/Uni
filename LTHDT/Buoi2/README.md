1. Cài đặt lớp Clock (mô tả về thời gian) gồm:
  + Các thuộc tính:  gio, phut, giay  (có kiểu là số integer)
  + Các phương thức (hàm): 
     - Hàm xây dựng mặc nhiên: Clock()
     - Hàm xây dựng có 3 tham số:  Clock(int h, int m, int s)
     - Hàm nhập thông tin từ bàn phím
     - Hàm hiển thị thông tin thời gian ra màn hình theo dạng:  gio:phut:giay
     - Hàm làm tròn:   void lamTron().  Chẳng hạn:  12:65:90 sẽ làm tròn thành: 13:6:30
     - Hàm cộng n số phút:    Clock congPhut(int  n)
     - Các getter:  int giaTriGio(); ...
2. Cài đặt lớp SDClock
   - Tạo 1 Clock c1 có giá trị:  12:65:90. Hiển thị thông tin ra màn hình.
   - Làm tròn c1 và hiển thị thông tin mới ra màn hình.
   - Tạo 1 Clock c2 có giá trị mặc nhiên. Nhập thông tin từ bàn phím cho c2. Hiển thị ra màn hình.
   - Nhập 1 số nguyên n từ bàn phím. Hiển thị ra màn hình giá trị (c2 + n phút).
