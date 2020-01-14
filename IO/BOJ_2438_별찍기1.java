import java.util.Scanner;

public class BOJ_2438_별찍기1 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int tc=sc.nextInt();
		for (int i = 1; i <=tc; i++) {
			for (int j = 1; j <=i; j++) {
				System.out.print("*");
			}System.out.println();
		}
	}
}
