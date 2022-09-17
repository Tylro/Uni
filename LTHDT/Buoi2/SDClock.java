package Buoi2;

import java.util.Scanner;

public class SDClock {

	public static void main(String[] args) {
		Clock c1 = new Clock(12,65,90);
		System.out.println("Thoi gian c1:");
		c1.hienThi();
		c1.lamTron();
		System.out.println("Thoi gian c1 sau khi lam tron:");
		c1.hienThi();
		Clock c2 = new Clock();
		System.out.println("Nhap thoi gian c2:");
		c2.nhap();
		System.out.println("Thoi gian c2:");
		c2.hienThi();
		System.out.println("Nhap n:");
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		c2.congPhut(n);
	}

}
