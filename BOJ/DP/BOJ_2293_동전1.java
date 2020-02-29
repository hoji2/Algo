import java.util.Scanner;

public class BOJ_2293_동전1 {

	// https://donggod.tistory.com/29
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		int[]coin=new int[n];
		int[]dp=new int[k+1];
		
		for (int i = 0; i < n; i++) {
			coin[i]=sc.nextInt();
		}
		
		// 추후 coin[i] 1개로 만들 수 있는 경우의 수를 구하기 위한 초기값
		dp[0]=1;
		
		//(중요) 위와 같이 돌리면 같은 동전의 구성이라도 순서가 다른 경우까지 계산함 -> (1,2) (2,1) 중복카운트
		// -> 1~k 까지 구하는 과정에서 모든 경우의수를 더한 dp[j]가 다음 step에서 사용된다
		
//		for (int j = 1; j <=k; j++) {
//			for (int i = 0; i <n; i++) {
//				if(j-coin[i]>=0)
//					dp[j]+=dp[j-coin[i]];
//			}
//		}
		
		// 따라서 코인 하나당 구할 수 있는 경우를 큰 루프로 돌린다
		// 이를 통해 각 스텝별로 이전 코인을 사용한 dp[j]의 개수를 통해 순서가 다른 중복을 제외할 수 있다.
		
		for (int i = 0; i <n; i++) {
			for (int j = 1; j <=k; j++) {
				if(j-coin[i]>=0)
					dp[j]+=dp[j-coin[i]];
			}
		}
		
		System.out.println(dp[k]);
		
	}
}
