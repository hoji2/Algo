import java.util.Scanner;

public class BOJ_2440_별찍기3 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int tc=sc.nextInt();
		for (int i = 1; i <=tc; i++) {
			for (int j = 1; j <=tc-i+1; j++)
				System.out.print("*");
			for (int j = tc-i+1; j <tc; j++) {
				System.out.print("");
			}System.out.println();
		}
	}
}
