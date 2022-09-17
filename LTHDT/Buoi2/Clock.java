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
	Scanner kb = new Scanner(System.in);
	System.out.print("Nhap gio:");
		gio = kb.nextInt();
	System.out.print("Nhap phut:");
		phut = kb.nextInt();
	System.out.print("Nhap giay:");
		giay = kb.nextInt();
}

public void hienThi() {
	System.out.println(gio + ":" + phut + ":" + giay);
}
public void lamTron() {
	int temp = gio * 3600 + phut * 60 + giay;
	gio = temp / 3600;
	phut = (temp % 3600) / 60;
	giay = (temp % 3600) % 60;
	if (gio >=24)
		gio = gio- 24;
}
public Clock congPhut(int n) {
	int temp = n * 60; 
	gio = gio + (temp / 3600);
	phut = phut + ((temp % 3600) / 60);
	giay = giay + ((temp % 3600) % 60);
	
	return new Clock(gio, phut, giay);
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
