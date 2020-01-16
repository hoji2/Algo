import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11053_가장긴부분수열 {
	
	static int map[],dp[] ;
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		map = new int[n+1];
		dp = new int[n+1];
        
		for(int i=1;i<=n;i++) {
			map[i] = sc.nextInt();
			dp[i]=1;
		}
		
		
		for(int i=2;i<=n;i++) { //두 번째 숫자를 기준으로 n까지 반복
			for(int j=1;j<i;j++) { // 첫 번째 부터 i이전 까지 비교를 위한 반복
				if(map[i]>map[j]) { // 기준값이 더 큰 경우
					//현재 자기자신 dp[i]에 탐색될 때 마다 그 이전 j와 최장길이가 저장되어있는 dp[j]값에 +1을 하여 MAX 판단
					dp[i] = Math.max(dp[i],dp[j]+1);
				}
			}
		}

		Arrays.sort(dp);
		System.out.println(dp[n]);
		
	}
}

[BinarySearch 풀이]

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11053_가장긴부분수열 {

	// https://code0xff.tistory.com/70
	// https://sudeky.tistory.com/131
	// Arrays.binarySearch : https://code0xff.tistory.com/68
	static Scanner sc=new Scanner(System.in);
	static int[]dp;
	static int[]map;
	static int idx;
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		dp=new int[n+1];
		map=new int[n+1];
		
		for (int i = 1; i <=n; i++) {
			map[i]=sc.nextInt();
		}
		
		dp[1]=map[1];
		idx=2;
		
		for (int i = 2; i <= n; i++) {
			if(dp[idx-1]<map[i])
				dp[idx++]=map[i];
			else {
				int tmp=Arrays.binarySearch(dp, 1, idx, map[i]);
				// Arrays.binarySearch의 경우
				// 우리가 원하는 타겟이 딱 맞게 존재하는 경우에는 양수가 반환되는데 정확히 같은 값이 아니면 배열에서 자기 위치를 찾아 음수로 반환한다는 특징이 있다.
				// 음수로 mapping되는 경우 자기가 들어가야하는 자리(양수)로 변환
				// 중요) 자신이 들어가야하는 자리 3인경우 -> binarySearch의 탐색 결과(tmp=-4)로 매핑되므로 위와 같이 변환
				dp[tmp < 0 ? -tmp - 1 : tmp]=map[i];
			}
		}
		System.out.println(idx-1);
	}
}
