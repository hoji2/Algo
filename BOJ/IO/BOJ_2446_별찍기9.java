import java.util.Scanner;

public class BOJ_2446_별찍기9 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int tc=sc.nextInt();
		int idx1=-1;
		for (int i = 1; i <=2*tc-1; i++) {
			if(i>tc)
				idx1--;
			else
				idx1++;
			
			for (int j = 1; j <=idx1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2*(tc-idx1)-1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
