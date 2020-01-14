import java.util.Scanner;

public class BOJ_11057_오르막수{

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n=sc.nextInt();
		int [][]dp=new int[n+1][10];
		
		for (int i = 0; i < 10; i++) {
			dp[0][i]=1;
		}
		
		for (int i = 1; i <=n; i++) {
			int tmp=1;
			for (int j = 9; j >=0; j--) {
				dp[i][j]=tmp%10007;
				
				// 마지막 0번째열에서는 -1번째열을 참조할 수 없음 : tmp 덧셈작업을 하지 않고 다음 루프로 넘어감
				if(j!=0)
					tmp+=dp[i-1][j-1];
			}
		}
		
		System.out.println(dp[n][0]);
	}
}
