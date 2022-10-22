package buoi3;

import java.util.Scanner;
class Diem {
	// Khai bao cac thuoc tinh
	private int x;
	private int y;
	// Ham xay dung
	public Diem() {	// Ham xay dung mac nhien (default constructor)
		x = y = 0;
	}
	public Diem(int h, int t) {
		x = h; y = t;
	}
	public Diem(int a) {
		x = y = a;
	}
	public Diem(Diem d) {	// Ham xay dung sao chep
		this.x = d.x;
		this.y = d.y;
	}
	// Ham sao chep sau (deep copy)

	public void makeCopy(Diem d) {
		this.x = d.x;
		this.y = d.y;
	}


	// Dinh nghia cac phuong thuc (ham)
	public void khoiTao(int h, int t) {
		x = h; y = t;
	}
	public void hienThi() {
		System.out.print("(" + x + "," + y + ")");
	}
	public void nhapDiem() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap hoanh do: ");
		x = kb.nextInt();
		System.out.print("Nhap tung do: ");
		y = kb.nextInt();
	}
	public void doiDiem(int dx, int dy) {
		x += dx; y += dy;
	}
	public float khoangCach() {
		float kc = 0;
		kc = (float)Math.sqrt(x*x + y*y);
		return kc;
	}
	public float khoangCach(Diem d) {
		float kc = (float)Math.sqrt( (d.x-this.x)*(d.x-this.x)
								   + (d.y-this.y)*(d.y-this.y) );
		return kc;
	}

	public int giaTriHoanhDo() {
		return x;
	}
	public int giaTriTungDo() {
		return y;
	}
	// Cac phuong thuc khac
	public boolean trung(Diem d) {
		return (x==d.x && y==d.y);
	}
	public Diem doiXung() {
		Diem kq = new Diem(-x,-y);
		return kq;
	}
}