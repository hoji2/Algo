import java.util.Scanner;
// http://blog.naver.com/PostView.nhn?blogId=ds020228&logNo=221704495488&parentCategoryNo=&categoryNo=15&viewDate=&isShowPopularPosts=true&from=search

public class BOJ_2133_타일채우기 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		
		if(n%2==1)
			System.out.println(0);
		else if(n==2)
			System.out.println(3);
		else {
			int []dp=new int[n+1];
			dp[0]=1;
			dp[2]=3;
			
			for (int i = 4; i <=n; i+=2) {
				dp[i]=3*dp[i-2];
				for (int j = 4; j <=i; j+=2) {
					// 새로운 세트가 들어올 때 마다 2x1이 맨위, 2x1이 맨아래 연속적으로 위치할 떄
					// 2가지 케이스에 대해 이전 dp[i-j]의 값을 더해준다
					dp[i]+=dp[i-j]*2;
				}
			}
			System.out.println(dp[n]);
		}
	}
}
