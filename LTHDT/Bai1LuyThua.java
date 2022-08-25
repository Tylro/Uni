package buoi1;
import java.util.InputMismatchException;
import java.util.Scanner;;
public class Bai1LuyThua {
	public static int LuyThua(int x, int n){
		int result = 1;
		for (int i = 0; i < n; i++ ){
			result *= x;
		}
		return result;
	}
	public static void main(String[] args) {
		while (true) 
			try{
				System.out.println("Nhap x: ");
				Scanner kb = new Scanner(System.in);
				int x = kb.nextInt();
				System.out.println("Nhap n: ");
				int n = kb.nextInt();
				System.out.println("Ket qua:" + x + "^" + n + "=" + LuyThua(x,n));
				break;
			}
			catch (InputMismatchException e) {
				System.out.println( "Nhap sai - Nhap lai !!!");
			}

	}

}
