import java.util.Scanner;

public class BOJ_2552_별찍기12 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int tc=sc.nextInt();
		int idx1=tc;
		for (int i = 1; i <=2*tc-1; i++) {
			if(i>tc)
				idx1++;
			else
				idx1--;
			
			for (int j = 1; j <=idx1; j++) {
				System.out.print(" ");
			}
			for (int j = idx1; j < tc; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
