import java.util.Scanner;

public class BOJ_1003_피보나치 {

	static Scanner sc= new Scanner(System.in);
	static int[][]dp=new int[42][2];
	
	public static void main(String[] args) {
	
		int tc=sc.nextInt();
		dp[0][0]=1;
		dp[1][1]=1;
		dp[2][0]=1;
		dp[2][1]=1;
		
		for (int i = 3; i <=41; i++) {
			solve(i);
		}
		
		for (int i = 0; i < tc; i++) {
			int x=sc.nextInt();
			System.out.println(dp[x][0]+" "+dp[x][1]);
		}
	}
	
	public static void solve(int num) {
		dp[num][0]=dp[num-1][0]+dp[num-2][0];
		dp[num][1]=dp[num-1][1]+dp[num-2][1];
	}
}
