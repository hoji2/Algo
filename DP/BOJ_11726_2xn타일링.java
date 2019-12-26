import java.util.Scanner;

public class BOJ_11726_2xn타일링 {

	static Scanner sc=new Scanner(System.in);
	//오버플로우 방지
	static long[]dp=new long[1001];
	
	public static void main(String[] args) {
	
		dp[1]=1;
		dp[2]=2;
		
		for (int i = 3; i <=1000; i++) {
			//중요 : 오버플로우 방지를 위해 계산과정에서 mod값으로 저장
			dp[i]=(dp[i-1]+dp[i-2])%10007;
		}
		
		System.out.println(dp[sc.nextInt()]);
	}
}
