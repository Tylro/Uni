package buoi1;

import java.util.Scanner;

public class Bai2UCLN {
	public static  int uscln(int a, int b){
		int result = 1;
		for (int i = 1; i <= a && i <= b; i++){
			if(a % i ==0 && b % i == 0)
				result = i;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println("Nhap so a: ");
		Scanner kb = new Scanner(System.in);
		int a = kb.nextInt();
		System.out.println("Nhap so b: ");
		int b = kb.nextInt();
		System.out.println("Uoc chung lon nhat: "  + uscln(a, b));
	}

}
