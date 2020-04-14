import java.util.Scanner;

public class BOJ_1904_01타일 {

	static Scanner sc=new Scanner(System.in);
	static long[]dp=new long[1000001];
	static int divder=15746;
	public static void main(String[] args) {
		
		dp[1]=1;
		dp[2]=2;
		
		for (int i = 3; i <=1000000; i++) {
			dp[i]=(dp[i-1]%divder+dp[i-2]%divder)%divder;
		}
		
		System.out.println(dp[sc.nextInt()]);
	}
}
