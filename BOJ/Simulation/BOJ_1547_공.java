import java.util.Scanner;

public class BOJ_1547_공 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int[]dp=new int[4];
		dp[1]=1;
		int k=sc.nextInt();
		
		for (int i = 0; i < k; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int tmp=dp[a];
			dp[a]=dp[b];
			dp[b]=tmp;
		}
		
		for (int i = 1; i <=3; i++) {
			if(dp[i]==1) {
				System.out.println(i);
				break;
			}
		}
	}
}
