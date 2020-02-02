import java.util.Scanner;

public class BOJ_9461_파도반수열 {

	static Scanner sc=new Scanner(System.in);
	
	// long타입 선언 : 입계값 dp[100] 확인 필수
	static long []dp=new long[101];
	
	public static void main(String[] args) {
	
		for (int i = 1; i <=3; i++) {
			dp[i]=1;
		}
		
		for (int i = 4; i <=100; i++) {
			dp[i]=dp[i-3]+dp[i-2];
		}
		
		int tc=sc.nextInt();
		for (int i = 0; i < tc; i++) {
			System.out.println(dp[sc.nextInt()]);
		}
	}
}
