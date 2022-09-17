package Buoi2;

import java.util.Scanner;

class Clock {

private int gio, phut, giay;

public Clock() {
	gio = 0; phut = 0; giay = 0;
}
public Clock(int h, int m, int s) {
	gio = h; phut = m; giay = s; 
}
public void nhap() {
	Scanner kb = new Scanner(System.out);
	System.out.print("Nhap gio:");
		gio = kb.nextInt(gio);
	System.out.print("Nhap phut:");
		gio = kb.nextInt(phut);
	System.out.print("Nhap giay:");
		gio = kb.nextInt(giay);
}
public void hienThi() {
	System.out.print(gio + ":" + phut + ":" + giay);
}
public void lamTron() {
	temp = h * 3600 + m * 60 + s;
	gio = temp / 3600;
	phut = (temp % 3600) / 60;
	giay = (temp % 3600) % 60;
}
public Clock congPhut(int n) {
	temp = n * 60; 
	giay = n + giay;
	return lamTron(gio, phut, giay);
}
public int giaTriGio() {
	return gio;
}
public int giaTriPhut() {
	return phut;
}
public int giaTriGiay() {
	return giay;
}

}
