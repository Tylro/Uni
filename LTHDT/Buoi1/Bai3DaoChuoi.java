package buoi1;

import java.util.Scanner;

public class Bai3DaoChuoi {
	public static void daoChuoi(String chuoi){
		int len = chuoi.length();
		char[] s1 = chuoi.toCharArray();
		for (int i = (len -1); i >= 0; i--){
			System.out.print(s1[i]);
		}
		
	}
	public static void main(String[] args) {
		System.out.println("Nhap chuoi:");
		Scanner kb = new Scanner(System.in);
		String chuoi = kb.nextLine();
		System.out.println("Chuoi ban dau:");
		System.out.println(chuoi);
		System.out.println("Chuoi dao nguoc:");
		daoChuoi(chuoi);
	}

}
