import java.util.Scanner;

public class BOJ_2445_별찍기8 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int tc=sc.nextInt();
		int idx=1;
		for (int i = 1; i <=tc; i++) {
			for (int j = 1; j <=idx; j++)
				System.out.print("*");
			for (int j = 1; j <=2*(tc-idx); j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <=idx; j++) {
				System.out.print("*");
			}System.out.println();
			idx++;
		}
		
		idx--;
		
		for (int i = 1; i <=tc; i++) {
			if(i==1) {
				idx--;
				continue;
			}
			for (int j = 1; j <=idx; j++)
				System.out.print("*");
			for (int j = 1; j <=2*(tc-idx); j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <=idx; j++) {
				System.out.print("*");
			}System.out.println();
			idx--;
		}
	}
}
