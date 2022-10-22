package buoi3;

import java.util.Scanner;

public class DuongTron {
	private Diem tam;
	private int bankinh;
	
	public DuongTron(){
		tam = new Diem();
		bankinh = 0;
	}
	public DuongTron(Diem tam, int bankinh){
		this.tam = new Diem(tam) ;
		this.bankinh = bankinh;
	}
	public DuongTron(int x ,int y, int bk){
		this.tam = new Diem(x, y);
		this.bankinh = bk;
	}
	public DuongTron(DuongTron r){
		this.tam = r.tam;
		this.bankinh = r.bankinh;
	}
	public void makeCopy(DuongTron r){
		this.tam = r.tam;
		this.bankinh = r.bankinh;
	}
	public void nhap(){
		System.out.println("Nhap tam duong tron: ");
		Scanner kb;
		kb = new Scanner(System.in);
		tam.nhapDiem();
		System.out.print("Nhap ban kinh duong tron: ");
		bankinh = kb.nextInt();
	}
	public void hienThi() {
		System.out.print("Tam duong tron" + ": ");
		tam.hienThi();
		System.out.println();
		System.out.println("Ban kinh duong tron" + ": " + bankinh);
	}
	public void doiDuongTron(int x, int y) {
		tam.doiDiem(x, y);
	}
	public double dienTich(){
		return (bankinh*bankinh) *Math.PI;
	}
	public double chuVi() {
		return bankinh*Math.PI*2;
	}
	public boolean trongDuongTron(Diem d){
		return (float)bankinh < d.khoangCach(tam);
		
		
	}
	public boolean catNhau(DuongTron dt){
		boolean kq2;
		if (bankinh < tam.khoangCach(dt.layTam()) && dt.layBanKinh() < dt.layTam().khoangCach(tam)){
			return  kq2 = false;
		}
		else
		return kq2 = true; 
	} 
	public Diem layTam(){
		return tam;
	}
	public int layBanKinh(){
		return bankinh;
	}
}
