import java.util.Scanner;

public class BOJ_11021_A더하기B_8 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		int tc=sc.nextInt();
		for (int i = 1; i <=tc; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			System.out.println("Case #"+i+": "+a+" + "+b+" = "+(a+b));
		}
	}
}
