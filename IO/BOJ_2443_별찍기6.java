import java.util.Scanner;

public class BOJ_2443_별찍기6 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int tc=sc.nextInt();
		int idx=2*tc-1;
		for (int i = 1; i <=tc; i++) {
			for (int j = 1; j <i; j++)
				System.out.print(" ");
			for (int j = 1; j <=idx; j++) {
				System.out.print("*");
			}System.out.println();
			
			idx-=2;
		}
	}
}
