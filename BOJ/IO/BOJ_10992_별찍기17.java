import java.util.Scanner;

public class BOJ_10992_별찍기17 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int tc=sc.nextInt();
		int idx1=tc, idx2=tc;
		
		for (int i = 1; i <=tc; i++) {
			for (int j = 1; j <=idx2; j++) {
				if(i==tc) {
					System.out.print("*");
				}else if(i==1) {
					if(j==tc)
						System.out.print("*");
					else
						System.out.print(" ");
				}else {
					if(j==idx1 || j==idx2)
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}
			idx1--;
			idx2++;
			System.out.println();
		}
	}
}
